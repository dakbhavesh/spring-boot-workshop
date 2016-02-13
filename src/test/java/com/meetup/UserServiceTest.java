package com.meetup;

import com.meetup.domain.User;
import com.meetup.repository.UserRepository;
import com.meetup.service.UserService;
import com.meetup.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by bhavesh.shah on 2/13/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserServiceImpl(userRepository);


    @Before
    public void before(){}

    @Test
    public void testSave(){
        User user = new User();
        user.setFirstName("Bhavesh");
        user.setLastName("Shah");

        Mockito.when(userRepository.save(user)).thenReturn(prepareUser());
        User result = userService.save(user);
        Assert.assertNotNull(result);
        Assert.assertEquals(new Long(1), result.getId());
    }

    @Test
    public void testFindOne(){
        Mockito.when(userRepository.findOne(1L)).thenReturn(prepareUser());
        User result = userService.findOne(1L);
        Assert.assertNotNull(result);
        Assert.assertEquals("Bhavesh", result.getFirstName());
    }

    private User prepareUser(){
        User user = new User();
        user.setFirstName("Bhavesh");
        user.setLastName("Shah");
        user.setId(1L);
        return user;
    }
}
