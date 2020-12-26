package test.case1.strategy;

import test.case1.service.UserService;

/**
 * @description: 接口策略模式
 * @author: gb
 * @create: 2020/09/25
 */
public class UserServiceStrategy {

    public static UserService of(int type){
        return UserServiceFactory.get(type);
    }

}
