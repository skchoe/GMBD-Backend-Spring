package com.ctd.gmbd.simple.restcontroller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctd.gmbd.simple.repository.AuthUserEntity;
import com.ctd.gmbd.simple.service.AuthService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allows your Capacitor app to bypass CORS
public class AuthController extends BaseController{

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping("/hello")
    public ResponseEntity<String> getHello(@RequestParam(required = true) String name) {
		return ResponseEntity.ok(name);
	}

	@GetMapping("/auth")
    public ResponseEntity<AuthResponse> createAuthUserTable(@RequestParam(required = false) String name) {
        // Call the service to save to SQL Server
    	try {
	    	if(name != null && 0 < name.trim().length()) {
		        AuthUserEntity savedUser = authService.createAndSaveUser(name);
		        return ResponseEntity.ok(new AuthResponse(null, "Hello, " + savedUser.getName() + "! You have been saved to the DB."));
	    	} else {
	    		String[] nameArray = new String[]{"Knox", "Delilah", "Jasper", "Sloane", "Saige Fuentes", "Bowen Higgins", "Leighton Kramer", "Marceline Avila", "Flynn Goodman", "Zariah Guevara"};
	    		List<String> names = Arrays.asList(nameArray);
	    		List<AuthUserEntity> users = names.stream().map(nm -> {
			        return authService.createAndSaveUser(nm);
	    		}).collect(Collectors.toList());
	    		
	    		Gson gson = getGson();
	    		List<String> authUserStrings = users.stream().map(user -> {
	    			return gson.toJson(user);
	    		}).collect(Collectors.toList());
	    		
	    		return ResponseEntity.ok(new AuthResponse(authUserStrings, null));
	    	}
    	} catch (RuntimeException e) {
    		String message = "Failed to register users: " + e.getMessage();
    		return ResponseEntity.internalServerError().body(new AuthResponse(null, message));
    	} catch (Exception e) {
    		if(e instanceof ConstraintViolationException) {
    			return ResponseEntity.badRequest()
    		            .body(new AuthResponse(null, "One of input username already exists."));
    		} else {
    			return ResponseEntity.internalServerError().body(new AuthResponse(null, "Error in saving user"));
    		}
    	}
    }
}