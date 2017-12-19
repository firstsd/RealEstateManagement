package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.User;

public interface UserService {
    
    User getById(Long id);
    
    User save(User user);
    
    List<User> getAll();
    
    User getByEmail(String name);

    List<User> getAgents();
    
}
