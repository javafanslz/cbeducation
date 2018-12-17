package com.education.po;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: lizhu
 * @ClassName: TeacherPo
 * @Desciption: Date:2018/8/12
 */
@Data
@ToString(callSuper = true)
public class TeacherPo extends BasePo {
    private String teacherId;
    private String teacherName;
    private String sex;
    private String birth;
    private String address;
    private String createDate;
    private String updateDate;
    private String major;
    private String school;
    private String telNum;
    private String startTime;
    private String endTime;
}