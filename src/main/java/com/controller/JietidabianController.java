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

import com.entity.JietidabianEntity;
import com.entity.view.JietidabianView;

import com.service.JietidabianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 结题答辩
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@RestController
@RequestMapping("/jietidabian")
public class JietidabianController {
    @Autowired
    private JietidabianService jietidabianService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JietidabianEntity jietidabian, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jietidabian.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jietidabian.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JietidabianEntity> ew = new EntityWrapper<JietidabianEntity>();


		PageUtils page = jietidabianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jietidabian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JietidabianEntity jietidabian, 
		HttpServletRequest request){
        EntityWrapper<JietidabianEntity> ew = new EntityWrapper<JietidabianEntity>();

		PageUtils page = jietidabianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jietidabian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JietidabianEntity jietidabian){
       	EntityWrapper<JietidabianEntity> ew = new EntityWrapper<JietidabianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jietidabian, "jietidabian")); 
        return R.ok().put("data", jietidabianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JietidabianEntity jietidabian){
        EntityWrapper< JietidabianEntity> ew = new EntityWrapper< JietidabianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jietidabian, "jietidabian")); 
		JietidabianView jietidabianView =  jietidabianService.selectView(ew);
		return R.ok("查询结题答辩成功").put("data", jietidabianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JietidabianEntity jietidabian = jietidabianService.selectById(id);
        return R.ok().put("data", jietidabian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JietidabianEntity jietidabian = jietidabianService.selectById(id);
        return R.ok().put("data", jietidabian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JietidabianEntity jietidabian, HttpServletRequest request){
    	jietidabian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jietidabian);

        jietidabianService.insert(jietidabian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JietidabianEntity jietidabian, HttpServletRequest request){
    	jietidabian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jietidabian);

        jietidabianService.insert(jietidabian);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JietidabianEntity jietidabian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jietidabian);
        jietidabianService.updateById(jietidabian);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jietidabianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
