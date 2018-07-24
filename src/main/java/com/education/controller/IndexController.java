package com.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <dl>
 * <dt> IndexController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate:2018/7/12</dd>
 * </dl>
 *
 * @author lizhu
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/gotoIndex")
    public String gotoIndex(){
        return "index";
    }
}
