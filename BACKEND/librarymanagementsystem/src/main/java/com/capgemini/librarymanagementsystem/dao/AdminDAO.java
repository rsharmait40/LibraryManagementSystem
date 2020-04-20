package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.UserInfoBean;
import com.capgemini.librarymanagementsystemadmin.dto.BookInfo;
import com.capgemini.librarymanagementsystemadmin.dto.BookRegister;
import com.capgemini.librarymanagementsystemadmin.dto.Issue;

public interface AdminDAO {

	public UserInfoBean getUser(String userName);
	
	public boolean addBook(int userId, BookInfo bookInfo);

	public boolean addUser(UserInfoBean userInfoBean);

	public boolean deleteUser(int userId);

	public boolean deleteBook(int bookId);

	public boolean updateUser(UserInfoBean userInfoBean);

	public List<UserInfoBean> showAllUser();

	public List<UserInfoBean> getByUserId(int userId);

//	public Issue addFine(int issueId, Date returnDate);

	public List<BookRegister> requestView();

	public Issue acceptRequest(int registerId);

	public Boolean requestDeny(int registerId);


}
