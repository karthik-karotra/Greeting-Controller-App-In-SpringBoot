package com.bridgelabz.greeting.greetinginitializer.service.implementors;

import com.bridgelabz.greeting.greetinginitializer.exceptions.GreetingException;
import com.bridgelabz.greeting.greetinginitializer.model.Greeting;
import com.bridgelabz.greeting.greetinginitializer.model.User;
import com.bridgelabz.greeting.greetinginitializer.repositories.IGreetingRepository;
import com.bridgelabz.greeting.greetinginitializer.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello  %s !";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "HELLO WORLD" : user.toString());
        Greeting greeting = new Greeting();
        greeting.setIncrementAndGet(counter.incrementAndGet());
        greeting.setFormat(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new GreetingException("No Greeting Found", GreetingException.ExceptionType.USER_NOT_FOUND));
    }

    @Override
    public List<Greeting> getOverallList() {
        return greetingRepository.findAll();
    }

    @Override
    public List<Greeting> getUpdatedListAfterDeletionById(long id) {
        Greeting greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new GreetingException("No Greeting Found", GreetingException.ExceptionType.USER_NOT_FOUND));
        greetingRepository.delete(greeting);
        return greetingRepository.findAll();

    }

    @Override
    public List<Greeting> getUpdatedListAfterDeletionByName(String fname) {
        List<Greeting> allGreeting = greetingRepository.findAll();
        Greeting greeting1 = allGreeting.stream()
                .filter(greeting -> greeting.getFormat().contains(fname))
                .findFirst()
                .orElseThrow(() -> new GreetingException("No Greeting Found", GreetingException.ExceptionType.USER_NOT_FOUND));
        greetingRepository.delete(greeting1);
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getMessageAfterModification(long id, String fName, String lName) {
        Greeting update = greetingRepository.findById(id).orElseThrow(() -> new GreetingException("No Greeting Found", GreetingException.ExceptionType.USER_NOT_FOUND));
        update.setFormat("Hello " + fName + " " + lName);
        return greetingRepository.save(update);
    }
}
