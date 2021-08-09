package com.xiao.deng.map;

public class TraceMessage implements ArcherEvent{
    private String traceId;
    private Integer type  ;


    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String getId() {
        return "2";
    }

    public Integer getType() {
        throw new IllegalArgumentException("error type");
//        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
