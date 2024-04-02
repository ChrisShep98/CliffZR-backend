package CliffZR.climbing.models;

import CliffZR.climbing.constant.UserListener;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_DEFAULT) // doesn't show property values that are set to null for models
@Table(name = "users")
@EntityListeners(UserListener.class)
public class User {

    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    @Column(name = "username")
    private String username;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BoulderingGrade boulderingGrade;
//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "boulderingGrade_id", referencedColumnName = "id")
//private BoulderingGrade boulderingGrade;

    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }
//    @PrePersist
//    protected void onCreateBoulderingGrade(User user){
//        // Create a new bouldering grade for the user
//        boulderingGrade = new BoulderingGrade();
//        boulderingGrade.setStatus(false);
//        boulderingGrade.setImage("imageurlhere");
//        boulderingGrade.setTitle("v0");
//        boulderingGrade.setUser(user);
//        user.setBoulderingGrade(boulderingGrade);;
//    }
}
