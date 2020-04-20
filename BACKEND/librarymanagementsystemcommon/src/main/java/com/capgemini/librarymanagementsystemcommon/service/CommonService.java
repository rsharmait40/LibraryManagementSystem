package com.capgemini.librarymanagementsystemcommon.service;

import java.util.List;
import com.capgemini.librarymanagementsystemcommon.dto.BookInfo;
import com.capgemini.librarymanagementsystemcommon.dto.UserInfoBean;

public interface CommonService {

	public boolean register(UserInfoBean bean);

	public boolean changePassword(int userId, String userPassword);

	public boolean forgotPassword(int userId, String userPassword);

	public List<BookInfo> showAllBooks();

	public List<BookInfo> getByBookName(String name);

}
