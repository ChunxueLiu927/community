package com.test.community.service;

import com.test.community.dao.DiscussPostMapper;
import com.test.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DiscussPostService
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/22 14:51
 * @Version 1.0
 */
@Service
public class DiscussPostService {

    private final DiscussPostMapper discussPostMapper;

    @Autowired
    public DiscussPostService(DiscussPostMapper discussPostMapper) {
        this.discussPostMapper = discussPostMapper;
    }

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
