package com.entity.view;

import com.entity.DiscussyouxiuxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 优秀项目评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@TableName("discussyouxiuxiangmu")
public class DiscussyouxiuxiangmuView  extends DiscussyouxiuxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyouxiuxiangmuView(){
	}
 
 	public DiscussyouxiuxiangmuView(DiscussyouxiuxiangmuEntity discussyouxiuxiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, discussyouxiuxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
