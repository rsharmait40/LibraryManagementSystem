package com.capgemini.librarymanagementsystem.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.capgemini.librarymanagementsystem.response.LibraryManagementSystemResponse;
import com.capgemini.librarymanagementsystemuser.dto.BookInfo;
import com.capgemini.librarymanagementsystemuser.dto.Issue;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	
	@RequestMapping(value="/template/searchBook/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse searchBook(@RequestBody BookInfo bookInfo){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookInfo> entity = new HttpEntity<BookInfo>(bookInfo,headers);
		return restTemplate.exchange("http://localhost:8084/searchBook/", HttpMethod.POST, entity, LibraryManagementSystemResponse.class).getBody();
	}
	
	
	@RequestMapping(value="/template/requestBook",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse requestBook(@RequestParam("bookId") int bookId, @RequestParam("username") String username) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LibraryManagementSystemResponse> entity = new HttpEntity<LibraryManagementSystemResponse>(headers);
		return restTemplate.exchange("http://localhost:8084/requestBook?bookId="+bookId+"&username="+username, HttpMethod.GET, entity, LibraryManagementSystemResponse.class).getBody();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@RequestMapping(value = "/requestBook", method = RequestMethod.POST)
//	public LibraryManagementSystemResponse requestBook(
//			@RequestBody com.capgemini.librarymanagementsystem.dto.BookInfo book, int userId) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Issue> entity = new HttpEntity<Issue>(headers);
//		return restTemplate.exchange("http://localhost:8081/requestBook", HttpMethod.POST, entity,
//				LibraryManagementSystemResponse.class).getBody();
//	}// End of requestBook()

//	@RequestMapping(value = "/borrow", method = RequestMethod.POST)
//	public LibraryManagementSystemResponse borrow(int userId, String bookName) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Issue> entity = new HttpEntity<Issue>(headers);
//		return restTemplate.exchange("http://localhost:8081/borrow", HttpMethod.POST, entity,
//				LibraryManagementSystemResponse.class).getBody();
//	}// End of borrow()
	
}// End of class
