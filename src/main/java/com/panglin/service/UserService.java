package com.panglin.service;

import com.panglin.mapper.BuildingMapper;
import com.panglin.mapper.OrderMapper;
import com.panglin.mapper.TbUserMapper;
import com.panglin.mapper.UnitMapper;
import com.panglin.pojo.Order;
import com.panglin.pojo.OrderExample;
import com.panglin.pojo.TbUser;
import com.panglin.pojo.TbUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 15:31
 */
@Service
public class UserService {
    @Autowired(required=false)
    TbUserMapper userMapper;
    @Autowired(required=false)
    BuildingMapper buildingMapper;
    @Autowired(required=false)
    UnitMapper unitMapper;
    @Autowired(required=false)
    OrderMapper orderMapper;

    /** 查询用户水费列表
     * @description: 查询用户水费列表
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 19:53
     */
    public List<Order> findAllByUserIdE(int id){
        OrderExample example=new OrderExample();
        example.createCriteria().andUIdEqualTo(id).andWaterOrElectricityEqualTo(1);
        return orderMapper.selectByExampleWithUser(example);
    }
    /** 查询用户水费未缴费列表
     * @description: 查询用户水费未缴费列表
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 19:53
     */
    public List<Order> findAllByUserIdENo(int id){
        OrderExample example=new OrderExample();
        example.createCriteria().andUIdEqualTo(id).andOrderStateEqualTo(0);
        return orderMapper.selectByExampleWithUser(example);
    }

    /** 查询用户电费列表
     * @description: 查询用户电费列表
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 19:53
     */
    public List<Order> findAllByUserIdW(int id){
        OrderExample example=new OrderExample();
        example.createCriteria().andUIdEqualTo(id).andWaterOrElectricityEqualTo(0);
        return orderMapper.selectByExampleWithUser(example);
    }
    
    /** 查询个人信息
     * @description: 查询个人信息
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 20:21
     */
    public TbUser selectUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }
    
    /** 修改个人信息
     * @description: 修改个人信息
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 20:34
     */
    public int userUpdById(TbUser user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /** 水费列表页面搜索
     * @description: 水费列表页面搜索
     * @param: * @param user
     * @return: java.util.List<com.panglin.pojo.TbUser>
     * @author Pang-Lin
     * @date: 2021/7/24 21:24
     */
    public List<Order> searchWaterTables(Order order){
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        if (order.getCreateTimeString()!="" && order.getPayTimeString()!=""){
            Timestamp date1 = getTimestamp(order.getCreateTimeString());
            Timestamp date2 = getTimestamp(order.getPayTimeString());
            criteria1.andCreateTimeBetween(date1,date2);
        }
        criteria1.andWaterOrElectricityEqualTo(0).andUIdEqualTo(order.getuId());
        return orderMapper.selectByExampleWithUser(orderExample);
    }
    /** 电费列表页面搜索
     * @description: 电费列表页面搜索
     * @param: * @param user
     * @return: java.util.List<com.panglin.pojo.TbUser>
     * @author Pang-Lin
     * @date: 2021/7/24 21:24
     */
    public List<Order> searchElectricTables(Order order){
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        if (order.getCreateTimeString()!="" && order.getPayTimeString()!=""){
            Timestamp date1 = getTimestamp(order.getCreateTimeString());
            Timestamp date2 = getTimestamp(order.getPayTimeString());
            criteria1.andCreateTimeBetween(date1,date2);
        }
        criteria1.andWaterOrElectricityEqualTo(1).andUIdEqualTo(order.getuId());
        return orderMapper.selectByExampleWithUser(orderExample);
    }

    public Timestamp getTimestamp(String sTime) {
        SimpleDateFormat format1 = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = null;
        try {
            date = format1.parse(sTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format2 = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String sdate = format2.format(date);
        Timestamp  fTimestamp = Timestamp.valueOf(sdate);

        return fTimestamp;
    }

    /**
     * @description: 订单修改已缴费
     * @param: * @param id
     * @return: int
     * @author Pang-Lin
     * @date: 2021/7/24 18:56
     */
    public int priceYesUser(int id){
        Order order=new Order();
        Date date=new Date();
        order.setId(id);
        order.setPayTime(date);
        order.setPayTimeString(date.toLocaleString());
        order.setOrderState(1);
        order.setOrderStateString("已缴费");
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
