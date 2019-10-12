package com.zhanglz.frame.web.controller;

import com.zhanglz.frame.web.service.WebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("web")
public class WebController {
    @Autowired
    @Qualifier("webService")
    private WebService webService;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        List<String> strList = webService.getFileList();
        List<String> htmlList = webService.getHtmlList();
        request.setAttribute("strList",strList);
        log.info("htmlList = {} ", htmlList);
        request.setAttribute("htmlList",htmlList);
        return "index.html";
    }

    @RequestMapping("initFile")
    @ResponseBody
    public void init(HttpServletRequest request){
        String nameStr = request.getParameter("nameStr");
        for(String str : nameStr.split("_")){
            log.info("fileName =  {}",str);
            webService.initFile(str);
        }
    }

    @RequestMapping("show")
    @ResponseBody
    public ModelAndView showFrame(HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        view.setViewName(request.getParameter("url"));
        return view;
    }

}
