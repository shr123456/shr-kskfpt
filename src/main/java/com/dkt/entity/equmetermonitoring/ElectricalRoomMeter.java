package com.dkt.entity.equmetermonitoring;

/**
 * Created by Tom Sun on 2018/1/18.
 */
public class ElectricalRoomMeter {

    private int EQU_ID;//设备 ID
    private int EQU_TYPE;//关联设备类型（0回路，1高压，2低压）
    private String METER_NAME;//电表名称
    private String GATEWAY_NO;//网关编号
    private String ELECTRICAL_ROOM_NAME;//电房名称

    public int getEQU_ID() {
        return EQU_ID;
    }

    public void setEQU_ID(int EQU_ID) {
        this.EQU_ID = EQU_ID;
    }

    public int getEQU_TYPE() {
        return EQU_TYPE;
    }

    public void setEQU_TYPE(int EQU_TYPE) {
        this.EQU_TYPE = EQU_TYPE;
    }

    public String getMETER_NAME() {
        return METER_NAME;
    }

    public void setMETER_NAME(String METER_NAME) {
        this.METER_NAME = METER_NAME;
    }

    public String getGATEWAY_NO() {
        return GATEWAY_NO;
    }

    public void setGATEWAY_NO(String GATEWAY_NO) {
        this.GATEWAY_NO = GATEWAY_NO;
    }

    public String getELECTRICAL_ROOM_NAME() {
        return ELECTRICAL_ROOM_NAME;
    }

    public void setELECTRICAL_ROOM_NAME(String ELECTRICAL_ROOM_NAME) {
        this.ELECTRICAL_ROOM_NAME = ELECTRICAL_ROOM_NAME;
    }

}
