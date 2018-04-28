package com.utn.Controllers;

//import com.utn.Repositories.JpaRepo;
import com.utn.Entities.Registry;
import com.utn.Services.RegService;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Matias on 24/04/2018.
 */
@RestController
@RequestMapping("/api")
public class RegController{

    @Autowired
    RegService service;

    @RequestMapping("/welcome")
    public Registry hi (@RequestHeader (value="User-Agent") String useragent){
        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
        ReadableUserAgent agent = parser.parse(useragent);
        parser.shutdown();
        Registry registry = new Registry();
        registry.setBrowser(agent.getName().toLowerCase());
        registry.setOs(agent.getOperatingSystem().getName().toLowerCase());
        service.save(registry);
        return registry;
    }

    @GetMapping("/all")
    public List<Registry> findAll(){ return service.findAll();}

    @GetMapping("/browser/mostused")
    public Object mostUsedBrowser(){
        Map<String,Long> hashmap = new HashMap<>();
        hashmap.put("chrome",service.countBrowser("chrome"));
        hashmap.put("firefox",service.countBrowser("firefox"));
        hashmap.put("edge",service.countBrowser("edge"));
        hashmap.put("opera",service.countBrowser("opera"));
        hashmap.put("safari",service.countBrowser("safari"));
        return this.getMax(hashmap);
    }

    @GetMapping("/os/mostused")
    public Object mostUsedOs(){
        Map<String,Long> hashmap= new HashMap<>();
        hashmap.put("windows",service.countOs("windows"));
        hashmap.put("mac",service.countOs("mac"));
        hashmap.put("unix",service.countOs("unix"));
        hashmap.put("chrome",service.countOs("chrome"));
        return this.getMax(hashmap);
    }

    @GetMapping("/browser/{BrowserName}")
    public Object getAllByBrowser(@PathVariable("BrowserName") String BrowserName){
        return service.findByBrowser(BrowserName);
    }

    @GetMapping("/os/{OsName}")
    public Object getAllByOs(@PathVariable("OsName") String OsName){
        return service.findByOs(OsName);
    }

    @GetMapping("/browser/{BrowserName}/count")
    public Object countBrowser(@PathVariable("BrowserName") String BrowserName){
        return service.countBrowser(BrowserName.toLowerCase());
    }

    @GetMapping("/os/{OsName}/count")
    public Object countOs(@PathVariable("OsName") String OsName){
        return service.countOs(OsName.toLowerCase());
    }


    public Object getMax(Map<String,Long> hashmap){
        Long max=0L;
        String key="";
        for (Map.Entry<String,Long> entry : hashmap.entrySet()) {
            if(entry.getValue()>max){
                key=entry.getKey();
                max=entry.getValue();
            }
        }
        return key;
    }
}
