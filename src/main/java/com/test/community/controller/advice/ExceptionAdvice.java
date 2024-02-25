package com.test.community.controller.advice;

import com.test.community.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ExceptionAdvice
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/25 15:20
 * @Version 1.0
 */
@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    @ExceptionHandler({Exception.class})
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response){
        logger.error("服务器发生异常" + e.getMessage());
        for(StackTraceElement element : e.getStackTrace()){
            logger.error(element.toString());
        }

        String xRequestedWith = request.getHeader("x-requested-with");
        if("XMLHttpRequest".equals(xRequestedWith)) {
            response.setContentType("application/plain;charset=utf-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.write(CommunityUtil.getJSONString(1, "服务器异常！"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else {
            try {
                response.sendRedirect(request.getContextPath() + "/error");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
