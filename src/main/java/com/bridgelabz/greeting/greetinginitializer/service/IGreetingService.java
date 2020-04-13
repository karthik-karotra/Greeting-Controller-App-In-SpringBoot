package com.bridgelabz.greeting.greetinginitializer.service;

import com.bridgelabz.greeting.greetinginitializer.model.Greeting;
import com.bridgelabz.greeting.greetinginitializer.model.User;
import java.util.List;

public interface IGreetingService {

    Greeting addGreeting(User user);
    Greeting getById(long id);
    List<Greeting> getOverallList();
    List<Greeting> getUpdatedListAfterDeletionById(long id);
    List<Greeting> getUpdatedListAfterDeletionByName(String fname);
    Greeting getMessageAfterModification(long id, String fName, String lName);

}
