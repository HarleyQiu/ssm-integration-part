package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIoCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * rootIoc容器配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, MapperJavaConfig.class, ServiceJavaConfig.class};
    }

    /**
     * webIoc容器配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    /**
     * dispatcherServlet的拦截路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
