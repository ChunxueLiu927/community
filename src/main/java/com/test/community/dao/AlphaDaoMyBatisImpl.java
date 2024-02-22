package com.test.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AlphaDaoMyBatisImpl
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/21 16:11
 * @Version 1.0
 */
@Repository
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao {

    @Override
    public String select() {
        return "MyBatis";
    }
}
