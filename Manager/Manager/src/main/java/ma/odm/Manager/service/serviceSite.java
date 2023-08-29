package ma.odm.Manager.service;

import jakarta.transaction.Transactional;
import ma.odm.Manager.Model.Site;
import ma.odm.Manager.exception.UserNotFoundException;
import ma.odm.Manager.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @Transactional
public class serviceSite {
    private final SiteRepository repository;

    @Autowired
    public serviceSite(SiteRepository repository) {
        this.repository = repository;
    }

    public Site addSite(Site site) {
        return repository.save(site);
    }

    public List<Site> findAllSites(){
        return repository.findAll();
    }

    public Site updateSite(Site site){
        return repository.save(site);
    }

    public Site findSiteById(Long id) throws Throwable {
        return repository.findSiteById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void deleteSite(Long id){
        repository.deleteSiteById(id);
    }
}
