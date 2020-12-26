package cace1;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import test.case1.service.*;
import test.case1.strategy.UserServiceStrategy;
import test.util.SpringUtil;

/**
 * @description: 测试1
 * @author: gb
 * @create: 2020/09/25
 */
public class UserServiceTest extends BaseTest {

    @Test
    public void test() {
        UserService a = UserServiceStrategy.of(1);
        UserService b = UserServiceStrategy.of(2);

        a.eat();
        b.eat();

        System.out.println(a);
        System.out.println(b);

        UserAServiceImpl aimpl = SpringUtil.getBean(UserAServiceImpl.class);
        UserBServiceImpl bimpl = SpringUtil.getBean(UserBServiceImpl.class);
        System.out.println(aimpl);
        System.out.println(bimpl);
    }

    @Test
    public void test2(){
        OrderService orderService = SpringUtil.getBean(OrderService.class);
        orderService.save();
    }

    @Test
    @Commit
    public void test3(){
        GroupService service = SpringUtil.getBean(GroupService.class);
        service.save();
    }
}
