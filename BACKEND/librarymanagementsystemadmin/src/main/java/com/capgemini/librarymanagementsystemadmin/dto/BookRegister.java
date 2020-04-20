package com.capgemini.librarymanagementsystemadmin.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bookRegister_info")
public class BookRegister implements Serializable{
	@Id
	@Column
	private int registerId;
	@Column
	private int bookId;
	@Column
	private int userId;
	@Column
	private Date registerDate;
	
//	@Exclude
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="userId",referencedColumnName="userId",insertable=false,updatable=false)
//	private UserInfoBean users;
//	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="bookId",referencedColumnName="bookId",insertable=false,updatable=false)
//	private BookInfo books;

}
