package com.capgemini.librarymanagementsystem.controller;

import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.Issue;
import com.capgemini.librarymanagementsystem.dto.UserInfoBean;
import com.capgemini.librarymanagementsystem.response.LibraryManagementSystemResponse;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders ="*",exposedHeaders="Access-Control-Allow-Origin")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/template/addBook/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse addBook(@PathVariable("userId") int userId,
			@RequestBody BookInfo bookInfo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookInfo> entity = new HttpEntity<BookInfo>(bookInfo, headers);
		return restTemplate.exchange("http://localhost:8082/addBook/" + userId, HttpMethod.POST, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of addBook()

	@RequestMapping(value = "/template/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse addUser(@RequestBody UserInfoBean userInfoBean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserInfoBean> entity = new HttpEntity<UserInfoBean>(userInfoBean, headers);
		return restTemplate.exchange("http://localhost:8082/addUser", HttpMethod.POST, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of addUser()

	@RequestMapping(value = "/template/deleteBook/{bookId}", method = RequestMethod.DELETE)
	public LibraryManagementSystemResponse deleteBookById(@PathVariable("bookId") int bookId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookInfo> entity = new HttpEntity<BookInfo>(headers);
		return restTemplate.exchange("http://localhost:8082/deleteBook/" + bookId, HttpMethod.DELETE, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of deleteBookById()

	@RequestMapping(value = "/template/deleteUser/{userId}", method = RequestMethod.DELETE)
	public LibraryManagementSystemResponse deleteUserById(@PathVariable("userId") int userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserInfoBean> entity = new HttpEntity<UserInfoBean>(headers);
		return restTemplate.exchange("http://localhost:8082/deleteUser/" + userId, HttpMethod.DELETE, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of deleteUserById()

	@RequestMapping(value = "/template/updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse update(@RequestBody UserInfoBean userInfoBean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserInfoBean> entity = new HttpEntity<UserInfoBean>(userInfoBean, headers);

		return restTemplate.exchange("http://localhost:8082/updateUser", HttpMethod.POST, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of update()

	@RequestMapping(value = "/template/getallUsers", method = RequestMethod.GET)
	public LibraryManagementSystemResponse getallUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8082/getallUsers", HttpMethod.GET, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of getallUsers()

	@RequestMapping(value = "/template/getbyId/{userId}", method = RequestMethod.GET)
	public LibraryManagementSystemResponse getById(@PathVariable("userId") int userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8082/getbyId/" + userId, HttpMethod.GET, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of getById()

	@RequestMapping(value = "/template/addFine", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse addFine(@RequestBody int issueId, Date returnDate, ModelMap map) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Issue> entity = new HttpEntity<Issue>(headers);
		return restTemplate.exchange("http://localhost:8082/addFine", HttpMethod.POST, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of addFine()
	
	@RequestMapping(value = "/template/acceptRequest/{userId}", method = RequestMethod.GET)
	public LibraryManagementSystemResponse acceptRequest(@PathVariable("userId") int registerId){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8082/acceptRequest/"+registerId , HttpMethod.GET, entity, LibraryManagementSystemResponse.class).getBody();
	}
	
	@RequestMapping(value = "/template/requestView", method = RequestMethod.GET )
	public LibraryManagementSystemResponse requestView(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8082/requestView", HttpMethod.GET, entity,LibraryManagementSystemResponse.class).getBody();
	}
	
	@RequestMapping(value="/template/denyRequest/{userId}", method = RequestMethod.DELETE)
	public LibraryManagementSystemResponse bookReject(@PathVariable("userId")int userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Issue> entity = new HttpEntity<Issue>(headers);
		return restTemplate.exchange("http://localhost:8082/denyRequest/{userId}" + userId, HttpMethod.DELETE, entity,
				LibraryManagementSystemResponse.class).getBody();
	}
	
	
	
	
	
	

}// End of class
