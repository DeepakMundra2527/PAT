package com.codewithprojects.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.codewithprojects.dto.UserDto;
import com.codewithprojects.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String password;
	
	private UserRole userRole;
	
public String getSecurityQuestion1() {
		return securityQuestion1;
	}


	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}


	public String getSecurityAnswer1() {
		return securityAnswer1;
	}


	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}


	public String getSecurityQuestion2() {
		return securityQuestion2;
	}


	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}


	public String getSecurityAnswer2() {
		return securityAnswer2;
	}


	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}


	public String getSecurityQuestion3() {
		return securityQuestion3;
	}


	public void setSecurityQuestion3(String securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}


	public String getSecurityAnswer3() {
		return securityAnswer3;
	}


	public void setSecurityAnswer3(String securityAnswer3) {
		this.securityAnswer3 = securityAnswer3;
	}


private String securityQuestion1;
	
	private String securityAnswer1;
	
	private String securityQuestion2;
	
	private String securityAnswer2;
	
	private String securityQuestion3;
	
	private String securityAnswer3;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(userRole.name()));
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public UserDto getUserDto() {
		UserDto userDto=new UserDto();
		userDto.setId(id);
		userDto.setName(name);
		userDto.setMobile(mobile);
		userDto.setEmail(email);
		userDto.setUserRole(userRole);
		return userDto;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserRole getUserRole() {
		return userRole;
	}


	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	

}
