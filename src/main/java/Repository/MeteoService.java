/**package Repository;


import Model.SpazioVariabili;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service

public class MeteoService {
    @Autowired
    private MeteoRepository meteoRepository;

    public List<SpazioVariabili> findAll(){
        var it=meteoRepository.findAll();
        var Variables = new ArrayList<SpazioVariabili>();
        it.forEach(e -> Variables.add(e));

        return Variables;
    }

    public Long count() {

        return meteoRepository.count();
    }

    public void deleteById(Long userId) {

        meteoRepository.deleteById(userId);
    }
}*/
