import java.util.HashMap;

/**
 * Created by kisstheraik on 16/7/25.
 */
public class test {

    public static void main(String[] args){

        LineHashMap<String,Integer> listHashMap=new LineHashMap<>(97);

        listHashMap.put("zfy",12);
        listHashMap.put("ljw",23);
        listHashMap.put("zfy",29);

        System.out.println(listHashMap.get("zfy"));


    }
}
