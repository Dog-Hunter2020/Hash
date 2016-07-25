import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by kisstheraik on 16/7/25.
 * Description 基于线性探测法的hashmap的实现
 */
public class LineHashMap<K,V> {

    //存储list的数组
    private Map.Entry list[];
    private int M;

    private int N;

    public LineHashMap(int M){

        this.M=M;
        list=new Map.Entry[M];
        this.N=M;

    }

    //插入键值
    public void put(K key,V value){

        //当使用率超过1/2的时候增加大小到原来的两倍
        if(N>=M/2)resize(M*2);

        Map.Entry simpleEntry=new AbstractMap.SimpleEntry(key,value);

        int i=0;

        for(i=hash(key);list[i]!=null;i=(i+1)%M)
            if(list[i].getKey().equals(key))list[i].setValue(value);

        list[i]=simpleEntry;
        N++;


    }
    //根据key获取相应的value
    public V get(K key){



       for(int i=hash(key);list[i]!=null;i=(i+1)%M)
           if(list[i].getKey().equals(key))
               return (V)list[i].getValue();

        return null;


    }
    //获取相应的下标
    private int hash(K key){

        return (key.hashCode()&0x7fffffff)%M;

    }

    //重置数组大小
    private void resize(int size){
        Map.Entry[] rlist=new Map.Entry[size];

        for(int i=0;i<M;i++){
            rlist[i]=list[i];
        }

        list=rlist;

    }


}
