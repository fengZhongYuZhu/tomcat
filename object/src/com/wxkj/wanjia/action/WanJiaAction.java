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
			//1、接收参数
			String userName=req.getParameter("userName");
			String password=req.getParameter("password");
			//2、做简单的处理（封装）
			//3、调用方法
			WanJiaEntity wanJiaEntity=WanJiaService.login(userName, password);
			//4、处理
			if(wanJiaEntity == null){
				//登录失败
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			}else{
				//登录成功
				//将登录的用户名称和数据主键保存session中
				session.setAttribute("userName", userName);
				session.setAttribute("w_id", wanJiaEntity.getW_id());
				//跳转请求，查询当前玩家已经购买的英雄和可以购买的英雄
				resp.sendRedirect(req.getContextPath()+"/yingXiong?state=queryMai");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void test(HttpServletRequest req, HttpServletResponse resp){
		//获取session对象
		HttpSession session=req.getSession();
		//获取application对象
		ServletContext application=session.getServletContext();
		System.out.println("你大爷");
	}
	
	/**
	 * 测试SVN
	 */
	public void he(){
		System.out.println("渴了");
	}
	
	/**
	 * 测试SVN
	 */
	public void chi(){
		System.out.println("饿了");
	}
}
