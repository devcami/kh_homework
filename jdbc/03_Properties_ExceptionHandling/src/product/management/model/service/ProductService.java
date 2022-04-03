package product.management.model.service;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.rollback;
import static common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import product.management.model.dao.ProductDao;
import product.management.model.vo.Product;
import product.management.model.vo.ProductIO;

public class ProductService {
	
	private ProductDao productDao = new ProductDao();
	
	//mainMenu_1 DQL
	public List<Product> selectAll() {
		Connection conn = getConnection();
		List<Product> list = productDao.selectAll(conn);
		close(conn);
		return list;
	}
	
	//mainMenu_2_1 DQL
	public List<Product> selectById(String id) {
		Connection conn = getConnection();
		List<Product> list = productDao.selectById(conn, id);
		close(conn);
		return list;
	}
	//mainMenu_2_2 DQL
	public List<Product> selectByName(String name) {
		Connection conn = getConnection();
		List<Product> list = productDao.selectByName(conn, name);
		close(conn);
		return list;
	}
	
	//mainMenu_3 DML(예외처리)
	public int insertProduct(Product product) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = productDao.insertProduct(conn, product);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	//mainMenu_4_DQL selectOne by Id 
	public Product selectOne(String id) {
		Connection conn = getConnection();
		Product product = productDao.selectOne(conn, id);
		close(conn);
		return product;
	}
	
	//mainMenu_4_DML
	public int updateProduct(String id, String colName, Object newValue) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = productDao.updateProduct(conn, id, colName, newValue);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	//mainMenu_5_DML
	public int deleteProduct(String id) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = productDao.deleteProduct(conn, id);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		
		return result;
	}

	//mainMenu_6_DQL
	public List<ProductIO> ioSelectAll(String id) {
		Connection conn = getConnection();
		List<ProductIO> ioList = productDao.ioSelectAll(conn, id);
		close(conn);
		return ioList;
	}
	
	//mainMenu_6_DML 입고
	public int insertIncoming(ProductIO productIo) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = productDao.insertIncoming(conn, productIo);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	//mainMenu_6_DML 출고
	public int insertOutcoming(ProductIO productIo) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = productDao.insertOutgoing(conn, productIo);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}


}
