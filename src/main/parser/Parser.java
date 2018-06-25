package main.parser;

import main.entity.HostCounter;
import main.constant.StringConstant;

import java.util.Set;

//universal for any log input type
public abstract class Parser {
    private int hostIndex;

    private HostCounter hostCounter;

    public Parser(){
        hostIndex = -1;
        hostCounter = new HostCounter();
    }

    public String getCurrentDescendingOrderCountHost(){
        return hostCounter.getInDescendingOrder();
    }

    //for client doesn't matter what information type line contains
    //support different file format
    public abstract void analyzeNextLine(String line);

    //for tests
    public int getHostIndex() {
        return hostIndex;
    }

    //for tests
    public Set<String> getAllUniqueHosts(){
        return hostCounter.keySet();
    }

    protected void setHostOrder(String line){
        LineParser fieldsParser = new LineParser(line);
        hostIndex =  fieldsParser.findPlace(StringConstant.CS_HOST);
    }

    protected boolean addHostFromLine(String line){
        if (hostIndex < 0){
            return false;
        }
        LineParser lineParser = new LineParser(line);
        String host = lineParser.findWord(hostIndex);
        if ("-".equals(host)){
            return false;
        }
        return hostCounter.addHost(host);
    }
}
