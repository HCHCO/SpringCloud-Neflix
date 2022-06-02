package com.controller;

import com.entity.UserBorrowDetail;
import com.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBrrows(@PathVariable("uid")int uid){
        return service.getUserBorrowDetailByUid(uid);
    }
}