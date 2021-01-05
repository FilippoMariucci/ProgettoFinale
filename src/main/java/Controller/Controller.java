package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/hello")

    public @ResponseBody
    String hello(){
        return "Hello Wordl!";
    }

    /*@Autowired
    private MeteoService meteoService;

    @GetMapping("/Variabili")
    public List<SpazioVariabili> allVariables(){
        return meteoService.findAll();
    }

    @GetMapping("/Variables/count")
    public Long count(){
        return meteoService.count();
    }

    @DeleteMapping("/Variables/{id}")
    public void delete(@PathVariable String id){
        Long VariablesId=Long.parseLong(id);
        meteoService.deleteById(VariablesId);
    }

*/
}
