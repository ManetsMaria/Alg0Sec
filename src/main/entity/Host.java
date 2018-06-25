package main.entity;

import main.constant.StringConstant;

import java.util.Objects;

public class Host {
    private String host;
    private int count;


    public Host(String host) {
        this.host = host;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host1 = (Host) o;
        return Objects.equals(host, host1.host);
    }

    @Override
    public int hashCode() {

        return Objects.hash(host);
    }

    @Override
    public String toString() {
        return StringConstant.HOST + host +","+
                StringConstant.COUNT + count;
    }

    public void increment(){
        count++;
    }

    public String getHost() {
        return host;
    }

    public int getCount() {
        return count;
    }
}
