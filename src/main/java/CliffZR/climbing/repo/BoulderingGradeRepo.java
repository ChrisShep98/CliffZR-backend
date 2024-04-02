package CliffZR.climbing.repo;


import CliffZR.climbing.models.BoulderingGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoulderingGradeRepo extends JpaRepository<BoulderingGrade, String> {
//    Optional<BoulderingGrades> findById(String id);
}
