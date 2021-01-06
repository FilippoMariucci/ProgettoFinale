/**package Service;

import Model.SpazioVariabili;
import Repository.MeteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeteoService implements IMeteoService{
    //@Autowired
    private MeteoRepository meteoRepository;


    public SpazioVariabili getMeteoeById(long articleId) {
        SpazioVariabili obj = meteoRepository.findById(articleId).get();
        return obj;
    }

    public List<SpazioVariabili> getAllArticles(){
        List<SpazioVariabili> list = new ArrayList<>();
        meteoRepository.findAll().forEach(e -> list.add(e));
        return list;
    }



    public void updateArticle(SpazioVariabili meteo) {
        meteoRepository.save(meteo);
    }

    public void deleteArticle(int articleId) {
       meteoRepository.delete(getMeteoById(articleId));
    }

    @Override
    public List<SpazioVariabili> getallMeteos() {
        return null;
    }

    @Override
    public SpazioVariabili getMeteoById(long meteoId) {
        return null;
    }

    @Override
    public boolean addMeteo(SpazioVariabili meteo) {
        return false;
    }

    @Override
    public void updateMeteo(SpazioVariabili meteo) {

    }

    @Override
    public void deleteMeteo(int meteoid) {

    }
}
*/