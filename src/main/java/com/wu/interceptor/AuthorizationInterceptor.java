package com.wu.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.wu.annotation.AuthToken;
import com.wu.utils.ConstantKit;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;


/**
 * 每次请求接口都会走拦截器，如果该接口标注了@AuthToken注解，则要检查客户端传过来的Authorization字段，
 * 获取 token。由于 token 与 username 双向绑定，可以通过获取的 token 来尝试从 redis 中获取 username，
 * 如果可以获取则说明 token 正确，反之，说明错误，返回鉴权失败。
 */



public class AuthorizationInterceptor implements HandlerInterceptor {

    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    /**
     * 存放登录用户模型Key的Request Key
     */
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断handler是否为HandlerMethod的实例
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 如果打上了AuthToken注解则需要验证token
        if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {

             String token = request.getHeader(httpHeaderName);
            //String token = request.getParameter(httpHeaderName);

            String userName = "";
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            if (token != null && token.length() != 0) {
                userName = jedis.get(token);
            }
            if (userName != null && !userName.trim().equals("")) {

                Long tokeBirthTime = Long.valueOf(jedis.get(token + userName));

                Long diff = System.currentTimeMillis() - tokeBirthTime;

                //重新设置Redis中的token过期时间
                if (diff > ConstantKit.TOKEN_RESET_TIME) {
                    jedis.expire(userName, ConstantKit.TOKEN_EXPIRE_TIME);
                    jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);

                    Long newBirthTime = System.currentTimeMillis();
                    jedis.set(token + userName, newBirthTime.toString());
                }

                //用完关闭
                jedis.close();
                request.setAttribute(REQUEST_CURRENT_KEY, userName);
                return true;
            } else {
                JSONObject jsonObject = new JSONObject();

                PrintWriter out = null;
                try {
                    response.setStatus(unauthorizedErrorCode);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    jsonObject.put("code", ((HttpServletResponse) response).getStatus());
                    jsonObject.put("message", HttpStatus.UNAUTHORIZED);
                    out = response.getWriter();
                    out.println(jsonObject);

                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                }
            }
        }

        request.setAttribute(REQUEST_CURRENT_KEY, null);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}