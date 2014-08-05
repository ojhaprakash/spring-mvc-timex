package ca.mountainpirate.timex.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.repository.EmployeeRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		List<Employee> list = employeeRepository.findByEmail(email);
		if (list == null || list.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		Employee employee = list.get(0);
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(employee.getUserRole()));
		
		User user = new User(employee.getEmail(), employee.getPassword(), authorities);
		return user;
	}
}
