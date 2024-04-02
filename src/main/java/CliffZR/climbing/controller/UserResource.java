package CliffZR.climbing.controller;

import CliffZR.climbing.models.BoulderingGrade;
import CliffZR.climbing.models.User;
import CliffZR.climbing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        //return ResponseEntity.ok().body(contactService.createContact(contact));
        if(userService.existsByUsername(user.getUsername())){
            // deal with error handling
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            return ResponseEntity.created(URI.create("/users/userID")).body(userService.createUser(user));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(user);
    }

//    @GetMapping("/login")
//    public ResponseEntity<User> getContact(@PathVariable(value = "id") String id) {
//        return ResponseEntity.ok().body(userService.getContact(id));
//    }



}