package com.entity.vo;

import com.entity.ZhongqidabianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 中期答辩
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
public class ZhongqidabianVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目类别
	 */
	
	private String xiangmuleibie;
		
	/**
	 * 经费来源
	 */
	
	private String jingfeilaiyuan;
		
	/**
	 * 教师工号
	 */
	
	private String jiaoshigonghao;
		
	/**
	 * 小组成员
	 */
	
	private String xiaozuchengyuan;
		
	/**
	 * 学生学号
	 */
	
	private String xueshengxuehao;
		
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 学院
	 */
	
	private String xueyuan;
		
	/**
	 * 专业
	 */
	
	private String zhuanye;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 提交时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tijiaoshijian;
		
	/**
	 * 中期答辩
	 */
	
	private String zhongqidabian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：项目类别
	 */
	 
	public void setXiangmuleibie(String xiangmuleibie) {
		this.xiangmuleibie = xiangmuleibie;
	}
	
	/**
	 * 获取：项目类别
	 */
	public String getXiangmuleibie() {
		return xiangmuleibie;
	}
				
	
	/**
	 * 设置：经费来源
	 */
	 
	public void setJingfeilaiyuan(String jingfeilaiyuan) {
		this.jingfeilaiyuan = jingfeilaiyuan;
	}
	
	/**
	 * 获取：经费来源
	 */
	public String getJingfeilaiyuan() {
		return jingfeilaiyuan;
	}
				
	
	/**
	 * 设置：教师工号
	 */
	 
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
				
	
	/**
	 * 设置：小组成员
	 */
	 
	public void setXiaozuchengyuan(String xiaozuchengyuan) {
		this.xiaozuchengyuan = xiaozuchengyuan;
	}
	
	/**
	 * 获取：小组成员
	 */
	public String getXiaozuchengyuan() {
		return xiaozuchengyuan;
	}
				
	
	/**
	 * 设置：学生学号
	 */
	 
	public void setXueshengxuehao(String xueshengxuehao) {
		this.xueshengxuehao = xueshengxuehao;
	}
	
	/**
	 * 获取：学生学号
	 */
	public String getXueshengxuehao() {
		return xueshengxuehao;
	}
				
	
	/**
	 * 设置：学生姓名
	 */
	 
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
				
	
	/**
	 * 设置：学院
	 */
	 
	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}
	
	/**
	 * 获取：学院
	 */
	public String getXueyuan() {
		return xueyuan;
	}
				
	
	/**
	 * 设置：专业
	 */
	 
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：提交时间
	 */
	 
	public void setTijiaoshijian(Date tijiaoshijian) {
		this.tijiaoshijian = tijiaoshijian;
	}
	
	/**
	 * 获取：提交时间
	 */
	public Date getTijiaoshijian() {
		return tijiaoshijian;
	}
				
	
	/**
	 * 设置：中期答辩
	 */
	 
	public void setZhongqidabian(String zhongqidabian) {
		this.zhongqidabian = zhongqidabian;
	}
	
	/**
	 * 获取：中期答辩
	 */
	public String getZhongqidabian() {
		return zhongqidabian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
