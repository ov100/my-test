package test.case1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description:
 * @author: gb
 * @create: 2020/09/25
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GameService gameService;
    @Lazy
    @Autowired
    private OrderService orderService;

    @Transactional
    @Override
    public void save() {
        gameService.save();
        orderService.save();
    }
}
