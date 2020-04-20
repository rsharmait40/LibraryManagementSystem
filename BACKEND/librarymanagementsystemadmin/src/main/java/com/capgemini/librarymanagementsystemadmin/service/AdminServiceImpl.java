package com.capgemini.librarymanagementsystemadmin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystemadmin.dao.AdminDAO;
import com.capgemini.librarymanagementsystemadmin.dto.BookInfo;
import com.capgemini.librarymanagementsystemadmin.dto.BookRegister;
import com.capgemini.librarymanagementsystemadmin.dto.Issue;
import com.capgemini.librarymanagementsystemadmin.dto.UserInfoBean;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;

	@Override
	public boolean addUser(UserInfoBean userInfoBean) {
		return dao.addUser(userInfoBean);
	}

	@Override
	public boolean deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public boolean updateUser(UserInfoBean userInfoBean) {
		return dao.updateUser(userInfoBean);
	}

	@Override
	public List<UserInfoBean> showAllUser() {
		return dao.showAllUser();
	}

	@Override
	public List<UserInfoBean> getByUserId(int userId) {
		return dao.getByUserId(userId);
	}

//	@Override
//	public Issue addFine(int issueId, Date returnDate) {
//		return dao.addFine(issueId, returnDate);
//	}
	//
	// @Override
	// public Issue acceptRequest(int issueId) {
	// return dao.acceptRequest(issueId);
	// }

	@Override
	public UserInfoBean getUser(String userName) {
		return dao.getUser(userName);
	}

	@Override
	public boolean addBook(int userId, BookInfo bean) {
		return dao.addBook(userId, bean);
	}

	@Override
	public List<BookRegister> requestView() {
		return dao.requestView();
	}

	@Override
	public Issue acceptRequest(int registerId) {
		return dao.acceptRequest(registerId);
	}

	@Override
	public Boolean requestDeny(int registerId) {
		return dao.requestDeny(registerId);
	}

}
