package com.test.community;

import com.test.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName SensitiveTests
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/24 15:44
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "可以赌博，可以开票，可以嫖娼，可以吸毒哈哈哈哈！";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
