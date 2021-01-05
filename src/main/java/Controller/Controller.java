package Controller;

import Model.SpazioVariabili;
import Repository.MeteoRepository;
//import Repository.MeteoService;
import Service.SchedulerInternet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Timer;

@RestController
public class Controller {
    @RequestMapping("/hello")

    public @ResponseBody
    String hello(){
        return "Hello Wordlcfgvhbjnvhvh!";
    }

    /**
     * ù@Autowired
     *     private MeteoService meteoService;
     *
     */

   /* @RequestMapping("/MIPIACELAFIGA1")
    public @ResponseBody
            SchedulerInternet si1{
        si1= new SchedulerInternet("Task1");
        t=new Timer();
        t.sche

    }*/






    /**
     *
     *   @Autowired
     *     MeteoRepository meteoRepository;
     *
     *
     *     @RequestMapping (" / Variabili ")
     *     public List<SpazioVariabili> allVariables(){
     *         var u1= new SpazioVariabili("3173435","it",278.71,279.82,279.26,275.98,"Milano");
     *         meteoRepository.save(u1);
     *         return (List<SpazioVariabili>) u1;
     *     }
     *
     * @GetMapping("/Variables/count")
     *     public Long count(){
     *         return .count();
     *     }
     *
     *     @DeleteMapping("/Variables/{id}")
     *     public void delete(@PathVariable String id){
     *         Long VariablesId=Long.parseLong(id);
     *         meteoService.deleteById(VariablesId);
     *     }
     *
     * @return
     */



}
