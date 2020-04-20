package com.capgemini.librarymanagementsystemuser.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.librarymanagementsystemuser.dto.BookInfo;
import com.capgemini.librarymanagementsystemuser.dto.BookRegister;
import com.capgemini.librarymanagementsystemuser.dto.UserInfoBean;
import lombok.extern.java.Log;

@Log
@Repository
public class UserDAOImpl implements UserDAO {

	public static int regId = 0;

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		List<BookInfo> bookInfos = null;
		try {
			EntityManager entityManager = factory.createEntityManager();
			TypedQuery<BookInfo> typedQuery = entityManager.createQuery("FROM BookInfo where bookName = :bookName",
					BookInfo.class);
			typedQuery.setParameter("bookName", bookInfo.getBookName());
			bookInfos = typedQuery.getResultList();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return bookInfos;
	}

	@Override
	public int requestBook(int bookId, String userName) {
		EntityManager entityManager = factory.createEntityManager();
		BookRegister bookRegister = new BookRegister();
		TypedQuery<UserInfoBean> query = entityManager.createQuery("from UserInfoBean  where username =: userName",
				UserInfoBean.class);
		query.setParameter("userName", userName);
		bookRegister.setUserId(query.getSingleResult().getUserId());
		bookRegister.setBookId(bookId);
		bookRegister.setRegisterDate(new Date());
		Random random = new Random();
		bookRegister.setRegisterId(random.nextInt(5000));
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(bookRegister);
			entityManager.getTransaction().commit();
			regId = bookRegister.getRegisterId();
			System.err.println("registerId" + regId);
			entityManager.close();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return bookRegister.getRegisterId();
	}

}
