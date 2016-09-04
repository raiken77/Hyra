package com.attributegrouptest.Domain.Repository;

import com.attributegrouptest.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Noobs on 04/09/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{

     User findByUsername(String username);


}
