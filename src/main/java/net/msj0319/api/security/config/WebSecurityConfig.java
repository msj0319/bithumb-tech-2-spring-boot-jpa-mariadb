package net.msj0319.api.security.config;

import lombok.RequiredArgsConstructor;
import net.msj0319.api.security.domain.SecurityProvider;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//프론트엔드에서 넘어오는 것들에 대한 보안
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityProvider provider;

    @Bean
    PasswordEncoder encoder() { //비밀번호 암호화
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }

    @Override @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //무상태 프로토콜 ; 메모리에 로그인했던 유저 정보를 저장하지 말 것
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //웹 토큰이 없어도 접속 가능한 페이지를 설정한다. (가입 안된 유저)
        http.authorizeRequests()
                .antMatchers("/users/signin").permitAll()
                .antMatchers("/users/signip").permitAll()
                .antMatchers("/users/findAll").permitAll()
                .antMatchers("/admin/access").permitAll()
                .antMatchers("/h2-console/**/**").permitAll()
                .anyRequest().authenticated();
        //회원정보가 필요한 이 외 로그인하라는 창으로 넘긴다.
        http.exceptionHandling().accessDeniedPage("/login");
        http.apply(new SecurityConfig(provider));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*/**")
                .antMatchers("/", "/h2-console/**/**");
    }
}