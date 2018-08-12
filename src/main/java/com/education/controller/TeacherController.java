package com.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lizhu
 * @ClassName: TeacherController
 * @Desciption: Date:2018/8/12
 * 老师controller
 */
@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @RequestMapping("/gotoView")
    public String gotoView(ModelMap modelMap){
        return "/teacher/queryTeacher";
    }
}
