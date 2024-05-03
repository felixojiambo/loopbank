//package com.zep.bankingkafka.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//
//@Bean
//HttpSecurity filterChain(HttpSecurity httpSecurity){
//    httpSecurity.csrf(csrf->csrf.disable())
//            .authorizeHttpRequests(authorize->
//                    authorize.requestMatchers(HttpMethod.POST,"/api/user/create").permitAll()
//                            .anyRequest().authenticated())
//    httpSecurity.sessionManagement(session -> session
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
//
//    return  httpSecurity.build();
//}
//}
