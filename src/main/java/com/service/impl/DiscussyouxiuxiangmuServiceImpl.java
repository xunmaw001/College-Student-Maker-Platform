package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyouxiuxiangmuDao;
import com.entity.DiscussyouxiuxiangmuEntity;
import com.service.DiscussyouxiuxiangmuService;
import com.entity.vo.DiscussyouxiuxiangmuVO;
import com.entity.view.DiscussyouxiuxiangmuView;

@Service("discussyouxiuxiangmuService")
public class DiscussyouxiuxiangmuServiceImpl extends ServiceImpl<DiscussyouxiuxiangmuDao, DiscussyouxiuxiangmuEntity> implements DiscussyouxiuxiangmuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyouxiuxiangmuEntity> page = this.selectPage(
                new Query<DiscussyouxiuxiangmuEntity>(params).getPage(),
                new EntityWrapper<DiscussyouxiuxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyouxiuxiangmuEntity> wrapper) {
		  Page<DiscussyouxiuxiangmuView> page =new Query<DiscussyouxiuxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyouxiuxiangmuVO> selectListVO(Wrapper<DiscussyouxiuxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyouxiuxiangmuVO selectVO(Wrapper<DiscussyouxiuxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyouxiuxiangmuView> selectListView(Wrapper<DiscussyouxiuxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyouxiuxiangmuView selectView(Wrapper<DiscussyouxiuxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
