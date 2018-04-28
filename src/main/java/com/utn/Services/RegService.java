package com.utn.Services;

import com.utn.Entities.Registry;
import com.utn.Repositories.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Matias on 26/04/2018.
 */
@Service
public class RegService{

    @Autowired
    RegRepository repository;


    public void  save(Registry reg){
        repository.save(reg);
    }

    public List<Registry> findAll(){
        return repository.findAll();
    }

    public List<Registry> findByBrowser(String Browser){
        return repository.findRegistriesByBrowser(Browser);
    }

    public List<Registry> findByOs(String Os){
        return repository.findRegistriesByOs(Os);
    }

    public Long countBrowser(String Browser){
        return repository.countRegistriesByBrowserEquals(Browser);
    }

    public Long countOs(String Os){
        return repository.countRegistriesByOsEquals(Os);
    }


}
