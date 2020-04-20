package com.capgemini.librarymanagementsystemadmin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.librarymanagementsystemadmin.dao.AdminDAO;
import com.capgemini.librarymanagementsystemadmin.dto.BookInfo;
import com.capgemini.librarymanagementsystemadmin.dto.UserInfoBean;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrarymanagementsystemadminApplicationTests {

	@Autowired
	private AdminDAO dao;

	@Test
	public void addBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookAuthor("rahul");
		bookInfo.setNoOfBooks(45);
		bookInfo.setPublisher("capgemini");
		bookInfo.setUserId(1);
		TestCase.assertTrue(dao.addBook(1, bookInfo));
	}

	@Test
	public void addUser() {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setName("kanimozhi");
		userInfoBean.setUsername("kaniii123@gmail.com");
		userInfoBean.setUserPassword("krishna@123");
		userInfoBean.setRole("ROLE_ADMIN");
		TestCase.assertTrue(dao.addUser(userInfoBean));
	}

	@Test
	void testDeleteBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookId(25);
		TestCase.assertTrue(dao.deleteBook(bookInfo.getBookId()));
	}

	@Test
	void testDeleteUser() {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUserId(20);
		TestCase.assertTrue(dao.deleteUser(userInfoBean.getUserId()));

	}

	@Test
	void testShowAllUsers() {
		List<UserInfoBean> allUsers = dao.showAllUser();
		assertNotNull(allUsers);
	}

	@Test
	void testUpdateUser() {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUserId(27);
		userInfoBean.setName("James");
		userInfoBean.setUsername("abhi@gmail.com");
		userInfoBean.setUserPassword("Abhi@1234");
		try {
			boolean expectedFlag = dao.updateUser(userInfoBean);
			assertEquals(expectedFlag, userInfoBean);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
