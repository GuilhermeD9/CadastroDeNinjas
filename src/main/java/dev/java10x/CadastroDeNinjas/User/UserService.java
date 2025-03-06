package dev.java10x.CadastroDeNinjas.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserModel save(UserModel user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }
}
