package com.zz.pail.core.control;

import com.zz.pail.annotation.PailsController;
import com.zz.pail.annotation.PailsRequestMapping;
import com.zz.pail.annotation.PailsRequestParam;
import com.zz.pail.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@PailsController
@PailsRequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource(name="userService")
    private UserService userService;

    @PailsRequestMapping("/doTest")
    public void test1(HttpServletRequest request, HttpServletResponse response,
                      @PailsRequestParam("param") String param){
        logger.info(param);
        try {
            response.getWriter().write( "doTest method success! param:"+param);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @PailsRequestMapping("/doTest2")
    public void test2(HttpServletRequest request, HttpServletResponse response){
        try {
            response.getWriter().println("doTest2 method success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}