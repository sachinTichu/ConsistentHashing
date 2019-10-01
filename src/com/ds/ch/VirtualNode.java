package com.ds.ch;

import java.security.PublicKey;

public class VirtualNode<T extends Node> implements Node
{
    public Integer index;
    public T pNode;

    VirtualNode(T inPNode,Integer index){
        this.pNode = inPNode;
        this.index = index;
    }

    public String getKey(){
        return pNode.getKey();
    }

    @Override
    public String toString() {
        return pNode.getKey();
    }
}
