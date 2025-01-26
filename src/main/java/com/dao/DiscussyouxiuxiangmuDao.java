package com.dao;

import com.entity.DiscussyouxiuxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyouxiuxiangmuVO;
import com.entity.view.DiscussyouxiuxiangmuView;


/**
 * 优秀项目评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public interface DiscussyouxiuxiangmuDao extends BaseMapper<DiscussyouxiuxiangmuEntity> {
	
	List<DiscussyouxiuxiangmuVO> selectListVO(@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
	
	DiscussyouxiuxiangmuVO selectVO(@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
	
	List<DiscussyouxiuxiangmuView> selectListView(@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);

	List<DiscussyouxiuxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
	
	DiscussyouxiuxiangmuView selectView(@Param("ew") Wrapper<DiscussyouxiuxiangmuEntity> wrapper);
	

}
