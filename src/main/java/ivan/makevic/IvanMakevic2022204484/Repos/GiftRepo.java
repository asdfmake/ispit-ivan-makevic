package ivan.makevic.IvanMakevic2022204484.Repos;

import ivan.makevic.IvanMakevic2022204484.Entities.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepo extends JpaRepository<GiftEntity, Long> {
}
