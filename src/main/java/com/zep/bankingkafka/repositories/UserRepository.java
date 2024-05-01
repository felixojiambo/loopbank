package com.zep.bankingkafka.repositories;
import com.zep.bankingkafka.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository  extends JpaRepository<User, Long> {
}
