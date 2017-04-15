package king.blog.service;

import king.blog.model.Dog;
import king.blog.common.util.BSUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kinginblue on 2017/4/10.
 */
@Service
public class DogService {

    @Transactional
    public Dog save(Dog dog){
        return dog;
    }

    @Transactional
    public Dog update(Dog dog){

        // some database options

        // 模拟狗狗新名字与其他狗狗的名字冲突
        BSUtil.isTrue(false, "狗狗名字已经被使用了...");

        // update database dog info

        // query dog info from database after update

        return dog;
    }

}
