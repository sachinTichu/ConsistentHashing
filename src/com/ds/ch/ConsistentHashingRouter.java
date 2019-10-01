package com.ds.ch;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashingRouter<T extends Node>
{
    private SortedMap<Long,Node> hashCircle;
    private HashingFunction hashFun;
    private int noOfVirtualNodes;

    ConsistentHashingRouter(HashingFunction hashFun,int virtualNodes){
        this.hashFun = hashFun;
        this.noOfVirtualNodes = virtualNodes;
        this.hashCircle = new TreeMap<Long,Node>();
    }

    public void addNode(T pNode){
        for(int i=0;i<noOfVirtualNodes;i++){
            Node node = new VirtualNode(pNode,i);

            String key = node.getKey();
            Long hashKey = hashFun.getHash(key);

            hashCircle.put(hashKey,node);
        }
    }

    public void removeNode(T pNode){
        Iterator<Long> it = hashCircle.keySet().iterator();

        while(it.hasNext())
        {
            Long hashKey = it.next();
            Node virtNode = hashCircle.get(hashKey);

            if(virtNode.getKey().equals(pNode.getKey())){
                hashCircle.remove(hashKey);
            }
        }
    }

    public Node getRoute(String key){
        Long hashKey = hashFun.getHash(key);

        if (hashCircle.containsKey(hashKey)){
            return hashCircle.get(hashKey);
        }

        SortedMap<Long,Node> tailMap = hashCircle.tailMap(hashKey);

        Long lKey = !tailMap.isEmpty() ? tailMap.firstKey() : hashCircle.firstKey();

        return hashCircle.get(lKey);
    }
}
