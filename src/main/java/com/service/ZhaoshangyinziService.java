package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaoshangyinziEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaoshangyinziVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaoshangyinziView;


/**
 * 招商引资
 *
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface ZhaoshangyinziService extends IService<ZhaoshangyinziEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaoshangyinziVO> selectListVO(Wrapper<ZhaoshangyinziEntity> wrapper);
   	
   	ZhaoshangyinziVO selectVO(@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);
   	
   	List<ZhaoshangyinziView> selectListView(Wrapper<ZhaoshangyinziEntity> wrapper);
   	
   	ZhaoshangyinziView selectView(@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaoshangyinziEntity> wrapper);
   	

}

