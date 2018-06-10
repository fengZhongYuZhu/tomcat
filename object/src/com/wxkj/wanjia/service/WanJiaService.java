package com.wxkj.wanjia.service;

import java.util.List;

import com.wxkj.dao.Dao;
import com.wxkj.wanjia.entity.WanJiaEntity;

public class WanJiaService {

	private Dao dao=new Dao();
	/**
	 * µÇÂ¼
	 */
	public WanJiaEntity login(String w_name,String w_id){
		String sql="select * from wanjia where w_name='"+w_name+"' and w_id='"+w_id+"'";
		List<WanJiaEntity> list=(List<WanJiaEntity>) dao.query(sql,WanJiaEntity.class);
		WanJiaEntity wanJiaEntity=null;
		try {
			wanJiaEntity=list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return wanJiaEntity;
	}
}
