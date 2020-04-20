package com.capgemini.librarymanagementsystemuser.dao;

import com.capgemini.librarymanagementsystemuser.dto.Issue;

public interface AdminDAO {
	public Issue acceptRequest(int registerId, String username, int bookId);

}
