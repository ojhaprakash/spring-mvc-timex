package ca.mountainpirate.timex.component;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

	Authentication getAuthentication();
}
