package com.study.movienetflix.services;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.RoleGetDTO;
import com.study.movienetflix.model.dtos.RolePostDTO;
import com.study.movienetflix.model.entities.Role;
import com.study.movienetflix.model.repositories.RoleRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleServiceTest {

    @InjectMocks
    private RoleService service;

    @Mock
    private RoleRepository repository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveSuccess(){
        RolePostDTO dto = new RolePostDTO();
        dto.setRole("role");
        Role role = new Role();
        role.setId(3);
        role.setRole("roleTest");
        Mockito.when(repository.save(Mockito.any(Role.class))).thenReturn(role);
        RoleGetDTO result =  service.save(dto);
        Assert.assertEquals(role.getRole(), result.getRole());
        Assert.assertEquals(role.getId(), result.getId());
    }

    @Test
    public void saveAlreadyInsertedValue(){
        RolePostDTO dto = new RolePostDTO();
        dto.setRole("role");
        Role role = new Role();
        role.setId(3);
        role.setRole("role");

        Optional<Role> roleResult = Optional.of(new Role());
        Mockito.when(repository.findByRole(Mockito.any(String.class))).thenReturn(roleResult);
        Assertions.assertThrows(BusinessException.class,() ->{
            RoleGetDTO result =  service.save(dto);
        });
    }

    @Test
    public void findAll(){
        Role role = new Role();
        role.setId(3);
        role.setRole("roleTest");
        List<Role> list = new ArrayList();
        list.add(role);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<RoleGetDTO> listResult = service.findAll();
        Assert.assertEquals(role.getRole(), listResult.get(0).getRole());
        Assert.assertEquals(role.getId(), listResult.get(0).getId());
    }
}
