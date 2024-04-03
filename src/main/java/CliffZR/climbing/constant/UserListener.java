package CliffZR.climbing.constant;

import CliffZR.climbing.models.BoulderingGrade;
import CliffZR.climbing.models.User;
import jakarta.persistence.PrePersist;

import java.util.ArrayList;
import java.util.List;

public class UserListener {



    @PrePersist
    public void prePersist(User user) {
        String[] gradeTitles = {"v0", "v1", "v2", "v3"};
        List<BoulderingGrade> boulderingGrades = new ArrayList<>();
        for (String gradeTitle : gradeTitles) {
            BoulderingGrade boulderingGrade = new BoulderingGrade();
            boulderingGrade.setStatus(false);
            boulderingGrade.setImage("imageurlhere");
            boulderingGrade.setTitle(gradeTitle);
            boulderingGrade.setUser(user);
            boulderingGrades.add(boulderingGrade);

        }
        user.setBoulderingGrade(boulderingGrades);

    }
}


//@PrePersist
//public void prePersist(User user) {
//    String[] gradeTitles = {"v0", "v1", "v2", "v3"};
//    List<BoulderingGrade> boulderingGrades = new ArrayList<>();
//    for (String gradeTitle : gradeTitles) {
//        BoulderingGrade boulderingGrade = new BoulderingGrade();
//        boulderingGrade.setStatus(false);
//        boulderingGrade.setImage("imageurlhere");
//        boulderingGrade.setTitle(gradeTitle);
//        boulderingGrade.setUser(user);
//        boulderingGrades.add(boulderingGrade); // Add the bouldering grade to the list
//    }
//    user.setBoulderingGrade(boulderingGrades); // Set the list of bouldering grades to the user
//}


//String[] gradeTitles = {"v0", "v1", "v2", "v3"};
//        for (String gradeTitle : gradeTitles) {
//BoulderingGrade boulderingGrade = new BoulderingGrade();
//            boulderingGrade.setStatus(false);
//            boulderingGrade.setImage("imageurlhere");
//            boulderingGrade.setTitle(gradeTitle);
//            boulderingGrade.setUser(user);
//            user.getBoulderingGrades().add(boulderingGrade); // Add bouldering grade to the list
//            entityManager.persist(boulderingGrade); // Persist bouldering grade
//        }