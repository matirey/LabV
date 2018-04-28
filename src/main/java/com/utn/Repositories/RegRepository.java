package com.utn.Repositories;

import com.utn.Entities.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Matias on 26/04/2018.
 */
@Repository
public interface RegRepository extends JpaRepository<Registry,Long> {
   List<Registry> findRegistriesByBrowser(String Browser);
   List<Registry> findRegistriesByOs(String Os);
   Long countRegistriesByBrowserEquals (String Browser);
   Long countRegistriesByOsEquals (String Os);

}
