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


import com.dao.DiscusszhaoshangyinziDao;
import com.entity.DiscusszhaoshangyinziEntity;
import com.service.DiscusszhaoshangyinziService;
import com.entity.vo.DiscusszhaoshangyinziVO;
import com.entity.view.DiscusszhaoshangyinziView;

@Service("discusszhaoshangyinziService")
public class DiscusszhaoshangyinziServiceImpl extends ServiceImpl<DiscusszhaoshangyinziDao, DiscusszhaoshangyinziEntity> implements DiscusszhaoshangyinziService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhaoshangyinziEntity> page = this.selectPage(
                new Query<DiscusszhaoshangyinziEntity>(params).getPage(),
                new EntityWrapper<DiscusszhaoshangyinziEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhaoshangyinziEntity> wrapper) {
		  Page<DiscusszhaoshangyinziView> page =new Query<DiscusszhaoshangyinziView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhaoshangyinziVO> selectListVO(Wrapper<DiscusszhaoshangyinziEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhaoshangyinziVO selectVO(Wrapper<DiscusszhaoshangyinziEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhaoshangyinziView> selectListView(Wrapper<DiscusszhaoshangyinziEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhaoshangyinziView selectView(Wrapper<DiscusszhaoshangyinziEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
