package com.buaa.backkom.cloud.service;

import com.buaa.backkom.cloud.entities.Class;
import com.buaa.backkom.cloud.entities.User;
import com.buaa.backkom.cloud.entities.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreService
{
    public User getUserById(Long id);

    public List<Class> getClassById(Long id);

    public String getClassNameById(Long class_id);

    public List<Score> getScoreByClass(Long id);

    public List<Score> getScoreByScore(Long id);

    public Long updateScore(@Param("stu_id") Long stu_id, @Param("class_id") Long class_id, @Param("score")Double score);
}
