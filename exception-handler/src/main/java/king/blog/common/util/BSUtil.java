package king.blog.common.util;

import king.blog.common.exception.BusinessException;
import org.springframework.validation.Errors;

import java.util.function.Predicate;

/**
 * Created by kinginblue on 2017/1/11.
 */
public class BSUtil {

    public static final String ILLEGAL_OPERATION = "illegal operation!";

    public static final String FAILED_OPERATION = "操作失败!";

    public static <T> void isTrue(T arg, Predicate<T> predicate, String error){
        if(!predicate.test(arg)){
            throw new BusinessException(error);
        }
    }

    public static void isTrue(boolean expression, String error){
        if(!expression) {
            throw new BusinessException(error);
        }
    }

    public static void isNull(Object object, String error){
        if(object != null) {
            throw new BusinessException(error);
        }
    }

    public static void notNull(Object object, String error) {
        if(object == null) {
            throw new BusinessException(error);
        }
    }

    /**
     * 校验 Controller 层数据 @Validated 的结果
     */
    public static void controllerValidate(Errors...errorsList){
        for (Errors errors : errorsList) {
            isTrue(!errors.hasErrors(), errors.hasErrors() ? errors.getFieldError().getDefaultMessage() : "");
        }
    }

    /**
     * 正则校验
     * @param input
     * @param regexp
     * @param error
     */
    public static void validateRegexp(String input, String regexp, String error){
        isTrue(input.matches(regexp), error);
    }
}
