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

import com.entity.JietipingjiaEntity;
import com.entity.view.JietipingjiaView;

import com.service.JietipingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 结题评价
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@RestController
@RequestMapping("/jietipingjia")
public class JietipingjiaController {
    @Autowired
    private JietipingjiaService jietipingjiaService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JietipingjiaEntity jietipingjia, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jietipingjia.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jietipingjia.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JietipingjiaEntity> ew = new EntityWrapper<JietipingjiaEntity>();


		PageUtils page = jietipingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jietipingjia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JietipingjiaEntity jietipingjia, 
		HttpServletRequest request){
        EntityWrapper<JietipingjiaEntity> ew = new EntityWrapper<JietipingjiaEntity>();

		PageUtils page = jietipingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jietipingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JietipingjiaEntity jietipingjia){
       	EntityWrapper<JietipingjiaEntity> ew = new EntityWrapper<JietipingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jietipingjia, "jietipingjia")); 
        return R.ok().put("data", jietipingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JietipingjiaEntity jietipingjia){
        EntityWrapper< JietipingjiaEntity> ew = new EntityWrapper< JietipingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jietipingjia, "jietipingjia")); 
		JietipingjiaView jietipingjiaView =  jietipingjiaService.selectView(ew);
		return R.ok("查询结题评价成功").put("data", jietipingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JietipingjiaEntity jietipingjia = jietipingjiaService.selectById(id);
        return R.ok().put("data", jietipingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JietipingjiaEntity jietipingjia = jietipingjiaService.selectById(id);
        return R.ok().put("data", jietipingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JietipingjiaEntity jietipingjia, HttpServletRequest request){
    	jietipingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jietipingjia);

        jietipingjiaService.insert(jietipingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JietipingjiaEntity jietipingjia, HttpServletRequest request){
    	jietipingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jietipingjia);

        jietipingjiaService.insert(jietipingjia);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JietipingjiaEntity jietipingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jietipingjia);
        jietipingjiaService.updateById(jietipingjia);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jietipingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
