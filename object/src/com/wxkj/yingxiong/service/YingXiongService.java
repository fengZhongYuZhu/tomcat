package com.wxkj.yingxiong.service;

import java.util.List;

import com.wxkj.yingxiong.entity.YingXiongEntity;

public interface YingXiongService {

	//����Ӣ������
	public void addYingXiong(YingXiongEntity yingXiongEntity);
	
	//ȫ��
	public List<YingXiongEntity> queryYingXiongByAll();
	
	//��һ��ѯ
	public YingXiongEntity queryYingXiongById(String p_id);
	
	//ģ����ѯ
	public List<YingXiongEntity> queryYingXiongByLike(String p_name);
	
	//��ѯ��ǰ����Ѿ������Ӣ��
	public List<YingXiongEntity> queryYiMai(String w_id);
	
	//��ѯ���ܹ����Ӣ��
	public List<YingXiongEntity> queryWeiMai();
	
	/**
	 * ��ǰ��ҹ���Ӣ��
	 */
	public void gouMai(String w_id,String p_id);
	
	/**
	 * ��ǰ����˻�
	 */
	public void tuiHuo(String p_id);
}
