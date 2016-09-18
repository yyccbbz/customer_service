package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bc_external_user_backup")
public class BcExternalUserBackup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "excel_id")
    private Long excelId;

    @Column(name = "phone_number")
    private Long phoneNumber;

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
     * @return excel_id
     */
    public Long getExcelId() {
        return excelId;
    }

    /**
     * @param excelId
     */
    public void setExcelId(Long excelId) {
        this.excelId = excelId;
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