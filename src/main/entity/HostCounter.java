package main.entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HostCounter extends HashMap<String, Host> {

    // counting host frequency, in saving think about fast access with host name not with frequency
    public boolean addHost(String host){
        if (host == null){
            return false;
        }
        if (!containsKey(host)){
            put(host, new Host(host));
        }
        get(host).increment();
        return true;
    }

    // copy Hosts into List and sort with frequency after sorting request
    public String getInDescendingOrder(){
        List<Host> hostList = new ArrayList<>(values());
        hostList.sort((a, b) -> (b.getCount() - a.getCount()));
        StringBuilder stringBuilder = new StringBuilder();
        for (Host h: hostList){
            stringBuilder.append(h.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
