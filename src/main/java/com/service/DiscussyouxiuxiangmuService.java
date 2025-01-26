package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyouxiuxiangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyouxiuxiangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyouxiuxiangmuView;


/**
 * 优秀项目评论表
 *
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface DiscussyouxiuxiangmuService extends IService<DiscussyouxiuxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyouxiuxiangmuVO> selectListVO(Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
   	
   	DiscussyouxiuxiangmuVO selectVO(@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
   	
   	List<DiscussyouxiuxiangmuView> selectListView(Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
   	
   	DiscussyouxiuxiangmuView selectView(@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
   	

}

