/**
 * package Service;
 *
 *
 * import Model.SpazioVariabili;
 * import Repository.MeteoRepository;
 * import org.json.simple.parser.ParseException;
 * import org.springframework.scheduling.annotation.Scheduled;
 *
 * import java.io.IOException;
 * import java.util.Date;
 * import java.util.TimerTask;
 *
 * public class SchedulerInternet extends TimerTask {
 *     private String name;
 *
 *     MeteoRepository meteoRepository;
 *
 *     public SchedulerInternet(String name) throws IOException, ParseException {
 *
 *         this.name = name;
 *     }
 *
 *     @Override
 *     public void run(){
 *
 *        ;
 *         System.out.println(Thread.currentThread().getName()+" "+name+" the task has executed succesfully"+ new Date());
 *         if ("Task1".equalsIgnoreCase(name)){
 *             try {
 *                 Thread.sleep(10000);
 *             }catch (InterruptedException e){
 *                 e.printStackTrace();
 *             }
 *         }
 *     }
 * }
 */





