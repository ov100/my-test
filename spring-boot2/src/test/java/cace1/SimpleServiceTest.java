package cace1;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import test.case1.service.SimpleService;
import test.util.SpringUtil;

/**
 * @author gb
 * @date 2020/12/25
 */
public class SimpleServiceTest extends BaseTest {
    @Test
    public void test(){
        SimpleService service = SpringUtil.getBean(SimpleService.class);
        service.save();
    }
}
