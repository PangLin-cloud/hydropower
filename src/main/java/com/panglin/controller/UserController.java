package com.panglin.controller;

import com.panglin.pojo.Building;
import com.panglin.pojo.Order;
import com.panglin.pojo.TbUser;
import com.panglin.pojo.Unit;
import com.panglin.service.AdminService;
import com.panglin.service.UserService;
import com.panglin.util.Msg;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 15:31
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    /** 
     * @description: 跳转用户主页
     * @param: * @param model 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 19:10
     */ 
    @RequestMapping("userIndex.action")
    public String userIndex(Model model, int id){
        List<Order> allByUserIdW = userService.findAllByUserIdENo(id);
        Map<Integer, String> adminStringMap = adminService.selectById();
        model.addAttribute("orderByStateList",allByUserIdW);
        model.addAttribute("adminStringMap",adminStringMap);
        return "user_index";
    }
    /** 水费历史订单
     * @description: 水费历史订单
     * @param:  
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/7/24 19:57
     */
    @RequestMapping("waterUser")
    public String tablesW(int id,Model model){
        List<Order> allByUserIdW = userService.findAllByUserIdW(id);
        Map<Integer, String> adminStringMap = adminService.selectById();
        model.addAttribute("orderByStateList",allByUserIdW);
        model.addAttribute("adminStringMap",adminStringMap);
        return "user_water_tables";
    }
    /** 电费历史订单
     * @description: 电费历史订单
     * @param:
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/24 19:57
     */
    @RequestMapping("electricUser")
    public String tablesE(int id,Model model){
        List<Order> allByUserIdW = userService.findAllByUserIdE(id);
        Map<Integer, String> adminStringMap = adminService.selectById();
        model.addAttribute("orderByStateList",allByUserIdW);
        model.addAttribute("adminStringMap",adminStringMap);
        return "user_electric_tables";
    }

    /** 查询个人信息跳转修改个人信息界面
     * @description: 查询个人信息跳转修改个人信息界面
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 20:20
     */
    @RequestMapping("selectUserById")
    public String selectUserById(int id,Model model){
        TbUser users = userService.selectUserById(id);
        List<Building> allBuilding = adminService.findAllBuilding();
        List<Unit> allUnit = adminService.findAllUnit();
        model.addAttribute("buildingList",allBuilding);
        model.addAttribute("unitList",allUnit);
        model.addAttribute("users",users);
        return "user_upd";
    }

    @RequestMapping("userUpdS")
    public String userUpd(TbUser user){
        userService.userUpdById(user);
        return "redirect:/selectUserById?id="+user.getId();
    }

    @RequestMapping("userLogOut")
    public String userLogOut(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    /**
     * @description: 电费订单全部列表搜索
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 23:33
     */
    @RequestMapping("/searchUserWaterTables")
    public String searchUserElectricTables(Order order,Model model) {
        List<Order> orders = userService.searchWaterTables(order);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orders);
        model.addAttribute("adminStringMap",stringMap);
        return "user_water_tables";
    }
    /**
     * @description: 电费订单全部列表搜索
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/24 23:33
     */
    @RequestMapping("/searchUserElectricTables")
    public String searchUserWaterTables(Order order,Model model) {
        List<Order> orders = userService.searchElectricTables(order);
        Map<Integer, String> stringMap = adminService.selectById();
        model.addAttribute("orderByStateList",orders);
        model.addAttribute("adminStringMap",stringMap);
        return "user_electric_tables";
    }
    /** 水费缴费
     * @description: 水费缴费
     * @param: * @param id
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/25 3:38
     */
    @RequestMapping("priceYesUserWater")
    @ResponseBody
    public Msg priceYesUserWater(int id){
        userService.priceYesUser(id);
        return Msg.success("缴费成功！");
    }

    /** 电费缴费
     * @description: 电费缴费
     * @param: * @param id
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/25 3:38
     */
    @RequestMapping("priceYesUserEletric")
    @ResponseBody
    public Msg priceYesUserEletric(int id){
        userService.priceYesUser(id);
        return Msg.success("缴费成功！");
    }

}
