package com.education.service;

import com.education.po.TeacherPo;
import com.education.vo.TeacherVO;

public interface TeacherService {
    /**
     * 查询总数
     * @param teacherVO
     * @return
     */
    long getCount(TeacherVO teacherVO);

    /**
     * 查询教师列表
     * @param teacherVO
     * @return
     */
    TeacherPo getTeacherList(TeacherVO teacherVO);

}
