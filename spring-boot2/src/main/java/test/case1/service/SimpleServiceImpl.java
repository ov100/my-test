package test.case1.service;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.case1.domain.Game;
import test.case1.domain.GameMapper;
import test.case1.domain.Order;
import test.case1.domain.OrderMapper;

/**
 * 简单测试
 *
 * @author gb
 * @date 2020/12/25
 */
@Service
public class SimpleServiceImpl implements SimpleService{
    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save() {
        Game game = new Game();
        game.setSchoolId(RandomUtil.randomInt(100000));
        game.setCreateBy(99);
        gameMapper.insert(game);

        Order order = new Order();
        order.setSchoolId(RandomUtil.randomInt(100000));
        order.setCreateBy(99);
        orderMapper.insert(order);

        if(true){
            throw new RuntimeException("");
        }
    }
}
