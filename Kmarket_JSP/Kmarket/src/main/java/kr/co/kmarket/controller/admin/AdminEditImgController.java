package kr.co.kmarket.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/admin/product/editImg.do")
public class AdminEditImgController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AdminService service = AdminService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/var/webapps/upload/thumb";
		MultipartRequest mr = new MultipartRequest(req, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		
		String fname = mr.getFilesystemName("fname");
		
		ProductVO vo = service.selectImg(mr.getParameter("prodNo"));
		
		File file1 = new File(path + "/" + vo.getEtc3() +"/"+ vo.getThumb1());
		File file2 = new File(path + "/" + vo.getEtc3() +"/"+ vo.getThumb2());
		File file3 = new File(path + "/" + vo.getEtc3() +"/"+ vo.getThumb3());
		File file4 = new File(path + "/" + vo.getEtc3() +"/"+ vo.getDetail());
		
		
		
		File newFile1 = new File(path + "/" + fname);
		
		FileUtils.copyFile(newFile1, file1);
		FileUtils.copyFile(newFile1, file2);
		FileUtils.copyFile(newFile1, file3);
		FileUtils.copyFile(newFile1, file4);
		FileUtils.delete(newFile1);
	}
}
