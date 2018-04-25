package com.dkt.entity.equmicromonitoring;

import org.apache.james.mime4j.field.datetime.DateTime;

/**
 * Created by Tom Sun on 2018/1/31.
 */
public class EquMicroMonitoring {

    private int ID;//设备主键
    private Double A_ELECTRICITY;//A相电流
    private Double B_ELECTRICITY;//相电流
    private Double C_ELECTRICITY;//C相电流
    private Double A_VOLTAGE;//A相电压
    private Double B_VOLTAGE;//B相电压
    private Double C_VOLTAGE;//C相电压
    private Double A_LOAD;//A相负荷
    private Double B_LOAD;//B相负荷
    private Double C_LOAD;//C相负荷
    private Double LOSS_PRESSURE_PROTECTION;//失压保护
    private Double OVERVOLTAGE_PROTECTION;//过电压保护
    private Double Z_E_P_THRESHOLD;//零序电流保护阀值
    private String S_O_E;//SOE事件记录
    private String EQUIPMENT_NAME;//设备名称
    private String ELECTRICAL_ROOM_NAME;//电房名称
    private Double OVERLOAD_PROTECTION;//过负荷保护
    private Double THREE_OVERCURRENT_PROTECTION;//三段过流保护
    private Double UAB_LINE_VOLTAGE; //A,B两相线电压
    private Double UBC_LINE_VOLTAGE; //B,C两相线电压
    private Double UAC_LINE_VOLTAGE; //A,C两相线电压

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Double getA_LOAD() {
        return A_LOAD;
    }

    public void setA_LOAD(Double a_LOAD) {
        A_LOAD = a_LOAD;
    }

    public Double getB_LOAD() {
        return B_LOAD;
    }

    public void setB_LOAD(Double b_LOAD) {
        B_LOAD = b_LOAD;
    }

    public Double getC_LOAD() {
        return C_LOAD;
    }

    public void setC_LOAD(Double c_LOAD) {
        C_LOAD = c_LOAD;
    }

    public Double getLOSS_PRESSURE_PROTECTION() {
        return LOSS_PRESSURE_PROTECTION;
    }

    public void setLOSS_PRESSURE_PROTECTION(Double LOSS_PRESSURE_PROTECTION) {
        this.LOSS_PRESSURE_PROTECTION = LOSS_PRESSURE_PROTECTION;
    }

    public Double getOVERVOLTAGE_PROTECTION() {
        return OVERVOLTAGE_PROTECTION;
    }

    public void setOVERVOLTAGE_PROTECTION(Double OVERVOLTAGE_PROTECTION) {
        this.OVERVOLTAGE_PROTECTION = OVERVOLTAGE_PROTECTION;
    }

    public Double getZ_E_P_THRESHOLD() {
        return Z_E_P_THRESHOLD;
    }

    public void setZ_E_P_THRESHOLD(Double z_E_P_THRESHOLD) {
        Z_E_P_THRESHOLD = z_E_P_THRESHOLD;
    }

    public String getS_O_E() {
        return S_O_E;
    }

    public void setS_O_E(String s_O_E) {
        S_O_E = s_O_E;
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

    public Double getTHREE_OVERCURRENT_PROTECTION() {
        return THREE_OVERCURRENT_PROTECTION;
    }

    public void setTHREE_OVERCURRENT_PROTECTION(Double THREE_OVERCURRENT_PROTECTION) {
        this.THREE_OVERCURRENT_PROTECTION = THREE_OVERCURRENT_PROTECTION;
    }

    public Double getOVERLOAD_PROTECTION() {
        return OVERLOAD_PROTECTION;
    }

    public void setOVERLOAD_PROTECTION(Double OVERLOAD_PROTECTION) {
        this.OVERLOAD_PROTECTION = OVERLOAD_PROTECTION;
    }

    public Double getUBC_LINE_VOLTAGE() {
        return UBC_LINE_VOLTAGE;
    }

    public void setUBC_LINE_VOLTAGE(Double UBC_LINE_VOLTAGE) {
        this.UBC_LINE_VOLTAGE = UBC_LINE_VOLTAGE;
    }

    public Double getUAB_LINE_VOLTAGE() {
        return UAB_LINE_VOLTAGE;
    }

    public void setUAB_LINE_VOLTAGE(Double UAB_LINE_VOLTAGE) {
        this.UAB_LINE_VOLTAGE = UAB_LINE_VOLTAGE;
    }

    public Double getUAC_LINE_VOLTAGE() {
        return UAC_LINE_VOLTAGE;
    }

    public void setUAC_LINE_VOLTAGE(Double UAC_LINE_VOLTAGE) {
        this.UAC_LINE_VOLTAGE = UAC_LINE_VOLTAGE;
    }


}
