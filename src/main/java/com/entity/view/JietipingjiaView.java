package com.entity.view;

import com.entity.JietipingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 结题评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@TableName("jietipingjia")
public class JietipingjiaView  extends JietipingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JietipingjiaView(){
	}
 
 	public JietipingjiaView(JietipingjiaEntity jietipingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, jietipingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
