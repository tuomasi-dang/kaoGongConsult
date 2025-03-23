package com.cl.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 报考指南
 * 数据库通用操作实体类（普通增删改查）
 * @author
 * @email
 * @date 2024-12-31 14:57:50
 */
@TableName("baokaozhinan")
@Getter
@Setter
public class BaokaozhinanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaokaozhinanEntity() {
	}

	public BaokaozhinanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 创建时间
	 */
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

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
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
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
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
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

	/**
	 * 部门名称
	 */
	private String bumenmingcheng;

	/**
	 * 职位代码
	 */
	private String zhiweidaima;

	/**
	 * 职位名称
	 */
	private String zhiweimingcheng;

	/**
	 * 科目类别(A/B/C类)
	 */
	private String kemuleibie;

	/**
	 * 招考人数
	 */
	private Integer zhaokaorenshu;

	/**
	 * 学历要求
	 */
	private String xueliyaoqiu;

	/**
	 * 专业要求
	 */
	private String zhuanyeyaoqiu;

	/**
	 * 政治面貌要求
	 */
	private String zhengzhimianmao;

	/**
	 * 咨询电话
	 */
	private String zixundianhua;

}
