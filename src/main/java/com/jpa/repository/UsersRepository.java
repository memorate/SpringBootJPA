package com.jpa.repository;

import com.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
    List<User> readByAgeLessThanEqual(int age);
    List<User> queryByNameStartingWith(String word);
    List<User> getByDescriptionIsNotNull();

    @Transactional
    @Modifying
    int deleteByName(String name);

    @Transactional
    @Modifying
    int deleteUserByName(String name);

    List<User> findAll(Sort sort);

//    @Query("select u from User u")
//    List<User> findAll(Sort sort);

//    @Query("select u from User u")
//    Page<User> findAll(Pageable pageable);

    Page<User> findAll(Pageable pageable);

    @Query("select u from User u where u.name = :name and u.age = :age")
    User findByNameAndAge(@Param("name") String name, @Param("age") int age);

    @Query("select u from User u where u.name like ?1")
    User findByName(String name);

    @Query(value = "SELECT * from users where age= :myAge", nativeQuery = true)
    User findByName(@Param("myAge") int age);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users set name=?1 where age=35", nativeQuery = true)
    int updateSpecific(String name);
}
