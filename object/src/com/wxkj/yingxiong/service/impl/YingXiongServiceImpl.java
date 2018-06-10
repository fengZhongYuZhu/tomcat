package com.wxkj.yingxiong.service.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.wxkj.dao.Dao;
import com.wxkj.dbUtil.DbUtil;
import com.wxkj.yingxiong.entity.YingXiongEntity;
import com.wxkj.yingxiong.service.YingXiongService;

public class YingXiongServiceImpl implements YingXiongService {

	private Dao dao=new Dao();
	
	@Override
	public void addYingXiong(YingXiongEntity yingXiongEntity) {
		// TODO Auto-generated method stub
		String sql="insert into yingxiong (p_id,p_name,p_weizhi) values ('"+yingXiongEntity.getP_id()+"','"+yingXiongEntity.getP_name()+"','"+yingXiongEntity.getP_weizhi()+"')";
		dao.addObj(sql);
	}

	/**
	 * 英雄表全查
	 */
	@Override
	public List<YingXiongEntity> queryYingXiongByAll() {
		// TODO Auto-generated method stub
		List<YingXiongEntity> list=null;
		try {
			String sql="select * from yingxiong";
			list=(List<YingXiongEntity>) dao.query(sql,YingXiongEntity.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 单一查询
	 */
	@Override
	public YingXiongEntity queryYingXiongById(String p_id) {
		// TODO Auto-generated method stub
		YingXiongEntity yingXiongEntity=null;
		try {
			String sql="select * from yingxiong where p_id='"+p_id+"'";
			List<YingXiongEntity> list=(List<YingXiongEntity>) dao.query(sql,YingXiongEntity.class);
			if(!list.isEmpty()){
				yingXiongEntity=list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return yingXiongEntity;
	}

	/**
	 * 根据名称进行模糊查询
	 */
	@Override
	public List<YingXiongEntity> queryYingXiongByLike(String p_name) {
		// TODO Auto-generated method stub
		String sql="select * from yingxiong where p_name like '%"+p_name+"%'";
		List<YingXiongEntity> list=(List<YingXiongEntity>) dao.query(sql,YingXiongEntity.class);
		return list;
	}
	
	//单一的封装
	public List<YingXiongEntity> fenZhuang(ResultSet resultSet){
		List<YingXiongEntity> list=new ArrayList<YingXiongEntity>();
		try {
			while(resultSet.next()){
				YingXiongEntity yingXiongEntity=new YingXiongEntity();
				yingXiongEntity.setP_age(resultSet.getInt("p_age"));
				yingXiongEntity.setP_id(resultSet.getString("p_id"));
				yingXiongEntity.setP_leader(resultSet.getString("p_leader"));
				yingXiongEntity.setP_name(resultSet.getString("p_name"));
				yingXiongEntity.setP_sex(resultSet.getString("p_sex"));
				yingXiongEntity.setP_weizhi(resultSet.getString("p_weizhi"));
				yingXiongEntity.setW_id(resultSet.getString("w_id"));
				list.add(yingXiongEntity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}

	/**
	 * 查询已经购买英雄
	 */
	@Override
	public List<YingXiongEntity> queryYiMai(String w_id) {
		// TODO Auto-generated method stub
		String sql="select * from yingxiong where w_id='"+w_id+"'";
		List<YingXiongEntity> list=(List<YingXiongEntity>) dao.query(sql,YingXiongEntity.class);
		return list;
	}

	/**
	 * 查询还可以购买英雄
	 */
	@Override
	public List<YingXiongEntity> queryWeiMai() {
		// TODO Auto-generated method stub
		String sql="select * from yingxiong where w_id is null or w_id=''";
		List<YingXiongEntity> list=(List<YingXiongEntity>) dao.query(sql,YingXiongEntity.class);
		return list;
	}

	/**
	 * 购买英雄
	 */
	@Override
	public void gouMai(String w_id,String p_id) {
		// TODO Auto-generated method stub
		String sql="update yingxiong set w_id='"+w_id+"' where p_id='"+p_id+"'";
		dao.addObj(sql);
	}

	/**
	 * 退货
	 */
	@Override
	public void tuiHuo(String p_id) {
		// TODO Auto-generated method stub
		String sql="update yingxiong set w_id='' where p_id='"+p_id+"'";
		dao.addObj(sql);
	}
}
