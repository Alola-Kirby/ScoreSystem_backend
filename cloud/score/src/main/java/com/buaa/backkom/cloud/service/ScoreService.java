package com.buaa.backkom.cloud.service;

import com.buaa.backkom.cloud.entities.Class;
import com.buaa.backkom.cloud.entities.User;
import com.buaa.backkom.cloud.entities.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreService
{
    User getUserById(String id);

    List<Class> getClassById(String id);

    String getClassNameById(String class_id);

    String getTeacherIdByClassId(String id);

    List<Score> getScoreByClass(String id);

    List<Score> getScoreByScore(String id);

    Long updateScore(@Param("stu_id") String stu_id, @Param("class_id") String class_id, @Param("score")Double score);

    String modifyInfo(String oriUserNo, String userName,
                      String oldPsw, String newPsw, String newPswConf);
}
