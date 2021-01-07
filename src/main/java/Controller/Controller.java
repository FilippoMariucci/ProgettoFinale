package Controller;

//import Model.SpazioVariabili;
//import Repository.MeteoRepository;
//import Repository.MeteoService;

//import Service.SchedulerInternet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Timer;

@RestController
public class Controller {
    @RequestMapping("/hello")

    public @ResponseBody
    String hello(){
        return "Hello Wordlcfgvhbjnvhvh!";

    }


    /**   private final MeteoRepository meteoRepository;
     Controller(MeteoRepository repository) {
     meteoRepository = repository;
     }
     @GetMapping("\meteo")
     Iterable<SpazioVariabili> getOpenWeatherParse() {
     return meteoRepository.findAll();
     }
     @GetMapping("\meteo")
     Iterable<SpazioVariabili> getOpenWeatherParse(@PathVariable Long cityId) {
     return meteoRepository.findById(cityId).orElseThreow(); //sevre per l'eccezione, poi vado a creare la mia eccezione
     }
     @PostMapping("/note") //ritorna una nota
     Controller createNote(@ResponseBody Controller newNote) {
     return MeteoRepository.save(newNote);
     }
     @PutMapping("/note/{cityId}")
     Controller updateNote(@PathVariable long cityId, @RequestBody Controller noteDto){
     Controller noteToUpdate = meteoRepository.findById(cityId).orElseThrow();
     noteToUpdate.setTitle(noteDto.getTitle());
     noteToUpdate.setContent(noteDto.getContent());
     meteoRepository.save(noteToUpdate);
     return meteoRepository.save(noteToUpdate);
     }
     @DeleteMapping("/note/{cityId}")
     void deleteNote(@PathVariable long cityId){
     Controller note = meteoRepository.findById(cityId).orElseThrow();
     meteoRepository.delete(note);
     }
     }
     */



    /**
     * @Autowired
     *     private MeteoService meteoService;
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
     * @RequestMapping("/MIPIACELAFIGA1")
     *     public @ResponseBody
     *             SchedulerInternet si1{
     *         si1= new SchedulerInternet("Task1");
     *         t=new Timer();
     *         t.sche
     *
     *     }
     * @return
     *
     *
     *
     *
     *   MeteoRepository meteoRepository;
     *     @RequestMapping("/Var")
     *     public List<SpazioVariabili> allVariables(){
     *       var m1=new SpazioVariabili("3173435","it",278.71,279.82,279.26,275.98,"Milano");
     *       meteoRepository.save(m1);
     *         return (List<SpazioVariabili>) m1;
     *     }
     *
     *
     *
     *    @Autowired
     *     private IMeteoService articleService;
     *     @GetMapping("article/{id}")
     *     public ResponseEntity<SpazioVariabili> getArticleById(@PathVariable("id") Integer id) {
     *         SpazioVariabili meteo = articleService.getMeteoById(id);
     *         return new ResponseEntity<SpazioVariabili>(meteo, HttpStatus.OK);
     *     }
     *     @GetMapping("articles")
     *     public ResponseEntity<List<SpazioVariabili>> getAllArticles() {
     *         List<SpazioVariabili> list = articleService.getallMeteos();
     *         return new ResponseEntity<List<SpazioVariabili>>(list, HttpStatus.OK);
     *     }
     *     @PostMapping("article")
     *     public ResponseEntity<Void> addArticle(@RequestBody SpazioVariabili meteo, UriComponentsBuilder builder) {
     *         boolean flag = articleService.addMeteo(meteo);
     *         if (flag == false) {
     *             return new ResponseEntity<Void>(HttpStatus.CONFLICT);
     *         }
     *         HttpHeaders headers = new HttpHeaders();
     *         headers.setLocation(builder.path("/article/{id}").buildAndExpand(meteo.getValMax()).toUri());
     *         return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
     *     }
     *     @PutMapping("article")
     *     public ResponseEntity<SpazioVariabili> updateArticle(@RequestBody SpazioVariabili meteo) {
     *         articleService.updateMeteo(meteo);
     *         return new ResponseEntity<SpazioVariabili>(meteo, HttpStatus.OK);
     *     }
     *     @DeleteMapping("article/{id}")
     *     public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
     *         articleService.deleteMeteo(id);
     *         return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
     *     }
     *
     *
     *
     *
     *
     */
}
