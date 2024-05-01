package com.zep.bankingkafka.repositories;
import com.zep.bankingkafka.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    Boolean existByEmail(String email);
}
