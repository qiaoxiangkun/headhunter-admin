package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PortalSemFileMapper;
import com.ruoyi.system.domain.PortalSemFile;
import com.ruoyi.system.service.IPortalSemFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 线索附件简历Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-04
 */
@Service
public class PortalSemFileServiceImpl implements IPortalSemFileService 
{
    @Autowired
    private PortalSemFileMapper portalSemFileMapper;

    /**
     * 查询线索附件简历
     * 
     * @param id 线索附件简历主键
     * @return 线索附件简历
     */
    @Override
    public PortalSemFile selectPortalSemFileById(Long id)
    {
        return portalSemFileMapper.selectPortalSemFileById(id);
    }

    /**
     * 查询线索附件简历列表
     * 
     * @param portalSemFile 线索附件简历
     * @return 线索附件简历
     */
    @Override
    public List<PortalSemFile> selectPortalSemFileList(PortalSemFile portalSemFile)
    {
        return portalSemFileMapper.selectPortalSemFileList(portalSemFile);
    }

    /**
     * 新增线索附件简历
     * 
     * @param portalSemFile 线索附件简历
     * @return 结果
     */
    @Override
    public int insertPortalSemFile(PortalSemFile portalSemFile)
    {
        return portalSemFileMapper.insertPortalSemFile(portalSemFile);
    }

    /**
     * 修改线索附件简历
     * 
     * @param portalSemFile 线索附件简历
     * @return 结果
     */
    @Override
    public int updatePortalSemFile(PortalSemFile portalSemFile)
    {
        return portalSemFileMapper.updatePortalSemFile(portalSemFile);
    }

    /**
     * 批量删除线索附件简历
     * 
     * @param ids 需要删除的线索附件简历主键
     * @return 结果
     */
    @Override
    public int deletePortalSemFileByIds(String ids)
    {
        return portalSemFileMapper.deletePortalSemFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除线索附件简历信息
     * 
     * @param id 线索附件简历主键
     * @return 结果
     */
    @Override
    public int deletePortalSemFileById(Long id)
    {
        return portalSemFileMapper.deletePortalSemFileById(id);
    }
}
