package com.education.mapper;

import com.education.po.TeacherPo;
import com.education.vo.TeacherVO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
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
            @Result(property = "teacherName",column = "teacherName",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "sex",column = "sex",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "birth",column = "birth",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "address",column = "address",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property = "createDate",column = "createDate",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "updateDate",column = "updateDate",javaType = String.class,jdbcType = JdbcType.DATE),
            @Result(property = "major",column = "major",javaType = String.class,jdbcType = JdbcType.INTEGER)
    })
    List<TeacherPo> queryTeachers(@Param("queryVo") TeacherVO queryVO);

    @SelectProvider(type = TeacherSelectProvider.class,method = "queryCount")
    int getTotal(@Param("queryVo") TeacherVO queryVO);


    class TeacherSelectProvider{

        private Logger logger = Logger.getLogger(TeacherSelectProvider.class);

        public String queryTeacher(Map<String,Object> queryMap){
            logger.debug("进入到TeacherSelectProvider中的queryTeacher方法");
            TeacherVO queryVo = (TeacherVO) queryMap.get("queryVo");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from teacher where 1=1 ");
            if(queryVo == null){
                logger.debug("查询的sql语句为["+sql.toString()+"]");
                return sql.toString();
            }
            if(StringUtils.isNotBlank(queryVo.getStartTime())&&StringUtils.isNotBlank(queryVo.getEndTime())){
               // sql.append("")
            }
            return "";
        }
    }
}
