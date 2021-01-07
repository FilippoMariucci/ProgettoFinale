package Repository;

import Model.SpazioVariabili;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MeteoRepository extends CrudRepository<SpazioVariabili,Long> {


}
