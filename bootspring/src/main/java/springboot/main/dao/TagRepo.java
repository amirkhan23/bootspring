package springboot.main.dao;

import org.springframework.data.repository.CrudRepository;

import springboot.main.entity.Tag;

public interface TagRepo extends CrudRepository<Tag, Integer> {

}
