package com.dao;

import com.entity.XiangmushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmushenqingVO;
import com.entity.view.XiangmushenqingView;


/**
 * 项目申请
 * 
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface XiangmushenqingDao extends BaseMapper<XiangmushenqingEntity> {
	
	List<XiangmushenqingVO> selectListVO(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	
	XiangmushenqingVO selectVO(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	
	List<XiangmushenqingView> selectListView(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);

	List<XiangmushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	
	XiangmushenqingView selectView(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	

}
