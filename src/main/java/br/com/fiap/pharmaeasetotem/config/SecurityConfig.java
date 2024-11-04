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
                        .requestMatchers("/", "/home", "/login", "/h2-console/**").permitAll() // Páginas públicas
                        .anyRequest().authenticated() // Exige autenticação para outras páginas
                )
                .formLogin(form -> form
                        .loginPage("/login") // Página de login personalizada
                        .defaultSuccessUrl("/clientes", true) // Redireciona para "home" após login bem-sucedido
                        .permitAll() // Permite acesso à página de login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL personalizada de logout
                        .logoutSuccessUrl("/login?logout") // Redireciona após logout
                        .permitAll()
                );


        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Configuração de usuários em memória para desenvolvimento
        UserDetails user = User.withUsername("user")
                .password("{noop}password") // "{noop}" para senha não codificada (apenas para desenvolvimento)
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
