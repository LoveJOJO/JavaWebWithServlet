package com.cjglib.javaweb.daoimlp;

import java.util.List;

import com.cjglib.javaweb.domain.CriteriaCustomer;
import com.cjglib.javaweb.domain.Customer;
import com.cjglib.javawebmvc.dao.CustomerDAO;
import com.cjglib.javawebmvc.dao.DAO;

public class CustomerDAOJdbcImlp extends DAO<Customer> implements CustomerDAO {

	@Override
	public List<Customer> getALL() {
		String sql = "SELECT id, name, address, phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
		
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
		
	}

	@Override
	public long getCountCustomer(String name) {
		String sql = "SELECT count(id) FROM customers WHERE name = ? ";
		return getForValue(sql, name);
	}

	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE + "
				+ "name LIKE ? AND address LIKE ? AND phone LIKE ?";
		return getForList(sql,cc.getName(),cc.getAddress(),cc.getPhone());
	}

}
