package com.attributegrouptest.Domain.Repository;

import com.attributegrouptest.Domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Noobs on 05/09/2016.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

}
