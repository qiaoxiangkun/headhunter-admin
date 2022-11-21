package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 线索客户扩展字段对象 portal_client_ext
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public class PortalClientExt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 线索ID */
    @Excel(name = "线索ID")
    private Long semId;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String creditCode;

    /** 法人姓名 */
    @Excel(name = "法人姓名")
    private String legalpersonName;

    /** 公司类型 */
    @Excel(name = "公司类型")
    private String companyType;

    /** 成立日期 */
    @Excel(name = "成立日期")
    private String establishDate;

    /** 企业状态 */
    @Excel(name = "企业状态")
    private String companyState;

    /** 注册资金(万元) */
    @Excel(name = "注册资金(万元)")
    private String registeredCapital;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String businessScope;

    /** 注册地址 */
    @Excel(name = "注册地址")
    private String registeredAddress;

    /** 所在行政区 */
    @Excel(name = "所在行政区")
    private String placeDistrict;

    /** 行业分类 */
    @Excel(name = "行业分类")
    private String industryCategory;

    /** 营收规模 */
    @Excel(name = "营收规模")
    private String revenueScale;

    /** 公司简介 */
    @Excel(name = "公司简介")
    private String companyIntroduce;

    /** 公司官网地址 */
    @Excel(name = "公司官网地址")
    private String companyWebsiteAddress;

    /** 通讯地址 */
    @Excel(name = "通讯地址")
    private String postalAddress;

    /** 股东 */
    @Excel(name = "股东")
    private String shareholder;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mailbox;

    /** 团队人数 */
    @Excel(name = "团队人数")
    private Long teamPeople;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdStime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedStime;

    /** 1是删除 */
    @Excel(name = "1是删除")
    private Long isDel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSemId(Long semId) 
    {
        this.semId = semId;
    }

    public Long getSemId() 
    {
        return semId;
    }
    public void setCreditCode(String creditCode) 
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode() 
    {
        return creditCode;
    }
    public void setLegalpersonName(String legalpersonName) 
    {
        this.legalpersonName = legalpersonName;
    }

    public String getLegalpersonName() 
    {
        return legalpersonName;
    }
    public void setCompanyType(String companyType) 
    {
        this.companyType = companyType;
    }

    public String getCompanyType() 
    {
        return companyType;
    }
    public void setEstablishDate(String establishDate) 
    {
        this.establishDate = establishDate;
    }

    public String getEstablishDate() 
    {
        return establishDate;
    }
    public void setCompanyState(String companyState) 
    {
        this.companyState = companyState;
    }

    public String getCompanyState() 
    {
        return companyState;
    }
    public void setRegisteredCapital(String registeredCapital) 
    {
        this.registeredCapital = registeredCapital;
    }

    public String getRegisteredCapital() 
    {
        return registeredCapital;
    }
    public void setBusinessScope(String businessScope) 
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope() 
    {
        return businessScope;
    }
    public void setRegisteredAddress(String registeredAddress) 
    {
        this.registeredAddress = registeredAddress;
    }

    public String getRegisteredAddress() 
    {
        return registeredAddress;
    }
    public void setPlaceDistrict(String placeDistrict) 
    {
        this.placeDistrict = placeDistrict;
    }

    public String getPlaceDistrict() 
    {
        return placeDistrict;
    }
    public void setIndustryCategory(String industryCategory) 
    {
        this.industryCategory = industryCategory;
    }

    public String getIndustryCategory() 
    {
        return industryCategory;
    }
    public void setRevenueScale(String revenueScale) 
    {
        this.revenueScale = revenueScale;
    }

    public String getRevenueScale() 
    {
        return revenueScale;
    }
    public void setCompanyIntroduce(String companyIntroduce) 
    {
        this.companyIntroduce = companyIntroduce;
    }

    public String getCompanyIntroduce() 
    {
        return companyIntroduce;
    }
    public void setCompanyWebsiteAddress(String companyWebsiteAddress) 
    {
        this.companyWebsiteAddress = companyWebsiteAddress;
    }

    public String getCompanyWebsiteAddress() 
    {
        return companyWebsiteAddress;
    }
    public void setPostalAddress(String postalAddress) 
    {
        this.postalAddress = postalAddress;
    }

    public String getPostalAddress() 
    {
        return postalAddress;
    }
    public void setShareholder(String shareholder) 
    {
        this.shareholder = shareholder;
    }

    public String getShareholder() 
    {
        return shareholder;
    }
    public void setMailbox(String mailbox) 
    {
        this.mailbox = mailbox;
    }

    public String getMailbox() 
    {
        return mailbox;
    }
    public void setTeamPeople(Long teamPeople) 
    {
        this.teamPeople = teamPeople;
    }

    public Long getTeamPeople() 
    {
        return teamPeople;
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
            .append("id", getId())
            .append("semId", getSemId())
            .append("creditCode", getCreditCode())
            .append("legalpersonName", getLegalpersonName())
            .append("companyType", getCompanyType())
            .append("establishDate", getEstablishDate())
            .append("companyState", getCompanyState())
            .append("registeredCapital", getRegisteredCapital())
            .append("businessScope", getBusinessScope())
            .append("registeredAddress", getRegisteredAddress())
            .append("placeDistrict", getPlaceDistrict())
            .append("industryCategory", getIndustryCategory())
            .append("revenueScale", getRevenueScale())
            .append("companyIntroduce", getCompanyIntroduce())
            .append("companyWebsiteAddress", getCompanyWebsiteAddress())
            .append("postalAddress", getPostalAddress())
            .append("shareholder", getShareholder())
            .append("mailbox", getMailbox())
            .append("teamPeople", getTeamPeople())
            .append("createdStime", getCreatedStime())
            .append("modifiedStime", getModifiedStime())
            .append("isDel", getIsDel())
            .toString();
    }
}
