package com.test.community.controller;

import com.test.community.entity.User;
import com.test.community.service.LikeService;
import com.test.community.util.CommunityUtil;
import com.test.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LikeController
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/25 20:23
 * @Version 1.0
 */
@Controller
public class LikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/like", method = RequestMethod.POST)
    @ResponseBody
    public String like(int entityType, int entityId, int entityUserId) {
        User user = hostHolder.getUser();
        // 点赞
        likeService.like(user.getId(), entityType, entityId, entityUserId);
        // 数量
        long likeCount = likeService.findEntityLikeCount(entityType, entityId);
        int likeStatus = likeService.findEntityLikeStatus(user.getId(), entityType, entityId);

        Map<String, Object> map = new HashMap<>();
        map.put("likeCount", likeCount);
        map.put("likeStatus", likeStatus);

        return CommunityUtil.getJSONString(0, null, map);
    }
}
