package king.blog.config.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import king.blog.config.jackson.mapper.CustomObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by kinginblue on 2016/8/11.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    ObjectMapper objectMapper(){
        return new CustomObjectMapper();
    }

}
