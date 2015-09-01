package com.drona.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class StudentImpl  extends OrganisationUserImpl {
@ManyToOne(fetch=FetchType.LAZY)
 private UserImpl parent1;
@ManyToOne(fetch=FetchType.LAZY)
private UserImpl parent2;
public UserImpl getParent1() {
	return parent1;
}
public void setParent1(UserImpl parent1) {
	this.parent1 = parent1;
}
public UserImpl getParent2() {
	return parent2;
}
public void setParent2(UserImpl parent2) {
	this.parent2 = parent2;
}
}
