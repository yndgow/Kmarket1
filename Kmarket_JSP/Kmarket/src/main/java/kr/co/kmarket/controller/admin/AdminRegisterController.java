package kr.co.kmarket.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/admin/product/register.do")
public class AdminRegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminService service = AdminService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String savePath = req.getServletContext().getRealPath("/file");
		String savePath = "/var/webapps/upload/thumb";
		File mdfile = new File(savePath);
		if(!mdfile.exists()) mdfile.mkdirs();
				int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		// 기본정보
		String prodCate1 = mr.getParameter("category1"); 
		String prodCate2 = mr.getParameter("category2");
		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String company = mr.getParameter("company");
		String price = mr.getParameter("price");
		String point = mr.getParameter("point");
		String stock = mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		String discount = mr.getParameter("discount");
		String thumb1 = mr.getFilesystemName("thumb1");
		String thumb2 = mr.getFilesystemName("thumb2");
		String thumb3 = mr.getFilesystemName("thumb3");
		String detail = mr.getFilesystemName("detail");
		String ip = req.getRemoteAddr();
		
		// 상품정보 제공고시
		String seller = mr.getParameter("seller");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String receipt = mr.getParameter("receipt");
		String bizType = mr.getParameter("bizType");
		String origin = mr.getParameter("origin");
		

		
		SimpleDateFormat sdf = new SimpleDateFormat("MM"); // 날짜형식 달 
		String monthFolder = sdf.format(new Date()); // 오늘 날짜 포맷 적용
		String monthPath = savePath + "/" + monthFolder;
		File mdfile1 = new File(monthPath);
		if(!mdfile1.exists()) mdfile1.mkdirs();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd"); // 날짜형식 월
		String dayFolder = sdf2.format(new Date());
		String dayPath = monthPath + "/" + dayFolder;
		File mdfile2 = new File(dayPath);
		if(!mdfile2.exists()) mdfile2.mkdirs();
		
		
		String extension1 = thumb1.substring(thumb1.lastIndexOf("."), thumb1.length());
		UUID th1 = UUID.randomUUID();
		String newFileName1 = th1.toString() + extension1;
		
		String extension2 = thumb2.substring(thumb2.lastIndexOf("."), thumb2.length());
		UUID th2 = UUID.randomUUID();
		String newFileName2 = th2.toString() + extension2;
		
		String extension3 = thumb3.substring(thumb3.lastIndexOf("."), thumb3.length());
		UUID th3 = UUID.randomUUID();
		String newFileName3 = th3.toString() + extension3;
		
		String extension4 = detail.substring(detail.lastIndexOf("."), detail.length());
		UUID th4 = UUID.randomUUID();
		String newFileName4 = th4.toString() + extension4;
		
		
		File test1 = new File(savePath +"/" + thumb1);
		File nFile = new File(dayPath + "/" + newFileName1);
		test1.renameTo(nFile);
		
		File test2 = new File(savePath +"/" + thumb2);
		File nFile1 = new File(dayPath + "/" + newFileName2);
		test2.renameTo(nFile1);
		
		File test3 = new File(savePath +"/" + thumb3);
		File nFile2 = new File(dayPath + "/" + newFileName3);
		test3.renameTo(nFile2);
		
		File test4 = new File(savePath +"/" + detail);
		File nFile3 = new File(dayPath + "/" + newFileName4);
		test4.renameTo(nFile3);
		
		
//		try {
//			newThumb1 = service.reNameFile(thumb1, "uid190", savePath);
//			TimeUnit.SECONDS.sleep(1);
//			newThumb2 = service.reNameFile(thumb2, "uid230", savePath);
//			TimeUnit.SECONDS.sleep(1);
//			newThumb3 = service.reNameFile(thumb3, "uid456", savePath);
//			TimeUnit.SECONDS.sleep(1);
//			newDetail = service.reNameFile(detail, "uid940", savePath);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		ProductVO vo = new ProductVO();
		vo.setProdCate1(prodCate1);
		vo.setProdCate2(prodCate2);
		vo.setProdName(prodName);
		vo.setDescript(descript);
		vo.setCompany(company);
		vo.setPrice(price);
		vo.setPoint(point);
		vo.setStock(stock);
		vo.setDelivery(delivery);
		vo.setDiscount(discount);
		vo.setThumb1(newFileName1);
		vo.setThumb2(newFileName2);
		vo.setThumb3(newFileName3);
		vo.setDetail(newFileName4);
		vo.setIp(ip);
		
		// 상품정보 제공고시
		vo.setSeller(seller);
		vo.setStatus(status);
		vo.setDuty(duty);
		vo.setReceipt(receipt);
		vo.setBizType(bizType);
		vo.setOrigin(origin);
		
		// 이미지 파일 주소 날짜 정보 추가
		vo.setEtc3(monthFolder + "/" + dayFolder);
		
		int result = service.insertProductByAdmin(vo);
		
		if(result > 0) resp.sendRedirect("./register.do");
		
	}
}
