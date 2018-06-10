package com.wxkj.dbUtil;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

	public static Object resultToList(ResultSet resultSet,Class<?> classs){
		//������װʵ�������
		List<Object> list=new ArrayList<Object>();
		try {
			while(resultSet.next()){
				//�����ĸ�������ƴ���ʵ�������
				Object entity=classs.newInstance();
				for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
					//����������ȡ��ǰ�ֶ�����
					String columnName=resultSet.getMetaData().getColumnName(i);
					//��ȡ��ǰ������ֵ
					Object value=resultSet.getObject(i);
					//�����ֶ����ƻ�õ�ǰ���еĵ�һ����
					Field field=classs.getDeclaredField(columnName);
					//����ǰ��������Ϊ�ɸ�ֵ״̬
					field.setAccessible(true);
					//Ϊָ����������Ľ��и�ֵ
					field.set(entity, value);
				}
				list.add(entity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
}
