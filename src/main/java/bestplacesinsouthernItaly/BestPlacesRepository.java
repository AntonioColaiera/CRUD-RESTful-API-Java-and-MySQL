package bestplacesinsouthernItaly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestPlacesRepository extends  JpaRepository<BestPlaces, Long>{

}
