package com.dkt.controller.once;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther shr
 * @date 2018/2/27
 * @time 16:39
 * @desc 一次图跳转控制类
 **/
@Controller
@RequestMapping(value="/once")
public class OnceController {

    /**
     * 进入tab标签
     * @return
     */
    @RequestMapping(value="/dy")
    public String goDy(){
        return "once/yicitu/index";
    }

    @RequestMapping(value="/gy")
    public String goGy(){
        return "once/yicitu_gy/index";
    }
}
