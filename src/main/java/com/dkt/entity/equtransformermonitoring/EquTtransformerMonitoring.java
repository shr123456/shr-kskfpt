package com.dkt.entity.equtransformermonitoring;

/**
 * Created by Tom Sun on 2018/1/24.
 */
public class EquTtransformerMonitoring {

    private int ID;//变压器主键
    private String EQUIPMENT_NAME;//变压器名称
    private String CAPACITY; //变压器容量
    private String LOW_EQUIPMENT_NAME;//低压柜名称
    private String LOW_ID;//低压柜ID
    private String ELECTRICAL_ROOM_NAME;//电房名称
    private Double TOTAL_P_AT_EE;//低压柜总电量
    private Double LOAD_RATE;//负载率
    private Double TOTAL_P_AT_EE_MIN;

    private Double A_WINDING_TEMPERATURE;//a相绕阻温度
    private Double B_WINDING_TEMPERATURE;//b相绕阻温度
    private Double C_WINDING_TEMPERATURE;//c相绕阻温度
    private Double A_CORE_TEMPERATURE;//a相铁芯温度
    private Double B_CORE_TEMPERATURE;//b相铁芯温度
    private Double C_CORE_TEMPERATURE;//c相铁芯温度

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

    public String getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(String CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public String getLOW_EQUIPMENT_NAME() {
        return LOW_EQUIPMENT_NAME;
    }

    public void setLOW_EQUIPMENT_NAME(String LOW_EQUIPMENT_NAME) {
        this.LOW_EQUIPMENT_NAME = LOW_EQUIPMENT_NAME;
    }

    public String getLOW_ID() {
        return LOW_ID;
    }

    public void setLOW_ID(String LOW_ID) {
        this.LOW_ID = LOW_ID;
    }

    public String getELECTRICAL_ROOM_NAME() {
        return ELECTRICAL_ROOM_NAME;
    }

    public void setELECTRICAL_ROOM_NAME(String ELECTRICAL_ROOM_NAME) {
        this.ELECTRICAL_ROOM_NAME = ELECTRICAL_ROOM_NAME;
    }

    public Double getTOTAL_P_AT_EE() {
        return TOTAL_P_AT_EE;
    }
    public void setTOTAL_P_AT_EE(Double TOTAL_P_AT_EE) {
        this.TOTAL_P_AT_EE = TOTAL_P_AT_EE;
    }

    public Double getLOAD_RATE() {
        return LOAD_RATE;
    }

    public void setLOAD_RATE(Double LOAD_RATE) {
        this.LOAD_RATE = LOAD_RATE;
    }

    public Double getA_WINDING_TEMPERATURE() {
        return A_WINDING_TEMPERATURE;
    }

    public void setA_WINDING_TEMPERATURE(Double a_WINDING_TEMPERATURE) {
        A_WINDING_TEMPERATURE = a_WINDING_TEMPERATURE;
    }

    public Double getB_WINDING_TEMPERATURE() {
        return B_WINDING_TEMPERATURE;
    }

    public void setB_WINDING_TEMPERATURE(Double b_WINDING_TEMPERATURE) {
        B_WINDING_TEMPERATURE = b_WINDING_TEMPERATURE;
    }

    public Double getC_WINDING_TEMPERATURE() {
        return C_WINDING_TEMPERATURE;
    }

    public void setC_WINDING_TEMPERATURE(Double c_WINDING_TEMPERATURE) {
        C_WINDING_TEMPERATURE = c_WINDING_TEMPERATURE;
    }

    public Double getA_CORE_TEMPERATURE() {
        return A_CORE_TEMPERATURE;
    }

    public void setA_CORE_TEMPERATURE(Double a_CORE_TEMPERATURE) {
        A_CORE_TEMPERATURE = a_CORE_TEMPERATURE;
    }

    public Double getB_CORE_TEMPERATURE() {
        return B_CORE_TEMPERATURE;
    }

    public void setB_CORE_TEMPERATURE(Double b_CORE_TEMPERATURE) {
        B_CORE_TEMPERATURE = b_CORE_TEMPERATURE;
    }

    public Double getC_CORE_TEMPERATURE() {
        return C_CORE_TEMPERATURE;
    }

    public void setC_CORE_TEMPERATURE(Double c_CORE_TEMPERATURE) {
        C_CORE_TEMPERATURE = c_CORE_TEMPERATURE;
    }

    public Double getTOTAL_P_AT_EE_MIN() {
        return TOTAL_P_AT_EE_MIN;
    }

    public void setTOTAL_P_AT_EE_MIN(Double TOTAL_P_AT_EE_MIN) {
        this.TOTAL_P_AT_EE_MIN = TOTAL_P_AT_EE_MIN;
    }

}
