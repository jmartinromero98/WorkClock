package com.workclock.user.infrastructure;

import com.workclock.user.application.LoginService;
import com.workclock.user.application.RegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    LoginService loginService(UserRAMRepository ramRepository) {
        return new LoginService(ramRepository);
    }

    @Bean
    RegisterService registerService(UserRAMRepository ramRepository) {
        return new RegisterService(ramRepository);
    }

}
