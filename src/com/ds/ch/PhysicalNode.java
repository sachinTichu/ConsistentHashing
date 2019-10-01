package com.ds.ch;

public class PhysicalNode implements Node
{
    public String hostName;
    public String ipAddress;
    public Integer portNumber;

    PhysicalNode(String aInHostName,String aInIpAdd,Integer aInPortNumber){
        this.hostName = aInHostName;
        this.ipAddress = aInIpAdd;
        this.portNumber = aInPortNumber;
    }

    public String getKey(){
        return hostName+"-"+ipAddress+":"+portNumber;
    }

    @Override
    public String toString() {
        return getKey();
    }
}
