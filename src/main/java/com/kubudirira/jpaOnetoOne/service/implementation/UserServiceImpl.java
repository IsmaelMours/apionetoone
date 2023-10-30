package com.kubudirira.jpaOnetoOne.service.implementation;

import com.kubudirira.jpaOnetoOne.model.User;
import com.kubudirira.jpaOnetoOne.repository.UserRepository;
import com.kubudirira.jpaOnetoOne.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user); // Return the saved user entity
    }

    @Override
    public List<User> saveAll(List<User> userList) {
        return (List<User>) userRepository.saveAll(userList); // Return the saved user entities as a list
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User update(int id, User user) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));

        foundUser.setEmail(user.getEmail());
        foundUser.setFirst_name(user.getFirst_name()); // Corrected method name
        foundUser.setLast_name(user.getLast_name());

        return userRepository.save(foundUser); // Return the updated user entity
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
