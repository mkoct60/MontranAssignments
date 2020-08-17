package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_type")
public class MemberType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int membertype_id;
	@Column(length = 20)
	private String member_type;
	@Column
	private int book_limit;

	public MemberType() {
		// TODO Auto-generated constructor stub
	}

	public MemberType(int membertype_id, String member_type, int book_limit) {
		super();
		this.membertype_id = membertype_id;
		this.member_type = member_type;
		this.book_limit = book_limit;
	}

	public int getMembertype_id() {
		return membertype_id;
	}

	public void setMembertype_id(int membertype_id) {
		this.membertype_id = membertype_id;
	}

	public String getMember_type() {
		return member_type;
	}

	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	public int getBook_limit() {
		return book_limit;
	}

	public void setBook_limit(int book_limit) {
		this.book_limit = book_limit;
	}

	@Override
	public String toString() {
		return "MemberType [membertype_id=" + membertype_id + ", member_type=" + member_type + ", book_limit="
				+ book_limit + "]";
	}

	

}
