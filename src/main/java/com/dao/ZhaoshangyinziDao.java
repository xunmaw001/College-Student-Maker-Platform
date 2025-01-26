package com.dao;

import com.entity.ZhaoshangyinziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaoshangyinziVO;
import com.entity.view.ZhaoshangyinziView;


/**
 * 招商引资
 * 
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface ZhaoshangyinziDao extends BaseMapper<ZhaoshangyinziEntity> {
	
	List<ZhaoshangyinziVO> selectListVO(@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);
	
	ZhaoshangyinziVO selectVO(@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);
	
	List<ZhaoshangyinziView> selectListView(@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);

	List<ZhaoshangyinziView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);
	
	ZhaoshangyinziView selectView(@Param("ew") Wrapper<ZhaoshangyinziEntity> wrapper);
	

}
