package com.education.vo;

/**
 * @Author: lizhu
 * @ClassName: TeacherVO
 * @Desciption: Date:2018/8/12
 */
public class TeacherVO extends BaseVO {
    private String teaacherName;
    private String teacherId;
    private String sex;
    private String birth;

    public String getTeaacherName() {
        return teaacherName;
    }

    public void setTeaacherName(String teaacherName) {
        this.teaacherName = teaacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "TeacherVO{" +
                "teaacherName='" + teaacherName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
