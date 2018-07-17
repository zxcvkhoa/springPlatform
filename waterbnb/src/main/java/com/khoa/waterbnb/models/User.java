package com.khoa.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2, message="First name must be greater than 2 characters")
    private String firstName;
    @Size(min=2, message="Last name must be greater than 2 characters")
    private String lastName;
    @Email(message="Email must be valid")
    private String email;
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    private String typeUser;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Review> reviews;
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Bnb> bnbs;
    
    public User() {
    }
    
    
    
	public User(Long id, @Size(min = 2, message = "First name must be greater than 2 characters") String firstName,
			@Size(min = 2, message = "Last name must be greater than 2 characters") String lastName,
			@Email(message = "Email must be valid") String email,
			@Size(min = 5, message = "Password must be greater than 5 characters") String password, String typeUser,
			Date createdAt, Date updatedAt, List<Review> reviews, List<Bnb> bnbs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.typeUser = typeUser;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.reviews = reviews;
		this.bnbs = bnbs;
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


	public String getTypeUser() {
		return typeUser;
	}


	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public List<Bnb> getBnbs() {
		return bnbs;
	}


	public void setBnbs(List<Bnb> bnbs) {
		this.bnbs = bnbs;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


}