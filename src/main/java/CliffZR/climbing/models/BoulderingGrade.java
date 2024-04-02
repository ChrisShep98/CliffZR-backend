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
    public boolean status;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}


