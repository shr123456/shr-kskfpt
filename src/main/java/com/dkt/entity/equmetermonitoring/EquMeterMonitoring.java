package com.dkt.entity.equmetermonitoring;

/**
 * Created by Tom Sun on 2018/1/15.
 */
public class EquMeterMonitoring {

    private int ID;//设备主键
    private Double TOTAL_P_AT_EE;//3相正向有功电能(电量)
    private Double A_ELECTRICITY;//A相电流
    private Double B_ELECTRICITY;//相电流
    private Double C_ELECTRICITY;//C相电流
    private Double A_VOLTAGE;//A相电压
    private Double B_VOLTAGE;//B相电压
    private Double C_VOLTAGE;//C相电压
    private Double TOTAL_POWER_FACTOR;//总功率因数
    private Double TOTAL_ACTIVE_POWER;//3相总有功功率(高压)
    private Double TOTAL_REACTIVE_POWER;//3相总无功功率(高压)
    private Double FREQUENCY;//频率
    private Double TOTAL_AP_REAT_EE;//3相总无功电能(无功电量)
    private int TEMPERATURE_ON_TYPE;
    private Double IF_INTO_LINE;//是否进线 0 不是  1是
    private String EQUIPMENT_NAME;//设备名称
    private String METER_NAME;//关联电表名称
    private int EQU_TYPE;//关联设备类型
    private String GATEWAY_NO;//关联电表网关
    private String ELECTRICAL_ROOM_NAME;//电房名称
    private String METER_ID;//电表主键
    private Double UAB_LINE_VOLTAGE; //A,B两相线电压
    private Double UBC_LINE_VOLTAGE; //B,C两相线电压
    private Double UAC_LINE_VOLTAGE; //A,C两相线电压
    private String C_T_RATIO;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Double getTOTAL_P_AT_EE() {
        return TOTAL_P_AT_EE;
    }

    public void setTOTAL_P_AT_EE(Double TOTAL_P_AT_EE) {
        this.TOTAL_P_AT_EE = TOTAL_P_AT_EE;
    }

    public Double getTOTAL_POWER_FACTOR() {
        return TOTAL_POWER_FACTOR;
    }

    public void setTOTAL_POWER_FACTOR(Double TOTAL_POWER_FACTOR) {
        this.TOTAL_POWER_FACTOR = TOTAL_POWER_FACTOR;
    }

    public Double getTOTAL_ACTIVE_POWER() {
        return TOTAL_ACTIVE_POWER;
    }

    public void setTOTAL_ACTIVE_POWER(Double TOTAL_ACTIVE_POWER) {
        this.TOTAL_ACTIVE_POWER = TOTAL_ACTIVE_POWER;
    }

    public Double getTOTAL_REACTIVE_POWER() {
        return TOTAL_REACTIVE_POWER;
    }

    public void setTOTAL_REACTIVE_POWER(Double TOTAL_REACTIVE_POWER) {
        this.TOTAL_REACTIVE_POWER = TOTAL_REACTIVE_POWER;
    }

    public Double getA_ELECTRICITY() {
        return A_ELECTRICITY;
    }

    public void setA_ELECTRICITY(Double a_ELECTRICITY) {
        A_ELECTRICITY = a_ELECTRICITY;
    }

    public Double getB_ELECTRICITY() {
        return B_ELECTRICITY;
    }

    public void setB_ELECTRICITY(Double b_ELECTRICITY) {
        B_ELECTRICITY = b_ELECTRICITY;
    }

    public Double getC_ELECTRICITY() {
        return C_ELECTRICITY;
    }

    public void setC_ELECTRICITY(Double c_ELECTRICITY) {
        C_ELECTRICITY = c_ELECTRICITY;
    }

    public Double getA_VOLTAGE() {
        return A_VOLTAGE;
    }

    public void setA_VOLTAGE(Double a_VOLTAGE) {
        A_VOLTAGE = a_VOLTAGE;
    }

