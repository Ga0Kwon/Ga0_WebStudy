package practice.Day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Ex3/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Product() {
    }
    //2. 제품 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<productDto> productList = ProductDao.getInStance().printProduct();
		
		ObjectMapper objectmmaper = new ObjectMapper();
		String jsonArray = objectmmaper.writeValueAsString(productList);
		
		response.setContentType("application/json");
		
		response.getWriter().print(jsonArray);
	}

	//1. 제품 등록 서블릿
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String productName = request.getParameter("productName");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		
		productDto dto = new productDto(0, productName, productPrice);
		
		boolean result = ProductDao.getInStance().insertProduct(dto);
		
		response.getWriter().print(result);
	}

	//3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int productNo = Integer.parseInt(request.getParameter("pno"));
		int productPrice = Integer.parseInt(request.getParameter("pprice"));
		String productName =  request.getParameter("pname");
		
		productDto dto  = new productDto(productNo, productName, productPrice);
		
		boolean result = ProductDao.getInStance().updateProduct(dto);
		
		response.getWriter().print(result);
		
	}

	//4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		int productNo = Integer.parseInt(request.getParameter("pno"));
		
		boolean result =  ProductDao.getInStance().deleteProduct(productNo);
		
		response.getWriter().print(result);
	}

}
