package com.entity.view;

import com.entity.XiangmushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 项目申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@TableName("xiangmushenqing")
public class XiangmushenqingView  extends XiangmushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiangmushenqingView(){
	}
 
 	public XiangmushenqingView(XiangmushenqingEntity xiangmushenqingEntity){
 	try {
			BeanUtils.copyProperties(this, xiangmushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
