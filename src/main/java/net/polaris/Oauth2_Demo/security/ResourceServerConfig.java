package net.polaris.Oauth2_Demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${resource.id}")
	private String RESOURCE_ID;
	
    @Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/auth/**").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .mvcMatchers(HttpMethod.GET,"/coupons/{id}").hasAnyRole("USER","ADMIN")
        .mvcMatchers(HttpMethod.GET,"/coupons").hasRole("ADMIN")
        .antMatchers("/").permitAll()
        .anyRequest().denyAll()
        .and().csrf().disable();
        
        http.headers().frameOptions().disable();

    }	

}