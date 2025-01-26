package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhaoshangyinziEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhaoshangyinziVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhaoshangyinziView;


/**
 * 招商引资评论表
 *
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface DiscusszhaoshangyinziService extends IService<DiscusszhaoshangyinziEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhaoshangyinziVO> selectListVO(Wrapper<DiscusszhaoshangyinziEntity> wrapper);
   	
   	DiscusszhaoshangyinziVO selectVO(@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);
   	
   	List<DiscusszhaoshangyinziView> selectListView(Wrapper<DiscusszhaoshangyinziEntity> wrapper);
   	
   	DiscusszhaoshangyinziView selectView(@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhaoshangyinziEntity> wrapper);
   	

}

