package br.com.transcarga.service;

import br.com.transcarga.model.User;
import br.com.transcarga.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    public User login(String username, String password) {
        return userRepo.findByUsername(username)
                .filter(user -> BCrypt.checkpw(password, user.getPassword()))
                .orElse(null);
    }

    public void register(String username, String password, String role) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User();
        user.setUsername(username);
        user.setPassword(hash);
        user.setRole(role);
        userRepo.save(user);
    }
}
