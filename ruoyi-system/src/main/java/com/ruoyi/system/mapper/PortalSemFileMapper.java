package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PortalSemFile;

/**
 * 线索附件简历Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
public interface PortalSemFileMapper 
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
     * 删除线索附件简历
     * 
     * @param id 线索附件简历主键
     * @return 结果
     */
    public int deletePortalSemFileById(Long id);

    /**
     * 批量删除线索附件简历
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalSemFileByIds(String[] ids);
}
