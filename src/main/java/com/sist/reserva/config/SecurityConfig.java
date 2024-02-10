package com.sist.reserva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// sirven para indicar que es la configuración de Spring Security
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean // retorna el SecurityFilterChain configura el comportamiento de Security
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception { // HttpSecurity ayuda a configurar la seguridad
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // vulnerabilidad de formularios (si es que se ocupa)
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)) // no se almacena el estado del usuario en el servidor
                .authorizeHttpRequests(request -> { // configuramos que urls estaran protegidas y cuales no
                    // que urls no estan protegidas
                    request.requestMatchers(HttpMethod.GET, "/sistReserva/usuarios", "/sistReserva/servicios", "/sistReserva/reservas", "/login").permitAll();
                    // urls que estan protegidas
                    request.anyRequest().authenticated(); // cualquier otro end point debe estar protegido
                })
                .formLogin(form -> {
                    form.permitAll();
                });
        return httpSecurity.build();
    }
}
