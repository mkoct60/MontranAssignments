package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "member_master")
public class MemberMaster {
	
	@Id
	@Column(length = 20)
	@Check(constraints = "LIKE 'M%'")
	private String member_id;
	
	@OneToOne(targetEntity = MemberType.class)
	@JoinColumn(name = "membertype_id")
	private MemberType memberType;
	
	@Column(length = 30)
	private String name;
	
	@Column
	private int book_limit;
	
	@Check(constraints = "total_book_issued<=book_limit")
	private int total_book_issued;
	
	public MemberMaster() {
		// TODO Auto-generated constructor stub
	}

	public MemberMaster(String member_id, MemberType memberType, String name, int book_limit, int total_book_issued) {
		super();
		this.member_id = member_id;
		this.memberType = memberType;
		this.name = name;
		this.book_limit = book_limit;
		this.total_book_issued = total_book_issued;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBook_limit() {
		return book_limit;
	}

	public void setBook_limit(int book_limit) {
		this.book_limit = book_limit;
	}

	public int getTotal_book_issued() {
		return total_book_issued;
	}

	public void setTotal_book_issued(int total_book_issued) {
		this.total_book_issued = total_book_issued;
	}

	@Override
	public String toString() {
		return "MemberMaster [member_id=" + member_id + ", memberType=" + memberType + ", name=" + name
				+ ", book_limit=" + book_limit + ", total_book_issued=" + total_book_issued + "]";
	}

	
}
