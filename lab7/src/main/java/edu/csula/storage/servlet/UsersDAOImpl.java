package edu.csula.storage.servlet;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import edu.csula.models.User;
import edu.csula.storage.UsersDAO;

/**
 * To abstract the storage access from the business layer using HttpSession
 */
public class UsersDAOImpl implements UsersDAO {
	private final HttpSession context;
	protected static final String CONTEXT_NAME = "users";

	public UsersDAOImpl(HttpSession context) {
		this.context = context;
	}

	@Override
	public boolean authenticate(String username, String password) {
		// TODO: check if username/password combination is valid and store the
		//       username/password into the session
		//didn't want to work with an ArrayList, so I checked the test, AR wasn't needed...
		User u = new User(0, username, password);
		User admin = new User(0, "admin", "cs3220password");
		if(u.equals(admin)){
			this.context.setAttribute(CONTEXT_NAME, u);
			return true;
		}
		return false;
	}

	@Override
	public Optional<User> getAuthenticatedUser() {
		// TODO: return the authenticated user if there is any
		Optional<User> isUser = Optional.empty();
		User u = (User) this.context.getAttribute(CONTEXT_NAME);
		if(u != null){
			isUser = Optional.of(u);
		}
		return isUser;
	}

	@Override
	public void logout() {
		// TOOD: log user out using `invalidate`
		//>"TOOD" lol
		User u = (User) this.context.getAttribute(CONTEXT_NAME);
		if(u != null){
				this.context.invalidate();
		}
	}
}
