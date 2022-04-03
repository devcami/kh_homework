package product.management.model.dao;

import static common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import product.management.model.exception.ProductException;
import product.management.model.vo.Product;
import product.management.model.vo.ProductIO;

public class ProductDao {
	
	Properties prop = new Properties();
	public ProductDao() {
		try {
			prop.load(new FileReader("resources/product-query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//mainManu_1 
	public List<Product> selectAll(Connection conn) {
		List<Product> list = new ArrayList<>();
		String sql = prop.getProperty("selectAll");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product();
				product.setId(rset.getString("id"));
				product.setBrand(rset.getString("brand"));
				product.setName(rset.getString("name"));
				product.setPrice(rset.getInt("price"));
				product.setMonitorSize(rset.getInt("monitor_size"));
				product.setOs(rset.getString("os"));
				product.setStorage(rset.getInt("storage"));
				product.setRegDate(rset.getDate("reg_date"));
				product.setStock(rset.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			throw new ProductException("! 전체 상품 조회 오류 !", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//mainMenu_2_1
	public List<Product> selectById(Connection conn, String id) {
		List<Product> list = new ArrayList<>();
		String sql = prop.getProperty("selectById");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + id + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product product = new Product();
				product.setId(rset.getString("id"));
				product.setBrand(rset.getString("brand"));
				product.setName(rset.getString("name"));
				product.setPrice(rset.getInt("price"));
				product.setMonitorSize(rset.getInt("monitor_size"));
				product.setOs(rset.getString("os"));
				product.setStorage(rset.getInt("storage"));
				product.setRegDate(rset.getDate("reg_date"));
				product.setStock(rset.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			throw new ProductException("! 아이디 검색 상품 조회 오류 !", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	//mainMenu_2_2
	public List<Product> selectByName(Connection conn, String name) {
		List<Product> list = new ArrayList<>();
		String sql = prop.getProperty("selectByName");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product product = new Product();
				product.setId(rset.getString("id"));
				product.setBrand(rset.getString("brand"));
				product.setName(rset.getString("name"));
				product.setPrice(rset.getInt("price"));
				product.setMonitorSize(rset.getInt("monitor_size"));
				product.setOs(rset.getString("os"));
				product.setStorage(rset.getInt("storage"));
				product.setRegDate(rset.getDate("reg_date"));
				product.setStock(rset.getInt("stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			throw new ProductException("! 이름 검색 상품 조회 오류 !", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//mainMenu_3
	public int insertProduct(Connection conn, Product product) {
		String sql = prop.getProperty("insertProduct");
		int result = 0;
		int resultStock = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getBrand());
			pstmt.setString(3, product.getName());
			pstmt.setInt(4, product.getPrice());
			pstmt.setInt(5, product.getMonitorSize());
			pstmt.setString(6, product.getOs());
			pstmt.setInt(7, product.getStorage());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ProductException("! 신규 상품 등록 오류 !", e);
		} try {
			sql = prop.getProperty("insertProduct_stock");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			resultStock = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//mainMenu_4_DQL selectOne by Id
	public Product selectOne(Connection conn, String id) {
		String sql = prop.getProperty("selectOne");
		Product product = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				id = rset.getString("id");
				String brand = rset.getString("brand");
				String name = rset.getString("name");
				int price = rset.getInt("price");
				int monitorSize = rset.getInt("monitor_size");
				String os = rset.getString("os");
				int storage = rset.getInt("storage");
				Date regDate = rset.getDate("reg_date");
				product = new Product(id, brand, name, price, monitorSize, os, storage, regDate);
			}
		} catch (SQLException e) {
			throw new ProductException("! 상품 아이디 검색 오류 !", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return product;
	}
	
	//mainMenu_4_DML updateInfo
	public int updateProduct(Connection conn, String id, String colName, Object newValue) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = prop.getProperty("updateProduct");
			sql = sql.replace("#", colName);
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, newValue);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ProductException("! 상품 정보 수정 오류 !", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	//mainMenu_5_DML deleteInfo
	public int deleteProduct(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = prop.getProperty("deleteProduct");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ProductException("! 상품 정보 수정 오류 !", e);
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//mainMenu_6_DQL selectAll
	public List<ProductIO> ioSelectAll(Connection conn, String id) {
		List<ProductIO> ioList = new ArrayList<>();
		String sql = prop.getProperty("ioSelectAll");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductIO productIo = new ProductIO();
				productIo.setNo(rset.getInt("no"));
				productIo.setId(id);
				productIo.setName(rset.getString("name"));
				productIo.setBrand(rset.getString("brand"));
				productIo.setCount(rset.getInt("count"));
				productIo.setStatus(rset.getString("status"));
				productIo.setIoDatetime(rset.getTimestamp("io_datetime"));
				ioList.add(productIo);
			}
		} catch (SQLException e) {
			throw new ProductException("! 상품 입출고 내역 조회 오류 !", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ioList;

	}

	//mainMenu_6_DML insert 입고처리
	public int insertIncoming(Connection conn, ProductIO productIo) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = prop.getProperty("insertIncoming");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productIo.getId());
			pstmt.setInt(2, productIo.getCount());
			pstmt.setString(3, productIo.getStatus());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ProductException("! 상품 정보 수정 오류 !", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	//mainMenu_6_DML insert 출고처리
	public int insertOutgoing(Connection conn, ProductIO productIo) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = prop.getProperty("insertIncoming");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productIo.getId());
			pstmt.setInt(2, productIo.getCount());
			pstmt.setString(3, productIo.getStatus());
			result = pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new ProductException("! 현재 재고보다 많은 수량을 출고할 수 없습니다 !", e2);
		} catch (SQLException e) {
			throw new ProductException("! 상품 정보 수정 오류 !", e);
		} finally {
			close(pstmt);
		}
		return result;
	}


	

}
