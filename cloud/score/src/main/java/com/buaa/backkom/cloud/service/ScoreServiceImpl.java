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
    public User getUserById(String id)
    {
        return scoreDao.getUserById(id);
    }

    @Override
    public List<Class> getClassById(String id)
    {
        return scoreDao.getClassById(id);
    }

    @Override
    public String getClassNameById(String class_id) {
        return scoreDao.getClassNameById(class_id);
    }

    @Override
    public String getTeacherIdByClassId(String id) {
        return scoreDao.getTeacherIdByClassId(id);
    }

    @Override
    public List<Score> getScoreByClass(String id)
    {
        return scoreDao.getScoreByClass(id);
    }

    @Override
    public List<Score> getScoreByScore(String id)
    {
        return scoreDao.getScoreByStudent(id);
    }

    @Override
    public Long updateScore(String stu_id, String class_id, Double score)
    {
        return scoreDao.updateScore(stu_id, class_id, score);
    }

    @Override
    public String modifyInfo(String oriUserNo, String userName,
                             String oldPsw, String newPsw, String newPswConf) {
        boolean isModifyPsw = false;
        User oriUser = this.getUserById(oriUserNo);
        if ((!"".equals(oldPsw)) && (!"".equals(newPsw)) && (!"".equals(newPswConf))) {
            if (!oriUser.getPassword().equals(oldPsw)) return "2";
            if (newPsw.length() < 6) return "3";
            if (newPsw.equals(oldPsw)) return "4";
            if (!newPsw.equals(newPswConf)) return "5";
            isModifyPsw = true;
        }
        scoreDao.modifyInfo(oriUserNo, userName, newPsw, isModifyPsw);
        return "0";
    }
}
