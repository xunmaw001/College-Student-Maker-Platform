package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiangmushenqingEntity;
import com.entity.view.XiangmushenqingView;

import com.service.XiangmushenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 项目申请
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@RestController
@RequestMapping("/xiangmushenqing")
public class XiangmushenqingController {
    @Autowired
    private XiangmushenqingService xiangmushenqingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmushenqingEntity xiangmushenqing, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			xiangmushenqing.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			xiangmushenqing.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiangmushenqingEntity> ew = new EntityWrapper<XiangmushenqingEntity>();


		PageUtils page = xiangmushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmushenqing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmushenqingEntity xiangmushenqing, 
		HttpServletRequest request){
        EntityWrapper<XiangmushenqingEntity> ew = new EntityWrapper<XiangmushenqingEntity>();

		PageUtils page = xiangmushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmushenqingEntity xiangmushenqing){
       	EntityWrapper<XiangmushenqingEntity> ew = new EntityWrapper<XiangmushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmushenqing, "xiangmushenqing")); 
        return R.ok().put("data", xiangmushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmushenqingEntity xiangmushenqing){
        EntityWrapper< XiangmushenqingEntity> ew = new EntityWrapper< XiangmushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmushenqing, "xiangmushenqing")); 
		XiangmushenqingView xiangmushenqingView =  xiangmushenqingService.selectView(ew);
		return R.ok("查询项目申请成功").put("data", xiangmushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmushenqingEntity xiangmushenqing = xiangmushenqingService.selectById(id);
        return R.ok().put("data", xiangmushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmushenqingEntity xiangmushenqing = xiangmushenqingService.selectById(id);
        return R.ok().put("data", xiangmushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmushenqingEntity xiangmushenqing, HttpServletRequest request){
    	xiangmushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmushenqing);

        xiangmushenqingService.insert(xiangmushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmushenqingEntity xiangmushenqing, HttpServletRequest request){
    	xiangmushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmushenqing);

        xiangmushenqingService.insert(xiangmushenqing);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmushenqingEntity xiangmushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmushenqing);
        xiangmushenqingService.updateById(xiangmushenqing);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
