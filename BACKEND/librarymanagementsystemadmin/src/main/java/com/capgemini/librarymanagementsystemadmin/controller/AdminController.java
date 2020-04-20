package com.capgemini.librarymanagementsystemadmin.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystemadmin.dto.BookInfo;
import com.capgemini.librarymanagementsystemadmin.dto.BookRegister;
import com.capgemini.librarymanagementsystemadmin.dto.Issue;
import com.capgemini.librarymanagementsystemadmin.dto.UserInfoBean;
import com.capgemini.librarymanagementsystemadmin.response.LibraryManagementSystemResponse;
import com.capgemini.librarymanagementsystemadmin.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
// @RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping(path = "/addBook/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse addBook(@PathVariable("userId") int userId,
			@RequestBody BookInfo bookInfo) {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		if (service.addBook(userId, bookInfo)) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Book added successfully into DB");
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Inserting book has failed");
		}
		return resp;
	}

	@PostMapping(path = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse addUser(@RequestBody UserInfoBean userInfoBean) {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		if (service.addUser(userInfoBean)) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("User added successfully into DB");
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Inserting user has failed");
		}
		return resp;
	}

	@DeleteMapping(path = "/deleteBook/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse deleteBookById(@PathVariable("bookId") int bookId) {
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (service.deleteBook(bookId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDecription("Deleted for the requested book Id");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDecription("Book Id not found");
		}
		return response;

	}

	@DeleteMapping(path = "/deleteUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse deleteUserById(@PathVariable("userId") int userId) {
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (service.deleteUser(userId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDecription("Deleted for the requested user Id");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDecription("User Id not found");
		}
		return response;

	}

	@PostMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse update(@RequestBody UserInfoBean userInfoBean) {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		if (service.updateUser(userInfoBean)) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Updation Successful");
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Updation Unsuccessful");
		}
		return resp;
	}

	@GetMapping(path = "/getallUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getallUsers() {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		List<UserInfoBean> users = service.showAllUser();
		if (users != null) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Users Found in DB");
			resp.setUsers(users);
			;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Users not found");
		}
		return resp;
	}

	@GetMapping(path = "/getbyId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getById(@PathVariable("userId") int userId) {
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		List<UserInfoBean> bean = service.getByUserId(userId);
		if (bean != null) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("User present");
			resp.setUsers(bean);
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("User not present");
		}
		return resp;
	}

//	@PostMapping("/addFine")
//	public Issue addFine(@RequestBody int issueId, Date returnDate, ModelMap map) {
//		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
//		Issue fine = service.addFine(issueId, returnDate);
//		if (fine != null) {
//			response.setStatusCode(201);
//			response.setMessage("success");
//		} else {
//			response.setStatusCode(404);
//			response.setMessage("failed");
//		}
//		return fine;
//
//	}
	
	@GetMapping(path = "/acceptRequest/{userId}")
	public LibraryManagementSystemResponse acceptRequest(@PathVariable("userId") int registerId){
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		Issue issues = service.acceptRequest(registerId);
		if (issues != null) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Request present");
			resp.setIssue(Arrays.asList(issues));
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Request not present");
		}
		return resp;
	}
	
	@GetMapping(path = "/requestView")
	public LibraryManagementSystemResponse requestView(){
		LibraryManagementSystemResponse resp = new LibraryManagementSystemResponse();
		List<BookRegister> bookRegisters = null;
		bookRegisters = service.requestView();
		if (bookRegisters != null) {
			resp.setStatusCode(201);
			resp.setMessage("Successfull");
			resp.setDecription("Request present");
			resp.setRegister(bookRegisters);
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Unsuccessfull");
			resp.setDecription("Request not present");
		}
		return resp;
	}
	
	@DeleteMapping(path="/denyRequest/{userId}")
	public Boolean bookReject(@PathVariable("userId")int userId) {
		boolean deleted = false;
		deleted = service.requestDeny(userId);
		return deleted;
	}
	
	
	

}
