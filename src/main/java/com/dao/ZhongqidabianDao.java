package com.dao;

import com.entity.ZhongqidabianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhongqidabianVO;
import com.entity.view.ZhongqidabianView;


/**
 * 中期答辩
 * 
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface ZhongqidabianDao extends BaseMapper<ZhongqidabianEntity> {
	
	List<ZhongqidabianVO> selectListVO(@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);
	
	ZhongqidabianVO selectVO(@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);
	
	List<ZhongqidabianView> selectListView(@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);

	List<ZhongqidabianView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);
	
	ZhongqidabianView selectView(@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);
	

}
