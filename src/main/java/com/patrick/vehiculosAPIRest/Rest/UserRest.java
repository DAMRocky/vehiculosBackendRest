package com.patrick.vehiculosAPIRest.Rest;

import com.patrick.vehiculosAPIRest.Business.UserBusiness;
import com.patrick.vehiculosAPIRest.DTO.userRegisterResponseDTO;
import com.patrick.vehiculosAPIRest.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class UserRest {
    @Autowired
    private UserBusiness userBusiness;

    @PostMapping("/user/create")
    public userRegisterResponseDTO createUser(@RequestBody User user) {
        try {
            return userBusiness.createUser(user);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible guardar los datos", e);
        }
    }

    @PostMapping("/user/authenticate")
    public userRegisterResponseDTO authenticateUser(@RequestBody User user) {
        try {
            return userBusiness.authenticateUser(user.getEmail(), user.getContrasena());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible autenticar", e);
        }
    }


}
