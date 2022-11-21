package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Client {
    private Integer clientid;

    private Integer createrid;

    private Date createdtime;

    private String name;

    private String statusid;

    private String sourceid;

    private String contactpersonname;

    private String contactpersonjobtitle;

    private String contactpersonemail;

    private String contactpersonmobilenumber;

    private String contactpersontelnumber;

    private String contactpersonfaxnumber;

    private String contactpersonqq;

    private String contactpersonmsn;

    private String description;

    private String introduction;

    private String address;

    private String zipcode;

    private String weburl;

    private Integer importantstatus;

    private Date lastcommunicationtime;

    private Date contractdate;

    private Date suspensiondate;

    private Date expirationdate;

    private BigDecimal contractratio;

    private String paymentmethod;

    private Integer ensurenceperiod;

    private Integer initialpayment;

    private Integer contractpaymenttype;

    private BigDecimal fixedpayment;

    private Integer qianyuestaffid;

    private Integer companyid;

    private Integer chiefmanagestaffid;

    private Integer viplevel;

    private String contactpersonweixinnum;

    private Integer transferstatus;

    private Integer tuijianstaffid;

    private String tuijianstaffname;

    private Date transfertime;

    private Boolean ispublicclient;

    private Integer phoneareaid;

    private String phoneareacode;

    private String tagkeywords;

    private String companyscale;

    private String companynature;

    private String companyculture;

    private String mainbusiness;

    private Byte certificationstatus;

    private Date certificationtime;

    private String regcapital;

    private String reglocation;

    private String industry;

    private String businessscope;

    private String orgnumber;

    private Date estiblishtime;

    private String regstatus;

    private String legalpersonname;

    private String companyorgtype;

    private String base;

    private String creditcode;

    private Integer parentclientid;

    private Integer internalclientid;

    private String companycity;

    private Integer companyscaleid;

    private Integer companynatureid;

    private Integer innerclient;

    private Integer clientno;

    private Integer clientcategory;

    private String customerid;

    private String transactionno;

    private String fddurl;

    private Integer fddstatus;

    private String clientuuid;

    private Boolean hadentry;

    private Boolean hadincome;

    private Integer socialstaffnum;

    private String staffnumrange;

    private Integer incomeamountcycle;

    private String u8ccode;

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getCreaterid() {
        return createrid;
    }

    public void setCreaterid(Integer createrid) {
        this.createrid = createrid;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid == null ? null : statusid.trim();
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid == null ? null : sourceid.trim();
    }

    public String getContactpersonname() {
        return contactpersonname;
    }

    public void setContactpersonname(String contactpersonname) {
        this.contactpersonname = contactpersonname == null ? null : contactpersonname.trim();
    }

    public String getContactpersonjobtitle() {
        return contactpersonjobtitle;
    }

    public void setContactpersonjobtitle(String contactpersonjobtitle) {
        this.contactpersonjobtitle = contactpersonjobtitle == null ? null : contactpersonjobtitle.trim();
    }

    public String getContactpersonemail() {
        return contactpersonemail;
    }

    public void setContactpersonemail(String contactpersonemail) {
        this.contactpersonemail = contactpersonemail == null ? null : contactpersonemail.trim();
    }

    public String getContactpersonmobilenumber() {
        return contactpersonmobilenumber;
    }

    public void setContactpersonmobilenumber(String contactpersonmobilenumber) {
        this.contactpersonmobilenumber = contactpersonmobilenumber == null ? null : contactpersonmobilenumber.trim();
    }

    public String getContactpersontelnumber() {
        return contactpersontelnumber;
    }

    public void setContactpersontelnumber(String contactpersontelnumber) {
        this.contactpersontelnumber = contactpersontelnumber == null ? null : contactpersontelnumber.trim();
    }

    public String getContactpersonfaxnumber() {
        return contactpersonfaxnumber;
    }

    public void setContactpersonfaxnumber(String contactpersonfaxnumber) {
        this.contactpersonfaxnumber = contactpersonfaxnumber == null ? null : contactpersonfaxnumber.trim();
    }

    public String getContactpersonqq() {
        return contactpersonqq;
    }

    public void setContactpersonqq(String contactpersonqq) {
        this.contactpersonqq = contactpersonqq == null ? null : contactpersonqq.trim();
    }

    public String getContactpersonmsn() {
        return contactpersonmsn;
    }

    public void setContactpersonmsn(String contactpersonmsn) {
        this.contactpersonmsn = contactpersonmsn == null ? null : contactpersonmsn.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl == null ? null : weburl.trim();
    }

    public Integer getImportantstatus() {
        return importantstatus;
    }

    public void setImportantstatus(Integer importantstatus) {
        this.importantstatus = importantstatus;
    }

    public Date getLastcommunicationtime() {
        return lastcommunicationtime;
    }

    public void setLastcommunicationtime(Date lastcommunicationtime) {
        this.lastcommunicationtime = lastcommunicationtime;
    }

    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    public Date getSuspensiondate() {
        return suspensiondate;
    }

    public void setSuspensiondate(Date suspensiondate) {
        this.suspensiondate = suspensiondate;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public BigDecimal getContractratio() {
        return contractratio;
    }

    public void setContractratio(BigDecimal contractratio) {
        this.contractratio = contractratio;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod == null ? null : paymentmethod.trim();
    }

    public Integer getEnsurenceperiod() {
        return ensurenceperiod;
    }

    public void setEnsurenceperiod(Integer ensurenceperiod) {
        this.ensurenceperiod = ensurenceperiod;
    }

    public Integer getInitialpayment() {
        return initialpayment;
    }

    public void setInitialpayment(Integer initialpayment) {
        this.initialpayment = initialpayment;
    }

    public Integer getContractpaymenttype() {
        return contractpaymenttype;
    }

    public void setContractpaymenttype(Integer contractpaymenttype) {
        this.contractpaymenttype = contractpaymenttype;
    }

    public BigDecimal getFixedpayment() {
        return fixedpayment;
    }

    public void setFixedpayment(BigDecimal fixedpayment) {
        this.fixedpayment = fixedpayment;
    }

    public Integer getQianyuestaffid() {
        return qianyuestaffid;
    }

    public void setQianyuestaffid(Integer qianyuestaffid) {
        this.qianyuestaffid = qianyuestaffid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getChiefmanagestaffid() {
        return chiefmanagestaffid;
    }

    public void setChiefmanagestaffid(Integer chiefmanagestaffid) {
        this.chiefmanagestaffid = chiefmanagestaffid;
    }

    public Integer getViplevel() {
        return viplevel;
    }

    public void setViplevel(Integer viplevel) {
        this.viplevel = viplevel;
    }

    public String getContactpersonweixinnum() {
        return contactpersonweixinnum;
    }

    public void setContactpersonweixinnum(String contactpersonweixinnum) {
        this.contactpersonweixinnum = contactpersonweixinnum == null ? null : contactpersonweixinnum.trim();
    }

    public Integer getTransferstatus() {
        return transferstatus;
    }

    public void setTransferstatus(Integer transferstatus) {
        this.transferstatus = transferstatus;
    }

    public Integer getTuijianstaffid() {
        return tuijianstaffid;
    }

    public void setTuijianstaffid(Integer tuijianstaffid) {
        this.tuijianstaffid = tuijianstaffid;
    }

    public String getTuijianstaffname() {
        return tuijianstaffname;
    }

    public void setTuijianstaffname(String tuijianstaffname) {
        this.tuijianstaffname = tuijianstaffname == null ? null : tuijianstaffname.trim();
    }

    public Date getTransfertime() {
        return transfertime;
    }

    public void setTransfertime(Date transfertime) {
        this.transfertime = transfertime;
    }

    public Boolean getIspublicclient() {
        return ispublicclient;
    }

    public void setIspublicclient(Boolean ispublicclient) {
        this.ispublicclient = ispublicclient;
    }

    public Integer getPhoneareaid() {
        return phoneareaid;
    }

    public void setPhoneareaid(Integer phoneareaid) {
        this.phoneareaid = phoneareaid;
    }

    public String getPhoneareacode() {
        return phoneareacode;
    }

    public void setPhoneareacode(String phoneareacode) {
        this.phoneareacode = phoneareacode == null ? null : phoneareacode.trim();
    }

    public String getTagkeywords() {
        return tagkeywords;
    }

    public void setTagkeywords(String tagkeywords) {
        this.tagkeywords = tagkeywords == null ? null : tagkeywords.trim();
    }

    public String getCompanyscale() {
        return companyscale;
    }

    public void setCompanyscale(String companyscale) {
        this.companyscale = companyscale == null ? null : companyscale.trim();
    }

    public String getCompanynature() {
        return companynature;
    }

    public void setCompanynature(String companynature) {
        this.companynature = companynature == null ? null : companynature.trim();
    }

    public String getCompanyculture() {
        return companyculture;
    }

    public void setCompanyculture(String companyculture) {
        this.companyculture = companyculture == null ? null : companyculture.trim();
    }

    public String getMainbusiness() {
        return mainbusiness;
    }

    public void setMainbusiness(String mainbusiness) {
        this.mainbusiness = mainbusiness == null ? null : mainbusiness.trim();
    }

    public Byte getCertificationstatus() {
        return certificationstatus;
    }

    public void setCertificationstatus(Byte certificationstatus) {
        this.certificationstatus = certificationstatus;
    }

    public Date getCertificationtime() {
        return certificationtime;
    }

    public void setCertificationtime(Date certificationtime) {
        this.certificationtime = certificationtime;
    }

    public String getRegcapital() {
        return regcapital;
    }

    public void setRegcapital(String regcapital) {
        this.regcapital = regcapital == null ? null : regcapital.trim();
    }

    public String getReglocation() {
        return reglocation;
    }

    public void setReglocation(String reglocation) {
        this.reglocation = reglocation == null ? null : reglocation.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope == null ? null : businessscope.trim();
    }

    public String getOrgnumber() {
        return orgnumber;
    }

    public void setOrgnumber(String orgnumber) {
        this.orgnumber = orgnumber == null ? null : orgnumber.trim();
    }

    public Date getEstiblishtime() {
        return estiblishtime;
    }

    public void setEstiblishtime(Date estiblishtime) {
        this.estiblishtime = estiblishtime;
    }

    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus == null ? null : regstatus.trim();
    }

    public String getLegalpersonname() {
        return legalpersonname;
    }

    public void setLegalpersonname(String legalpersonname) {
        this.legalpersonname = legalpersonname == null ? null : legalpersonname.trim();
    }

    public String getCompanyorgtype() {
        return companyorgtype;
    }

    public void setCompanyorgtype(String companyorgtype) {
        this.companyorgtype = companyorgtype == null ? null : companyorgtype.trim();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base == null ? null : base.trim();
    }

    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode == null ? null : creditcode.trim();
    }

    public Integer getParentclientid() {
        return parentclientid;
    }

    public void setParentclientid(Integer parentclientid) {
        this.parentclientid = parentclientid;
    }

    public Integer getInternalclientid() {
        return internalclientid;
    }

    public void setInternalclientid(Integer internalclientid) {
        this.internalclientid = internalclientid;
    }

    public String getCompanycity() {
        return companycity;
    }

    public void setCompanycity(String companycity) {
        this.companycity = companycity == null ? null : companycity.trim();
    }

    public Integer getCompanyscaleid() {
        return companyscaleid;
    }

    public void setCompanyscaleid(Integer companyscaleid) {
        this.companyscaleid = companyscaleid;
    }

    public Integer getCompanynatureid() {
        return companynatureid;
    }

    public void setCompanynatureid(Integer companynatureid) {
        this.companynatureid = companynatureid;
    }

    public Integer getInnerclient() {
        return innerclient;
    }

    public void setInnerclient(Integer innerclient) {
        this.innerclient = innerclient;
    }

    public Integer getClientno() {
        return clientno;
    }

    public void setClientno(Integer clientno) {
        this.clientno = clientno;
    }

    public Integer getClientcategory() {
        return clientcategory;
    }

    public void setClientcategory(Integer clientcategory) {
        this.clientcategory = clientcategory;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getTransactionno() {
        return transactionno;
    }

    public void setTransactionno(String transactionno) {
        this.transactionno = transactionno == null ? null : transactionno.trim();
    }

    public String getFddurl() {
        return fddurl;
    }

    public void setFddurl(String fddurl) {
        this.fddurl = fddurl == null ? null : fddurl.trim();
    }

    public Integer getFddstatus() {
        return fddstatus;
    }

    public void setFddstatus(Integer fddstatus) {
        this.fddstatus = fddstatus;
    }

    public String getClientuuid() {
        return clientuuid;
    }

    public void setClientuuid(String clientuuid) {
        this.clientuuid = clientuuid == null ? null : clientuuid.trim();
    }

    public Boolean getHadentry() {
        return hadentry;
    }

    public void setHadentry(Boolean hadentry) {
        this.hadentry = hadentry;
    }

    public Boolean getHadincome() {
        return hadincome;
    }

    public void setHadincome(Boolean hadincome) {
        this.hadincome = hadincome;
    }

    public Integer getSocialstaffnum() {
        return socialstaffnum;
    }

    public void setSocialstaffnum(Integer socialstaffnum) {
        this.socialstaffnum = socialstaffnum;
    }

    public String getStaffnumrange() {
        return staffnumrange;
    }

    public void setStaffnumrange(String staffnumrange) {
        this.staffnumrange = staffnumrange == null ? null : staffnumrange.trim();
    }

    public Integer getIncomeamountcycle() {
        return incomeamountcycle;
    }

    public void setIncomeamountcycle(Integer incomeamountcycle) {
        this.incomeamountcycle = incomeamountcycle;
    }

    public String getU8ccode() {
        return u8ccode;
    }

    public void setU8ccode(String u8ccode) {
        this.u8ccode = u8ccode == null ? null : u8ccode.trim();
    }
}