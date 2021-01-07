package com.buaa.backkom.cloud.service;

import com.buaa.backkom.cloud.dao.ScoreDao;
import com.buaa.backkom.cloud.entities.Class;
import com.buaa.backkom.cloud.entities.User;
import com.buaa.backkom.cloud.entities.Score;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService
{
    @Resource
    private ScoreDao scoreDao;

    @Override
    public User getUserById(Long id)
    {
        return scoreDao.getUserById(id);
    }

    @Override
    public List<Class> getClassById(Long id)
    {
        return scoreDao.getClassById(id);
    }

    @Override
    public String getClassNameById(Long class_id) {
        return scoreDao.getClassNameById(class_id);
    }

    @Override
    public List<Score> getScoreByClass(Long id)
    {
        return scoreDao.getScoreByClass(id);
    }

    @Override
    public List<Score> getScoreByScore(Long id)
    {
        return scoreDao.getScoreByStudent(id);
    }

    @Override
    public Long updateScore(Long stu_id, Long class_id, Double score)
    {
        return scoreDao.updateScore(stu_id, class_id, score);
    }
}
