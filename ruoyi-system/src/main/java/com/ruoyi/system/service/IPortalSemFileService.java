package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PortalSemFile;

/**
 * 线索附件简历Service接口
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
public interface IPortalSemFileService 
{
    /**
     * 查询线索附件简历
     * 
     * @param id 线索附件简历主键
     * @return 线索附件简历
     */
    public PortalSemFile selectPortalSemFileById(Long id);

    /**
     * 查询线索附件简历列表
     * 
     * @param portalSemFile 线索附件简历
     * @return 线索附件简历集合
     */
    public List<PortalSemFile> selectPortalSemFileList(PortalSemFile portalSemFile);

    /**
     * 新增线索附件简历
     * 
     * @param portalSemFile 线索附件简历
     * @return 结果
     */
    public int insertPortalSemFile(PortalSemFile portalSemFile);

    /**
     * 修改线索附件简历
     * 
     * @param portalSemFile 线索附件简历
     * @return 结果
     */
    public int updatePortalSemFile(PortalSemFile portalSemFile);

    /**
     * 批量删除线索附件简历
     * 
     * @param ids 需要删除的线索附件简历主键集合
     * @return 结果
     */
    public int deletePortalSemFileByIds(String ids);

    /**
     * 删除线索附件简历信息
     * 
     * @param id 线索附件简历主键
     * @return 结果
     */
    public int deletePortalSemFileById(Long id);
}
