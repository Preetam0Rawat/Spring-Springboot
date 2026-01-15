package com.in28minutes.learn_spring_security.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {
	
	private JwtEncoder jwtEncoder;
	
	public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
		  this.jwtEncoder = jwtEncoder;
	}

	@PostMapping("/authenticate")
	public JwtResponse authneticate(Authentication authentication) {
		return new	JwtResponse(createToken(authentication));
   }

	private String createToken(Authentication authentication) {
		var claims =JwtClaimsSet.builder()
						.issuer("self")
						.issuedAt(Instant.now())
						.expiresAt(Instant.now().plusSeconds(60*3))
						.subject(authentication.getName())
						.claim("scope", createScope(authentication))
						.build();
		
		return jwtEncoder.encode(JwtEncoderParameters.from(claims))
				 				.getTokenValue();
	}

	private String createScope(Authentication authentication) {
		return authentication.getAuthorities().stream()
				.map(a-> a.getAuthority())
				.collect(Collectors.joining(" "));
	}

}

record JwtResponse(String token) {}




//eyJraWQiOiI2NmVkY2RjOC01Y2JjLTQ1NDYtOTg4NC04NDQ2YTE4YTJhZGUiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiaW4yOG1pbnV0ZXMiLCJleHAiOjE3Njc5NjUzMDksImlhdCI6MTc2Nzk2NTEyOSwic2NvcGUiOiJST0xFX1VTRVIifQ.X9EMtcwkb20cGvNmK1HbMJu5tUhv1fr0SW-HpaumE9xMECb0OrjLnKMBsdfpu0T0fN3jbckhfqt8fgcZeRoJIGZmHPYCeJvuZSP7V41j7ylYYDoRCvUxaQBKa7CjxmEzariPi7tuyjBmoW7mMW40BJdIvYjby6TUNLC2JG5UAdR_BALUGP54F7Lu3a11K2PUARNneCDgRecYq_vj-nAwDiAzFRoY8xQiBZuMNgHrr_a3XKOj28RGVyIeCMPcIgw1f5Ky8PPk5L3mhrpTDFDROecUGC2erCg6ffEwCMTfk6ycwDPTRkqJEQdKLHdq__ahStmXvbEEToiU4DeUhsB-ug
