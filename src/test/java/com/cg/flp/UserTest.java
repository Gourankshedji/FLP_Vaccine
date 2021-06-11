package com.cg.flp;


	 

	import static org.junit.jupiter.api.Assertions.*;
	import static org.mockito.Mockito.when;

	 

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	 

	import com.cg.flp.entities.User;
	import com.cg.flp.repository.IUserRepository;
	import com.cg.flp.service.IUserService;

	 


	@SpringBootTest
	class UserTest {
	    
	    @Autowired
	    private IUserService userService;
	    
	    @MockBean
	    IUserRepository userRepository;
	    
	    
	    @Test
	    public void testAddUser() {

	 

	        User user= getUser();
	        when(userRepository.save(user)).thenReturn(user);
	        assertEquals(userService.addUser(user), user);

	 

	    }

	 

	    private User getUser() {
	        User user = new User();

	 

	        user.setUserId(4);
	        user.setPassword("Pas@123");
	        user.setUserName("John");

	 

	        return user;
	    }
	}

