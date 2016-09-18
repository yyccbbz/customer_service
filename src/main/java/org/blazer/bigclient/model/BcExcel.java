package org.blazer.bigclient.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bc_excel")
public class BcExcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "excel_name")
    private String excelName;

    @Column(name = "excel_real_name")
    private String excelRealName;

    @Column(name = "excel_real_path")
    private String excelRealPath;

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
     * @return service_id
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return excel_name
     */
    public String getExcelName() {
        return excelName;
    }

    /**
     * @param excelName
     */
    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    /**
     * @return excel_real_name
     */
    public String getExcelRealName() {
        return excelRealName;
    }

    /**
     * @param excelRealName
     */
    public void setExcelRealName(String excelRealName) {
        this.excelRealName = excelRealName;
    }

    /**
     * @return excel_real_path
     */
    public String getExcelRealPath() {
        return excelRealPath;
    }

    /**
     * @param excelRealPath
     */
    public void setExcelRealPath(String excelRealPath) {
        this.excelRealPath = excelRealPath;
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

    @Override
    public String toString() {
        return "BcExcel{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", userId=" + userId +
                ", excelName='" + excelName + '\'' +
                ", excelRealName='" + excelRealName + '\'' +
                ", excelRealPath='" + excelRealPath + '\'' +
                ", mtime=" + mtime +
                ", ctime=" + ctime +
                '}';
    }
}