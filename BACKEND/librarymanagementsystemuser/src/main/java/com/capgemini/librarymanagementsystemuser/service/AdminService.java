package com.capgemini.librarymanagementsystemuser.service;

import com.capgemini.librarymanagementsystemuser.dto.Issue;

public interface AdminService {
	public Issue acceptRequest(int registerId, String username, int bookId);

}
