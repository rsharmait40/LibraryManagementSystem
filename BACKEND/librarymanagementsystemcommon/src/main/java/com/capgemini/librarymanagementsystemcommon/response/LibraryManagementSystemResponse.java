package com.capgemini.librarymanagementsystemcommon.response;

import java.util.List;

import com.capgemini.librarymanagementsystemcommon.dto.BookInfo;
import com.capgemini.librarymanagementsystemcommon.dto.BookRegister;
import com.capgemini.librarymanagementsystemcommon.dto.Issue;
import com.capgemini.librarymanagementsystemcommon.dto.UserInfoBean;

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
	
//	private int statusCode;
//	private String message;
//	private String decription;
//	private List<Issue> beans;
//	private List<BookInfo> book;
//	private List<UserInfoBean> users;

}
