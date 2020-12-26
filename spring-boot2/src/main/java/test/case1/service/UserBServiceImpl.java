package test.case1.service;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.case1.domain.User;
import test.case1.domain.UserMapper;
import test.case1.strategy.UserServiceFactory;

/**
 * @description: 实现类a
 * @author: gb
 * @create: 2020/09/25
 */
//@Service
public class UserBServiceImpl implements UserService
//        , InitializingBean
{
    //@Autowired
    private UserMapper userMapper;

    @Override
    public void eat() {
        System.out.println(this+"->我是B喜欢吃土豆");
    }

    //@Transactional(rollbackFor = Exception.class)
    @Override
    public void save() {
        User u = new User();
        u.setSchoolId(RandomUtil.randomInt(100000));
        userMapper.insert(u);
    }

    //@Override
    public void afterPropertiesSet() throws Exception {
        UserServiceFactory.registry(2,this);
    }
}
