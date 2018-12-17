package com.education.controller;

import com.alibaba.fastjson.JSONObject;
import com.education.po.TeacherPo;
import com.education.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: lizhu
 * @ClassName: TeacherController
 * @Desciption: Date:2018/8/12
 * 老师controller
 */
@RequestMapping("/teacher")
@Controller
public class TeacherController {
    private Logger logger = Logger.getLogger(TeacherController.class);
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/gotoView")
    public String gotoView(ModelMap modelMap) {
        return "/teacher/queryTeacher";
    }

    /**
     * 查询
     *
     * @param teacherPo
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/queryData")
    @ResponseBody
    public JSONObject queryData(TeacherPo teacherPo, HttpServletRequest request, HttpServletResponse response) {
        JSONObject object = new JSONObject();
        try {
            List<TeacherPo> dataList = teacherService.getTeacherList(teacherPo);
            long count = teacherService.getCount(teacherPo);
            object.put("success", true);
            object.put("total", count);
            object.put("msg", "");
            object.put("rows", dataList);
        } catch (Exception e) {
            object.put("success", false);
            object.put("total", 0);
            object.put("msg", "查询过程失败");
            object.put("rows", null);
        }
        return object;
    }


    /**
     * 查询
     *
     * @param teacherPo
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public JSONObject addData(TeacherPo teacherPo, HttpServletRequest request, HttpServletResponse response) {
        JSONObject object = new JSONObject();
        try {
            boolean result = teacherService.addTeacher(teacherPo);
            if (result) {
                object.put("msg", "success");
            } else {
                object.put("msg", "error");
            }

        } catch (Exception e) {
            logger.error("插入失败",e);
            object.put("msg", "error");

        }
        return object;
    }


}
