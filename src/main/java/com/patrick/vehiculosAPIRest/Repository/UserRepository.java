package com.patrick.vehiculosAPIRest.Repository;

import com.patrick.vehiculosAPIRest.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByemail(String email);
}
