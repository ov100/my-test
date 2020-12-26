package test.case1.strategy;


import test.case1.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 工厂模式
 * @author: gb
 * @create: 2020/09/25
 */
public class UserServiceFactory {
    private static Map<Integer, UserService> CACHE = new HashMap<>();

    public static void registry(int type, UserService service) {
        CACHE.put(type, service);
    }

    public static UserService get(int type) {
        return CACHE.get(type);
    }
}
