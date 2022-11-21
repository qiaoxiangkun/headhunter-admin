/*
package com.ruoyi.framework.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


*/
/**
 * qiaoxiangkun
 *//*

@Configuration
@MapperScan(basePackages = {"com.ruoyi.system.mapper.headhuntersqlserver"}, sqlSessionTemplateRef  = "headhuntersqlserverSqlSessionTemplate")
public class HeadHunterSqlServerConfig {
    @Primary
    @Bean(name = "headhuntersqlserverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.headhuntersqlserver")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean(name = "headhuntersqlserverTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("headhuntersqlserverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Primary
    @Bean(name = "headhuntersqlserverSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("headhuntersqlserverDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/ruoyi/system/mapper/headhuntersqlserver/*.xml"));
        return factoryBean.getObject();
    }
    @Primary
    @Bean(name = "headhuntersqlserverSqlSessionTemplate")
    public SqlSessionTemplate headhuntersqlserverSqlSessionTemplate(@Qualifier("headhuntersqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

*/
