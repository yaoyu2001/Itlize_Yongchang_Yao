
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findById(Long id);

    @SuppressWarnings("unchecked")
    public User save(User user);//Save user

    @Query(value = "SELECT u FROM User u WHERE name=:name")
    public User findNameHql(@Param("name") String name);

    //nativeQuery为true代表使用SQL语言
    @Query(value = "SELECT * FROM yyh_user WHERE name=?", nativeQuery = true)
    public User findNameSql(String name);

    // Delete user
    @SuppressWarnings("")
    public void deleteById(Long id);

    //
//    public User findAll(){
//
//    }


}
