package com.grabduck.demo.springsecurity.services;

import com.grabduck.demo.springsecurity.persistence.UserDao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {

//        userDao.findByUsername("user").ifPresent(user -> {
//            user.setPassword(new BCryptPasswordEncoder().encode("user"));
//            userDao.save(user);
//        });
//
//        if (!userDao.findByUsername("admin").isPresent()) {
//            userDao.save(User.builder()
//                    .username("admin")
//                    .password(new BCryptPasswordEncoder().encode("admin"))
//                    .authorities(ImmutableList.of(Role.ADMIN))
//                    .accountNonExpired(true)
//                    .accountNonLocked(true)
//                    .credentialsNonExpired(true)
//                    .enabled(true)
//                    .build());
//        }
//
//        if (!userDao.findByUsername("power").isPresent()) {
//            userDao.save(User.builder()
//                    .username("power")
//                    .password(new BCryptPasswordEncoder().encode("power"))
//                    .authorities(ImmutableList.of(Role.POWER_USER))
//                    .accountNonExpired(true)
//                    .accountNonLocked(true)
//                    .credentialsNonExpired(true)
//                    .enabled(true)
//                    .build());
//        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("user " + username + " was not found!"));
    }
}
