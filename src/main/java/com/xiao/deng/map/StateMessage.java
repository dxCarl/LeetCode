package com.xiao.deng.map;

public class StateMessage implements ArcherEvent{
    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getId() {
        return "1";
    }
}
