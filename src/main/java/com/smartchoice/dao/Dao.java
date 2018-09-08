package com.smartchoice.dao;

import java.util.List;

import com.smartchoice.model.Admin;
import com.smartchoice.model.Customer;
import com.smartchoice.model.Employee;
import com.smartchoice.model.OrderList;
import com.smartchoice.model.Product_details;
import com.smartchoice.model.UploadFile;

public interface Dao {

	
	/******Admin Model Methods********/
	public void createAdmin(Admin ad);
	
	public List<Admin> selectAll();
	
	public Admin selectbyId(int id);
	
	public void deleteAdmin(int id);

	
	/***************Employee Model Methods*************/
	
	public void createEmp(Employee e);
	
	public List<Employee> selectAllEmployee();
	
	public Employee select_emp_byId(int id);

	public void deleteEmp(int id);

	public void updateEmp(Employee e);
	
	/******Customer Model Methods******/
	public List<Customer> selectAllCustomer();

	public void createCustomer(Customer c);

	public Customer selectCustomerbyId(int id);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer c);

	
	/******Order Model Methods******/
	public void createOrder(OrderList o);

	public List<OrderList> getAllOrders();

	public OrderList selectOrderById(int id);

	public void deleteOrder(int id);

	public void updateOrder(OrderList order);

	public void createProductD(Product_details pro);

	public Product_details selectProduct_Detail_byId(int id);

	public List<Product_details> selectAllProductD();

	public void deleteProductDbyId(Product_details pbyid);

	public void updateProductD(Product_details p);
	
/*############# File Updoad ###########################
*/	
	void save(UploadFile uploadFile);

	void remove(long documentId);

	List<UploadFile> getAllFileUpload();

	UploadFile getfile(UploadFile f);

	public void createProduct(UploadFile upProduct);
}
