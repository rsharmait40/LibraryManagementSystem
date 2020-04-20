package com.capgemini.librarymanagementsystemuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystemuser.dao.AdminDAO;
import com.capgemini.librarymanagementsystemuser.dto.Issue;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO dao;

	@Override
	public Issue acceptRequest(int registerId, String username, int bookId) {
		return dao.acceptRequest(registerId, username, bookId);
	}




}
