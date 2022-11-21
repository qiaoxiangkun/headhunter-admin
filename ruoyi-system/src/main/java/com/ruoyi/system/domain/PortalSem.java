package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 线索对象 portal_sem
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class PortalSem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long semId;

    /** net SqlServer库semid */
    //@Excel(name = "net SqlServer库semid")
    private Long netSemId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mobileNumber;

    /** 性别0未知 1男 2女 */
    @Excel(name = "性别0未知 1男 2女")
    private Long gender;

    /** 期望职位 */
    @Excel(name = "期望职位")
    private String hopePosition;

    /** 当前年薪 */
    private Long currentSalary;

    /** 当前年薪文本 */
    @Excel(name = "当前年薪")
    private String currentSalaryText;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 招聘职位 */
    @Excel(name = "招聘职位")
    private String recruitPosition;

    /** 营销类型 1我要招人 2我要找工作 */
    @Excel(name = "营销类型 1我要招人 2我要找工作")
    private Long semType;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ip;

    /** 提交来源地址 */
    @Excel(name = "提交来源地址")
    private String urlAddress;

    /** 线索来源（(0:百度sem,1:电话400,2:每日信动） */
    @Excel(name = "线索来源(0:百度sem,1:电话400,2:每日信动）")
    private Long clueSource;

    /** 处理状态（0：未处理） */
    @Excel(name = "处理状态 0=：未处理")
    private Long processingStatus;

    /** 录入来源（0：自动，1：添加按钮，2：Excel导入） */
    @Excel(name = "录入来源0=：自动，1：添加按钮，2：Excel导入")
    private Long inputSource;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdStime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedStime;

    /** 1是删除 */
    private Long isDel;

    private List<PortalSemFile> portalSemFileList;

    private  PortalClientExt portalClientExt;

    public PortalClientExt getPortalClientExt() {
        return portalClientExt;
    }

    public void setPortalClientExt(PortalClientExt portalClientExt) {
        this.portalClientExt = portalClientExt;
    }

    public List<PortalSemFile> getPortalSemFileList() {
        return portalSemFileList;
    }

    public void setPortalSemFileList(List<PortalSemFile> portalSemFileList) {
        this.portalSemFileList = portalSemFileList;
    }

    public void setSemId(Long semId)
    {
        this.semId = semId;
    }

    public Long getSemId() 
    {
        return semId;
    }
    public void setNetSemId(Long netSemId) 
    {
        this.netSemId = netSemId;
    }

    public Long getNetSemId() 
    {
        return netSemId;
    }
    public void setMobileNumber(String mobileNumber) 
    {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() 
    {
        return mobileNumber;
    }
    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }
    public void setHopePosition(String hopePosition) 
    {
        this.hopePosition = hopePosition;
    }

    public String getHopePosition() 
    {
        return hopePosition;
    }
    public void setCurrentSalary(Long currentSalary) 
    {
        this.currentSalary = currentSalary;
    }

    public Long getCurrentSalary() 
    {
        return currentSalary;
    }
    public void setCurrentSalaryText(String currentSalaryText) 
    {
        this.currentSalaryText = currentSalaryText;
    }

    public String getCurrentSalaryText() 
    {
        return currentSalaryText;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setRecruitPosition(String recruitPosition) 
    {
        this.recruitPosition = recruitPosition;
    }

    public String getRecruitPosition() 
    {
        return recruitPosition;
    }
    public void setSemType(Long semType) 
    {
        this.semType = semType;
    }

    public Long getSemType() 
    {
        return semType;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setUrlAddress(String urlAddress) 
    {
        this.urlAddress = urlAddress;
    }

    public String getUrlAddress() 
    {
        return urlAddress;
    }
    public void setClueSource(Long clueSource) 
    {
        this.clueSource = clueSource;
    }

    public Long getClueSource() 
    {
        return clueSource;
    }
    public void setProcessingStatus(Long processingStatus) 
    {
        this.processingStatus = processingStatus;
    }

    public Long getProcessingStatus() 
    {
        return processingStatus;
    }
    public void setInputSource(Long inputSource) 
    {
        this.inputSource = inputSource;
    }

    public Long getInputSource() 
    {
        return inputSource;
    }
    public void setCreatedStime(Date createdStime) 
    {
        this.createdStime = createdStime;
    }

    public Date getCreatedStime() 
    {
        return createdStime;
    }
    public void setModifiedStime(Date modifiedStime) 
    {
        this.modifiedStime = modifiedStime;
    }

    public Date getModifiedStime() 
    {
        return modifiedStime;
    }
    public void setIsDel(Long isDel) 
    {
        this.isDel = isDel;
    }

    public Long getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("semId", getSemId())
            .append("netSemId", getNetSemId())
            .append("mobileNumber", getMobileNumber())
            .append("gender", getGender())
            .append("hopePosition", getHopePosition())
            .append("currentSalary", getCurrentSalary())
            .append("currentSalaryText", getCurrentSalaryText())
            .append("name", getName())
            .append("companyName", getCompanyName())
            .append("recruitPosition", getRecruitPosition())
            .append("semType", getSemType())
            .append("ip", getIp())
            .append("urlAddress", getUrlAddress())
            .append("clueSource", getClueSource())
            .append("processingStatus", getProcessingStatus())
            .append("inputSource", getInputSource())
            .append("createdStime", getCreatedStime())
            .append("modifiedStime", getModifiedStime())
            .append("isDel", getIsDel())
            .toString();
    }
}
