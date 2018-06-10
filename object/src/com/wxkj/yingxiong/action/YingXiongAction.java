package com.wxkj.yingxiong.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxkj.yingxiong.entity.YingXiongEntity;
import com.wxkj.yingxiong.service.YingXiongService;
import com.wxkj.yingxiong.service.impl.YingXiongServiceImpl;

public class YingXiongAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private YingXiongService yingXiongService=new YingXiongServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String state=req.getParameter("state");
		if(state.equals("queryAll")){
			this.queryAll(req, resp);
		}else if(state.equals("addYingXiong")){
			this.addYingXiong(req, resp);
		}else if(state.equals("updateYingXiong")){
			this.updateYingXiong(req, resp);
		}else if(state.equals("deleteYingXiong")){
			this.deleteYingXiong(req, resp);
		}else if(state.equals("oneYingXiong")){
			this.oneYingXiong(req, resp);
		}else if(state.equals("queryMai")){
			this.queryMai(req,resp);
		}else if(state.equals("mai")){
			this.mai(req,resp);
		}else if(state.equals("tui")){
			this.tui(req,resp);
		}
	}
	
	/**
	 * �˻�
	 * @param req
	 * @param resp
	 */
	private void tui(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String p_id=req.getParameter("p_id");
			yingXiongService.tuiHuo(p_id);
			resp.sendRedirect(req.getContextPath()+"/yingXiong?state=queryMai");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * ��ǰ��¼��ҹ���Ӣ��
	 * @param req
	 * @param resp
	 */
	private void mai(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			HttpSession session=req.getSession();
			String w_id=(String) session.getAttribute("w_id");
			String p_id=req.getParameter("p_id");
			yingXiongService.gouMai(w_id, p_id);
			resp.sendRedirect(req.getContextPath()+"/yingXiong?state=queryMai");
			//this.queryMai(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * ��ѯ��ǰ��¼������Ѿ������Ӣ�ۺͿ��Թ����Ӣ��
	 */
	private void queryMai(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		String w_id=(String) session.getAttribute("w_id");
		List<YingXiongEntity> yiMaiList=yingXiongService.queryYiMai(w_id);
		List<YingXiongEntity> weiMaiList=yingXiongService.queryWeiMai();
		req.setAttribute("yiMaiList", yiMaiList);
		req.setAttribute("weiMaiList", weiMaiList);
		try {
			req.getRequestDispatcher("/jsp/yingXiongList.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ȫ��
	 */
	public void queryAll(HttpServletRequest req, HttpServletResponse resp){
		try {
			List<YingXiongEntity> list=yingXiongService.queryYingXiongByAll();
			req.setAttribute("yingXiongList", list);
			req.getRequestDispatcher("/jsp/yingXiongList.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ����
	 */
	public void addYingXiong(HttpServletRequest req, HttpServletResponse resp){
		
	}
	
	
	/**
	 * �޸�
	 */
	public void updateYingXiong(HttpServletRequest req, HttpServletResponse resp){
		
	}
	
	
	
	/**
	 * ɾ��
	 */
	public void deleteYingXiong(HttpServletRequest req, HttpServletResponse resp){
		
	}
	
	
	/**
	 * ��һ��ѯ
	 */
	public void oneYingXiong(HttpServletRequest req, HttpServletResponse resp){
		
	}
}
