package com.wu.test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.math.BigDecimal;

/**
 * @ClassName TaxForeCastDTO
 * @Author laixiaoxing
 * @Date 2019/1/26 下午2:09
 * @Description 税赋预测表dto
 * @Version 1.0
 */
public class TaxForeEO extends BaseRowModel {

    @ExcelProperty(value = "账套编码",index = 0)
    private String organizeId;
    @ExcelProperty(value = "账套名称",index = 1)
    private String organizeName;
    @ExcelProperty(value = "期初留抵税额",index = 2)
    private BigDecimal periodTax;
    @ExcelProperty(value = "进项税额",index = 3)
    private BigDecimal inputVATTax;
    @ExcelProperty(value = "进项转出税额",index = 4)
    private BigDecimal inputToOutputTax;
    @ExcelProperty(value = "销项不含税金额",index = 5)
    private BigDecimal deductionFullTax;
    @ExcelProperty(value = "销项税额",index = 6)
    private BigDecimal deductionTax;
    @ExcelProperty(value = "简易征收销项不含税金额",index = 7)
    private BigDecimal simpleFullTax;
    @ExcelProperty(value = "简易征收销项税额",index = 8)
    private BigDecimal simpleTax;
    @ExcelProperty(value = "未开票直租不含税金额",index = 9)
    private BigDecimal uninvoicedDirectRentFullTax;
    @ExcelProperty(value = "未开票直租税额",index = 10)
    private BigDecimal uninvoicedDirectRentTax;
    @ExcelProperty(value = "未开票回租不含税金额",index = 11)
    private BigDecimal uninvoicedLeasebackRentFullTax;
    @ExcelProperty(value = "未开票回租税额",index = 12)
    private BigDecimal uninvoicedLeasebackRentTax;
    @ExcelProperty(value = "购置税扣除额",index = 13)
    private BigDecimal purchaseTaxDeduction;
    @ExcelProperty(value = "期末留抵税额",index = 14)
    private BigDecimal endTax;
    @ExcelProperty(value = "应缴增值税",index = 15)
    private BigDecimal VATpayable;

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public BigDecimal getPeriodTax() {
        return periodTax;
    }

    public void setPeriodTax(BigDecimal periodTax) {
        this.periodTax = periodTax;
    }

    public BigDecimal getInputVATTax() {
        return inputVATTax;
    }

    public void setInputVATTax(BigDecimal inputVATTax) {
        this.inputVATTax = inputVATTax;
    }

    public BigDecimal getInputToOutputTax() {
        return inputToOutputTax;
    }

    public void setInputToOutputTax(BigDecimal inputToOutputTax) {
        this.inputToOutputTax = inputToOutputTax;
    }

    public BigDecimal getDeductionFullTax() {
        return deductionFullTax;
    }

    public void setDeductionFullTax(BigDecimal deductionFullTax) {
        this.deductionFullTax = deductionFullTax;
    }

    public BigDecimal getDeductionTax() {
        return deductionTax;
    }

    public void setDeductionTax(BigDecimal deductionTax) {
        this.deductionTax = deductionTax;
    }

    public BigDecimal getSimpleFullTax() {
        return simpleFullTax;
    }

    public void setSimpleFullTax(BigDecimal simpleFullTax) {
        this.simpleFullTax = simpleFullTax;
    }

    public BigDecimal getSimpleTax() {
        return simpleTax;
    }

    public void setSimpleTax(BigDecimal simpleTax) {
        this.simpleTax = simpleTax;
    }

    public BigDecimal getUninvoicedDirectRentFullTax() {
        return uninvoicedDirectRentFullTax;
    }

    public void setUninvoicedDirectRentFullTax(BigDecimal uninvoicedDirectRentFullTax) {
        this.uninvoicedDirectRentFullTax = uninvoicedDirectRentFullTax;
    }

    public BigDecimal getUninvoicedDirectRentTax() {
        return uninvoicedDirectRentTax;
    }

    public void setUninvoicedDirectRentTax(BigDecimal uninvoicedDirectRentTax) {
        this.uninvoicedDirectRentTax = uninvoicedDirectRentTax;
    }

    public BigDecimal getUninvoicedLeasebackRentFullTax() {
        return uninvoicedLeasebackRentFullTax;
    }

    public void setUninvoicedLeasebackRentFullTax(BigDecimal uninvoicedLeasebackRentFullTax) {
        this.uninvoicedLeasebackRentFullTax = uninvoicedLeasebackRentFullTax;
    }

    public BigDecimal getUninvoicedLeasebackRentTax() {
        return uninvoicedLeasebackRentTax;
    }

    public void setUninvoicedLeasebackRentTax(BigDecimal uninvoicedLeasebackRentTax) {
        this.uninvoicedLeasebackRentTax = uninvoicedLeasebackRentTax;
    }

    public BigDecimal getPurchaseTaxDeduction() {
        return purchaseTaxDeduction;
    }

    public void setPurchaseTaxDeduction(BigDecimal purchaseTaxDeduction) {
        this.purchaseTaxDeduction = purchaseTaxDeduction;
    }

    public BigDecimal getEndTax() {
        return endTax;
    }

    public void setEndTax(BigDecimal endTax) {
        this.endTax = endTax;
    }

    public BigDecimal getVATpayable() {
        return VATpayable;
    }

    public void setVATpayable(BigDecimal VATpayable) {
        this.VATpayable = VATpayable;
    }

    @Override
    public String toString() {
        return "TaxForeEO{" +
                "organizeId='" + organizeId + '\'' +
                ", organizeName='" + organizeName + '\'' +
                ", periodTax=" + periodTax +
                ", inputVATTax=" + inputVATTax +
                ", inputToOutputTax=" + inputToOutputTax +
                ", deductionFullTax=" + deductionFullTax +
                ", deductionTax=" + deductionTax +
                ", simpleFullTax=" + simpleFullTax +
                ", simpleTax=" + simpleTax +
                ", uninvoicedDirectRentFullTax=" + uninvoicedDirectRentFullTax +
                ", uninvoicedDirectRentTax=" + uninvoicedDirectRentTax +
                ", uninvoicedLeasebackRentFullTax=" + uninvoicedLeasebackRentFullTax +
                ", uninvoicedLeasebackRentTax=" + uninvoicedLeasebackRentTax +
                ", purchaseTaxDeduction=" + purchaseTaxDeduction +
                ", endTax=" + endTax +
                ", VATpayable=" + VATpayable +
                '}';
    }
}
