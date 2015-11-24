package com.drona.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.drona.entity.organisation.OrganisationImpl;

@Entity
@Table(name = "ORGANISATION_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrganisationUserImpl {
	@Id
	@Column(name = "ORGANISATION_USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserImpl userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORG_ID")
	private OrganisationImpl organisation;

	@Column(name = "STATUS", length = 1, nullable = false)
	private int status;

	@Column(name = "ROLE_TYPE_Id", length = 1, nullable = false)
	private Long roleTypeId;
	@Embedded
	private AuditData auditData;

	public OrganisationImpl getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationImpl organisation) {
		this.organisation = organisation;
	}

	public Long getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(Long roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

}
