package com.tommystore.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.tommystore.constant.Role;


@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotNull
	@Column(nullable=false)
	private String password;
	
	@NotNull
	@Column(nullable=false)
	private String firstName;
	
	@NotNull
	@Column(nullable=false)
	private String lastName;
	
	@NotNull
	@Column(nullable=false)
	private String contactNumber;
	
	@OneToMany(mappedBy="user")
	private List<ShippingAddress> shippingAddresses;
	
	@OneToMany(mappedBy="user")
	private List<CreditCard> creditCards;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="create_date")
	private Date createDateTime;

	public void setShippingAddresses(List<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	public List<ShippingAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	
	public Date getCreatedAt() {
		return createDateTime;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setCreatedAt(Date createdAt) {
		this.createDateTime = createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", shippingAddresses="
				+ shippingAddresses + ", creditCards=" + creditCards + ", role=" + role + ", createdAt=" + createDateTime
				+ "]";
	}

}
