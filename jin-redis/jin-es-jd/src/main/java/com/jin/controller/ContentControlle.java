package com.jin.controller;

import com.jin.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ContentControlle {

    @Autowired
    private ContentService contentService;

    @GetMapping("/parse/{keywords}")
    @ResponseBody
    public boolean parse(@PathVariable("keywords") String keywords) throws IOException {
        return  contentService.parseContent(keywords);
    }
    @ResponseBody
    @RequestMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> getGoods(@PathVariable String keyword,@PathVariable int pageNo,@PathVariable int pageSize){
        try {
            return contentService.search(keyword, pageNo, pageSize);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
