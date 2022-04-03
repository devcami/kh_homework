package product.management.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import product.management.controller.ProductController;
import product.management.model.vo.Product;
import product.management.model.vo.ProductIO;

public class ProductMenu {
	
	private Scanner sc = new Scanner(System.in);
	private ProductController productController = new ProductController();
	public void mainMenu() {
		String menu = "******* 상품 재고관리 프로그램 *******\n"
					+ "\t1. 전체상품조회\n"
					+ "\t2. 상품검색\n"
					+ "\t3. 상품등록\n"
					+ "\t4. 상품정보변경\n"
					+ "\t5. 상품삭제\n"
					+ "\t6. 상품입/출고 메뉴\n"
					+ "\t0. 프로그램종료\n"
					+ "********************************\n"
					+ "\t>> 선택 : ";
		while(true) {
			
			System.out.print(menu);
			String choice = sc.next();
			List<Product> list = null;
			Product product = null;
			int result = 0; 
			String id = null;
			
			switch (choice) {
			case "1":
				list = productController.selectAll();
				printProductList(list);
				break;
			case "2":
				searchMenu();
				break;
			case "3":
				product = inputProduct();
				result = productController.insertProduct(product);
				printResultMsg(result, "상품 등록 성공 !", "상품 등록 실패 !");
				break;
			case "4":
				updateMenu();
				break;
			case "5":
				System.out.println(">> 상품 정보 삭제를 선택하셨습니다.");
				id = inputProductId();
				result = productController.deleteProduct(id);
				printResultMsg(result, "상품 삭제 성공 !", "상품 삭제 실패");
				break;
			case "6":
				ioMenu();
				break;

			case "0": return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	/**
	 * 삭제, 수정, 입고를 위한 id입력
	 * return id
	 */
	private String inputProductId() {
		System.out.println(">> 정확한 상품 id를 입력해주세요");
		System.out.print("아이디 : ");
		return sc.next();
	}

	/**
	 * mainMenu_6 
	 * 상품 입출고 메뉴
	 */
	private void ioMenu() {
		String menu = "********* 상품 입출고 메뉴 *********\n"
					+ "\t1. 입출고 내역 조회\n"
					+ "\t2. 상품입고\n"
					+ "\t3. 상품출고\n"
					+ "\t0. 메인메뉴로 돌아가기\n"
					+ "********************************\n"
					+ "\t>> 선택 : ";
		
		
		List<ProductIO> ioList = null;
		ProductIO productIo = null;
		int result = 0;
		String id = null;
		
		while(true) {
			
			System.out.print(menu);
			String choice = sc.next();
			
			switch (choice) {
			case "1":
				id = printAllandInputId();
				ioList = productController.ioSelectAll(id);
				printIoList(ioList);
				break;
			case "2":
				id = printAllandInputId();
				productIo = incomingProduct(id);
				result = productController.insertIncoming(productIo);
				printResultMsg(result, "입고 처리 성공 !", "입고 처리 실패 !");
				break;
			case "3":
				id = printAllandInputId();
				productIo = outgoingProduct(id);
				result = productController.insertOutgoing(productIo);
				printResultMsg(result, "출고 처리 성공 !", "출고 처리 실패 !");
				break;
				
			case "0": return;
			default: System.out.println("잘못 입력하셨습니다."); continue;
			}
			
		}
	}
	
	private String printAllandInputId() {
		while(true) {
			List<Product> list = productController.selectAll();
			printProductList(list);
			
			System.out.println(">> 관리를 원하는 상품의 아이디를 입력하세요.");
			
			String id = inputProductId();
			Product product = productController.selectOne(id);
			if(product == null) {
				System.out.println(">> 조회된 회원이 없습니다.");
				continue;
			} else return id;
		}
		
	}

	/**
	 * mainMenu_6_DML insert
	 * 특정 상품 출고처리
	 */
	private ProductIO outgoingProduct(String id) {
		ProductIO productIo = new ProductIO();
		productIo.setId(id);
		productIo.setStatus("O");
		System.out.print(">> 출고 수량을 입력하세요 : ");
		productIo.setCount(sc.nextInt());
		return productIo;
	}

	/**
	 * mainMenu_6_DML insert
	 * 특정 상품 입고처리
	 */
	private ProductIO incomingProduct(String id) {
		ProductIO productIo = new ProductIO();
		productIo.setId(id);
		productIo.setStatus("I");
		System.out.print(">> 입고 수량을 입력하세요 : ");
		productIo.setCount(sc.nextInt());
		return productIo;
	}

	/**
	 * mainMenu_6
	 * 특정 상품의 입출고 내역 출력
	 */
	private void printIoList(List<ProductIO> ioList) {
		if(ioList == null || ioList.isEmpty()) {
			System.err.println(">> 조회된 상품의 입출고 내역이 없습니다.");
		}
		else{
			System.out.println(">> 선택 상품 입출고 조회 결과");
			System.out.println("-------------------------------------------------"
							 + "---------------------------------------------------");
			System.out.printf("%s%12s%15s(%s)%10s%15s%20s%n","no","id","name","brand","count","status","ioDateTime");
			System.out.println("-------------------------------------------------"
							 + "---------------------------------------------------");
			for(ProductIO productIo : ioList) {
				System.out.printf("%s%12s%15s(%s)%10s%15s%35s%n",
						productIo.getNo(),
						productIo.getId(),
						productIo.getName(),
						productIo.getBrand(),
						productIo.getCount(),
						productIo.getStatus(),
						productIo.getIoDatetime()
						);
			}
			System.out.println("-------------------------------------------------"
					+ "---------------------------------------------------");
			System.out.println();
		}
	}

	/**
	 * mainMenu_4
	 * 상품 정보 변경 메뉴
	 */
	private void updateMenu() {
		String menu = "******** 상품정보 변경 메뉴 ********\n"
					+ "\t1. 상품명변경\n"
					+ "\t2. 가격변경\n"
					+ "\t3. 사양변경\n"
					+ "\t0. 메인메뉴로 돌아가기\n"
					+ "********************************\n"
					+ "\t>> 선택 : ";
		System.out.println(">> 상품 정보 수정을 선택하셨습니다.");
		String id = inputProductId();
		
		outer:
		while(true) {
			Product product = productController.selectOne(id);
			
			if(product == null) {
				System.out.println(">> 조회된 회원이 없습니다.");
				return;
			}
			else printProduct(product);
			
			
			System.out.print(menu);
			String choice = sc.next();
			String colName = null;
			Object newValue = null;
			
			switch (choice) {
			case "1":
				System.out.print(">> 변경할 상품명 입력 : ");
				colName = "name";
				newValue = sc.next();
				break;
			case "2":
				System.out.print(">> 변경할 가격 입력 : ");
				colName = "price";
				newValue = sc.nextInt();
				break;
			case "3":
				
				inner :
				while(true) {
					System.out.println(">> 어떤 사양을 변경하시겠습니까 ?");
					System.out.println("---------------------------------------------------------");
					System.out.println("1. 모니터 사이즈\t2. 운영체제\t3. 저장공간\t0.뒤로가기");
					System.out.println("---------------------------------------------------------");
					System.out.println("선택 : ");
					String spec = sc.next();
					
					switch(spec) {
					case "1" :
						System.out.print(">> 변경할 모니터사이즈 입력 : ");
						colName = "monitor_size";
						newValue = sc.nextInt();
						break inner;
					case "2" :
						System.out.print(">> 변경할 운영체제 입력 : ");
						colName = "os";
						newValue = sc.next();
						break inner;
					case "3" :
						System.out.print(">> 변경할 저장공간 입력 : ");
						colName = "storage";
						newValue = sc.nextInt();
						break inner;
					case "0" : break inner;
					default: System.out.println("잘못 입력하셨습니다."); continue inner;
					}
				}
				
				break;
			case "0": return;
			default: System.out.println("잘못 입력하셨습니다."); continue outer;
				
			}
			int result = productController.updateProduct(product.getId(), colName, newValue);
			printResultMsg(result, "상품 정보 변경 성공 !", "상품 정보 변경 실패 !");
		}
	}

	/**
	 * mainMenu_4
	 * id로 검색해 1개 정보 출력
	 */
	private void printProduct(Product product) {
		System.out.println("==========================================");
		System.out.printf("id : %s%n", product.getId());
		System.out.printf("brand : %s%n", product.getBrand());
		System.out.printf("name : %s%n", product.getName());
		System.out.printf("price : %s%n", product.getPrice());
		System.out.printf("monitorSize : %s%n", product.getMonitorSize());
		System.out.printf("os : %s%n", product.getOs());
		System.out.printf("storage : %s%n", product.getStorage());
		System.out.printf("regDate : %s%n", product.getRegDate());
		System.out.println("------------------------------------------");
		System.out.println();
	}

	/**
	 * mainMenu_3
	 * 상품 디테일 정보 입력 
	 */
	private Product inputProduct() {
		Product product = new Product();
		System.out.println(">> 신규 상품 정보를 입력하세요.");
		System.out.print("아이디 : ");
		product.setId(sc.next());
		System.out.print("브랜드 : ");
		product.setBrand(sc.next());
		System.out.print("상품명 : ");
		sc.nextLine();
		product.setName(sc.nextLine());
		System.out.print("가격 : ");
		product.setPrice(sc.nextInt());
		System.out.print("모니터 사이즈 : ");
		product.setMonitorSize(sc.nextInt());
		System.out.print("운영체제 : ");
		product.setOs(sc.next());
		System.out.print("저장공간 : ");
		product.setStorage(sc.nextInt());
		
		return product;
	}

	/**
	 * mainMenu_2
	 * 상품 정보 검색 (아이디로 / 상품평으로) 
	 * 검색된 n개의 상품 리스트 출력
	 */
	public void searchMenu() {
		
		String menu = "********** 상품검색 메뉴 **********\n"
					+ "\t1. 아이디 검색\n"
					+ "\t2. 상품명 검색\n"
					+ "\t0. 전메뉴로 돌아가기\n"
					+ "********************************\n"
					+ "\t>> 선택 : ";
		
		List<Product> list = null;
		
		while(true) {
			System.out.print(menu);
			String choice = sc.next();
			
			switch (choice) {
			case "1":
				System.out.print(">> 아이디 입력 : ");
				String id = sc.next();
				list = productController.selectById(id);
				printProductList(list);
				break;
			case "2":
				System.out.print(">> 상품명 입력 : ");
				String name = sc.next();
				list = productController.selectByName(name);
				printProductList(list);
				break;
				
			case "0" : return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}
	
	/**
	 * mainMenu_1
	 * 전체 상품 리스트 출력 메소드
	 * @param list
	 */
	private void printProductList(List<Product> list) {
		DecimalFormat df = new DecimalFormat("###,###원");
		if(list == null || list.isEmpty()) {
			System.err.println(">> 조회된 상품이 없습니다.");
		}
		else{
			System.out.println(">> 전체 상품 조회 결과");
			System.out.println("---------------------------------------------------------"
							 + "-------------------------------------------------------");
			System.out.printf("%10s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t\t%s%n","id","brand","name","price","spec","stock");
			System.out.println("---------------------------------------------------------"
							 + "-------------------------------------------------------");
			for(Product product : list) {
				System.out.printf("%15s\t\t%s\t\t%s\t\t%s\t%s\t  %s%n",
						product.getId(),
						product.getBrand(),
						product.getName(),
						df.format(product.getPrice()),
						product.getMonitorSize() + "인치 / " + product.getOs() + " / " + product.getStorage() + "GB" ,
						product.getStock()
						);
			}
			System.out.println("-----------------------------------------------------"
					+ "-----------------------------------------------------------");
			System.out.println();
		}
	}
	
	/*
	 * DML처리 결과 출력 메소드
	 */
	private void printResultMsg(int result, String successMsg, String failureMsg) {
		if(result > 0)
			System.out.println(">> " + successMsg);
		else
			System.out.println(">> " + failureMsg);
		System.out.println();
			
	}
}
