package com.echo.controller;

import com.echo.entity.LearnResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by echo on 2017/7/17.
 */
@Controller
@RequestMapping("/learn")
public class LearnController {

    @Autowired
    private LearnService learnService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn(){
        return "learn-resource";
    }

    @RequestMapping(value = "/queryLearnList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void queryLearnList(HttpServletRequest request, HttpServletResponse response){
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String author = request.getParameter("author");
        String title = request.getParameter("title");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("author", author);
        params.put("title", title);

        List<LearnResource> learnList = learnService.queryLearnResourceList(params);
        PageInfo<LearnResource> pageInfo = new PageInfo<LearnResource>(learnList);
    }
}
