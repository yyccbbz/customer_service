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
    private Long settlementCapital;

    /**
     * 投资起始时间
     */
    @Column(name = "inception_date")
    private String inceptionDate;

    /**
     * 投资到期时间
     */
    @Column(name = "due_date")
    private String dueDate;

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

    /**
     * 获取自动序号
     *
     * @return id - 自动序号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自动序号
     *
     * @param id 自动序号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取手机号码
     *
     * @return phone_number - 手机号码
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取投资金额
     *
     * @return settlement_capital - 投资金额
     */
    public Long getSettlementCapital() {
        return settlementCapital;
    }

    /**
     * 设置投资金额
     *
     * @param settlementCapital 投资金额
     */
    public void setSettlementCapital(Long settlementCapital) {
        this.settlementCapital = settlementCapital;
    }

    /**
     * 获取投资起始时间
     *
     * @return inception_date - 投资起始时间
     */
    public String getInceptionDate() {
        return inceptionDate;
    }

    /**
     * 设置投资起始时间
     *
     * @param inceptionDate 投资起始时间
     */
    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    /**
     * 获取投资到期时间
     *
     * @return due_date - 投资到期时间
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * 设置投资到期时间
     *
     * @param dueDate 投资到期时间
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * 获取证件号码
     *
     * @return id_no - 证件号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置证件号码
     *
     * @param idNo 证件号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取更新时间
     *
     * @return mtime - 更新时间
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * 设置更新时间
     *
     * @param mtime 更新时间
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * 获取创建时间
     *
     * @return ctime - 创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime 创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}