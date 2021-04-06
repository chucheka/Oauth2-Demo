package net.polaris.Oauth2_Demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.polaris.Oauth2_Demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

}
