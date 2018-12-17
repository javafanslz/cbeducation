package com.education.service.impl;

import com.education.mapper.TeacherMapper;
import com.education.po.TeacherPo;
import com.education.service.TeacherService;
import com.education.vo.TeacherVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: lizhu
 * @ClassName: TeacherServiceImpl
 * @Desciption: Date:2018/8/19
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private Logger logger = Logger.getLogger(TeacherServiceImpl.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public long getCount(TeacherPo teacherVO) {
        logger.debug("进入到TeacherServiceImpl中的getCount方法");
        return teacherMapper.getTotal(teacherVO);
    }

    @Override
    public List<TeacherPo> getTeacherList(TeacherPo teacherPo) {
        logger.debug("进入到TeacherServiceImpl中的getTeacherList方法");
        List<TeacherPo> list = teacherMapper.queryTeachers(teacherPo);
        return list;
    }

    @Override
    public boolean addTeacher(TeacherPo teacherPo){
        Date date = new Date();
        teacherPo.setCreateDate(format.format(date));
        teacherPo.setUpdateDate(format.format(date));
        int result = teacherMapper.addTeacher(teacherPo);
        return result>0;
    }
}
