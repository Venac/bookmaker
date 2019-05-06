package rs.netcast.stefan.filipovic9.bookmaker.security;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;

@Component
public class AccessFilter implements Filter {
	private static final Set<String> accessURIs = new HashSet<String>();
	private static final Set<String> userURIs = new HashSet<String>();
	private static final Set<String> operatorURIs = new HashSet<String>();
	
	static {
		accessURIs.add("/login/user");
		accessURIs.add("/login/operator");
		accessURIs.add("/register/user");
		
		userURIs.add("/tickets/save");
		userURIs.add("/matches/findBettable");
		userURIs.add("/tickets/findByUser");
		userURIs.add("/users/update");
		userURIs.add("/users/addFunds");
		userURIs.add("/users/withdrawFunds");
		userURIs.add("/users/period");
		
		operatorURIs.add("/matches");
		operatorURIs.add("/teams");
		operatorURIs.add("/operators");
		operatorURIs.add("/tickets/findAll");
		operatorURIs.add("/tickets/find");
		operatorURIs.add("/tickets/update");
		operatorURIs.add("/tickets/delete");
		operatorURIs.add("/users/findAll");
		operatorURIs.add("/users/find");
		operatorURIs.add("/users/delete");
		operatorURIs.add("/transactions/find");
		operatorURIs.add("/transactions/findAll");
		// for testing and demonstration purposes
		operatorURIs.add("/bookmakers");
	}
	
	@Autowired
	private Access access;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (accessURIs.contains(httpRequest.getRequestURI())) {
			chain.doFilter(request, response);
		} else {
			if (httpRequest.getHeader("token") != null) {
				String token = httpRequest.getHeader("token");
				if (access.isTokenValid(token)) {
					int id = access.getUserId(token);
					String type = access.getUserType(token);
					httpRequest.setAttribute("id", id);
					httpRequest.setAttribute("type", type);
					if ( (userHasAccess(httpRequest.getRequestURI()) && type.equals(User.class.getSimpleName())) 
							|| (operatorHasAccess(httpRequest.getRequestURI()) && type.equals(Operator.class.getSimpleName())) ) {
						chain.doFilter(request, response);
					} else {
						httpResponse.sendError(401, "Unauthorized");
					}
				} else {
					httpResponse.sendError(401, "Invalid token");
				}
			}
		}
	}
	
	public boolean userHasAccess(String URI) {
		System.out.println("URI: " + URI);
		for (String s : userURIs) {
			if (URI.startsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean operatorHasAccess(String URI) {
		System.out.println("URI: " + URI);
		for (String s : operatorURIs) {
			if (URI.startsWith(s)) {
				return true;
			}
		}
		return false;
	}

}
