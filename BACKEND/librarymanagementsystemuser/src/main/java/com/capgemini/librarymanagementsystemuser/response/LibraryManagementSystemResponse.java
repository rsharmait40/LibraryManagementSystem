package com.capgemini.librarymanagementsystemuser.response;

import java.util.List;

import com.capgemini.librarymanagementsystemuser.dto.BookInfo;
import com.capgemini.librarymanagementsystemuser.dto.BookRegister;
import com.capgemini.librarymanagementsystemuser.dto.Issue;
import com.capgemini.librarymanagementsystemuser.dto.UserInfoBean;

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
