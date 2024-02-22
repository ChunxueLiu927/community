package com.test.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @ClassName AlphaDaoHibernateImpl
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/21 16:08
 * @Version 1.0
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
