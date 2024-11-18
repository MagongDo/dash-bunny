package com.devcourse.dashbunny.feature.user.service;


import com.devcourse.dashbunny.domain.user.User;
import com.devcourse.dashbunny.feature.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        // 'name'을 사용자명으로 사용한다고 가정. 필요에 따라 변경.
        User user = userRepository.findByPhone(phone)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + phone));

        // 역할을 GrantedAuthority로 매핑
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getPhone(),
                user.getPassword(),
                authorities
        );
    }
}
