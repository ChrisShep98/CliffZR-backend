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
