package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.model.entities.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserServiceTest {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    UserService service;

    @Autowired
    RoleService roleService;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void save(){
        UserPostDTO user = new UserPostDTO();
        user.setUserName("Matheus");
        user.setEmail("Matheus@mail.com");
        user.setActive(true);
        user.setLastName("Oliveira");
        user.setPassword("123456798");
        user.setName("Matheus");

        List<RolePostDTO> rolesDTO = roleService.findAll();

        Set<Role> roles = rolesDTO.stream().map(role -> mapper.map(role, Role.class)).collect(Collectors.toSet());
        user.setRoles(roles);
        UserPostDTO response;
        user.getRoles().stream().forEach(item -> System.out.println(item.getRole()));
        response = service.save(user);
    }

    @Test
    public void findAll(){
        List<UserPostDTO> list = service.findAll();
        Assert.assertTrue(list.size() >= 0);
    }
}
