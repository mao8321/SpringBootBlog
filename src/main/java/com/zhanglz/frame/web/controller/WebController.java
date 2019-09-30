package com.zhanglz.frame.web.controller;

import com.zhanglz.frame.web.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("web")
public class WebController {
    @Autowired
    @Qualifier("webService")
    private WebService webService;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        webService.initFile();
        request.setAttribute("name","张力中");
        return "index";
    }

    @RequestMapping("show")
    public String showFrame(HttpServletRequest request){
        return "note_01.html";
    }

}
