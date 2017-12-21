package mum.edu.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mum.edu.project.domain.User;
import mum.edu.project.repository.UserRepository;
import mum.edu.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getByEmail(String name) {
        return userRepository.getByEmail(name);
    }

    @Override
    public List<User> getAgents() {
        return (List<User>) userRepository.getByAgent();
    }

}
