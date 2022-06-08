package com.service.client;

import entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserFallbackClient implements UserClient{
    @Override
    public User getUserById(int uid) {
        System.out.println("fallback 被调用了");
        User user=new User();
        user.setName("errorUser");
        return user;
    }

}
