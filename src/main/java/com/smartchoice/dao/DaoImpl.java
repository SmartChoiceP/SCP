package com.smartchoice.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.QualifierEntry;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.smartchoice.model.UploadFile;

import com.smartchoice.model.Admin;
import com.smartchoice.model.Customer;
import com.smartchoice.model.Employee;
import com.smartchoice.model.OrderList;
import com.smartchoice.model.Product_details;

@Component
public class DaoImpl implements Dao{

	@Autowired
	SessionFactory sf;
	
	@Override
	public void createAdmin(Admin ad) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(ad);
		tr.commit();
	}

	@Override
	public List<Admin> selectAll() {
		
		Session session=sf.openSession();
		Query query=session.createQuery("select a from Admin a");
		List alist=query.list();
		return alist;
	}

	@Override
	public Admin selectbyId(int id) {

		Session session=sf.openSession();
		Admin ad=session.get(Admin.class, id);
		session.beginTransaction().commit();
		return ad;
	}

	@Override
	public void deleteAdmin(int id) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Admin ad=selectbyId(id);
		session.delete(ad);
		tr.commit();
	}

	/*#################CUSTOMER#################
*/	@Override
	public List<Customer> selectAllCustomer() {
		Session session=sf.openSession();
		Query query=session.createQuery("select c from Customer c");
		List<Customer> clist=query.list();
		return clist;
	}

	@Override
	public void createCustomer(Customer c) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(c);
		tr.commit();		
	}

	@Override
	public Customer selectCustomerbyId(int id) {
		Session session=sf.openSession();
		Customer cbyid=session.get(Customer.class,id);
		return cbyid ;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Customer c=session.get(Customer.class,id);
		session.delete(c);
		tr.commit();
		
	}

	@Override
	public void updateCustomer(Customer c) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		session.update(c);
		tr.commit();
	}
/*########## Order ########*/
	@Override
	public void createOrder(OrderList o) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(o);
		tr.commit();
		
	}

	@Override
	public List<OrderList> getAllOrders() {
		Session session=sf.openSession();
		Query query=session.createQuery("select o from OrderList o");
		List qlist=query.list();
		return qlist;
	}

	@Override
	public OrderList selectOrderById(int id) {
		Session session=sf.openSession();
		OrderList obyid=session.get(OrderList.class,id);
		return obyid;
	}

	@Override
	public void deleteOrder(int id) {
		Session session=sf.openSession();
		OrderList order=session.get(OrderList.class,id);
		Transaction tr=session.beginTransaction();
		session.delete(order);
		tr.commit();
	}

	@Override
	public void updateOrder(OrderList order) {
		Session session=sf.openSession();
		session.update(order);
		Transaction tr=session.beginTransaction();
		tr.commit();
		
		
	}

	@Override
	public void createProductD(Product_details pro) {
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();
		session.save(pro);
		tr.commit();
	}

	@Override
	public Product_details selectProduct_Detail_byId(int id) {
		
		Session session=sf.openSession();
		Product_details pbyid=session.get(Product_details.class,id);
		return pbyid;
		
		
	}

	@Override
	public List<Product_details> selectAllProductD() {
		Session session=sf.openSession();
		Query query=session.createQuery("select p from Product_details p");
		List plist=query.list();
		return plist ;
	}

	@Override
	public void deleteProductDbyId(Product_details pbyid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(pbyid);
		tr.commit();
		
		
	}

	@Override
	public void updateProductD(Product_details p) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(p);
		tr.commit();
		
	}
	
	

	
	

	public DaoImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional
	public void save(UploadFile uploadFile) {
		sf.getCurrentSession().save(uploadFile);
		
	}
	

	@Transactional
	public void remove(long id) {
		Session session = sf.getCurrentSession();
		
		UploadFile document = (UploadFile)session.get(UploadFile.class, id);
		
		session.delete(document);
	}
	
	@Transactional
	public UploadFile get(long id) {
		Session session = sf.getCurrentSession();
		return (UploadFile)session.get(UploadFile.class, id);
	}

	@Transactional
    public List<UploadFile> getAllFileUpload() {
		
	Session session=sf.openSession();
	System.out.println("display");
	Criteria cr=session.createCriteria(UploadFile.class );
	Transaction tr = session.beginTransaction();
	List<UploadFile> list =cr.list();
	System.out.println("list====="+list);
	tr.commit();
	return list;
}
	 public UploadFile getfile(UploadFile ul) 
     {
	
		 Session session = sf.openSession();
    	 UploadFile f=session.get(UploadFile.class, ul.getId()); 
    	 return f;
    	 
     }

	@Override
	public void createProduct(UploadFile upProduct) {
			
		
		
	}
	

	@Override
	public void createEmp(Employee e) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(e);
		tr.commit();
		
	}

	@Override
	public List<Employee> selectAllEmployee() {
		Session session=sf.openSession();
		Query query=session.createQuery("select e from Employee e");
		List qlist=query.list();
		return qlist;
	}

	@Override
	public Employee select_emp_byId(int id) {
		Session session=sf.openSession();
		Employee e=session.get(Employee.class,id);
		return e;
	}

	@Override
	public void deleteEmp(int id) {
		Session session=sf.openSession();
		Employee e=session.get(Employee.class,id);
		Transaction tr=session.beginTransaction();
		session.delete(e);
		tr.commit();
	}

	@Override
	public void updateEmp(Employee e) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(e);
		tr.commit();
		
	}

}
