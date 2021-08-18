package com.panglin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private Integer id;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    private String createTimeString;

    private String payTimeString;

    private Double price;

    private Integer uId;

    private Integer orderState;

    private String orderStateString;

    private Integer payAdminId;

    private Integer waterOrElectricity;

    private String waterOrElectricityString;

    private TbUser user;

    public TbUser getUser() {
        return user;
    }

    public void setUser(TbUser user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getCreateTimeString() {
        return createTimeString;
    }

    public void setCreateTimeString(String createTimeString) {
        this.createTimeString = createTimeString == null ? null : createTimeString.trim();
    }

    public String getPayTimeString() {
        return payTimeString;
    }

    public void setPayTimeString(String payTimeString) {
        this.payTimeString = payTimeString == null ? null : payTimeString.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderStateString() {
        return orderStateString;
    }

    public void setOrderStateString(String orderStateString) {
        this.orderStateString = orderStateString == null ? null : orderStateString.trim();
    }

    public Integer getPayAdminId() {
        return payAdminId;
    }

    public void setPayAdminId(Integer payAdminId) {
        this.payAdminId = payAdminId;
    }

    public Integer getWaterOrElectricity() {
        return waterOrElectricity;
    }

    public void setWaterOrElectricity(Integer waterOrElectricity) {
        this.waterOrElectricity = waterOrElectricity;
    }

    public String getWaterOrElectricityString() {
        return waterOrElectricityString;
    }

    public void setWaterOrElectricityString(String waterOrElectricityString) {
        this.waterOrElectricityString = waterOrElectricityString == null ? null : waterOrElectricityString.trim();
    }
}