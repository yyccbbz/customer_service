package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bc_wait_allot_user")
public class BcWaitAllotUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "register_date")
    private String registerDate;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "if_employee")
    private String ifEmployee;

    @Column(name = "assets_amount")
    private String assetsAmount;

    private String sex;

    private String age;

    private String birthday;

    private String referrer;

    @Column(name = "referrer_phone_number")
    private String referrerPhoneNumber;

    @Column(name = "if_referrer_employee")
    private String ifReferrerEmployee;

    private Date mtime;

    private Date ctime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return phone_number
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return register_date
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return id_card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return if_employee
     */
    public String getIfEmployee() {
        return ifEmployee;
    }

    /**
     * @param ifEmployee
     */
    public void setIfEmployee(String ifEmployee) {
        this.ifEmployee = ifEmployee;
    }

    /**
     * @return assets_amount
     */
    public String getAssetsAmount() {
        return assetsAmount;
    }

    /**
     * @param assetsAmount
     */
    public void setAssetsAmount(String assetsAmount) {
        this.assetsAmount = assetsAmount;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return referrer
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     * @param referrer
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    /**
     * @return referrer_phone_number
     */
    public String getReferrerPhoneNumber() {
        return referrerPhoneNumber;
    }

    /**
     * @param referrerPhoneNumber
     */
    public void setReferrerPhoneNumber(String referrerPhoneNumber) {
        this.referrerPhoneNumber = referrerPhoneNumber;
    }

    /**
     * @return if_referrer_employee
     */
    public String getIfReferrerEmployee() {
        return ifReferrerEmployee;
    }

    /**
     * @param ifReferrerEmployee
     */
    public void setIfReferrerEmployee(String ifReferrerEmployee) {
        this.ifReferrerEmployee = ifReferrerEmployee;
    }

    /**
     * @return mtime
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     * @param mtime
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     * @return ctime
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}