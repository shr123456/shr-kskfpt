package com.dkt.entity.equhighpc;

import org.apache.james.mime4j.field.datetime.DateTime;
import java.util.Date;

/**
 * Created by Tom Sun on 2018/1/22.
 */
public class EquHighPC {

    private int ID;//主键
    private int ELECTRICAL_ROOM_ID;//电房ID
    private String EQUIPMENT_NAME;//设备名称
    private String EQUIPMENT_CODE;//设备编号
    private String LOOP_NAME;//回路名称
    private String INSTALLATION_POSITION;//安装位置
    private String EQUIPMENT_VERSION;//设备型号
    private String RATED_CURRENT;//额定电流
    private String RATED_VOLTAGE;//额定电压
    private Date MAKE_TIME;//生产日期
    private String BRAND;//品牌
    private String MANUFACTURER;//生产厂家

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getELECTRICAL_ROOM_ID() {
        return ELECTRICAL_ROOM_ID;
    }

    public void setELECTRICAL_ROOM_ID(int ELECTRICAL_ROOM_ID) {
        this.ELECTRICAL_ROOM_ID = ELECTRICAL_ROOM_ID;
    }

    public String getEQUIPMENT_NAME() {
        return EQUIPMENT_NAME;
    }

    public void setEQUIPMENT_NAME(String EQUIPMENT_NAME) {
        this.EQUIPMENT_NAME = EQUIPMENT_NAME;
    }

    public String getEQUIPMENT_CODE() {
        return EQUIPMENT_CODE;
    }

    public void setEQUIPMENT_CODE(String EQUIPMENT_CODE) {
        this.EQUIPMENT_CODE = EQUIPMENT_CODE;
    }

    public String getLOOP_NAME() {
        return LOOP_NAME;
    }

    public void setLOOP_NAME(String LOOP_NAME) {
        this.LOOP_NAME = LOOP_NAME;
    }

    public String getINSTALLATION_POSITION() {
        return INSTALLATION_POSITION;
    }

    public void setINSTALLATION_POSITION(String INSTALLATION_POSITION) {
        this.INSTALLATION_POSITION = INSTALLATION_POSITION;
    }

    public String getEQUIPMENT_VERSION() {
        return EQUIPMENT_VERSION;
    }

    public void setEQUIPMENT_VERSION(String EQUIPMENT_VERSION) {
        this.EQUIPMENT_VERSION = EQUIPMENT_VERSION;
    }

    public String getRATED_CURRENT() {
        return RATED_CURRENT;
    }

    public void setRATED_CURRENT(String RATED_CURRENT) {
        this.RATED_CURRENT = RATED_CURRENT;
    }

    public String getRATED_VOLTAGE() {
        return RATED_VOLTAGE;
    }

    public void setRATED_VOLTAGE(String RATED_VOLTAGE) {
        this.RATED_VOLTAGE = RATED_VOLTAGE;
    }

    public Date getMAKE_TIME() {
        return MAKE_TIME;
    }

    public void setMAKE_TIME(Date MAKE_TIME) {
        this.MAKE_TIME = MAKE_TIME;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public void setMANUFACTURER(String MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }


}
