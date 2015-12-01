package com.settleUp.requestResponse;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse extends JasonResponse {
	private Long groupId;
	private List<UsersDTO> users = new ArrayList<UsersDTO>();

	public UserListResponse() {
	}

	public UserListResponse(List<UsersDTO> users,Long groupId) {
		super();
		this.users = users;
		this.groupId=groupId;
	}

	public List<UsersDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UsersDTO> users) {
		this.users = users;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
