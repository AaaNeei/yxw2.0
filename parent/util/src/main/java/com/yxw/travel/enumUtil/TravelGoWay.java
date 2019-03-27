package com.yxw.travel.enumUtil;

/**
 * @Author:阿倪
 * @Date: 2019/3/27 20:45
 * @Description:
 * @return:
 * @throws:
 */
public enum TravelGoWay {
    TRAVEL_GO_WAY_FOOT("徒步", 1),
    TRAVEL_GO_WAY_TRAIN("徒步", 2),
    TRAVEL_GO_WAY_CAR("汽车", 3),
    TRAVEL_GO_WAY_AIRCRAFT("飞机", 4),
    TRAVEL_GO_WAY_RIDING("骑行", 5),
    TRAVEL_GO_WAY_CRH("动车", 6),
    TRAVEL_GO_WAY_SELF("自驾", 1),
    TRAVEL_GO_WAY_OTHER("其他", 1),;

    TravelGoWay(String way, int value) {
        this.way = way;
        this.value = value;
    }

    private String way;
    private int value;

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
