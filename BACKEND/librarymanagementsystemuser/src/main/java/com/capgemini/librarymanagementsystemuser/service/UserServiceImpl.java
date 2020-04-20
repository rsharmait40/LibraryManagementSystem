package com.capgemini.librarymanagementsystemuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystemuser.dao.UserDAO;
import com.capgemini.librarymanagementsystemuser.dto.BookInfo;
import com.capgemini.librarymanagementsystemuser.dto.Issue;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public List<BookInfo> searchBook(BookInfo bookInfo) {
		return dao.searchBook(bookInfo);
	}

	@Override
	public int requestBook(int bookId, String username) {
		return dao.requestBook(bookId, username);
	}

//	@Override
//	public Boolean requestBook(int bookId) {
//		return dao.requestBook(bookId);
//	}

//	@Override
//	public Issue requestBook(BookInfo book, int userId) {
//		return dao.requestBook(book, userId);
//	}
//
//	@Override
//	public boolean borrow(int userId, String bookName) {
//		return dao.borrow(userId, bookName);
//	}
//
//	@Override
//	public boolean book(BookInfo bookInfo) {
//		return dao.book(bookInfo);
//	}

}
