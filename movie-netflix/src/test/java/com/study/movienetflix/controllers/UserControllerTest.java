package com.study.movienetflix.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.dtos.UserGetDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.entities.Role;
import com.study.movienetflix.services.MovieService;
import com.study.movienetflix.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.*;

@WebMvcTest(controllers = UserController.class)
@RunWith(SpringRunner.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void newUserSuccess() throws Exception {
        UserPostDTO dto = new UserPostDTO();
        dto.setName("name");
        dto.setPassword("password");
        dto.setActive(true);
        dto.setEmail("email@mail.com");
        dto.setUserName("userName");
        dto.setLastName("LastName");
        Role role = new Role();
        role.setRole("role");
        role.setId(1);
        Set<Role> rolesList = new HashSet<>();
        rolesList.add(role);
        dto.setRoles(rolesList);

        UserGetDTO getDto = new UserGetDTO();
        getDto.setName("name");
        getDto.setActive(true);
        getDto.setEmail("email@mail.com");
        getDto.setUserName("userName");
        getDto.setLastName("LastName");
        getDto.setRoles(rolesList);

        Mockito.when(userService.save(Mockito.any(UserPostDTO.class))).thenReturn(getDto);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",is(getDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.active",is(getDto.getActive())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",is(getDto.getEmail())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName",is(getDto.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roles[0].role", is(role.getRole())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName",is(getDto.getLastName())));
    }

    @Test
    void newUserSuccessException() throws Exception {
        UserPostDTO dto = new UserPostDTO();
        dto.setName("");
        dto.setActive(true);
        dto.setEmail("email@mail.com");
        dto.setUserName("userName");
        dto.setLastName("LastName");
        Role role = new Role();
        role.setRole("role");
        role.setId(1);
        Set<Role> rolesList = new HashSet<>();
        rolesList.add(role);
        dto.setRoles(rolesList);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message",is(instanceOf(String.class))));
    }

    @Test
    void getUsers() throws Exception {
        UserGetDTO dto = new UserGetDTO();
        dto.setId(3);
        dto.setName("name");
        dto.setActive(true);
        dto.setEmail("email@mail.com");
        dto.setUserName("userName");
        dto.setLastName("LastName");
        Role role = new Role();
        role.setRole("role");
        role.setId(1);
        Set<Role> rolesList = new HashSet<>();
        rolesList.add(role);
        dto.setRoles(rolesList);

        List<UserGetDTO> list = new ArrayList();
        list.add(dto);
        Mockito.when(userService.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(dto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",is(dto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].active",is(dto.getActive())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email",is(dto.getEmail())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userName",is(dto.getUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].roles[0].role", is(role.getRole())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName",is(dto.getLastName())));
    }
}


