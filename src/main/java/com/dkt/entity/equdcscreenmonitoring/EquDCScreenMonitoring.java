package com.dkt.entity.equdcscreenmonitoring;

/**
 * Created by Tom Sun on 2018/1/24.
 */
public class EquDCScreenMonitoring {
    private int ID;//设备 ID
    private String EQUIPMENT_NAME;//设备名称
    private String ELECTRICAL_ROOM_NAME;//电房名称

    private Double MOTHER_CONTROL_UNDERVOLTAGE; //控制母线欠压
    private Double MOTHER_CONTROL_OVERVOLTAGE; //控制母线过压
    private Double MOTHER_CONTROL_ELECTRICITY;  //控制母线电流
    private Double MOTHER_CONTROL_VOLTAGE; //控制母线电压

    private Double MOTHER_CLOSING_VOLTAGE; //合闸母线电压
    private Double MOTHER_CLOSING_UNDERVOLTAGE; //合闸母线欠压
    private Double MOTHER_CLOSING_OVERVOLTAGE; //合闸母线过压
    private Double MOTHER_CLOSING_ELECTRICITY; //合闸母线电流

    private Double RECHARGEABLE_BATTERY_CURRENT; //充电电池电流
    private Double BATTERY_VOLTAGE_ONE; //1#电池单元电压
    private Double BATTERY_VOLTAGE_TWO; //2#电池单元电压
    private Double BATTERY_TEMPERATURE_ONE; //1#电池单元温度
    private Double BATTERY_TEMPERATURE_TWO; //1#电池单元温度

    private int VOLTAGE_LEVEL; //电压等级
    private int UPS_WORK;//UPS工作(0正常)
    private int FAILURE_STATE;//故障状态(0无故障)

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEQUIPMENT_NAME() {
        return EQUIPMENT_NAME;
    }

    public void setEQUIPMENT_NAME(String EQUIPMENT_NAME) {
        this.EQUIPMENT_NAME = EQUIPMENT_NAME;
    }

    public String getELECTRICAL_ROOM_NAME() {
        return ELECTRICAL_ROOM_NAME;
    }

    public void setELECTRICAL_ROOM_NAME(String ELECTRICAL_ROOM_NAME) {
        this.ELECTRICAL_ROOM_NAME = ELECTRICAL_ROOM_NAME;
    }

    public int getUPS_WORK() {
        return UPS_WORK;
    }

    public void setUPS_WORK(int UPS_WORK) {
        this.UPS_WORK = UPS_WORK;
    }

    public int getFAILURE_STATE() {
        return FAILURE_STATE;
    }

    public void setFAILURE_STATE(int FAILURE_STATE) {
        this.FAILURE_STATE = FAILURE_STATE;
    }

    public Double getMOTHER_CONTROL_UNDERVOLTAGE() {
        return MOTHER_CONTROL_UNDERVOLTAGE;
    }

    public void setMOTHER_CONTROL_UNDERVOLTAGE(Double MOTHER_CONTROL_UNDERVOLTAGE) {
        this.MOTHER_CONTROL_UNDERVOLTAGE = MOTHER_CONTROL_UNDERVOLTAGE;
    }

    public Double getMOTHER_CONTROL_OVERVOLTAGE() {
        return MOTHER_CONTROL_OVERVOLTAGE;
    }

    public void setMOTHER_CONTROL_OVERVOLTAGE(Double MOTHER_CONTROL_OVERVOLTAGE) {
        this.MOTHER_CONTROL_OVERVOLTAGE = MOTHER_CONTROL_OVERVOLTAGE;
    }

    public Double getMOTHER_CONTROL_ELECTRICITY() {
        return MOTHER_CONTROL_ELECTRICITY;
    }

    public void setMOTHER_CONTROL_ELECTRICITY(Double MOTHER_CONTROL_ELECTRICITY) {
        this.MOTHER_CONTROL_ELECTRICITY = MOTHER_CONTROL_ELECTRICITY;
    }

