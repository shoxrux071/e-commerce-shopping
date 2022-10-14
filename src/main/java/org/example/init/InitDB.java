package org.example.init;



import org.example.domains.AuthRole;
import org.example.domains.AuthUser;
import org.example.repository.AuthPermissionRepository;
import org.example.repository.AuthRepository;
import org.example.repository.AuthRoleRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class InitDB implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        AuthRoleRepository authRoleRepository = context.getBean(AuthRoleRepository.class);
        AuthPermissionRepository authPermissionRepository = context.getBean(AuthPermissionRepository.class);
        AuthRepository repository = context.getBean(AuthRepository.class);
        authPermissionRepository.deleteAll();
        authRoleRepository.deleteAll();
        repository.deleteAll();
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        AuthUser superUser = new AuthUser();
        superUser.setUsername("superuser");
        superUser.setPassword(passwordEncoder.encode("123"));
        superUser.setActive(true);
        superUser.setEmail("superUser@mail.ru");

        AuthUser managerUser = new AuthUser();
        managerUser.setUsername("manager");
        managerUser.setPassword(passwordEncoder.encode("123"));
        managerUser.setActive(true);
        managerUser.setEmail("manager@gmail.com");

        AuthRole admin = new AuthRole();
        admin.setCode("ADMIN");
        admin.setName("Admin");

        AuthRole manager = new AuthRole();
        manager.setCode("MANAGER");
        manager.setName("Manager");


        superUser.getRoles().add(admin);
        superUser.getRoles().add(manager);
        managerUser.setRoles(Collections.singletonList(manager));
        repository.saveAll(List.of(superUser, managerUser));

    }
}
