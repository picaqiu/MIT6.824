package org.mit.map_reduce.common;

public enum TaskStatus {
    IDLE("idle"),//空闲
    IN_PROGRESS("progressing"),
    FAILED("failed"),
    DONE("done");

    private String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