    public Double getMOTHER_CONTROL_VOLTAGE() {
        return MOTHER_CONTROL_VOLTAGE;
    }

    public void setMOTHER_CONTROL_VOLTAGE(Double MOTHER_CONTROL_VOLTAGE) {
        this.MOTHER_CONTROL_VOLTAGE = MOTHER_CONTROL_VOLTAGE;
    }

    public Double getMOTHER_CLOSING_VOLTAGE() {
        return MOTHER_CLOSING_VOLTAGE;
    }

    public void setMOTHER_CLOSING_VOLTAGE(Double MOTHER_CLOSING_VOLTAGE) {
        this.MOTHER_CLOSING_VOLTAGE = MOTHER_CLOSING_VOLTAGE;
    }

    public Double getMOTHER_CLOSING_UNDERVOLTAGE() {
        return MOTHER_CLOSING_UNDERVOLTAGE;
    }

    public void setMOTHER_CLOSING_UNDERVOLTAGE(Double MOTHER_CLOSING_UNDERVOLTAGE) {
        this.MOTHER_CLOSING_UNDERVOLTAGE = MOTHER_CLOSING_UNDERVOLTAGE;
    }

    public Double getMOTHER_CLOSING_OVERVOLTAGE() {
        return MOTHER_CLOSING_OVERVOLTAGE;
    }

    public void setMOTHER_CLOSING_OVERVOLTAGE(Double MOTHER_CLOSING_OVERVOLTAGE) {
        this.MOTHER_CLOSING_OVERVOLTAGE = MOTHER_CLOSING_OVERVOLTAGE;
    }

    public Double getMOTHER_CLOSING_ELECTRICITY() {
        return MOTHER_CLOSING_ELECTRICITY;
    }

    public void setMOTHER_CLOSING_ELECTRICITY(Double MOTHER_CLOSING_ELECTRICITY) {
        this.MOTHER_CLOSING_ELECTRICITY = MOTHER_CLOSING_ELECTRICITY;
    }

    public Double getRECHARGEABLE_BATTERY_CURRENT() {
        return RECHARGEABLE_BATTERY_CURRENT;
    }

    public void setRECHARGEABLE_BATTERY_CURRENT(Double RECHARGEABLE_BATTERY_CURRENT) {
        this.RECHARGEABLE_BATTERY_CURRENT = RECHARGEABLE_BATTERY_CURRENT;
    }

    public Double getBATTERY_VOLTAGE_ONE() {
        return BATTERY_VOLTAGE_ONE;
    }

    public void setBATTERY_VOLTAGE_ONE(Double BATTERY_VOLTAGE_ONE) {
        this.BATTERY_VOLTAGE_ONE = BATTERY_VOLTAGE_ONE;
    }

    public Double getBATTERY_VOLTAGE_TWO() {
        return BATTERY_VOLTAGE_TWO;
    }

    public void setBATTERY_VOLTAGE_TWO(Double BATTERY_VOLTAGE_TWO) {
        this.BATTERY_VOLTAGE_TWO = BATTERY_VOLTAGE_TWO;
    }

    public Double getBATTERY_TEMPERATURE_ONE() {
        return BATTERY_TEMPERATURE_ONE;
    }

    public void setBATTERY_TEMPERATURE_ONE(Double BATTERY_TEMPERATURE_ONE) {
        this.BATTERY_TEMPERATURE_ONE = BATTERY_TEMPERATURE_ONE;
    }

    public Double getBATTERY_TEMPERATURE_TWO() {
        return BATTERY_TEMPERATURE_TWO;
    }

    public void setBATTERY_TEMPERATURE_TWO(Double BATTERY_TEMPERATURE_TWO) {
        this.BATTERY_TEMPERATURE_TWO = BATTERY_TEMPERATURE_TWO;
    }

    public int getVOLTAGE_LEVEL() {
        return VOLTAGE_LEVEL;
    }

    public void setVOLTAGE_LEVEL(int VOLTAGE_LEVEL) {
        this.VOLTAGE_LEVEL = VOLTAGE_LEVEL;
    }

}
