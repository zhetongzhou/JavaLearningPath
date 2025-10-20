package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import db.DB;
public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		request.setCharacterEncoding("gb2312");
		// ������Ӧ����
		response.setContentType("gb2312");
		// ��ȡtitle����
		String title=request.getParameter("title");
		// ��ȡcontent����
		String content=request.getParameter("content");
		// ��session��ȡ����ǰ�û�����
		HttpSession session =request.getSession();
		User user=(User) session.getAttribute("user");/////////////////////////////User user=(User) request.getSession().getAttribute("user");/////////////////////////////////////////////////////

		// �������Ա��ӦJavaBean���󣬰����ݷ�װ��ȥ
		LyTable ly=new LyTable();
		ly.setUserId(user.getId());//////////////////////////////////////////////user.getId()
		// ����Ϊ��ȡ�ĵ�ǰʱ��
		ly.setDate(new Date(System.currentTimeMillis()));
		ly.setTitle(title);
		ly.setContent(content);
		//
		if(new DB().addInfo(ly)){
			response.sendRedirect("success.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
