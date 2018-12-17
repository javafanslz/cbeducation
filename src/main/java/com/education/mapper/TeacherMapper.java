package com.education.mapper;

import com.education.po.TeacherPo;
import com.education.vo.TeacherVO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface TeacherMapper {

    @SelectProvider(type = TeacherSelectProvider.class,method = "queryTeacher")
    @Results(value = {
            @Result(property = "teacherId",column = "id",javaType = String.class,jdbcType = JdbcType.INTEGER),
            @Result(property = "teacherName",column = "name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "sex",column = "sex",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "birth",column = "birth",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "address",column = "address",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "createDate",column = "createDate",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "updateDate",column = "updateDate",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "major",column = "major",javaType = String.class,jdbcType = JdbcType.INTEGER),
            @Result(property = "startTime",column = "start_time",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "endTime",column = "end_time",javaType = String.class,jdbcType = JdbcType.DATE)
    })
    List<TeacherPo> queryTeachers(@Param("queryVo") TeacherPo teacherPo);

    @SelectProvider(type = TeacherSelectProvider.class,method = "countTeacher")
    int getTotal(@Param("queryVo") TeacherPo teacherPo);

    @UpdateProvider(type = TeacherSelectProvider.class,method = "addTeacher")
    int addTeacher(@Param("addPo") TeacherPo teacherPo);

    int updateTeacher(@Param("queryVo") TeacherVO queryVO);


    class TeacherSelectProvider{

        private Logger logger = Logger.getLogger(TeacherSelectProvider.class);

        public String queryTeacher(Map<String,TeacherPo> queryMap){
            logger.debug("进入到TeacherSelectProvider中的queryTeacher方法");
            TeacherPo queryVo =  queryMap.get("queryVo");
            StringBuffer sql = new StringBuffer();
            sql.append("select id,name,sex,birth,address,createDate,updateDate,major,school,telnum,str_to_date(start_time,'%Y-%m-%d %H:%i:%s') as start_time,str_to_date(end_time,'%Y-%m-%d %H:%i:%s') as end_time from teacher where 1=1 ");
            if(queryVo == null){
                logger.debug("查询的sql语句为["+sql.toString()+"]");
                return sql.toString();
            }
            if(StringUtils.isNotBlank(queryVo.getStartTime())){
                sql.append(" and start_time >= str_to_date('").append(queryVo.getStartTime()).append("','%Y-%m-%d %H:%i:%s')");
            }

            if(StringUtils.isNotBlank(queryVo.getEndTime())){
                sql.append(" and end_time < str_to_date('").append(queryVo.getStartTime()).append("','%Y-%m-%d %H:%i:%s')");
            }
            if(StringUtils.isNotBlank(queryVo.getTeacherName())){
                sql.append(" and name like '%").append(queryVo.getTeacherName()).append("%'");
            }
            if(StringUtils.isNotBlank(queryVo.getTelNum())){
                sql.append(" and telnum like '%").append(queryVo.getTeacherName()).append("%'");
            }
            if(logger.isDebugEnabled()){
                logger.debug(String.format("查询老师的sql语句为:%s",sql.toString()));
            }
            return sql.toString();
        }

        public String countTeacher(Map<String,TeacherPo> queryMap){
            logger.debug("进入到TeacherSelectProvider中的countTeacher方法");
            TeacherPo queryVo =  queryMap.get("queryVo");
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) from teacher where 1=1 ");
            if(queryVo == null){
                logger.debug("查询的sql语句为["+sql.toString()+"]");
                return sql.toString();
            }
            if(StringUtils.isNotBlank(queryVo.getStartTime())){
                sql.append(" and start_time >= str_to_date('").append(queryVo.getStartTime()).append("','%Y-%m-%d %H:%i:%s')");
            }

            if(StringUtils.isNotBlank(queryVo.getEndTime())){
                sql.append(" and end_time < str_to_date('").append(queryVo.getStartTime()).append("','%Y-%m-%d %H:%i:%s')");
            }
            if(StringUtils.isNotBlank(queryVo.getTeacherName())){
                sql.append(" and name like '%").append(queryVo.getTeacherName()).append("%'");
            }
            if(StringUtils.isNotBlank(queryVo.getTelNum())){
                sql.append(" and telnum like '%").append(queryVo.getTeacherName()).append("%'");
            }
            if(logger.isDebugEnabled()){
                logger.debug(String.format("查询老师的sql语句为:%s",sql.toString()));
            }
            return sql.toString();
        }


        /**
         * 添加数据
         * @return
         */
        public String addTeacher(Map<String,TeacherPo> paramMap){
            TeacherPo teacherPo = paramMap.get("addPo");
            StringBuffer sql = new StringBuffer();
            sql.append("insert into teacher values (");
            sql.append("'").append(teacherPo.getTeacherName()).append("',");
            sql.append("'").append(teacherPo.getSex()).append("',");
            sql.append("'").append(teacherPo.getBirth()).append("',");
            sql.append("'").append(teacherPo.getAddress()).append("',");
            sql.append("'").append(teacherPo.getCreateDate()).append("',");
            sql.append("'").append(teacherPo.getUpdateDate()).append("',");
            sql.append("'").append(teacherPo.getMajor()).append("',");
            sql.append("'").append(teacherPo.getSchool()).append("',");
            sql.append("'").append(teacherPo.getTelNum()).append("',");
            sql.append("str_to_date('").append(teacherPo.getStartTime()).append("','%H:%i:%s'),");
            sql.append("str_to_date('").append(teacherPo.getEndTime()).append("','%H:%i:%s'))");

            if(logger.isDebugEnabled()){
                logger.debug(String.format("插入老师的sql语句为:%s",sql.toString()));
            }
            return sql.toString();
        }

        public String updateTeacher(Map<String,TeacherPo> paramMap){
            TeacherPo teacherPo = paramMap.get("addPo");
            StringBuffer sql = new StringBuffer();
            sql.append("update  teacher values set ");
            sql.append("name = '").append(teacherPo.getTeacherName()).append("',");
            sql.append("sex= '").append(teacherPo.getSex()).append("',");
            sql.append("birth = '").append(teacherPo.getBirth()).append("',");
            sql.append("address = '").append(teacherPo.getAddress()).append("',");
            sql.append("createDate ='").append(teacherPo.getCreateDate()).append("',");
            sql.append("updateDate = '").append(teacherPo.getUpdateDate()).append("',");
            sql.append("major = '").append(teacherPo.getMajor()).append("',");
            sql.append("schoole = '").append(teacherPo.getSchool()).append("',");
            sql.append("telNum = '").append(teacherPo.getTeacherName()).append("'");
            sql.append(" where id = ").append(teacherPo.getTeacherId());
            if(logger.isDebugEnabled()){
                logger.debug(String.format("更新老师的sql语句为:%s",sql.toString()));
            }
            return sql.toString();
        }
    }
}
