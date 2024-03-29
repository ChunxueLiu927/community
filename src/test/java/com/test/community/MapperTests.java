package com.test.community;


import com.mysql.cj.log.Log;
import com.test.community.dao.DiscussPostMapper;
import com.test.community.dao.LoginTicketMapper;
import com.test.community.dao.MessageMapper;
import com.test.community.dao.UserMapper;
import com.test.community.entity.DiscussPost;
import com.test.community.entity.LoginTicket;
import com.test.community.entity.Message;
import com.test.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MapperTests
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/21 21:33
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void selectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Autowired
    private LoginTicketMapper ticketMapper;
    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        ticketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = ticketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
        ticketMapper.updateStatus("abc", 1);
        loginTicket = ticketMapper.selectByTicket("abc");
        System.out.println(loginTicket);


    }

    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testSelectLetters() {
        List<Message> list = messageMapper.selectConversations(111,0,20);
        for (Message message:
             list) {
            System.out.println(message);
        }

        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);
        List<Message> list1 =  messageMapper.selectLetters("111_112", 0,10);
        for (Message message:
                list1) {
            System.out.println(message);
        }

        int count1 = messageMapper.selectLetterCount("111_112");
        System.out.println(count1);

    }




}
