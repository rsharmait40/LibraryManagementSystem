package com.capgemini.librarymanagementsystemuser.service;

import java.util.List;
import com.capgemini.librarymanagementsystemuser.dto.BookInfo;

public interface UserService {

	public List<BookInfo> searchBook(BookInfo bookInfo);

	public int requestBook(int bookId, String username);

}
