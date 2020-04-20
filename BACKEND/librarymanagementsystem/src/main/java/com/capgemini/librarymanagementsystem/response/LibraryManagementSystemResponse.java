package com.capgemini.librarymanagementsystem.response;

import java.util.List;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.Issue;
import com.capgemini.librarymanagementsystem.dto.UserInfoBean;
import com.capgemini.librarymanagementsystemadmin.dto.BookRegister;
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
