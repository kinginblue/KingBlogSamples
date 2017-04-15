package king.blog.common.exception;

/**
 * Created by kinginblue on 2017/1/11.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(){
        super();
    }

    public BusinessException(String message){
        super(message);
    }
}
