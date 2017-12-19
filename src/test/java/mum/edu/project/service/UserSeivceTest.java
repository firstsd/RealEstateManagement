/*
 * Created on Nov 16, 2017
 */
package mum.edu.project.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mum.edu.project.model.Address;
import mum.edu.project.model.Role;
import mum.edu.project.model.User;
import mum.edu.project.repository.UserRepository;
import mum.edu.project.service.impl.UserServiceImpl;

public class UserSeivceTest {
	 
    @Mock
    UserRepository userRepositoryMock;
    
    @InjectMocks
    UserServiceImpl userService;

    List<User> users = new ArrayList<User>();
    
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        User u1 = new User();
        u1.setFirstName("Gundsambuu");
        u1.setEmail("gbadam@mum.edu");
        u1.setLastName("B");
        User u2 = new User();
        u2.setFirstName("Sodjamts");
        u2.setEmail("Skhurelbat@mum.edu");
        u2.setLastName("K");
        users.add(u1);
        users.add(u2);
    }

    @Test
    public void getAll() throws Exception {
        when(userRepositoryMock.findAll()).thenReturn(users);
        List<User> users = userService.getAll();
        for(User user :users ) {
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getEmail());
        }
    }
}
