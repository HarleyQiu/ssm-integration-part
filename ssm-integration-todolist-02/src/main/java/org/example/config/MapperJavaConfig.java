package org.example.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MapperJavaConfig {

    /**
     * sqlSessionFactory加入ioc容器
     *
     * @param dataSource 德鲁伊连接池
     * @return sqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //指定配置文件等信息
        //指定数据库连接池对象
        sqlSessionFactory.setDataSource(dataSource);
        //指定mybatis配置文件的功能，使用代码的形式
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);

        // 存储setting的配置文件
        sqlSessionFactory.setConfiguration(configuration);

        //别名设置
        sqlSessionFactory.setTypeAliasesPackage("org.example.pojo");

        // 分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactory.addPlugins(pageInterceptor);

        return sqlSessionFactory;
    }

    /**
     * mapper代理对象加入到ioc
     *
     * @return mapper
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // Mapper代理兑现的factoryBean -> 指定一个包 -> mapper接口 -》sqlSessionFactory -> sqlSession -> getMapper -> mapper代理对象 -》 ioc
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.example.mapper");
        return mapperScannerConfigurer;
    }


}
