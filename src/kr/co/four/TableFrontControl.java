package kr.co.four;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.ta")
public class TableFrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TableDTO tdto;
	TableDAO tdao;
	ArrayList<TableDTO> tableList;
	ArrayList<TableDTO> tableList1;

	public TableFrontControl() {
		tdto = new TableDTO();
		tdao = new TableDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length());

		if (command.equals("/totalList.ta")) {// ���
			int curPage = 1;// �⺻������
			if (request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			PageTo list = tdao.page(curPage);

			RequestDispatcher dis = request.getRequestDispatcher("template.jsp?page=simulator");
			request.setAttribute("page", list);
			// listPage.jsp���� ��� ����Ʈ ������ ����
			request.setAttribute("list", list.getBoardlist());
			// page.jsp���� ����¡ ó�� ������ ����
			dis.forward(request, response);

		} else if (command.equals("/report.ta")) {
			// HttpSession session = request.getSession();
			HttpSession session = request.getSession();
			tdto.setNal1(request.getParameter("nal1"));
			tdto.setNal2(request.getParameter("nal2"));

			tableList = tdao.report(tdto);
			System.out.println("11");

			System.out.println(tableList);
			System.out.println("22");
			System.out.println(tableList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("totalList.ta");
			session.setAttribute("tableList", tableList);
			dispatcher.forward(request, response);

		} else if (command.equals("/mainList.ta")) {//���̺� ��� �ѱ��
			tableList = tdao.head(tdto);
			System.out.println(tableList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("totalList.ta");
			request.setAttribute("totalList", tableList);
			dispatcher.forward(request, response);
		}//���̺� ����Ʈ �ѱ��
		
		else if(command.equals("/mainDelete")) {//����Ʈ ����
			String deleteNal = request.getParameter("nal");
			tdto.setNal(deleteNal);
			tdao.mainDelete(tdto);
		}//����Ʈ����
		

	}

}
