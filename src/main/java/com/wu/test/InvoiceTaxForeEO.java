package com.wu.test;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.math.BigDecimal;

public class InvoiceTaxForeEO extends BaseRowModel {

    @ExcelProperty(value = "账套编码")
    private String organizeId;

    @ExcelProperty(value = "账套名称")
    private String organizeName;

    @ExcelProperty(value = "期初留抵税额")
    private BigDecimal invoicePeriodTax;

    @ExcelProperty(value = "销项不含税金额")
    private BigDecimal deductionFullTax;

    @ExcelProperty(value = "销项税额")
    private BigDecimal deductionTax;

    @ExcelProperty(value = "进项税额")
    private BigDecimal inputVATTax;

    @ExcelProperty(value = "进项转出税额")
    private BigDecimal inputToOutputTax;

    @ExcelProperty(value = "期末留抵税额")
    private BigDecimal invoiceEndTax;

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

    public BigDecimal getInvoicePeriodTax() {
        return invoicePeriodTax;
    }

    public void setInvoicePeriodTax(BigDecimal invoicePeriodTax) {
        this.invoicePeriodTax = invoicePeriodTax;
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

    public BigDecimal getInvoiceEndTax() {
        return invoiceEndTax;
    }

    public void setInvoiceEndTax(BigDecimal invoiceEndTax) {
        this.invoiceEndTax = invoiceEndTax;
    }

    @Override
    public String toString() {
        return "InvoiceTaxForeEO{" +
                "organizeId='" + organizeId + '\'' +
                ", organizeName='" + organizeName + '\'' +
                ", invoicePeriodTax=" + invoicePeriodTax +
                ", deductionFullTax=" + deductionFullTax +
                ", deductionTax=" + deductionTax +
                ", inputVATTax=" + inputVATTax +
                ", inputToOutputTax=" + inputToOutputTax +
                ", invoiceEndTax=" + invoiceEndTax +
                '}';
    }
}





