package kr.co.daegu.analysis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnalysisFrontControllServlet
 */
@WebServlet("*.analysis")
public class AnalysisFrontControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private AnalysisDAO analysisDAO;
		private AnalysisDTO analysisDTO;
		private ArrayList<AnalysisDTO> analysisList;
		
	public AnalysisFrontControllServlet() {
		analysisDAO = new AnalysisDAO();
		analysisDTO = new AnalysisDTO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI  =request.getRequestURI();//jsp���ο� �ۼ���  action�ּҷ� �����ٰ� �ؼ� �� ���°Ծƴϴ�. localhost����ؼ� (�ּ� �Ǿ�)���� �� �Ѿ. �ٵ� �� ������ ��ģ ���� �ڹٺ����� ����.
		String contextPath = request.getContextPath();//
		String command = requestURI.substring(contextPath.length());//���� �ΰ����� �ڸ��� ���� �κ��� substring¥���ڴ�. ��ü�ּ��߿� contextPath.length��ŭ�� ¥����. �׸��� �Ʒ��� if���ȿ� boardList.boa�� ���Ѵ�.
		
		if(command.equals("/dayAver.analysis")) {
			String nal1 = request.getParameter("nal1");
			String nal2 = request.getParameter("nal2");
			analysisDTO.setNal1(nal1);
			analysisDTO.setNal2(nal2);
			response.sendRedirect("analysisList.analysis");
		}//�˻� ��¥
	
	}

}
