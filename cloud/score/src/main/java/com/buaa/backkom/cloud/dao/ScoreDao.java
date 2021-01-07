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
    public User getUserById(Long id);

    public List<Class> getClassById(Long id);

    public String getClassNameById(Long class_id);

    public List<Score> getScoreByClass(Long id);

    public List<Score> getScoreByStudent(Long id);

    public Long updateScore(@Param("stu_id") Long stu_id, @Param("class_id") Long class_id, @Param("score")Double score);
}
