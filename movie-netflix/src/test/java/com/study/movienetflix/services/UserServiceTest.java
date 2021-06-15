package com.study.movienetflix.services;

import com.study.movienetflix.exception.BusinessException;
import com.study.movienetflix.model.dtos.MovieGetDTO;
import com.study.movienetflix.model.dtos.MoviePostDTO;
import com.study.movienetflix.model.dtos.UserGetDTO;
import com.study.movienetflix.model.dtos.UserPostDTO;
import com.study.movienetflix.model.entities.Category;
import com.study.movienetflix.model.entities.Movie;
import com.study.movienetflix.model.entities.Role;
import com.study.movienetflix.model.entities.User;
import com.study.movienetflix.model.repositories.MovieRepository;
import com.study.movienetflix.model.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveSuccess(){
        UserPostDTO dto = new UserPostDTO();
        dto.setName("name");
        dto.setPassword("password");
        dto.setUserName("userName");
        dto.setEmail("email@mail.com");
        dto.setActive(true);
        dto.setLastName("LastName");
        Set<Role> rolesList = new HashSet<>();
        rolesList.add(new Role());
        dto.setRoles(rolesList);
        dto.setRoles(rolesList);
        User user = new User();
        user.setName("name");
        user.setPassword("password");
        user.setUserName("userName");
        user.setEmail("email@mail.com");
        user.setId(5);

        Mockito.when(repository.save(Mockito.any(User.class))).thenReturn(user);
        UserGetDTO result =  service.save(dto);
        Assert.assertEquals(user.getName(), result.getName());
        Assert.assertEquals(user.getId(), result.getId());
    }

    @Test
    public void saveAlreadyInsertedValue(){
        UserPostDTO dto = new UserPostDTO();
        dto.setName("name");
        dto.setPassword("password");
        dto.setUserName("userName");
        dto.setEmail("email@mail.com");
        dto.setActive(true);
        dto.setLastName("LastName");
        Set<Role> rolesList = new HashSet<>();
        rolesList.add(new Role());
        dto.setRoles(rolesList);
        dto.setRoles(rolesList);

        Optional<User> userResult = Optional.of(new User());
        Mockito.when(repository.findByUserName(Mockito.any(String.class))).thenReturn(userResult);
        Assertions.assertThrows(BusinessException.class,() ->{
            UserGetDTO result =  service.save(dto);
        });
    }

    @Test
    public void findAll(){
        User user = new User();
        user.setName("name");
        user.setPassword("password");
        user.setUserName("userName");
        user.setEmail("email@mail.com");
        user.setActive(true);
        user.setLastName("LastName");
        Set<Role> rolesList = new HashSet<>();
        rolesList.add(new Role());
        user.setRoles(rolesList);
        user.setRoles(rolesList);
        List<User> list = new ArrayList();
        list.add(user);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<UserGetDTO> listResult = service.findAll();
        Assert.assertEquals(user.getName(), listResult.get(0).getName());
        Assert.assertEquals(user.getId(), listResult.get(0).getId());
    }
}
