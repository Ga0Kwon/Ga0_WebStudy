package 과제.과제11.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import 과제.과제11.controller.PController;
import 과제.과제11.model.ProductDto;

public class View {
	private Scanner scanner = new Scanner(System.in);
	
	
	private static View view = new View();
	public View() {}
	
	public static View getInstance() {
		return view;
	}
	
	public void index() {
		while(true) {
			try {
				System.out.println("------------------------------------제품관리시스템------------------------------------");
				System.out.print("1. 제품 등록 2. 모든 제품 출력 3. 제품 수정[이름, 가격] 4. 제품 재고 변경/수정 5. 제품 삭제 : ");
				int choice =  scanner.nextInt();
				
				if(choice == 1) { //1. 제품 등록
					enrollProduct();
				}else if(choice == 2) {//2. 모든 제품 출력
					printProduct();
				}else if(choice == 3) {//3. 제품 수정[이름, 가격]
					updateProductInfo();
				}else if(choice == 4) {//4. 제품 재고 변경
					updateProductStock();
				}else if(choice == 5) {//5. 제품 삭제
					deleteProduct();
				}
			}catch(InputMismatchException e) {
				System.err.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in); //입력값 초기화
			}catch(Exception e) {
				System.err.println("[프로그램 오류] 관리자에게 문의해주세요.");
			}
		}
	}
	
	//1. 제품 등록
	public void enrollProduct() {
		System.out.println("-------------------------------------제품 등록--------------------------------------");
		System.out.print("제품 이름 : "); scanner.nextLine(); String name = scanner.nextLine();
		System.out.print("제품 가격 : "); int price = scanner.nextInt();
		System.out.print("제품 재고 : "); int stock = scanner.nextInt();
		
		boolean result = PController.getInstance().enrollProduct(name, price, stock);
		
		if(result) {
			System.out.println("제품이 등록되었습니다.");
		}else {
			System.err.println("제품 등록에 실패하였습니다.");
		}
	}
	
	//2. 모든 제품 출력
	public void printProduct() {
		System.out.println("-------------------------------------제품 리스트-------------------------------------");
		ArrayList<ProductDto> productList = PController.getInstance().printProduct();
		System.out.printf("%5s %20s %25s %20s \n", "제품 번호", "제품 이름", "제품 가격", "제품 재고");
		for(ProductDto dto : productList) {
			System.out.printf("%-10d  %20s  %18d  %20d \n", 
					dto.getpNo(), 
					dto.getpName(),
					dto.getpPrice(),
					dto.getpStock());
		}
	}
	
	//3. 제품 수정[이름, 가격]
	public void updateProductInfo() {
		System.out.println("----------------------------------제품 이름&가격 변경----------------------------------");
		System.out.print("제품 번호 : "); int no = scanner.nextInt();
		System.out.print("수정 제품 이름 : ");scanner.nextLine(); String name = scanner.nextLine();
		System.out.print("수정 제품 가격 : "); int price = scanner.nextInt();
		
		int result = PController.getInstance().updateProductInfo(no, name, price);
		
		if(result == -1) { // 없는 제품 번호
			System.out.println("없는 제품 번호입니다.");
		}else if(result == -2) {
			System.out.println("[DB에러] 해당 제품을 수정할 수 없습니다.");
		}else if(result == 0) {
			System.out.println(no + "번 제품의 정보[이름,가격]를 수정 완료하였습니다.");
		}
	}
	
	//4. 제품 재고 수정
	public void updateProductStock() {
		System.out.println("------------------------------------제품 재고 변경------------------------------------");
		System.out.print("제품 번호 : "); int no = scanner.nextInt();
		System.out.print("변경 제품 재고 : "); int stock = scanner.nextInt();
		
		int result = PController.getInstance().updateProductStock(no, stock);
		
		if(result == -1) { // 없는 제품 번호
			System.out.println("없는 제품 번호입니다.");
		}else if(result == -2) {
			System.out.println("[DB에러] 해당 제품의 재고를 변경할 수 없습니다.");
		}else if(result == 0) {
			System.out.println(no + "번 제품의 재고를 변경 완료하였습니다.");
		}
	}
	
	//5. 제품 삭제
	public void deleteProduct() {
		System.out.println("------------------------------------제품 삭제------------------------------------");
		System.out.print("삭제할 제품 번호 : "); int no = scanner.nextInt();
		
		int result = PController.getInstance().deleteProduct(no);
		
		if(result == -1) { // 없는 제품 번호
			System.out.println("없는 제품 번호입니다.");
		}else if(result == -2) {
			System.out.println("[DB에러] 해당 제품을 삭제할 수 없습니다.");
		}else if(result == 0) {
			System.out.println(no + "번 제품을 삭제하였습니다.");
		}
	}
}
