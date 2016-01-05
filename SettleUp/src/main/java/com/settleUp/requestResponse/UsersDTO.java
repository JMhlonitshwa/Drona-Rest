package com.settleUp.requestResponse;

public class UsersDTO {
private Long id ;
private String name;
private String email;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public UsersDTO() {
	super();
}

public UsersDTO(String name, String email) {
	super();
	this.name = name;
	this.email = email;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
