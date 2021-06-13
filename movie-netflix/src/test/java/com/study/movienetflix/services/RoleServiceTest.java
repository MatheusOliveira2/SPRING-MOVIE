package com.study.movienetflix.services;

import com.study.movienetflix.model.dtos.RoleGetDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceTest {

    @Autowired
    RoleService service;

    @Test
    public void save(){
        RolePostDTO role = new RolePostDTO();
        role.setRole("UserOne");
        RoleGetDTO response;
        response = service.save(role);
        Assert.assertTrue(response.getRole() == role.getRole());
    }

    @Test
    public void findAll(){
        List<RoleGetDTO> list = service.findAll();
        Assert.assertTrue(list.size() >= 0);
    }
}
