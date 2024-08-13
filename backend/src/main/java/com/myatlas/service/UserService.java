package com.myatlas.service;

import com.myatlas.model.User;
import com.myatlas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Здесь можно добавить дополнительную логику для регистрации пользователя, такую как валидация или хеширование пароля
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByVkId(String vkId) {
        return userRepository.findByVkId(vkId);
    }

    public Optional<User> findByTelegramId(String telegramId) {
        return userRepository.findByTelegramId(telegramId);
    }

    public User updateUser(User user) {
        // Здесь можно добавить логику для обновления информации о пользователе
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
