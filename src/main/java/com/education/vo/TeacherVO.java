package com.education.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: lizhu
 * @ClassName: TeacherVO
 * @Desciption: Date:2018/8/12
 */
@Data
@ToString(callSuper = true)
public class TeacherVO extends BaseVO {
    private String teaacherName;
    private String teacherId;
}
