package com.entity.view;

import com.entity.DiscusszhaoshangyinziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招商引资评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@TableName("discusszhaoshangyinzi")
public class DiscusszhaoshangyinziView  extends DiscusszhaoshangyinziEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhaoshangyinziView(){
	}
 
 	public DiscusszhaoshangyinziView(DiscusszhaoshangyinziEntity discusszhaoshangyinziEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhaoshangyinziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
