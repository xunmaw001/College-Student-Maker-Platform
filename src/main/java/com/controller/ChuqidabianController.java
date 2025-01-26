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

import com.entity.ChuqidabianEntity;
import com.entity.view.ChuqidabianView;

import com.service.ChuqidabianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 初期答辩
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@RestController
@RequestMapping("/chuqidabian")
public class ChuqidabianController {
    @Autowired
    private ChuqidabianService chuqidabianService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuqidabianEntity chuqidabian, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			chuqidabian.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			chuqidabian.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChuqidabianEntity> ew = new EntityWrapper<ChuqidabianEntity>();


		PageUtils page = chuqidabianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuqidabian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuqidabianEntity chuqidabian, 
		HttpServletRequest request){
        EntityWrapper<ChuqidabianEntity> ew = new EntityWrapper<ChuqidabianEntity>();

		PageUtils page = chuqidabianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuqidabian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuqidabianEntity chuqidabian){
       	EntityWrapper<ChuqidabianEntity> ew = new EntityWrapper<ChuqidabianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuqidabian, "chuqidabian")); 
        return R.ok().put("data", chuqidabianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuqidabianEntity chuqidabian){
        EntityWrapper< ChuqidabianEntity> ew = new EntityWrapper< ChuqidabianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuqidabian, "chuqidabian")); 
		ChuqidabianView chuqidabianView =  chuqidabianService.selectView(ew);
		return R.ok("查询初期答辩成功").put("data", chuqidabianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuqidabianEntity chuqidabian = chuqidabianService.selectById(id);
        return R.ok().put("data", chuqidabian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuqidabianEntity chuqidabian = chuqidabianService.selectById(id);
        return R.ok().put("data", chuqidabian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuqidabianEntity chuqidabian, HttpServletRequest request){
    	chuqidabian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuqidabian);

        chuqidabianService.insert(chuqidabian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuqidabianEntity chuqidabian, HttpServletRequest request){
    	chuqidabian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuqidabian);

        chuqidabianService.insert(chuqidabian);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuqidabianEntity chuqidabian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuqidabian);
        chuqidabianService.updateById(chuqidabian);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuqidabianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
