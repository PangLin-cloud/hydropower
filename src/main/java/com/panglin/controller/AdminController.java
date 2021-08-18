package com.panglin.controller;

import com.panglin.pojo.*;
import com.panglin.service.AdminService;
import com.panglin.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 15:30
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;
    /** 查询所有用户列表
     * @description: 查询所有用户列表 
     * @param: * @param model 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/23 9:14
     */ 
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        List<TbUser> allUser = adminService.findAllUser();
        model.addAttribute("userlist",allUser);
        return "tables";
    }
    /** 跳转主页
     * @description: 跳转主页
     * @param: * @param model 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/23 9:14
     */
    @RequestMapping("/admin.action")
    public String adminAction(Model model){
        int usercounts = adminService.selectUsercounts();
        int priceYes = adminService.selectPriceCount(1);
        int priceNo = adminService.selectPriceCount(2);
        Double price = adminService.selecrPrice();
        model.addAttribute("usercount",usercounts);
        model.addAttribute("priceYes",priceYes);
        model.addAttribute("priceNo",priceNo);
        model.addAttribute("price",price);
        return "index";
    }

    /** 查询楼号和单元号返回用于插入下拉框
     * @description: 查询楼号和单元号返回用于插入下拉框
     * @param: * @param model
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/23 9:15
     */
    @RequestMapping("/insert_user.action")
    public String insert_userAction(Model model){
        List<Building> allBuilding = adminService.findAllBuilding();
        List<Unit> allUnit = adminService.findAllUnit();
        model.addAttribute("buildingList",allBuilding);
        model.addAttribute("unitList",allUnit);
        return "insert_user";
    }

    /** 处理分配账号业务，往用户表新增一条数据
     * @description: 处理分配账号业务，往用户表新增一条数据
     * @param: * @param model
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/23 9:15
     */
    @RequestMapping("/insert_user")
    public String insertUser(TbUser user){
        adminService.insertUser(user);
        return "redirect:/findAllUser";
    }
    
    /** 重置密码
     * @description: 重置密码
     * @param: * @param id 
     * @return: com.panglin.util.Msg 
     * @author Pang-Lin
     * @date: 2021/7/23 11:22
     */ 
    @RequestMapping("/resetPwd")
    @ResponseBody
    public Msg resetPwd(int id){
        adminService.resetPwd(id);
        return Msg.success("密码重置成功！重置后密码为：123456");
    }
    /** 删除用户
     * @description: 删除用户
     * @param: * @param id 
     * @return: com.panglin.util.Msg 
     * @author Pang-Lin
     * @date: 2021/7/23 11:29
     */ 
    @RequestMapping("delUser")
    @ResponseBody
    public Msg delUser(int id){
        int i = adminService.delUser(id);
        if (i>=0){
            return Msg.success("删除成功！");
        }else {
            return Msg.fail("删除失败！");
        }
    }


    
    /** 跳转电费未缴费列表
     * @description: 跳转电费未缴费列表
     * @param: * @param model 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/23 15:17
     */ 
    @RequestMapping("/electric.actionNo")
    public String electricNoHtml(Model model){
        List<Order> orderByState = adminService.findOrderByState(0, 1);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orderByState);
        model.addAttribute("adminStringMap",stringMap);
        return "electric_tablesNo";
    }
    /** 跳转电费全部订单列表
     * @description: 跳转电费全部订单列表
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/23 15:18
     */
    @RequestMapping("electric.action")
    public String electricHtml(Model model){
        List<Order> orderByState = adminService.findOrderByState(0, 0);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orderByState);
        model.addAttribute("adminStringMap",stringMap);
        return "electric_tables";
    }

    /** 跳转水费全部订单列表
     * @description: 跳转水费全部订单列表
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/23 15:18
     */
    @RequestMapping("water.action")
    public String waterHtml(Model model){
        List<Order> orderByState = adminService.findOrderByState(1, 0);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orderByState);
        model.addAttribute("adminStringMap",stringMap);
        return "water_tables";
    }

    /**跳转水费未缴费订单列表
     * @description: 跳转水费未缴费订单列表
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/23 15:18
     */
    @RequestMapping("waterNo.action")
    public String waterNoHtml(Model model){
        List<Order> orderByState = adminService.findOrderByState(1, 1);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orderByState);
        model.addAttribute("adminStringMap",stringMap);
        return "water_tablesNo";
    }
    /** 跳转添加水费订单页面
     * @description: 跳转添加水费订单页面
     * @param: * @param order 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 16:00
     */ 
    @RequestMapping("setUpWeater")
    public String setUpWeater(Model model){
        model.addAttribute("userList",adminService.findAllUser());
        model.addAttribute("adminList",adminService.findAllAdmin());
        return "set_up_water";
    }
    /** 添加水费订单
     * @description: 添加水费订单 
     * @param: * @param order 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 17:51
     */ 
    @RequestMapping("setUpweaters")
    public String setUpweaters(Order order){
        adminService.setUpweaters(order);
        return "redirect:/water.action";
    }
    
    /** 跳转添加的电费订单页面
     * @description: 跳转添加的电费订单页面
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 17:51
     */
    @RequestMapping("setUpelectric")
    public String setUpelectric(Model model){
        model.addAttribute("userList",adminService.findAllUser());
        model.addAttribute("adminList",adminService.findAllAdmin());
        return "set_up_electric";
    }
    /** 
     * @description: 添加水费订单
     * @param: * @param order 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 18:11
     */ 
    @RequestMapping("setUpelectrics")
    public String setUpelectrics(Order order){
        adminService.setUpelectrics(order);
        return "redirect:/electric.action";
    }
    /** 跳转系统设置
     * @description: 跳转系统设置
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 18:12
     */
    @RequestMapping("settings")
    public String settings(Model model){
        model.addAttribute("settings",adminService.findAllSettings());
        return "settings";

    }
    /** 
     * @description: 更新系统设置
     * @param: * @param settings 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 18:51
     */ 
    @RequestMapping("updSettings")
    public String updSettings(TbSettings settings){
        adminService.updSettings(settings);
        return "redirect:/settings";
    }
    /** 电费缴费按钮
     * @description: 水费缴费按钮
     * @param: * @param id 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 18:55
     */ 
    @RequestMapping("payWater")
    @ResponseBody
    public Msg payWater(int id){
        adminService.payYes(id);
        return Msg.success("缴费成功！");
    }
    /** 电费缴费按钮
     * @description: 电费缴费按钮
     * @param: * @param id
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/24 18:55
     */
    @RequestMapping("payEletric")
    @ResponseBody
    public Msg payElectric(int id){
        adminService.payYes(id);
        return Msg.success("缴费成功！");
    }
    
    /** 
     * @description: 退出登录
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 19:04
     */
    @RequestMapping("loginOut")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    
    /** 用户列表页面搜索
     * @description: 用户列表页面搜索
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/7/24 21:21
     */
    @RequestMapping("searchTables")
    public String searchTables(TbUser user,Model model){
        List<TbUser> tbUsers = adminService.searchTables(user);
        model.addAttribute("userlist",tbUsers);
        return "tables";
    }

    /**
     * @description: 水费订单全部列表搜索
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 23:33
     */
    @RequestMapping("/searchWaterTables")
    public String searchWaterTables(Order order,Model model) {
        List<Order> orders = adminService.searchWaterTables(order);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orders);
        model.addAttribute("adminStringMap",stringMap);
        return "water_tables";
    }
    /**
     * @description: 水费订单全部列表搜索
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 23:33
     */
    @RequestMapping("/searchElectricTables")
    public String searchElectricTables(Order order,Model model) {
        List<Order> orders = adminService.searchElectricTables(order);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orders);
        model.addAttribute("adminStringMap",stringMap);
        return "electric_tables";
    }
}
