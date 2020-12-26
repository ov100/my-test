package test.case1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.case1.service.GroupService;

/**
 * test
 *
 * @author gb
 * @date 2020/12/21
 */
@RestController
public class Case1Controller {
    @Autowired
    private GroupService groupService;

    @GetMapping("/")
    public String test(){
        groupService.save();
        return "success";
    }
}
