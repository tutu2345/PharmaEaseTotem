package br.com.fiap.pharmaeasetotem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home").permitAll() // Permite acesso a essas rotas sem autenticação
                        .requestMatchers("/h2-console/**").permitAll() // Permite acesso à consola H2
                        .anyRequest().authenticated() // Qualquer outra requisição exige autenticação
                )
                .formLogin(form -> form
                        .loginPage("/login") // Define uma página de login personalizada
                        .permitAll() // Permite acesso à página de login sem autenticação
                )
                .logout(logout -> logout.permitAll()) // Permite logout sem autenticação
                .csrf(csrf -> csrf.disable()) // Desabilita proteção CSRF para a consola H2
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()) // Permite o uso de iframes para o console H2
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}password") // Usando "{noop}" para indicar que a senha não está codificada (apenas para desenvolvimento)
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin); // Adiciona os usuários ao gerenciador de detalhes
    }
}