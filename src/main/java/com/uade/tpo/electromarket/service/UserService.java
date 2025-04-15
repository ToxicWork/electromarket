package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.entity.User;
import com.uade.tpo.electromarket.repository.UserRepository;
import com.uade.tpo.electromarket.requests.LoginRequest;
import com.uade.tpo.electromarket.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registrarUsuario(RegisterRequest r) {
        User user = userRepository.findByEmail(r.getEmail());
        System.out.println(user);
        if (user == null) {
            User u = User.builder()
                    .email(r.getEmail())
                    .pass(r.getPass())
                    .apellido(r.getApellido())
                    .nombre(r.getNombre())
                    .build();
            userRepository.save(u);
            return;
        }
        throw new IllegalArgumentException("Email ya registrado");
    }

    @Override
    public void iniciarSesion(LoginRequest l) {

    }
}
