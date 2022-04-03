package product.management.controller;

import java.util.List;

import product.management.model.service.ProductService;
import product.management.model.vo.Product;
import product.management.model.vo.ProductIO;

public class ProductController {
	
	private ProductService productService = new ProductService();
	
	//mainMenu_1 
	public List<Product> selectAll() {
		List<Product> list = null;
		try {
			list = productService.selectAll();
		} catch(Exception e) {
			System.out.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return list;
	}

	//mainMenu_2_1
	public List<Product> selectById(String id) {
		List<Product> list = null;
		try {
			list = productService.selectById(id);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return list;
	}
	//mainMenu_2_2
	public List<Product> selectByName(String name) {
		List<Product> list = null;
		try {
			list = productService.selectByName(name);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return list;
	}
	
	//mainMenu_3
	public int insertProduct(Product product) {
		int result = 0;
		try {
			result = productService.insertProduct(product);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return result;
	}
	
	//mainMenu_4_DQL selelctOne by Id
	public Product selectOne(String id) {
		Product product = null;
		try {
			product = productService.selectOne(id);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return product;
	}
	
	//mainMenu_4_DML update Info
	public int updateProduct(String id, String colName, Object newValue) {
		int result = 0;
		try {
			result = productService.updateProduct(id, colName, newValue);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		
		return result;
	}

	//mainMenu_5_DML delete Info
	public int deleteProduct(String id) {
		int result = 0;
		try {
			result = productService.deleteProduct(id);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return result;
	}

	//mainMenu_6_DQL select All
	public List<ProductIO> ioSelectAll(String id) {
		List<ProductIO> ioList = null;
		try {
			ioList = productService.ioSelectAll(id);
		} catch(Exception e) {
			System.out.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return ioList;
	}

	//mainMenu_6_DML insert 입고
	public int insertIncoming(ProductIO productIo) {
		int result = 0;
		try {
			result = productService.insertIncoming(productIo);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return result;
	}

	//mainMenu_6_DML insert 출고
	public int insertOutgoing(ProductIO productIo) {
		int result = 0;
		try {
			result = productService.insertOutcoming(productIo);
		} catch (Exception e) {
			System.err.println("[" + e.getMessage() + "] 불편을 드려 죄송합니다. 관리자에게 문의해주세요.");
		}
		return result;
	}
	


}
