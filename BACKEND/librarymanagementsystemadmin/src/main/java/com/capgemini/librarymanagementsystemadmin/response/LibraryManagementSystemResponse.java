package com.capgemini.librarymanagementsystemadmin.response;

import java.util.List;
import com.capgemini.librarymanagementsystemadmin.dto.BookInfo;
import com.capgemini.librarymanagementsystemadmin.dto.BookRegister;
import com.capgemini.librarymanagementsystemadmin.dto.Issue;
import com.capgemini.librarymanagementsystemadmin.dto.UserInfoBean;
import lombok.Data;

@Data
public class LibraryManagementSystemResponse {
	private int statusCode;
	private String message;
	private String decription;
	private List<Issue> issue;
	private List<BookInfo> book;
	private List<UserInfoBean> users;
	private List<BookRegister> register;
	
}
