package net.polaris.Oauth2_Demo.service;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.polaris.Oauth2_Demo.dto.SignUpDto;
import net.polaris.Oauth2_Demo.exception.AppException;
import net.polaris.Oauth2_Demo.exception.BadRequestException;
import net.polaris.Oauth2_Demo.model.Role;
import net.polaris.Oauth2_Demo.model.RoleName;
import net.polaris.Oauth2_Demo.model.User;
import net.polaris.Oauth2_Demo.payload.ApiResponse;
import net.polaris.Oauth2_Demo.repository.RoleRepository;
import net.polaris.Oauth2_Demo.repository.UserRepository;






@Service
public class AuthService {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
    
       
    public ApiResponse registerUser(SignUpDto dto) throws BadRequestException{

        
        if(userRepository.existsByEmail(dto.getEmail())) {
       	 throw new BadRequestException("There is an account with this email : " + dto.getEmail());
       }
        
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
         
        User user = new User.UserBuilder(dto.getUsername(),dto.getEmail(),Collections.singleton(userRole))
        		.password(passwordEncoder.encode(dto.getPassword()))
        		.build();
    
      
        
        User savedUser = userRepository.save(user);
        
        		 
        return new ApiResponse(HttpStatus.CREATED.name(),savedUser);
    }

}
