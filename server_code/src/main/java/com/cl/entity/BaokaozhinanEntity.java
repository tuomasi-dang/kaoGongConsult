package com.cl.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


/**
 * 报考指南
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@TableName("baokaozhinan")
public class BaokaozhinanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BaokaozhinanEntity() {
		
	}
	
	public BaokaozhinanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 院校
	 */
					
	private String yuanxiao;
	
	/**
	 * 科目
	 */
					
	private String kemu;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 报考条件
	 */
					
	private String baokaotiaojian;
	
	/**
	 * 学历条件
	 */
					
	private String xuelitiaojian;
	
	/**
	 * 报名时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baomingshijian;
	
	/**
	 * 报名网址
	 */
					
	private String baomingwangzhi;
	
	/**
	 * 费用缴纳
	 */
					
	private Double feiyongjiaona;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 详情简介
	 */
					
	private String xiangqingjianjie;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupNumber;
	
	/**
	 * 踩
	 */
					
	private Integer crazilyNumber;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupNumber;
	
	/**
	 * 评论数
	 */
					
	private Integer discussNumber;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：院校
	 */
	public void setYuanxiao(String yuanxiao) {
		this.yuanxiao = yuanxiao;
	}
	/**
	 * 获取：院校
	 */
	public String getYuanxiao() {
		return yuanxiao;
	}
	/**
	 * 设置：科目
	 */
	public void setKemu(String kemu) {
		this.kemu = kemu;
	}
	/**
	 * 获取：科目
	 */
	public String getKemu() {
		return kemu;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：报考条件
	 */
	public void setBaokaotiaojian(String baokaotiaojian) {
		this.baokaotiaojian = baokaotiaojian;
	}
	/**
	 * 获取：报考条件
	 */
	public String getBaokaotiaojian() {
		return baokaotiaojian;
	}
	/**
	 * 设置：学历条件
	 */
	public void setXuelitiaojian(String xuelitiaojian) {
		this.xuelitiaojian = xuelitiaojian;
	}
	/**
	 * 获取：学历条件
	 */
	public String getXuelitiaojian() {
		return xuelitiaojian;
	}
	/**
	 * 设置：报名时间
	 */
	public void setBaomingshijian(Date baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	/**
	 * 获取：报名时间
	 */
	public Date getBaomingshijian() {
		return baomingshijian;
	}
	/**
	 * 设置：报名网址
	 */
	public void setBaomingwangzhi(String baomingwangzhi) {
		this.baomingwangzhi = baomingwangzhi;
	}
	/**
	 * 获取：报名网址
	 */
	public String getBaomingwangzhi() {
		return baomingwangzhi;
	}
	/**
	 * 设置：费用缴纳
	 */
	public void setFeiyongjiaona(Double feiyongjiaona) {
		this.feiyongjiaona = feiyongjiaona;
	}
	/**
	 * 获取：费用缴纳
	 */
	public Double getFeiyongjiaona() {
		return feiyongjiaona;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：详情简介
	 */
	public void setXiangqingjianjie(String xiangqingjianjie) {
		this.xiangqingjianjie = xiangqingjianjie;
	}
	/**
	 * 获取：详情简介
	 */
	public String getXiangqingjianjie() {
		return xiangqingjianjie;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupNumber(Integer thumbsupNumber) {
		this.thumbsupNumber = thumbsupNumber;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupNumber() {
		return thumbsupNumber;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilyNumber(Integer crazilyNumber) {
		this.crazilyNumber = crazilyNumber;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilyNumber() {
		return crazilyNumber;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupNumber(Integer storeupNumber) {
		this.storeupNumber = storeupNumber;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupNumber() {
		return storeupNumber;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussNumber(Integer discussNumber) {
		this.discussNumber = discussNumber;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussNumber() {
		return discussNumber;
	}

}
