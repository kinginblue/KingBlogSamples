package king.blog.config.jackson.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Created by kinginblue on 2017/1/12.
 */
public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper(){
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);// 设置序列化时，null字段不序列化
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// 设置序列化空对象时不抛异常
    }

}
