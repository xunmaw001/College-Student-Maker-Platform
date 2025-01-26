package com.dao;

import com.entity.DiscusszhaoshangyinziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhaoshangyinziVO;
import com.entity.view.DiscusszhaoshangyinziView;


/**
 * 招商引资评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface DiscusszhaoshangyinziDao extends BaseMapper<DiscusszhaoshangyinziEntity> {
	
	List<DiscusszhaoshangyinziVO> selectListVO(@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);
	
	DiscusszhaoshangyinziVO selectVO(@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);
	
	List<DiscusszhaoshangyinziView> selectListView(@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);

	List<DiscusszhaoshangyinziView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);
	
	DiscusszhaoshangyinziView selectView(@Param("ew") Wrapper<DiscusszhaoshangyinziEntity> wrapper);
	

}
