package com.wxkj.wanjia.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.wxkj.wanjia.entity.WanJiaEntity;
import com.wxkj.wanjia.service.WanJiaService;
import com.wxkj.yingxiong.entity.YingXiongEntity;

public class WanJiaAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private WanJiaService WanJiaService=new WanJiaService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		try{
			HttpSession session=req.getSession();
			//1�����ղ���
			String userName=req.getParameter("userName");
			String password=req.getParameter("password");
			//2�����򵥵Ĵ�����װ��
			//3�����÷���
			WanJiaEntity wanJiaEntity=WanJiaService.login(userName, password);
			//4������
			if(wanJiaEntity == null){
				//��¼ʧ��
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			}else{
				//��¼�ɹ�
				//����¼���û����ƺ�������������session��
				session.setAttribute("userName", userName);
				session.setAttribute("w_id", wanJiaEntity.getW_id());
				//��ת���󣬲�ѯ��ǰ����Ѿ������Ӣ�ۺͿ��Թ����Ӣ��
				resp.sendRedirect(req.getContextPath()+"/yingXiong?state=queryMai");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void test(HttpServletRequest req, HttpServletResponse resp){
		//��ȡsession����
		HttpSession session=req.getSession();
		//��ȡapplication����
		ServletContext application=session.getServletContext();
		System.out.println("���ү");
	}
	
	/**
	 * ����SVN
	 */
	public void he(){
		System.out.println("����");
	}
	
	/**
	 * ����SVN
	 */
	public void chi(){
		System.out.println("����");
	}
}
