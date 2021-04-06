package net.polaris.Oauth2_Demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@Builder
public class OauthRefreshToken {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tokenId;
	
	@Lob
	private byte[] token;
	
	@Lob
	private byte[] authentication;
}
