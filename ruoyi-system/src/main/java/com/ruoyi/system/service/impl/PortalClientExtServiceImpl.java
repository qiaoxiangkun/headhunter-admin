package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Client;
import com.ruoyi.system.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PortalClientExtMapper;
import com.ruoyi.system.domain.PortalClientExt;
import com.ruoyi.system.service.IPortalClientExtService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED;

/**
 * 线索客户扩展字段Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
@Service
public class PortalClientExtServiceImpl implements IPortalClientExtService 
{
    @Autowired
    private PortalClientExtMapper portalClientExtMapper;
    @Autowired
    ClientMapper clientMapper;

    /**
     * 查询线索客户扩展字段
     * 
     * @param id 线索客户扩展字段主键
     * @return 线索客户扩展字段
     */
    @Override
    public PortalClientExt selectPortalClientExtById(Long id)
    {
        return portalClientExtMapper.selectPortalClientExtById(id);
    }

    /**
     * 查询线索客户扩展字段列表
     * 
     * @param portalClientExt 线索客户扩展字段
     * @return 线索客户扩展字段
     */
    @Override
    public List<PortalClientExt> selectPortalClientExtList(PortalClientExt portalClientExt)
    {
        return portalClientExtMapper.selectPortalClientExtList(portalClientExt);
    }

    /**
     * 新增线索客户扩展字段
     * 
     * @param portalClientExt 线索客户扩展字段
     * @return 结果
     */
    @Override
    public int insertPortalClientExt(PortalClientExt portalClientExt)
    {
        return portalClientExtMapper.insertPortalClientExt(portalClientExt);
    }

    /**
     * 修改线索客户扩展字段
     * 
     * @param portalClientExt 线索客户扩展字段
     * @return 结果
     */
    @Override
    public int updatePortalClientExt(PortalClientExt portalClientExt)
    {
        return portalClientExtMapper.updatePortalClientExt(portalClientExt);
    }

    /**
     * 批量删除线索客户扩展字段
     * 
     * @param ids 需要删除的线索客户扩展字段主键
     * @return 结果
     */
    @Override
    public int deletePortalClientExtByIds(String ids)
    {
        return portalClientExtMapper.deletePortalClientExtByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除线索客户扩展字段信息
     * 
     * @param id 线索客户扩展字段主键
     * @return 结果
     */
    @Override
    public int deletePortalClientExtById(Long id)
    {
        return portalClientExtMapper.deletePortalClientExtById(id);
    }
    @Override
    public PortalClientExt selectPortalClientExtBySemId(Long semId)
    {
        return portalClientExtMapper.selectPortalClientExtBySemId(semId);
    }
    /**
     * 不使用事务
     * @param companyName
     * @return
     */
    @Override
    @Transactional(propagation = NOT_SUPPORTED )
    public Client getClientByCompanyName(String companyName) {
        Client client=clientMapper.getClientByCompanyName(companyName);
        return client;
    }
}
