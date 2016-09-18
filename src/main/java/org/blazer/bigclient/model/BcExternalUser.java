package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bc_external_user")
public class BcExternalUser {
    /**
     * 自动序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * excel关联id
     */
    @Column(name = "excel_id")
    private Long excelId;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * 系统内姓名
     */
    @Column(name = "sys_name")
    private String sysName;

    /**
     * 是否注册
     */
    @Column(name = "sys_if_register")
    private String sysIfRegister;

    /**
     * 注册日期
     */
    @Column(name = "sys_register_date")
    private String sysRegisterDate;

    /**
     * 是否实名
     */
    @Column(name = "sys_if_real_name")
    private String sysIfRealName;

    /**
     * 是否绑卡
     */
    @Column(name = "sys_if_bind_card")
    private String sysIfBindCard;

    /**
     * 是否有过交易
     */
    @Column(name = "sys_if_transaction")
    private String sysIfTransaction;

    /**
     * 扫码推荐人
     */
    @Column(name = "sys_referrer")
    private String sysReferrer;

    /**
     * 返利失效日期
     */
    @Column(name = "sys_rebate_expiration_date")
    private String sysRebateExpirationDate;

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
     * 获取excel关联id
     *
     * @return excel_id - excel关联id
     */
    public Long getExcelId() {
        return excelId;
    }

    /**
     * 设置excel关联id
     *
     * @param excelId excel关联id
     */
    public void setExcelId(Long excelId) {
        this.excelId = excelId;
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
     * 获取系统内姓名
     *
     * @return sys_name - 系统内姓名
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 设置系统内姓名
     *
     * @param sysName 系统内姓名
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 获取是否注册
     *
     * @return sys_if_register - 是否注册
     */
    public String getSysIfRegister() {
        return sysIfRegister;
    }

    /**
     * 设置是否注册
     *
     * @param sysIfRegister 是否注册
     */
    public void setSysIfRegister(String sysIfRegister) {
        this.sysIfRegister = sysIfRegister;
    }

    /**
     * 获取注册日期
     *
     * @return sys_register_date - 注册日期
     */
    public String getSysRegisterDate() {
        return sysRegisterDate;
    }

    /**
     * 设置注册日期
     *
     * @param sysRegisterDate 注册日期
     */
    public void setSysRegisterDate(String sysRegisterDate) {
        this.sysRegisterDate = sysRegisterDate;
    }

    /**
     * 获取是否实名
     *
     * @return sys_if_real_name - 是否实名
     */
    public String getSysIfRealName() {
        return sysIfRealName;
    }

    /**
     * 设置是否实名
     *
     * @param sysIfRealName 是否实名
     */
    public void setSysIfRealName(String sysIfRealName) {
        this.sysIfRealName = sysIfRealName;
    }

    /**
     * 获取是否绑卡
     *
     * @return sys_if_bind_card - 是否绑卡
     */
    public String getSysIfBindCard() {
        return sysIfBindCard;
    }

    /**
     * 设置是否绑卡
     *
     * @param sysIfBindCard 是否绑卡
     */
    public void setSysIfBindCard(String sysIfBindCard) {
        this.sysIfBindCard = sysIfBindCard;
    }

    /**
     * 获取是否有过交易
     *
     * @return sys_if_transaction - 是否有过交易
     */
    public String getSysIfTransaction() {
        return sysIfTransaction;
    }

    /**
     * 设置是否有过交易
     *
     * @param sysIfTransaction 是否有过交易
     */
    public void setSysIfTransaction(String sysIfTransaction) {
        this.sysIfTransaction = sysIfTransaction;
    }

    /**
     * 获取扫码推荐人
     *
     * @return sys_referrer - 扫码推荐人
     */
    public String getSysReferrer() {
        return sysReferrer;
    }

    /**
     * 设置扫码推荐人
     *
     * @param sysReferrer 扫码推荐人
     */
    public void setSysReferrer(String sysReferrer) {
        this.sysReferrer = sysReferrer;
    }

    /**
     * 获取返利失效日期
     *
     * @return sys_rebate_expiration_date - 返利失效日期
     */
    public String getSysRebateExpirationDate() {
        return sysRebateExpirationDate;
    }

    /**
     * 设置返利失效日期
     *
     * @param sysRebateExpirationDate 返利失效日期
     */
    public void setSysRebateExpirationDate(String sysRebateExpirationDate) {
        this.sysRebateExpirationDate = sysRebateExpirationDate;
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

    @Override
    public String toString() {
        return "BcExternalUser{" +
                "id=" + id +
                ", excelId=" + excelId +
                ", phoneNumber=" + phoneNumber +
                ", sysName='" + sysName + '\'' +
                ", sysIfRegister='" + sysIfRegister + '\'' +
                ", sysRegisterDate='" + sysRegisterDate + '\'' +
                ", sysIfRealName='" + sysIfRealName + '\'' +
                ", sysIfBindCard='" + sysIfBindCard + '\'' +
                ", sysIfTransaction='" + sysIfTransaction + '\'' +
                ", sysReferrer='" + sysReferrer + '\'' +
                ", sysRebateExpirationDate='" + sysRebateExpirationDate + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}