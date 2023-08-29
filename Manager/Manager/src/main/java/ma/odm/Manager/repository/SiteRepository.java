package ma.odm.Manager.repository;

import ma.odm.Manager.Model.Patient;
import ma.odm.Manager.Model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SiteRepository extends JpaRepository<Site, Long> {
    void deleteSiteById(Long id);

    Optional<Site> findSiteById(Long id);
}
