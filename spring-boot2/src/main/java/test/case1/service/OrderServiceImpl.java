package test.case1.service;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.case1.domain.Order;
import test.case1.domain.OrderMapper;


/**
 * @description:
 * @author: gb
 * @create: 2020/09/25
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save() {
        Order o = new Order();
        o.setSchoolId(RandomUtil.randomInt(100000));
        o.setCreateBy(99);
        orderMapper.insert(o);
        if(true){
            throw new RuntimeException("");
        }

        //UserServiceStrategy.of(1).save();
    }
}
