package com.bridgelabz.greeting.greetinginitializer.repositories;

import com.bridgelabz.greeting.greetinginitializer.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}
