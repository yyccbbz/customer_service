package com.evergrande.customer_service.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cs_user")
public class CsUser {
    /**
     * 自动序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 投资金额
     */
    @Column(name = "settlement_capital")
    private String settlementCapital;

    /**
     * 投资起始时间
     */
    @Column(name = "inception_date")
    private Date inceptionDate;

    /**
     * 投资到期时间
     */
    @Column(name = "due_date")
    private Date dueDate;

    /**
     * 证件号码
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 更新时间
     */
    private Date mtime;

    /**
     * 创建时间
     */
    private Date ctime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSettlementCapital() {
        return settlementCapital;
    }

    public void setSettlementCapital(String settlementCapital) {
        this.settlementCapital = settlementCapital;
    }

    public Date getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(Date inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}