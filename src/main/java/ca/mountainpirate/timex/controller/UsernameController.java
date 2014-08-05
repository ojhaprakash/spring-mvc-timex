package ca.mountainpirate.timex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.mountainpirate.timex.component.AuthenticationFacadeImpl;


@Controller
@RequestMapping("/username")
public class UsernameController {

	@Autowired
	private AuthenticationFacadeImpl authenticationFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String getUsername() {
		return authenticationFacade.getAuthentication().getName();
	}
}
