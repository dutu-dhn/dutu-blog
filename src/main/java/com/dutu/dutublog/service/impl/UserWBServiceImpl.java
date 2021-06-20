package com.dutu.dutublog.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dutu.dutublog.bean.Userwb;
import com.dutu.dutublog.mapper.UserWBMapper;
import com.dutu.dutublog.service.UserWBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author dutu
 * @date 2021-05-28 15:16
 */
@Service
public class UserWBServiceImpl implements UserWBService {
    @Autowired
    UserWBMapper userWBMapper;

    @Override
    public int loginUserofWB(Userwb user) {
        Timestamp logintime = new Timestamp(System.currentTimeMillis());
        user.setLogintime(logintime);
        Userwb userwb = userWBMapper.selectById(user.getIdstr());
        if (userwb != null){
            UpdateWrapper updateWrapper = Wrappers.update();
            updateWrapper.set("logintime",logintime);
            return userWBMapper.update(user,updateWrapper);
        }else {
            user.setClient("微博");
            return userWBMapper.insert(user);
        }

    }
}
