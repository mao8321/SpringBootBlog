package com.zhanglz.frame.web.controller;

import com.zhanglz.frame.web.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("web")
public class WebController {
    @Autowired
    @Qualifier("webService")
    private WebService webService;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        List<String> strList = webService.getFileList();
        request.setAttribute("strList",strList);
        return "index";
    }

    @RequestMapping("initFile")
    public void init(HttpServletRequest request){
        String nameStr = request.getParameter("nameStr");
        for(String str : nameStr.split("_")){
            webService.initFile(str);
        }
    }

    @RequestMapping("show")
    public String showFrame(HttpServletRequest request){
        return "note_01.html";
    }

}
