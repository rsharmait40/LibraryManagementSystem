package com.capgemini.librarymanagementsystemadmin.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "issue_info")
public class Issue implements Serializable {
	@Id
	@Column
	@GeneratedValue
	private int issueId;
	@Column
	private int registerId;
	@Column
	private LocalDate issueDate;
	@Column
	private LocalDate returnDate;
	@Column
	private double fine;
	

	@Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
	private UserInfoBean users;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId", referencedColumnName = "bookId", insertable = false, updatable = false)
	private BookInfo books;

}
