package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Client;
import com.ruoyi.system.domain.PortalClientExt;

/**
 * 线索客户扩展字段Service接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface IPortalClientExtService 
{
    /**
     * 查询线索客户扩展字段
     * 
     * @param id 线索客户扩展字段主键
     * @return 线索客户扩展字段
     */
    public PortalClientExt selectPortalClientExtById(Long id);

    /**
     * 查询线索客户扩展字段列表
     * 
     * @param portalClientExt 线索客户扩展字段
     * @return 线索客户扩展字段集合
     */
    public List<PortalClientExt> selectPortalClientExtList(PortalClientExt portalClientExt);

    /**
     * 新增线索客户扩展字段
     * 
     * @param portalClientExt 线索客户扩展字段
     * @return 结果
     */
    public int insertPortalClientExt(PortalClientExt portalClientExt);

    /**
     * 修改线索客户扩展字段
     * 
     * @param portalClientExt 线索客户扩展字段
     * @return 结果
     */
    public int updatePortalClientExt(PortalClientExt portalClientExt);

    /**
     * 批量删除线索客户扩展字段
     * 
     * @param ids 需要删除的线索客户扩展字段主键集合
     * @return 结果
     */
    public int deletePortalClientExtByIds(String ids);

    /**
     * 删除线索客户扩展字段信息
     * 
     * @param id 线索客户扩展字段主键
     * @return 结果
     */
    public int deletePortalClientExtById(Long id);

    PortalClientExt selectPortalClientExtBySemId(Long semId);

    Client getClientByCompanyName(String companyName);
}
