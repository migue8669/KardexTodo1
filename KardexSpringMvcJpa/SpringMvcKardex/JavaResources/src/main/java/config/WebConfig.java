package config;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.InternalResourceViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@ComponentScan({"springmvc_example"})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		org.springframework.web.servlet.view.InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp");
		viewResolver.setPrefix(".jsp");
		return viewResolver;
				
	}
	@Bean
	public MongoDbFactory mongoDbFactory(){
		return new SimpleMongoDbFactory(new MongoClient("localhost",27017),"test");

	}
	@Bean
	public MongoTemplate mongoTemplate (){
		return new MongoTemplate(mongoDbFactory());
	}

}
