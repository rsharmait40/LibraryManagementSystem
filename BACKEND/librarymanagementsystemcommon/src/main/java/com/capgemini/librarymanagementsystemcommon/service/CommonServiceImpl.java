package com.capgemini.librarymanagementsystemcommon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystemcommon.dao.CommonDAO;
import com.capgemini.librarymanagementsystemcommon.dto.BookInfo;
import com.capgemini.librarymanagementsystemcommon.dto.UserInfoBean;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDAO dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean register(UserInfoBean bean) {
		bean.setUserPassword(encoder.encode(bean.getUserPassword()));
		return dao.register(bean);
	}

	@Override
	public boolean changePassword(int userId, String userPassword) {
		return dao.changePassword(userId, userPassword);
	}

	@Override
	public boolean forgotPassword(int userId, String userPassword) {
		return dao.forgotPassword(userId, userPassword);
	}

	@Override
	public List<BookInfo> showAllBooks() {
		return dao.showAllBooks();
	}

	@Override
	public List<BookInfo> getByBookName(String name) {
		return dao.getByBookName(name);
	}

}
