package com.example.mystore.entity;

import lombok.Data;

@Data
public class Supplier {
    private String scode;        //商家编码
    private String spassword;    //商家密码
    private String sname;        //商家名称
    private String sweixin;      //微信
    private String tel;          //电话（手机）
    private Float evaluate;      //商家综合评价
}