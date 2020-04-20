package com.capgemini.librarymanagementsystemadmin.service;

import java.util.Date;
import java.util.List;
import com.capgemini.librarymanagementsystemadmin.dto.BookInfo;
import com.capgemini.librarymanagementsystemadmin.dto.BookRegister;
import com.capgemini.librarymanagementsystemadmin.dto.Issue;
import com.capgemini.librarymanagementsystemadmin.dto.UserInfoBean;

public interface AdminService {

	public boolean addBook(int userId, BookInfo bean);

	public boolean addUser(UserInfoBean userInfoBean);

	public boolean deleteUser(int userId);

	public boolean deleteBook(int bookId);

	public boolean updateUser(UserInfoBean userInfoBean);

	public List<UserInfoBean> showAllUser();

	public List<UserInfoBean> getByUserId(int userId);

//	public Issue addFine(int issueId, Date returnDate);

	public UserInfoBean getUser(String userName);
	
	public List<BookRegister> requestView();

	public Issue acceptRequest(int registerId);

	public Boolean requestDeny(int registerId);


}
