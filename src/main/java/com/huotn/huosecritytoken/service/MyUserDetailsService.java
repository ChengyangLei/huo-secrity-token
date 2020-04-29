package com.huotn.huosecritytoken.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huotn.huosecritytoken.entity.TSysUser;
import com.huotn.huosecritytoken.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author:leichengyang
 * @desc:com.huotn.huosecritytoken.service
 * @date:2020-04-29
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "TSysUserServiceImpl")
    private TSysUserService tSysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<TSysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        TSysUser user = tSysUserService.getOne(queryWrapper);
        return new User(username, passwordEncoder.encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
