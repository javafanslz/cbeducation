package com.education.service.impl;

import com.education.mapper.TeacherMapper;
import com.education.po.TeacherPo;
import com.education.service.TeacherService;
import com.education.vo.TeacherVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lizhu
 * @ClassName: TeacherServiceImpl
 * @Desciption: Date:2018/8/19
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private Logger logger = Logger.getLogger(TeacherServiceImpl.class);
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public long getCount(TeacherVO teacherVO) {
        logger.debug("进入到TeacherServiceImpl中的getCount方法");
        return 0;
    }

    @Override
    public TeacherPo getTeacherList(TeacherVO teacherVO) {
        return null;
    }
}
