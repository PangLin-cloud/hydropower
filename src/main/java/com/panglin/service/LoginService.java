package com.panglin.service;

import com.panglin.mapper.TbUserMapper;
import com.panglin.pojo.TbUser;
import com.panglin.pojo.TbUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 17:48
 */
@Service
public class LoginService {
    @Autowired(required=false)
    TbUserMapper tbUserMapper;

    public List<TbUser> selectUserByPhoneAndPassword(TbUser user){
        TbUserExample tbUserExample=new TbUserExample();
        tbUserExample.createCriteria().andPhoneEqualTo(user.getPhone()).andPasswordEqualTo(user.getPassword());
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        return tbUsers.size()==0?null:tbUsers;
    }
}
