package com.test.community.util;

import com.test.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName HostHolder
 * @Description 持有用户信息，用于代替session对象
 * @Author lcx
 * @Date 2024/2/23 14:59
 * @Version 1.0
 */

@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
