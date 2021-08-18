package com.panglin.service;

import com.panglin.mapper.*;
import com.panglin.pojo.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.omg.CORBA.OMGVMCID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 15:30
 */
@Service
public class AdminService {
    @Autowired(required=false)
    TbUserMapper userMapper;
    @Autowired(required=false)
    BuildingMapper buildingMapper;
    @Autowired(required=false)
    UnitMapper unitMapper;
    @Autowired(required=false)
    OrderMapper orderMapper;
    @Autowired(required=false)
    TbSettingsMapper settingsMapper;
    /** 查询所有用户
     * @description: 查询所有用户
     * @param:  
     * @return: java.util.List<com.panglin.pojo.TbUser> 
     * @author Pang-Lin
     * @date: 2021/7/22 15:38
     */ 
    public List<TbUser> findAllUser(){
        TbUserExample userExample=new TbUserExample();
        userExample.createCriteria().andUserOrAdminEqualTo(1);
        return userMapper.selectByExample(userExample);
    }
    /** 查询用户总数
     * @description: 查询用户总数
     * @param:  
     * @return: int 
     * @author Pang-Lin
     * @date: 2021/7/22 15:38
     */ 
    public int selectUsercounts(){
        TbUserExample userExample=new TbUserExample();
        userExample.createCriteria().andUserOrAdminEqualTo(1);
        int size = userMapper.selectByExample(userExample).size();
        return size;
    }
    /**
     * @description: 查询订单数量
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 19:36
     */
    public int selectPriceCount(int type){
        if (type==1){
            OrderExample example=new OrderExample();
            example.createCriteria().andOrderStateEqualTo(1);
            return orderMapper.selectByExample(example).size();
        }else {
            OrderExample example=new OrderExample();
            example.createCriteria().andOrderStateEqualTo(0);
            return orderMapper.selectByExample(example).size();
        }
    }
    /** 
     * @description: 查询历史已缴费总金额
     * @param:  
     * @return: java.util.List<com.panglin.pojo.Building> 
     * @author Pang-Lin
     * @date: 2021/7/24 19:38
     */
    public Double selecrPrice(){
        OrderExample example=new OrderExample();
        example.createCriteria().andOrderStateEqualTo(1);
        List<Order> orders = orderMapper.selectByExample(example);
        double price=0;
        for (Order order:orders) {
            price=price+order.getPrice();
        }
        return price;
    }
    /* 查询楼号 */
    public List<Building> findAllBuilding(){
        return buildingMapper.selectByExample(null);
    }
    /* 查询单元号 */
    public List<Unit> findAllUnit(){
        return unitMapper.selectByExample(null);
    }
    /** 往用户表插入数据，完成分配账号操作
     * @description: 往用户表插入数据，完成分配账号操作
     * @param: * @param user 
     * @return: int 
     * @author Pang-Lin
     * @date: 2021/7/23 9:18
     */ 
    public int insertUser(TbUser user){
        user.setPassword("123456");
        user.setUserOrAdmin(1);
        return userMapper.insertSelective(user);
    }
    /** 将密码修改为123456，完成重置密码操作
     * @description:  将密码修改为123456，完成重置密码操作
     * @param: * @param id
     * @return: int
     * @author Pang-Lin
     * @date: 2021/7/23 9:19
     */
    public int resetPwd(int id){
        TbUser tbUser=new TbUser();
        tbUser.setPassword("123456");
        tbUser.setId(id);
        return userMapper.updateByPrimaryKeySelective(tbUser);
    }
    /** 删除用户
     * @description: 删除用户
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/23 11:22
     */
    public int delUser(int id){
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * @description: 查询订单
     * @param: * @param type
     * @return: java.util.List<com.panglin.pojo.Order>
     * @author Pang-Lin
     * @date: 2021/7/23 11:37
     */
    public List<Order> findOrderByState(int types,int type){
        OrderExample example=new OrderExample();
        if (types==1){
            if (type==1){
                example.createCriteria().andOrderStateEqualTo(0).andOrderStateStringEqualTo("未缴费").andWaterOrElectricityEqualTo(0).andWaterOrElectricityStringEqualTo("水费");
            }else {
                example.createCriteria().andWaterOrElectricityEqualTo(0).andWaterOrElectricityStringEqualTo("水费");
            }
        }else {
            if (type==1){
                example.createCriteria().andOrderStateEqualTo(0).andOrderStateStringEqualTo("未缴费").andWaterOrElectricityEqualTo(1).andWaterOrElectricityStringEqualTo("电费");
            }else {
                example.createCriteria().andWaterOrElectricityEqualTo(1).andWaterOrElectricityStringEqualTo("电费");
            }
        }
        return orderMapper.selectByExampleWithUser(example);
    }
    /** 查询所有管理员
     * @description: 查询所有管理员
     * @param: * @param order 
     * @return: int 
     * @author Pang-Lin
     * @date: 2021/7/24 16:01
     */ 
    public List<TbUser> findAllAdmin(){
        TbUserExample example=new TbUserExample();
        example.createCriteria().andUserOrAdminEqualTo(0);
        return userMapper.selectByExample(example);
    }
    /** 查询所有管理员
     * @description: 查询所有管理员
     * @param:
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/24 16:16
     */
    public Map<Integer, String> selectById(){
        Map<Integer,String> map=new HashMap<Integer,String>();
        TbUserExample userExample=new TbUserExample();
        userExample.createCriteria().andUserOrAdminEqualTo(0);
        List<TbUser> tbUsers = userMapper.selectByExample(userExample);
        for (TbUser user:tbUsers) {
            map.put(user.getId(),user.getUsername());
        }
        return map;
    }
    /** 添加水费订单
     * @description: 添加水费订单
     * @param:
     * @return: int
     * @author Pang-Lin
     * @date: 2021/7/24 16:59
     */
    public int setUpweaters(Order order){
        order.setPrice(weaterCountPrice(order.getPrice()));
        Date date=new Date();
        order.setCreateTime(date);
        order.setCreateTimeString(date.toLocaleString());
        order.setOrderState(0);
        order.setOrderStateString("未缴费");
        order.setWaterOrElectricity(0);
        order.setWaterOrElectricityString("水费");
        int i = orderMapper.insertSelective(order);
        return i;
    }

    /** 添加电费订单
     * @description: 添加电费订单
     * @param:
     * @return: int
     * @author Pang-Lin
     * @date: 2021/7/24 16:59
     */
    public int setUpelectrics(Order order){
        order.setPrice(electricCountPrice(order.getPrice()));
        Date date=new Date();
        order.setCreateTime(date);
        order.setCreateTimeString(date.toLocaleString());
        order.setOrderState(0);
        order.setOrderStateString("未缴费");
        order.setWaterOrElectricity(1);
        order.setWaterOrElectricityString("电费");
        int i = orderMapper.insertSelective(order);
        return i;
    }
    
    /** 
     * @description: 查询系统设置
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 18:15
     */
    public List<TbSettings> findAllSettings(){
        List<TbSettings> tbSettings = settingsMapper.selectByExample(null);
        return tbSettings;
    }
    /** 更新设置
     * @description: 更新设置
     * @param: * @param settings 
     * @return: int 
     * @author Pang-Lin
     * @date: 2021/7/24 18:31
     */ 
    public int updSettings(TbSettings settings){
        TbSettingsExample example=new TbSettingsExample();
        example.createCriteria().andSettingsEqualTo(settings.getSettings());
        settings.setSettings(null);
        int i = settingsMapper.updateByExampleSelective(settings, example);
        return i;
    }
    
    /** 计算水费费用
     * @description: 计算水费费用
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 18:31
     */
    public Double weaterCountPrice(double number){
        double price=0;
        List<TbSettings> tbSettings = settingsMapper.selectByExample(null);
        Map<String,Double> map=new HashMap<>();
        for (TbSettings settings:tbSettings) {
            map.put(settings.getSettings(),settings.getSettingsValue());
        }
        if (number<=50){
            price =number*map.get("水费0-50");
        }
        if (number > 50 && number <=100){
            price =50*map.get("水费0-50")+(number-50)*map.get("水费50-100");
        }
        if (number > 100 && number <=500){
            price =50*map.get("水费0-50")+50*map.get("水费50-100")+(number-50-50)* map.get("水费100-500");
        }
        if (number > 500){
            price =50*map.get("水费0-50")+50*map.get("水费50-100")+400* map.get("水费100-500")+(number-500)* map.get("水费500-");
        }
        return price;
    }

    /** 计算电费费用
     * @description: 计算电费费用
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 18:31
     */
    public Double electricCountPrice(double number){
        double price=0;
        List<TbSettings> tbSettings = settingsMapper.selectByExample(null);
        Map<String,Double> map=new HashMap<>();
        for (TbSettings settings:tbSettings) {
            map.put(settings.getSettings(),settings.getSettingsValue());
        }
        if (number<=50){
            price =number*map.get("电费0-50");
        }
        if (number > 50 && number <=100){
            price =50*map.get("电费0-50")+(number-50)*map.get("电费50-100");
        }
        if (number > 100 && number <=500){
            price =50*map.get("电费0-50")+50*map.get("电费50-100")+(number-50-50)* map.get("电费100-500");
        }
        if (number > 500){
            price =50*map.get("电费0-50")+50*map.get("电费50-100")+400* map.get("电费100-500")+(number-500)* map.get("电费500-");
        }
        return price;
    }
    /**
     * @description: 订单修改已缴费
     * @param: * @param id
     * @return: int
     * @author Pang-Lin
     * @date: 2021/7/24 18:56
     */
    public int payYes(int id){
        Order order=new Order();
        Date date=new Date();
        order.setId(id);
        order.setPayTime(date);
        order.setPayTimeString(date.toLocaleString());
        order.setOrderState(1);
        order.setOrderStateString("已缴费");
        return orderMapper.updateByPrimaryKeySelective(order);
    }
    /** 
     * @description: 用户列表页面搜索
     * @param: * @param user 
     * @return: java.util.List<com.panglin.pojo.TbUser> 
     * @author Pang-Lin
     * @date: 2021/7/24 21:24
     */ 
    public List<TbUser> searchTables(TbUser user){
        System.out.println(user.getUsername());
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        System.out.println();
        if (user.getUsername()!=null){
            criteria.andUsernameLike("%"+user.getUsername()+"%");
        }
        if (user.getPhone()!=null){
            criteria.andPhoneEqualTo(user.getPhone());
        }
        if (user.getIdCard()!=null){
            criteria.andIdCardEqualTo(user.getIdCard());
        }
        criteria.andUserOrAdminEqualTo(1);
        return userMapper.selectByExample(example);
    }

    /** 水费列表页面搜索
     * @description: 水费列表页面搜索
     * @param: * @param user
     * @return: java.util.List<com.panglin.pojo.TbUser>
     * @author Pang-Lin
     * @date: 2021/7/24 21:24
     */
    public List<Order> searchWaterTables(Order order){
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        criteria.andUsernameLike("%"+""+"%");
        if (order.getUser().getPhone()!=null){
            criteria.andPhoneEqualTo(order.getUser().getPhone());
            Integer id = userMapper.selectByExample(example).get(0).getId();
            criteria1.andUIdEqualTo(id);
        }
        if (order.getCreateTimeString()!="" && order.getPayTimeString()!=""){
            Timestamp date1 = getTimestamp(order.getCreateTimeString());
            Timestamp date2 = getTimestamp(order.getPayTimeString());
            criteria1.andCreateTimeBetween(date1,date2);
        }
        criteria1.andWaterOrElectricityEqualTo(0);
        return orderMapper.selectByExampleWithUser(orderExample);
    }
    /** 水费列表页面搜索
     * @description: 水费列表页面搜索
     * @param: * @param user
     * @return: java.util.List<com.panglin.pojo.TbUser>
     * @author Pang-Lin
     * @date: 2021/7/24 21:24
     */
    public List<Order> searchElectricTables(Order order){
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        criteria.andUsernameLike("%"+""+"%");
        if (order.getUser().getPhone()!=null){
            criteria.andPhoneEqualTo(order.getUser().getPhone());
            Integer id = userMapper.selectByExample(example).get(0).getId();
            criteria1.andUIdEqualTo(id);
        }
        if (order.getCreateTimeString()!="" && order.getPayTimeString()!=""){
            Timestamp date1 = getTimestamp(order.getCreateTimeString());
            Timestamp date2 = getTimestamp(order.getPayTimeString());
            criteria1.andCreateTimeBetween(date1,date2);
        }
        criteria1.andWaterOrElectricityEqualTo(1);
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
}
