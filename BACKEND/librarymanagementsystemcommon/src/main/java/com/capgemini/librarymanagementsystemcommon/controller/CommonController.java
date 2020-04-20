package com.capgemini.librarymanagementsystemcommon.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.librarymanagementsystemcommon.dto.BookInfo;
import com.capgemini.librarymanagementsystemcommon.dto.UserInfoBean;
import com.capgemini.librarymanagementsystemcommon.response.LibraryManagementSystemResponse;
import com.capgemini.librarymanagementsystemcommon.service.CommonService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
// @RequestMapping("/common")
public class CommonController {
	@Autowired
	private CommonService service;


	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse changePassword(@RequestBody UserInfoBean userInfoBean) {
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (service.changePassword(userInfoBean.getUserId(), userInfoBean.getUserPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDecription("New Password Updated");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDecription("New Password not Updated");
		}
		return response;

	}
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse register(@RequestBody UserInfoBean bean) {
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDecription("Registration Successful");
			response.setUsers(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDecription("Registration Unsuccessful");
		}
		return response;
	}

	@PutMapping(path = "/forgot-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse forgotPassword(@RequestBody UserInfoBean user) {

		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (service.forgotPassword(user.getUserId(), user.getUserPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDecription("Password is changed successfully");
			response.setUsers(Arrays.asList(user));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDecription("Failed to change the password");
		}
		return response;
	}

	@GetMapping(path = "/getallBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getallBooks() {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		List<BookInfo> book = service.showAllBooks();
		if (book != null) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Books Found in DB");
			resp.setBook(book);
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Books not found");
		}
		return resp;
	}

	@GetMapping(path = "/getbyname/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getByName(@PathVariable("bookName") String bookName) {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		List<BookInfo> bean = service.getByBookName(bookName);
		if (bean != null) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Book present with the given name");
			resp.setBook(bean);
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Book not present with the given name");
		}
		return resp;
	}

}
