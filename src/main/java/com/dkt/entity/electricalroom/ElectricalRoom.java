package com.dkt.entity.electricalroom;

/**
 * Created by Tom Sun on 2018/1/15.
 */
public class ElectricalRoom {

    private int ROOM_ID;//主键
    private String CUSTOMER_ID;//客户ID
    private String ELECTRICAL_ROOM_CODE;//电房编号
    private String ELECTRICAL_ROOM_NAME;//电房名称
    private Double TEMPERATURE;//温度
    private Double DAMPNESS;//湿度
    private String CHARGER;//负责人
    private String CHARGE_TEL;//负责人联系电话电话
    private String REMARK;//备注
    private String PHOTO_URL;//相关照片

    public int getROOM_ID() {
        return ROOM_ID;
    }
    public void setROOM_ID(int ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getELECTRICAL_ROOM_CODE() {
        return ELECTRICAL_ROOM_CODE;
    }

    public void setELECTRICAL_ROOM_CODE(String ELECTRICAL_ROOM_CODE) {
        this.ELECTRICAL_ROOM_CODE = ELECTRICAL_ROOM_CODE;
    }

    public String getELECTRICAL_ROOM_NAME() {
        return ELECTRICAL_ROOM_NAME;
    }

    public void setELECTRICAL_ROOM_NAME(String ELECTRICAL_ROOM_NAME) {
        this.ELECTRICAL_ROOM_NAME = ELECTRICAL_ROOM_NAME;
    }

    public Double getTEMPERATURE() {
        return TEMPERATURE;
    }

    public void setTEMPERATURE(Double TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    public Double getDAMPNESS() {
        return DAMPNESS;
    }

    public void setDAMPNESS(Double DAMPNESS) {
        this.DAMPNESS = DAMPNESS;
    }

    public String getCHARGER() {
        return CHARGER;
    }

    public void setCHARGER(String CHARGER) {
        this.CHARGER = CHARGER;
    }

    public String getCHARGE_TEL() {
        return CHARGE_TEL;
    }

    public void setCHARGE_TEL(String CHARGE_TEL) {
        this.CHARGE_TEL = CHARGE_TEL;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getPHOTO_URL() {
        return PHOTO_URL;
    }

    public void setPHOTO_URL(String PHOTO_URL) {
        this.PHOTO_URL = PHOTO_URL;
    }

}



