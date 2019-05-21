package com.wyd.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication
@EnableRedisHttpSession  
@MapperScan(value = "com.wyd.login.dao")
@ComponentScan(basePackages={"com.wyd.login"})
/*public class App extends SpringBootServletInitializer{
	 public static void main( String[] args )
	    {
	        SpringApplication.run(App.class, args);
	    }

	 @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return super.configure(builder);
		}

}*/

public class App {
	 public static void main( String[] args )
	    {
	        SpringApplication.run(App.class, args);
	    }
}

