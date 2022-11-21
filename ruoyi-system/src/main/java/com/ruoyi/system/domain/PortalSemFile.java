package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 线索附件简历对象 portal_sem_file
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
public class PortalSemFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 线索ID */
    @Excel(name = "线索ID")
    private Long semId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileUrl;

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
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
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
            .append("fileName", getFileName())
            .append("fileUrl", getFileUrl())
            .append("createdStime", getCreatedStime())
            .append("modifiedStime", getModifiedStime())
            .append("isDel", getIsDel())
            .toString();
    }
}
