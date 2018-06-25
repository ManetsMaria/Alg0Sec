package test.entity;

import main.entity.HostCounter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HostCounterTest {

    HostCounter hostCounter;
    String expected = "Host: host1, Count: 3\n"+
                        "Host: host3, Count: 2\n"+
                        "Host: host2, Count: 1\n";

    @BeforeMethod
    public void init(){
        hostCounter = new HostCounter();
        hostCounter.addHost("host1");
        hostCounter.addHost("host2");
        hostCounter.addHost("host3");
        hostCounter.addHost("host1");
        hostCounter.addHost("host1");
        hostCounter.addHost("host3");
    }

    @Test
    public void hostCounterSortTest(){
        Assert.assertEquals(hostCounter.getInDescendingOrder(), expected);
    }
}
