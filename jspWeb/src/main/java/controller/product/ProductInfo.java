package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ProductDto;


@WebServlet("/product/info")
public class ProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ProductInfo() {
	
	}

	ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동");
		String 서 = request.getParameter("서");
		String 남 = request.getParameter("남");
		String 북 = request.getParameter("북");

		ArrayList<ProductDto> result = ProductDao.getInstance().getProductList(동, 서, 남, 북);

		String jsonarray = mapper.writeValueAsString(result);
		System.out.println(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*-------------------------- commons.jar 사용시 --------------------------*/
		request.setCharacterEncoding("UTF-8");
		
		//1. 다운로드 할 서버 경로
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		//2. 해당 경로의 파일/폴더 객체화 [setRepository에서 대입하기 위해 ] 저장 경로 객체(savePath)
		File savePath = new File(path);
		
		//3.업로드할 저장소 객체 생성[Disk => Window]
		DiskFileItemFactory saveStore = new DiskFileItemFactory();
		saveStore.setRepository(savePath); //파일 저장소 위치 대입
		saveStore.setSizeThreshold(1024*1024*10); //파일 저장소에 저장할 수 있는 최대용향 범위
		
		//4. 파일 업로드 객체
		ServletFileUpload fileupload = new  ServletFileUpload(saveStore);
		
		try {
			//5. 매개변수 요청해서 리스트에 담기 [무조건 예외처리 발생] 
			List<FileItem> fileitemList = fileupload.parseRequest(request);
			List<String> usufeildList = new ArrayList<>();
			List<String> filefeildList = new ArrayList<>();
			
			//6.
			for(FileItem item : fileitemList) {//요청된 모든 매개변수들을 반복문 돌려서 확인
				if(item.isFormField()) {
					// .isFormField() : 펌부파일이 아니면 true/ 첨부파일이면 false
					System.out.println("첨부파일 아닌 필드명 : " + item.getFieldName());
					System.out.println("첨부파일이 아닌 필드값 :" +item.getString());
					
					usufeildList.add(item.getString()); //필드안에 있는 값을 가져옴
				}else {
					System.out.println("첨부파일인 필드명 : " + item.getFieldName());  //매개변수명 확인
					System.out.println("필드내 첨부된 파일명" + item.getName()); //매개변수가 파일일 경우 파일명 확인
					
					//9.첨부파일 이름 식별 이름 변경 [replaceAll("기존문자","새로운 문자") : 문자열 치환
						// commons는 cos의 new DefaultFileRenamePolicy()을 지원X 
						//1) 파일명의 공백이 존재하면 -로 변경 [ .replaceAll("기존문자", "새로운문자") 문자열 치환변수]
						//2) UUID : 범용 고유 식별자[중복이 없는 식별자 만들기]
						//3) 최종 식별 파일명 : UUID 파일명
					String fileName = UUID.randomUUID() + " " + item.getName().replaceAll(" ", "-");
					
					filefeildList.add(fileName);
			
					//7. 저장경로+/+파일명의 파일을 객체화 
					File uplaodFile = new File(savePath + "/" +fileName); //객체화 시키고 
					//8. 해당 파일 객체 저장 [첨부파일만 write() => 다른 필드도 write하면 문제가 생긴다.]
					// 실질적인 업로드
					item.write(uplaodFile); //넣는다. [그냥 savePath + "/" + item.getFieldName() 이걸 넣으면 에러남 File 객체가 아니라서]
					
				}
				
			}
			
			int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
				
			System.out.println(usufeildList.toString());
			System.out.println(filefeildList.toString());
			//Dao 처리
			ProductDto dto = new ProductDto(
					usufeildList.get(0),
					usufeildList.get(1),
					Integer.parseInt(usufeildList.get(2)),
					usufeildList.get(3),
					usufeildList.get(4),
					mno,
					filefeildList);
				
			System.out.println( "dto : " + dto.toString() );
				
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		
		/*-------------------------- cos.jar 사용시 --------------------------*/
		/*
		 * String path =
		 * request.getSession().getServletContext().getRealPath("/product/pimg");
		 * 
		 * MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 *
		 * 10, "UTF-8", new DefaultFileRenamePolicy());
		 * 
		 * String pname = multi.getParameter("pname"); String pcomment =
		 * multi.getParameter("pcomment"); int pprice =
		 * Integer.parseInt(multi.getParameter("pprice")); String plat =
		 * multi.getParameter("plat"); String plng = multi.getParameter("plng");
		 */

		/*
		 * //첨부파일 1개 이름 가져오기 multiple x String pfile = multi.getFilesystemName("pfile");
		 * 
		 * //첨부파일 여러개 이름 가져오기 1 multiple x String pfile1 =
		 * multi.getFilesystemName("pfile1"); String pfile2 =
		 * multi.getFilesystemName("pfile2"); String pfile3 =
		 * multi.getFilesystemName("pfile3");
		 * 
		 * //첨부파일 여러개 이름 가져오기 2 multiple //multiple input에 등록된 여러 사진들의 이름을 가져오기 불가능 ->
		 * [cos.jar 제공X] //다른 라이브러리 사용 String pfiles =
		 * multi.getFilesystemName("pfiles"); //이름이 하나밖에 안가져옴 Enumeration<String> pfiles
		 * = multi.getFileNames(); //input type이 file의 태그명 호출
		 * 
		 * while(pfiles.hasMoreElements()) { //해당 목록 [pfiles] 에 요소 [element]가 존재하면 true/
		 * 아니면 false String s = pfiles.nextElement(); //다음요소 가져오기 }
		 */
	
		/* ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng); */
		/* System.out.println(dto); */
		/* boolean result = ProductDao.getInstance().write(dto); */
		/* response.getWriter().print(result); */
		 
	}

}