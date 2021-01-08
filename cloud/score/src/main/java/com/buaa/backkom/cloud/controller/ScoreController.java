package com.buaa.backkom.cloud.controller;

import com.buaa.backkom.cloud.entities.Class;
import com.buaa.backkom.cloud.entities.CommonResult;
import com.buaa.backkom.cloud.entities.User;
import com.buaa.backkom.cloud.entities.Score;
import com.buaa.backkom.cloud.service.ScoreService;
import com.buaa.backkom.cloud.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class ScoreController
{
    @Resource
    private ScoreService scoreService;

    // 用户登录（已完成）
    @GetMapping("/user/login")
    public CommonResult<String> login(@RequestParam(value = "usrNo") String id,
                               @RequestParam(value = "password") String psw,
                               @RequestParam(value = "role") String role) {
        User user = scoreService.getUserById(id);
        log.info("********查询结果:" + user);
        if (user != null && user.getPassword().equals(psw) && role.equals(user.getType())) {
            return new CommonResult<>(200,"登录成功", user.getName());
        }else {
            return new CommonResult<>(444,"登录失败，请检查用户名或密码是否正确");
        }
    }

    // 老师课程列表查询（已完成）
    @GetMapping("/teacher/get_class")
    public CommonResult<List<Class>> getCourseList(@RequestParam(value = "usrNo") String id) {
        String oriRole = RequestUtil.role();
        String oriUsrNo = RequestUtil.id();
        if ((!"teacher".equals(oriRole)) || (!id.equals(oriUsrNo))) {
            return new CommonResult<>(444,"您没有权限执行此操作");
        }
        List<Class> class_list = scoreService.getClassById(id);
        log.info("********查询结果:" + class_list.size());
        if (class_list.size() > 0) {
            return new CommonResult<>(200,"查询成功", class_list);
        } else {
            return new CommonResult<>(444,"您没有正在教授的课程");
        }
    }

    // 根据课程id查询课程名称（已完成）
    @GetMapping("/getClassName")
    public CommonResult<String> getCourseName(@RequestParam(value = "class_id") String class_id) {
        String oriUsrNo = RequestUtil.id();
        String objUsrNo = scoreService.getTeacherIdByClassId(class_id);
        if (!oriUsrNo.equals(objUsrNo)) {
            return new CommonResult<>(444,"您没有权限执行此操作");
        }
        String name = scoreService.getClassNameById(class_id);
        return new CommonResult<>(200,"查询成功", name);
    }

    // 老师课程成绩详情查询（已完成）
    @GetMapping("/teacher/get_score")
    public CommonResult<List<Score>> getAllScoreOfClass(@RequestParam(value = "class_id") String id) {
        String oriRole = RequestUtil.role();
        String oriUsrNo = RequestUtil.id();
        String objUsrNo = scoreService.getTeacherIdByClassId(id);
        if ((!"teacher".equals(oriRole)) || (!oriUsrNo.equals(objUsrNo))) {
            return new CommonResult<>(444,"您没有权限执行此操作");
        }
        List<Score> score_list = scoreService.getScoreByClass(id);
        log.info("********查询结果:" + score_list.size());
        if (score_list.size() > 0) {
            return new CommonResult<>(200,"查询成功", score_list);
        }else {
            return new CommonResult<>(444,"该课程下没有上课的学生");
        }
    }

    // 老师修改单个学生成绩（已完成）
    @GetMapping("/teacher/update_score")
    public CommonResult<Long> updatePerScore(@RequestParam(value = "stu_id") String stu_id,
                                             @RequestParam(value = "class_id") String class_id,
                                             @RequestParam(value = "score") Double score) {
        String oriRole = RequestUtil.role();
        String oriUsrNo = RequestUtil.id();
        String objUsrNo = scoreService.getTeacherIdByClassId(class_id);
        if ((!"teacher".equals(oriRole)) || (!oriUsrNo.equals(objUsrNo))) {
            return new CommonResult<>(444,"您没有权限执行此操作");
        }
        Long res = scoreService.updateScore(stu_id, class_id, score);
        log.info("********查询结果:" + res);
        if (res > 0) {
            return new CommonResult<>(200,"查询成功", res);
        }else {
            return new CommonResult<>(444,"查询失败");
        }
    }

    // 学生成绩查询（已完成）
    @GetMapping("/student/get_score")
    public CommonResult<List<Score>> getStudentScoreList(@RequestParam(value = "usrNo") String id) {
        String oriRole = RequestUtil.role();
        String oriUsrNo = RequestUtil.id();
        if ((!"student".equals(oriRole)) || (!id.equals(oriUsrNo))) {
            return new CommonResult<>(444,"您没有权限执行此操作");
        }
        List<Score> score_list = scoreService.getScoreByScore(id);
        log.info("********查询结果:" + score_list.size());
        if (score_list.size() > 0) {
            return new CommonResult<>(200,"查询成功", score_list);
        }else {
            return new CommonResult<>(444,"您当前没有选任何课程");
        }
    }

    // 用户更改个人信息
    @GetMapping("/modifyInfo")
    public CommonResult modifyInfo(@RequestParam("oriUsrNo") String oriUserNo,
                                   @RequestParam("usrName") String userName,
                                   @RequestParam("oldPassword") String oldPsw,
                                   @RequestParam("newPassword") String newPsw,
                                   @RequestParam("newPasswordConfirm") String newPswConf) {
        String res = scoreService.modifyInfo(oriUserNo, userName, oldPsw, newPsw, newPswConf);
        if ("2".equals(res)) {
            return new CommonResult(444,"原密码错误，请修改");
        } else if ("3".equals(res)) {
            return new CommonResult(444,"新密码不能小于6位，请修改");
        } else if ("4".equals(res)) {
            return new CommonResult(444,"新密码不能和原密码相同，请修改");
        } else if ("5".equals(res)) {
            return new CommonResult(444,"两次输入的新密码不同，请修改");
        } else {
            return new CommonResult(200,"信息修改成功");
        }
    }
}
