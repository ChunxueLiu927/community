package com.test.community.controller;

import com.test.community.entity.DiscussPost;
import com.test.community.entity.Page;
import com.test.community.entity.User;
import com.test.community.service.DiscussPostService;
import com.test.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/22 15:02
 * @Version 1.0
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

     @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String setIndexPage(Model model, Page page) {
         // 方法调用之前，SpringMVC会自动实例化Model和Page,并将Page注入Model
         // 所以在thymeleaf中可以直接访问Page对象中的数据
         page.setRows(discussPostService.findDiscussPostRows(0));
         page.setPath("/index");
         List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
         List<Map<String, Object>> discussPosts = new ArrayList<>();
         if (list != null) {
             for (DiscussPost post:
                  list) {
                 Map<String, Object> map = new HashMap<>();
                 map.put("post", post);
                 User user = userService.findUserById(post.getUserId());
                 System.out.println(user);
                 discussPosts.add(map);
             }
         }
         model.addAttribute("discussPosts", discussPosts);
         return "/index";
     }


}
