package org.launchcode.professionaltrainingtracker.models.data;

import org.launchcode.professionaltrainingtracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    public User findByEmail(String email);

}

