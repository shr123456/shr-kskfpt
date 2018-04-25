package com.dkt.entity.drawing;

/**
 * @auther shr
 * @date 2018/3/1
 * @time 16:08
 * @desc
 **/
public class EquDrawingFile {

    private String FILE_ID;
    private String FILE_URL;
    private String FILE_NAME;
    private String DRAWING_ID;
    private String CREATOR;
    private String CREATE_TIME;

    public String getFILE_ID() {
        return FILE_ID;
    }

    public void setFILE_ID(String FILE_ID) {
        this.FILE_ID = FILE_ID;
    }

    public String getFILE_URL() {
        return FILE_URL;
    }

    public void setFILE_URL(String FILE_URL) {
        this.FILE_URL = FILE_URL;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }

    public String getDRAWING_ID() {
        return DRAWING_ID;
    }

    public void setDRAWING_ID(String DRAWING_ID) {
        this.DRAWING_ID = DRAWING_ID;
    }

    public String getCREATOR() {
        return CREATOR;
    }

    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }
}
