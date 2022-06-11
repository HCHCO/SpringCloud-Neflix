package com.controller;

import com.entity.UserBorrowDetail;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBrrows(@PathVariable("uid")int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    UserBorrowDetail onError(int uid){
        System.out.println("on error");
        return new UserBorrowDetail(null, Collections.emptyList());
    }


//    @HystrixCommand(fallbackMethod = "onError")
//    @RequestMapping("/borrow/{uid}")
//    UserBorrowDetail findUserBrrows(@PathVariable("uid")int uid){
//        return service.getUserBorrowDetailByUid(uid);
//    }
//    UserBorrowDetail onError(int uid){
//        System.out.println("on error");
//        return new UserBorrowDetail(null, Collections.emptyList());
//    }
}