    public Double getB_VOLTAGE() {
        return B_VOLTAGE;
    }

    public void setB_VOLTAGE(Double b_VOLTAGE) {
        B_VOLTAGE = b_VOLTAGE;
    }

    public Double getC_VOLTAGE() {
        return C_VOLTAGE;
    }

    public void setC_VOLTAGE(Double c_VOLTAGE) {
        C_VOLTAGE = c_VOLTAGE;
    }

    public Double getIF_INTO_LINE() {
        return IF_INTO_LINE;
    }

    public void setIF_INTO_LINE(Double IF_INTO_LINE) {
        this.IF_INTO_LINE = IF_INTO_LINE;
    }

    public String getEQUIPMENT_NAME() {
        return EQUIPMENT_NAME;
    }

    public void setEQUIPMENT_NAME(String EQUIPMENT_NAME) {
        this.EQUIPMENT_NAME = EQUIPMENT_NAME;
    }

    public String getGATEWAY_NO() {
        return GATEWAY_NO;
    }

    public void setGATEWAY_NO(String GATEWAY_NO) {
        this.GATEWAY_NO = GATEWAY_NO;
    }

    public String getMETER_NAME() {
        return METER_NAME;
    }

    public void setMETER_NAME(String METER_NAME) {
        this.METER_NAME = METER_NAME;
    }

    public String getELECTRICAL_ROOM_NAME() {
        return ELECTRICAL_ROOM_NAME;
    }

    public void setELECTRICAL_ROOM_NAME(String ELECTRICAL_ROOM_NAME) {
        this.ELECTRICAL_ROOM_NAME = ELECTRICAL_ROOM_NAME;
    }

    public int getEQU_TYPE() {
        return EQU_TYPE;
    }
    public void setEQU_TYPE(int EQU_TYPE) {
        this.EQU_TYPE = EQU_TYPE;
    }

    public Double getTOTAL_AP_REAT_EE() {
        return TOTAL_AP_REAT_EE;
    }

    public void setTOTAL_AP_REAT_EE(Double TOTAL_AP_REAT_EE) {
        this.TOTAL_AP_REAT_EE = TOTAL_AP_REAT_EE;
    }

    public Double getFREQUENCY() {
        return FREQUENCY;
    }

    public void setFREQUENCY(Double FREQUENCY) {
        this.FREQUENCY = FREQUENCY;
    }

    public int getTEMPERATURE_ON_TYPE() {
        return TEMPERATURE_ON_TYPE;
    }

    public void setTEMPERATURE_ON_TYPE(int TEMPERATURE_ON_TYPE) {
        this.TEMPERATURE_ON_TYPE = TEMPERATURE_ON_TYPE;
    }

    public String getMETER_ID() {
        return METER_ID;
    }

    public void setMETER_ID(String METER_ID) {
        this.METER_ID = METER_ID;
    }

    public Double getUAB_LINE_VOLTAGE() {
        return UAB_LINE_VOLTAGE;
    }

    public void setUAB_LINE_VOLTAGE(Double UAB_LINE_VOLTAGE) {
        this.UAB_LINE_VOLTAGE = UAB_LINE_VOLTAGE;
    }

    public Double getUBC_LINE_VOLTAGE() {
        return UBC_LINE_VOLTAGE;
    }

    public void setUBC_LINE_VOLTAGE(Double UBC_LINE_VOLTAGE) {
        this.UBC_LINE_VOLTAGE = UBC_LINE_VOLTAGE;
    }

    public Double getUAC_LINE_VOLTAGE() {
        return UAC_LINE_VOLTAGE;
    }

    public void setUAC_LINE_VOLTAGE(Double UAC_LINE_VOLTAGE) {
        this.UAC_LINE_VOLTAGE = UAC_LINE_VOLTAGE;
    }

    public String getC_T_RATIO() {
        return C_T_RATIO;
    }

    public void setC_T_RATIO(String c_T_RATIO) {
        C_T_RATIO = c_T_RATIO;
    }
}



