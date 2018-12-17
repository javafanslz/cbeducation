package com.education.service;

import com.education.po.TeacherPo;

import java.util.List;

public interface TeacherService {
    /**
     * 查询总数
     * @param teacherPo
     * @return
     */
    long getCount(TeacherPo teacherPo);

    /**
     * 查询教师列表
     * @param teacherPo
     * @return
     */
    List<TeacherPo> getTeacherList(TeacherPo teacherPo);

    /**
     * 添加数据
     * @param teacherPo
     * @return
     */
    boolean addTeacher(TeacherPo teacherPo);

}
