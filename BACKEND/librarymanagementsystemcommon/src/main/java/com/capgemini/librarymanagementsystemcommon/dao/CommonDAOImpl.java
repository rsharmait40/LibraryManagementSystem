package com.capgemini.librarymanagementsystemcommon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystemcommon.dto.BookInfo;
import com.capgemini.librarymanagementsystemcommon.dto.UserInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class CommonDAOImpl implements CommonDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public List<BookInfo> showAllBooks() {
		String jpql = "select b from BookInfo b";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<BookInfo> query = manager.createQuery(jpql, BookInfo.class);
		return query.getResultList();
	}

	@Override
	public boolean register(UserInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			System.out.println(bean.getUserPassword());
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BookInfo> getByBookName(String bookName) {
		String jpql = "select b from BookInfo b where b.bookName=:bookName";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<BookInfo> query = manager.createQuery(jpql, BookInfo.class);
		query.setParameter("bookName", bookName);
		return query.getResultList();
	}

	@Override
	public boolean changePassword(int userId, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserInfoBean bean = manager.find(UserInfoBean.class, userId);
		bean.setUserPassword(encoder.encode(password));
		manager.persist(bean);
		transaction.commit();
		return true;
	}

	@Override
	public boolean forgotPassword(int userId, String userPassword) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserInfoBean bean = manager.find(UserInfoBean.class, userId);
		bean.setUserPassword(encoder.encode(userPassword));
		manager.persist(bean);
		transaction.commit();
		return true;
	}


}
