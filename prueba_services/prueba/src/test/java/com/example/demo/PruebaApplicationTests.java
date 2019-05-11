
package com.example.demo;

import static org.junit.Assert.assertTrue;

import com.example.demo.model.Usuario;
import com.example.demo.repository.IUsuarioRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest
public class PruebaApplicationTests {

  @Autowired
  private IUsuarioRepository repo;

  @Autowired
  private BCryptPasswordEncoder encoder;

  @Test
  public void crearUsuarioTest() {

    Usuario usa = new Usuario();
    usa.setId(1);
    usa.setNombre("lvizxa");
    usa.setClave(encoder.encode("100"));
    Usuario retorno = repo.save(usa);

    assertTrue(retorno.getClave().equalsIgnoreCase(usa.getClave()));

  }


}
