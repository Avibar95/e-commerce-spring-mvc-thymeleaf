 package com.ecommerce.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {
	
	private User user;
	
	public CustomUserDetails(User user){
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authoritieList = new ArrayList<>();
		super.getRoles().forEach(role ->{
			authoritieList.add(new SimpleGrantedAuthority(role.getName()));
		});
		return authoritieList;
	}
	
	@Override
	public List<Role> getRoles() {
		return super.getRoles();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() { 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
