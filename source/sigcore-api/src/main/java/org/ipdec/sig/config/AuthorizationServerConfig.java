package org.ipdec.sig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Profile("oauth-security")
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("angular")
			.secret("$2a$10$5FPPOV07HEmaYf3NGdQtIuTs55XRR7BCFACydtH.AqkJ6pYeMIPk2") //@ngul@r0
			.scopes("read", "write")
			.authorizedGrantTypes("password","refresh_token")
			.refreshTokenValiditySeconds(3600 * 24) //1 dia
			.accessTokenValiditySeconds(3600) //20 segundos
		.and()
			.withClient("mobile")
			.secret("$2a$10$6dj8lkPIXzmm7b4Ib1KWye2GLlprov1D5E4Zq1H1bsqlcKMMQ6Mxa") //m0b1l30
			.scopes("read")
			.authorizedGrantTypes("password","refresh_token")
			.refreshTokenValiditySeconds(3600 * 24) //1 dia
			.accessTokenValiditySeconds(3600); //20 segundos		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter())
			.reuseRefreshTokens(false)
			.userDetailsService(userDetailsService)
			.authenticationManager(authenticationManager);
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("algaworks");
		return accessTokenConverter;
	}

	@Bean 
	public TokenStore tokenStore() { 
		return new JwtTokenStore(accessTokenConverter());
	}
	
	
	
	

}
