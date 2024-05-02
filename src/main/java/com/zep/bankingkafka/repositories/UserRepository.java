package com.zep.bankingkafka.repositories;
import com.zep.bankingkafka.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
   // Boolean existByEmail(String email);
    Boolean existsByAccountNumber(String accountNumber);
    User findByAccountNumber(String accountNumber);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
    Boolean existByEmail(@Param("email") String email);
}
