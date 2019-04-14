package com.yxw.travel.enumUtil;

/**
 * @Author:阿倪
 * @Date: 2019/3/24 21:47
 * @Description:
 * @return:
 * @throws:
 */
public enum  TravelGroupState {

    TRAVEL_GROUP_STATE_WAITING("待发布", 1),
    TRAVEL_GROUP_STATE_START("已发布", 2),
    TRAVEL_GROUP_STATE_TEAMING("组队中", 3),
    TRAVEL_GROUP_STATE_FINISH("完成组队", 4),
    TRAVEL_GROUP_STATE_OVERTIME("超时", 5),
    TRAVEL_GROUP_STATE_CANCEL_FINISH_BEFORE("完成组队前取消", 6),
    TRAVEL_GROUP_STATE_CANCEL("超时取消", 7),
    TRAVEL_GROUP_STATE_CANCEL_FINISH_LATER("完成组队后取消", 8),
    TRAVEL_GROUP_STATE_OTHER("其他", 9);

    TravelGroupState(String state, int value) {
        this.state = state;
        this.value = value;
    }

    private String state;
    private int value;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
