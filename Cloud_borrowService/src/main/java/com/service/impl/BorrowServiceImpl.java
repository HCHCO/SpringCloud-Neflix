package com.service.impl;

import com.Mapper.BorrowMapper;
import com.entity.UserBorrowDetail;
import com.service.BorrowService;
import entity.Book;
import entity.Borrow;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper mapper;
    @Resource
    RestTemplate template;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrows=mapper.getBorrowByUid(uid);
        //User user = template.getForObject("http://localhost:1236/user/"+uid,User.class);
        User user = template.getForObject("http://UserService/user/"+uid,User.class);
        List<Book> bookList= borrows
                .stream()
                //.map(b->template.getForObject("http://localhost:1234/book/"+b.getBid(),Book.class))
                .map(b->template.getForObject("http://BookService/book/"+b.getBid(),Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);
    }
}
