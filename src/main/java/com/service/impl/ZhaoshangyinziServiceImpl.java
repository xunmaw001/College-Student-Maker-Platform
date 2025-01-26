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


import com.dao.ZhaoshangyinziDao;
import com.entity.ZhaoshangyinziEntity;
import com.service.ZhaoshangyinziService;
import com.entity.vo.ZhaoshangyinziVO;
import com.entity.view.ZhaoshangyinziView;

@Service("zhaoshangyinziService")
public class ZhaoshangyinziServiceImpl extends ServiceImpl<ZhaoshangyinziDao, ZhaoshangyinziEntity> implements ZhaoshangyinziService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaoshangyinziEntity> page = this.selectPage(
                new Query<ZhaoshangyinziEntity>(params).getPage(),
                new EntityWrapper<ZhaoshangyinziEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaoshangyinziEntity> wrapper) {
		  Page<ZhaoshangyinziView> page =new Query<ZhaoshangyinziView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaoshangyinziVO> selectListVO(Wrapper<ZhaoshangyinziEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaoshangyinziVO selectVO(Wrapper<ZhaoshangyinziEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaoshangyinziView> selectListView(Wrapper<ZhaoshangyinziEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaoshangyinziView selectView(Wrapper<ZhaoshangyinziEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
