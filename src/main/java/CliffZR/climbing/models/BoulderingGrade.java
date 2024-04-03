package CliffZR.climbing.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Table(name = "boulderingGrade")
public class BoulderingGrade {

    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    public String title;
    public String image;
    public boolean status = false;
    @JsonBackReference
    @ManyToOne
//    @JoinColumn(name = "user_id")
    // above was the initial way of keying specific boulderingRoutes to a user but threw "key already exists" error so going to keep below code unless problems arise from it
    @JoinColumn(name = "key_of_user")
    private User user;

}


