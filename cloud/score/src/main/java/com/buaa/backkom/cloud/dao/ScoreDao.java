package com.buaa.backkom.cloud.dao;

import com.buaa.backkom.cloud.entities.User;
import com.buaa.backkom.cloud.entities.Score;
import com.buaa.backkom.cloud.entities.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreDao
{
    User getUserById(String id);

    List<Class> getClassById(String id);

    String getClassNameById(String class_id);

    String getTeacherIdByClassId(String id);

    List<Score> getScoreByClass(String id);

    List<Score> getScoreByStudent(String id);

    Long updateScore(@Param("stu_id") String stu_id, @Param("class_id") String class_id, @Param("score")Double score);

    void modifyInfo(@Param("ori_usr_no") String ori_usr_no,
                    @Param("usr_name") String usr_name, @Param("new_psw") String new_psw,
                    @Param("is_modify_psw") Boolean is_modify_psw);
}
