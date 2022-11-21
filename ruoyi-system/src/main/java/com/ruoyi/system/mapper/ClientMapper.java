package com.ruoyi.system.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.Client;
@DataSource(value = DataSourceType.SLAVE)
public interface ClientMapper {
    int deleteByPrimaryKey(Integer clientid);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer clientid);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    /**
     * 根据公司名称查询公司信息
     * @param companyName
     * @return
     */
    Client getClientByCompanyName(String companyName);
}