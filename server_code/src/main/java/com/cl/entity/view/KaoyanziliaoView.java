package com.cl.entity.view;

import com.cl.entity.KaoyanziliaoEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 考公资料
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@TableName("kaoyanziliao")
public class KaoyanziliaoView  extends KaoyanziliaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaoyanziliaoView(){
	}
 
 	public KaoyanziliaoView(KaoyanziliaoEntity kaoyanziliaoEntity){
 	try {
			BeanUtils.copyProperties(this, kaoyanziliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
