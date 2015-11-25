package com.drona.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.drona.common.json.JsonResponse;
import com.drona.common.json.UserJson;

public class UserJsonResponse extends JsonResponse {
	List<UserJson> users= new ArrayList<UserJson>();

	public List<UserJson> getUsers() {
		return users;
	}

	public void setUsers(List<UserJson> users) {
		this.users = users;
	}

}
