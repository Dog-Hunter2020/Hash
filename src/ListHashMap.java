import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by kisstheraik on 16/7/25.
 * Description 基于拉链法的hashmap实现
 */
public class ListHashMap<K,V> {

    //用于存储数据的链表
    private LinkedList<Map.Entry<K,V>>[] list;

    private int M;

    public ListHashMap(int M){

        this.M=M;
        list=(LinkedList<Map.Entry<K,V>>[])new LinkedList[M];

        for(int i=0;i<M;i++)
            list[i]=new LinkedList<>();

    }

    //向链表插入键值对
    public void put(K key,V value){

        list[hash(key)].add(new AbstractMap.SimpleEntry<K, V>(key,value));


    }

    //根据key获取相应的value
    public V  get(K key){

        Iterator iterator=list[hash(key)].iterator();

        while(iterator.hasNext()){
            Map.Entry tmp=(Map.Entry)iterator.next();
            if(tmp.getKey().equals(key))
                return (V)tmp.getValue();
        }

        return null;
    }

    //获取相应的hash数组下标
    private int hash(K key){
        return (key.hashCode()&0x7fffffff)%M;
    }

}
