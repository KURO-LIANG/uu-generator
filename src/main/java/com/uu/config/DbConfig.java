/**
 * Copyright (c) 2016-2019 炫酷游 All rights reserved.
 *
 * https://www.xkygame.com
 *
 * 版权所有，侵权必究！
 */

package com.uu.config;

import com.uu.dao.*;
import com.uu.utils.UUException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库配置
 *
 * @author KURO clarence_liang@163.com
 */
@Configuration
public class DbConfig {
    @Value("${slowcom.database: mysql}")
    private String database;
    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;
    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;
    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;
    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao(){
        if("mysql".equalsIgnoreCase(database)){
            return mySQLGeneratorDao;
        }else if("oracle".equalsIgnoreCase(database)){
            return oracleGeneratorDao;
        }else if("sqlserver".equalsIgnoreCase(database)){
            return sqlServerGeneratorDao;
        }else if("postgresql".equalsIgnoreCase(database)){
            return postgreSQLGeneratorDao;
        }else {
            throw new UUException("不支持当前数据库：" + database);
        }
    }
}
