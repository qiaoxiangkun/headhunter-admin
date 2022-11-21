package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.PortalClientExt;

/**
 * 线索客户扩展字段Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-11
 */
public interface PortalClientExtMapper 
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
     * 删除线索客户扩展字段
     * 
     * @param id 线索客户扩展字段主键
     * @return 结果
     */
    public int deletePortalClientExtById(Long id);

    /**
     * 批量删除线索客户扩展字段
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalClientExtByIds(String[] ids);

    /**
     * 根据线索ID获取线索扩展信息
     * @param semId
     * @return
     */
    PortalClientExt selectPortalClientExtBySemId(Long semId);
}
