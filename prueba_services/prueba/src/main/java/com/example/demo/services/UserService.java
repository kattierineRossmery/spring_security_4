package com.example.demo.services;

import com.example.demo.model.Usuario;
import com.example.demo.repository.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserDetailsService {

  @Autowired
  private IUsuarioRepository repo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usa = repo.findByNombre(username);

    List<GrantedAuthority> roles = new ArrayList<>();
    roles.add(new SimpleGrantedAuthority("ADMIN"));

    UserDetails userdet = new User(usa.getNombre(), usa.getClave(), roles);
    return userdet;

  }

}
