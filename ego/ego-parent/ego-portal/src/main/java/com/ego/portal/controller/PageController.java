package com.ego.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/5
 */
@Controller
public class PageController {

    @RequestMapping("/")/*表示跳转任何控制器*/
    public String welcome(){
        return "index";
    }
}
