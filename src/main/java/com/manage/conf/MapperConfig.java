package com.manage.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by L on 2017/8/12.
 */

@Configuration
public class MapperConfig {

//    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//    mapperScannerConfigurer.setBasePackage("cn.XXX.dao.mapper");
//    Properties propertiesMapper = new Properties();
//    propertiesMapper.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
//    propertiesMapper.setProperty("IDENTITY","SELECT REPLACE(UUID(),'-','')");
//    propertiesMapper.setProperty("ORDER","BEFORE");
//    mapperScannerConfigurer.setProperties(propertiesMapper);
//    return mapperScannerConfigurer;
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.manage.mapping");
        mapperScannerConfigurer.setMarkerInterface(tk.mybatis.mapper.common.Mapper.class);
        Properties propertiesMapper = new Properties();
        propertiesMapper.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
        propertiesMapper.setProperty("IDENTITY","SELECT LAST_INSERT_ID()");
        propertiesMapper.setProperty("ORDER","AFTER");//BEFORE AFTER
        mapperScannerConfigurer.setProperties(propertiesMapper);
        return mapperScannerConfigurer;
    }

}
