package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PortalSem;

/**
 * 线索Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface PortalSemMapper 
{
    /**
     * 查询线索
     * 
     * @param semId 线索主键
     * @return 线索
     */
    public PortalSem selectPortalSemBySemId(Long semId);

    /**
     * 查询线索列表
     * 
     * @param portalSem 线索
     * @return 线索集合
     */
    public List<PortalSem> selectPortalSemList(PortalSem portalSem);

    /**
     * 新增线索
     * 
     * @param portalSem 线索
     * @return 结果
     */
    public int insertPortalSem(PortalSem portalSem);

    /**
     * 修改线索
     * 
     * @param portalSem 线索
     * @return 结果
     */
    public int updatePortalSem(PortalSem portalSem);

    /**
     * 删除线索
     * 
     * @param semId 线索主键
     * @return 结果
     */
    public int deletePortalSemBySemId(Long semId);

    /**
     * 批量删除线索
     * 
     * @param semIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalSemBySemIds(String[] semIds);

    public int updatePortalSemBySemIds(String[] semIds);
}
