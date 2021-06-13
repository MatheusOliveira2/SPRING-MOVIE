package com.study.movienetflix.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.movienetflix.model.dtos.RoleGetDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.services.RoleService;
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
import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@WebMvcTest(controllers = RoleController.class)
@RunWith(SpringRunner.class)
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void newRoleSuccess() throws Exception {
        RolePostDTO dto = new RolePostDTO();
        dto.setRole("Role");
        RoleGetDTO getDto = new RoleGetDTO();
        getDto.setId(3);
        getDto.setRole("Role");
        Mockito.when(roleService.save(Mockito.any(RolePostDTO.class))).thenReturn(getDto);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/role").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.role",is(dto.getRole())));
    }

    @Test
    void newRoleSuccessException() throws Exception {
        RolePostDTO dto = new RolePostDTO();
        dto.setRole("");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/role").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message",is(instanceOf(String.class))));
    }

    @Test
    void getRoles() throws Exception {
        RoleGetDTO dto = new RoleGetDTO();
        dto.setId(3);
        dto.setRole("Role");
        List<RoleGetDTO> list = new ArrayList();
        list.add(dto);
        Mockito.when(roleService.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/role")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(dto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].role",is(dto.getRole())));
    }
}