package test.case1.service;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.case1.domain.Game;
import test.case1.domain.GameMapper;


/**
 * @description:
 * @author: gb
 * @create: 2020/09/25
 */
@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameMapper gameMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save() {
        Game o = new Game();
        o.setSchoolId(RandomUtil.randomInt(100000));
        o.setCreateBy(99);
        gameMapper.insert(o);
    }
}
