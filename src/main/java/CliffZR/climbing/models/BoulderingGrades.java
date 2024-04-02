//package CliffZR.climbing.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.UuidGenerator;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
////@JsonInclude(JsonInclude.Include.NON_DEFAULT) // doesn't show property values that are set to null for models
//@Table(name = "boulderingGrades")
//public class BoulderingGrades {
//    @Id
//    @UuidGenerator
//    @Column(name = "id", unique = true, updatable = false)
//    private String id;
//    private String title;
//    private String status;
//    private String photoUrl;
////    @OneToOne(mappedBy = "parent")
////    private BoulderingGrade child;
//
//
//}
