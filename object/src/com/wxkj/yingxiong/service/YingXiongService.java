package com.wxkj.yingxiong.service;

import java.util.List;

import com.wxkj.yingxiong.entity.YingXiongEntity;

public interface YingXiongService {

	//新增英雄数据
	public void addYingXiong(YingXiongEntity yingXiongEntity);
	
	//全查
	public List<YingXiongEntity> queryYingXiongByAll();
	
	//单一查询
	public YingXiongEntity queryYingXiongById(String p_id);
	
	//模糊查询
	public List<YingXiongEntity> queryYingXiongByLike(String p_name);
	
	//查询当前玩家已经购买的英雄
	public List<YingXiongEntity> queryYiMai(String w_id);
	
	//查询还能购买的英雄
	public List<YingXiongEntity> queryWeiMai();
	
	/**
	 * 当前玩家购买英雄
	 */
	public void gouMai(String w_id,String p_id);
	
	/**
	 * 当前玩家退货
	 */
	public void tuiHuo(String p_id);
}
