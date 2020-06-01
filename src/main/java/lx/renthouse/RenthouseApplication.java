package lx.renthouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan(basePackages = {"lx.renthouse.dao"})
public class RenthouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenthouseApplication.class, args);
    }

    //配置action后缀
/*    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
        bean.addUrlMappings("*.action");
        return bean;
    }*/

}
