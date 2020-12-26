package test.case2;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试使用validtion
 * @author: gb
 * @create: 2020/09/25
 */
@RestController
public class MyController {

    @RequestMapping("list")
    public String list(@Validated @RequestBody ValidtionVo vo){

        return "success";
    }
}
