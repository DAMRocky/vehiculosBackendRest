package com.patrick.vehiculosAPIRest.Business;
import com.patrick.vehiculosAPIRest.DTO.userRegisterResponseDTO;
import com.patrick.vehiculosAPIRest.Entities.User;
import com.patrick.vehiculosAPIRest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserBusiness {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public userRegisterResponseDTO createUser(User user) {
        try {
            User registerUser = userRepository.findByemail(user.getEmail());
            if (registerUser != null){
                return new userRegisterResponseDTO(2 , "El correo electrónico ya está registrado");
            }
            String hashedPassword = passwordEncoder.encode(user.getContrasena());
            user.setContrasena(hashedPassword);
            user.setIdEstado(1);
            userRepository.save(user);
            return new userRegisterResponseDTO(1,"El usuario ha sido creado");
        } catch (Exception e) {
            throw e;
        }
    }

    public userRegisterResponseDTO authenticateUser(String email, String password) {
        try {
            User user = userRepository.findByemail(email);
            if (user != null && passwordEncoder.matches(password, user.getContrasena())) {
                return new userRegisterResponseDTO(1, "Ok");
            } else {
                return new userRegisterResponseDTO(2, "Credenciales inválidas");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
