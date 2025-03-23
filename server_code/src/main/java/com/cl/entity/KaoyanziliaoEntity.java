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
 * 考公资料
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@TableName("kaoyanziliao")
public class KaoyanziliaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaoyanziliaoEntity() {
		
	}
	
	public KaoyanziliaoEntity(T t) {
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
	 * 资料名称
	 */
					
	private String ziliaomingcheng;
	
	/**
	 * 资料分类
	 */
					
	private String ziliaofenlei;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 上传时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shangchuanshijian;
	
	/**
	 * 资料详情
	 */
					
	private String ziliaoxiangqing;
	
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
	
	/**
	 * 单限
	 */
					
	private Integer onelimittimes;
	
	/**
	 * 库存
	 */
					
	private Integer alllimittimes;
	
	/**
	 * 价格
	 */
					
	private Double price;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	

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
	 * 设置：资料名称
	 */
	public void setZiliaomingcheng(String ziliaomingcheng) {
		this.ziliaomingcheng = ziliaomingcheng;
	}
	/**
	 * 获取：资料名称
	 */
	public String getZiliaomingcheng() {
		return ziliaomingcheng;
	}
	/**
	 * 设置：资料分类
	 */
	public void setZiliaofenlei(String ziliaofenlei) {
		this.ziliaofenlei = ziliaofenlei;
	}
	/**
	 * 获取：资料分类
	 */
	public String getZiliaofenlei() {
		return ziliaofenlei;
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
	 * 设置：上传时间
	 */
	public void setShangchuanshijian(Date shangchuanshijian) {
		this.shangchuanshijian = shangchuanshijian;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getShangchuanshijian() {
		return shangchuanshijian;
	}
	/**
	 * 设置：资料详情
	 */
	public void setZiliaoxiangqing(String ziliaoxiangqing) {
		this.ziliaoxiangqing = ziliaoxiangqing;
	}
	/**
	 * 获取：资料详情
	 */
	public String getZiliaoxiangqing() {
		return ziliaoxiangqing;
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
	/**
	 * 设置：单限
	 */
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
	/**
	 * 设置：库存
	 */
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
