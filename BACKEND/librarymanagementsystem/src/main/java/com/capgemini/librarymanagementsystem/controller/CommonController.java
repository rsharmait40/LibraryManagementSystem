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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.capgemini.librarymanagementsystem.response.LibraryManagementSystemResponse;
import com.capgemini.librarymanagementsystemcommon.dto.UserInfoBean;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders ="*",exposedHeaders="Access-Control-Allow-Origin")
public class CommonController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/template/change-password", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse changePassword(@RequestBody UserInfoBean userInfoBean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserInfoBean> entity = new HttpEntity<UserInfoBean>(userInfoBean, headers);
		return restTemplate.exchange("http://localhost:8083/change-password", HttpMethod.PUT, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of changePassword()


	@RequestMapping(value = "/template/register", method = RequestMethod.POST	,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse register(@RequestBody UserInfoBean bean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserInfoBean> entity = new HttpEntity<UserInfoBean>(bean, headers);
		return restTemplate.exchange("http://localhost:8083/register", HttpMethod.POST, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of register()

	@RequestMapping(value = "/template/forgot-password", method = RequestMethod.PUT)
	public LibraryManagementSystemResponse forgotPassword(@RequestBody UserInfoBean user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserInfoBean> entity = new HttpEntity<UserInfoBean>(user, headers);
		return restTemplate.exchange("http://localhost:8083/forgot-password", HttpMethod.PUT, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of forgotPassword()


	@RequestMapping(value = "/template/getallBooks", method = RequestMethod.GET)
	public LibraryManagementSystemResponse getallBooks() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8083/getallBooks", HttpMethod.GET, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of getallBooks()

	@RequestMapping(value = "/template/getbyname/{bookName}", method = RequestMethod.GET)
	public LibraryManagementSystemResponse getByName(@PathVariable("bookName") String bookName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8083/getbyname/" + bookName, HttpMethod.GET, entity,
				LibraryManagementSystemResponse.class).getBody();
	}// End of getByName()

}// End of class
