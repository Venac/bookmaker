package rs.netcast.stefan.filipovic9.bookmaker.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.TextCodec;
import rs.netcast.stefan.filipovic9.bookmaker.dao.OperatorDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.UserDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;
import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.register.RegisterDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.register.RegistreeLogInDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.register.RegistreeTokenDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.ConversionService;

@Service
public class Access {
	public static final byte[] key = TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=");
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OperatorDAO operatorDAO;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ModelMapper mapper;

	public String generateLogInJWT(RegistreeLogInDto r, HttpServletRequest request) {
		if (request.getRequestURI().contains("/login/user")) {
			User u = userDAO.findByEmailAndPassword(r.getEmail(), r.getPassword());
			if (u != null) {
				return generateToken(u, User.class.getSimpleName());
			}
		} else if (request.getRequestURI().contains("/login/operator")) {
			Operator o = operatorDAO.findByEmailAndPassword(r.getEmail(), r.getPassword());
			if (o != null) {
				return generateToken(o, Operator.class.getSimpleName());
			}
		}
		return null;
	}

	public RegistreeTokenDto generateRegisterJWT(RegisterDto r, HttpServletRequest request) throws IOException {
		if (request.getRequestURI().contains("/register/user")) {
			User u = userDAO.findByEmail(r.getEmail());
			if (u == null) {
				u = mapper.map(r, User.class);
				u.setBalance(conversionService.convertInitial(5));
				u = userDAO.save(u);
				String token = generateToken(u, User.class.getSimpleName());
				return new RegistreeTokenDto(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), token);
			} else {
				return null;
			}
		}
		if (request.getRequestURI().contains("/register/operator")) {
			Operator o = operatorDAO.findByEmail(r.getEmail());
			if (o == null) {
				o = mapper.map(r, Operator.class);
				o = operatorDAO.save(o);
				String token = generateToken(o, Operator.class.getSimpleName());
				return new RegistreeTokenDto(o.getId(), o.getFirstName(), o.getLastName(), o.getEmail(), token);
			} else {
				return null;
			}
		}
		return null;
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("id", Integer.class);
			Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("type", String.class);
			return true;
		} catch (SignatureException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getUserId(String token) {
		try {
			return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("id", Integer.class);
		} catch (SignatureException | NullPointerException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getUserType(String token) {
		try {
			return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("type", String.class);
		} catch (SignatureException | NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateToken(Object object, String type) {
		String token = "";
		if (object instanceof User) {
			User u = (User) object;
			token = Jwts.builder().claim("id", u.getId()).claim("email", u.getEmail()).claim("type", type)
					.signWith(SignatureAlgorithm.HS256, key).compact();
		} else if (object instanceof Operator) {
			Operator u = (Operator) object;
			token = Jwts.builder().claim("id", u.getId()).claim("email", u.getEmail()).claim("type", type)
					.signWith(SignatureAlgorithm.HS256, key).compact();
		}
		return token;
	}

}
