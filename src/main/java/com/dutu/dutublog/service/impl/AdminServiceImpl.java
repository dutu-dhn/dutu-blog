package com.dutu.dutublog.service.impl;

import com.dutu.dutublog.bean.Admin;
import com.dutu.dutublog.mapper.AdminMapper;
import com.dutu.dutublog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dutu
 * @date 2021-03-25 10:50
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getAdminMessage(){
        List<Admin> admins = adminMapper.selectList(null);

        return admins.get(0);
    }
}
