package CliffZR.climbing.constant;

import CliffZR.climbing.models.BoulderingGrade;
import CliffZR.climbing.models.User;
import jakarta.persistence.PrePersist;

public class UserListener {

    @PrePersist
    public void prePersist(User user) {
        // Create a new bouldering grade for the user
        BoulderingGrade boulderingGrade = new BoulderingGrade();
        boulderingGrade.setStatus(false);
        boulderingGrade.setImage("imageurlhere");
        boulderingGrade.setTitle("v0");
        boulderingGrade.setUser(user);
        user.setBoulderingGrade(boulderingGrade);
    }
}
