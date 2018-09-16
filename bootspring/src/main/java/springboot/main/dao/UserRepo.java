package springboot.main.dao;

import org.springframework.data.repository.CrudRepository;

import springboot.main.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
