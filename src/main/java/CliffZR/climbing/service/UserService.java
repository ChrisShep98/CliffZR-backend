package CliffZR.climbing.service;


import CliffZR.climbing.models.BoulderingGrade;
import CliffZR.climbing.models.User;
import CliffZR.climbing.repo.BoulderingGradeRepo;
import CliffZR.climbing.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public boolean existsByUsername(String username){
        return userRepo.findUserByUsername(username) != null;
    }

    public User createUser(User user) {

        return userRepo.save(user);
    }

    public User authenticate(String username, String password) {
        User user = userRepo.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Authentication failed
    }

    public List<BoulderingGrade> getUsersBoulderingGrades(String username){
        List<BoulderingGrade> boulderingGrades = userRepo.findUserByUsername(username).getBoulderingGrade();
        return boulderingGrades;
    }

    public List<User> getAllUsers(){
//        User users = userRepo.findUserByUsername(username);
        return userRepo.findAll();
    }

//    public boolean userExistsByUsername(String username){
//        return userRepo.findUserByUsername(username);
//    }


//    public User createUser(User user) {
//            return userRepo.save(user);
//        }
    };







