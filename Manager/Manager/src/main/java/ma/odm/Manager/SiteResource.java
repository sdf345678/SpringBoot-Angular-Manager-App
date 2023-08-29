package ma.odm.Manager;

import ma.odm.Manager.Model.Site;
import ma.odm.Manager.service.serviceSite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
@CrossOrigin("*")
public class SiteResource {
    private final serviceSite siteServiceSite;

    public SiteResource(serviceSite siteServiceSite) {
        this.siteServiceSite = siteServiceSite;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Site>> getAllSites (){
        List<Site> Sites = siteServiceSite.findAllSites();
        return new ResponseEntity<>(Sites, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Site> getSiteById (@PathVariable("id") Long id) throws Throwable {
        Site site = siteServiceSite.findSiteById(id);
        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Site> addSite (@RequestBody Site site) throws Throwable {
        Site sitenew = siteServiceSite.addSite(site) ;
        return new ResponseEntity<>(sitenew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Site> updateSite (@RequestBody Site site) throws Throwable {
        Site siteupdate = siteServiceSite.updateSite(site) ;
        return new ResponseEntity<>(siteupdate, HttpStatus.OK);
    }

    @DeleteMapping(value ="/delete/{id}")
    public void deleteSite (@PathVariable Long id)  {
        siteServiceSite.deleteSite(id);
    }
}
