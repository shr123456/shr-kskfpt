package com.dkt.service.trendcurvemanagement;

import com.dkt.entity.Page;
import com.dkt.util.PageData;

import java.util.List;

public interface TransformerManager {
    /**查询三相温度
     * @param pd
     * @return
     * @throws Exception
     */
    public List<PageData> findThreePhaseTemperature(PageData pd) throws Exception;
    /**列表
     * @param page
     * @throws Exception
     */
    public List<PageData> list(Page page)throws Exception;
    /**
     * 查最新一条设备id
     */
    public List<PageData> selEquTransNewId(PageData pd)throws Exception;
    /**
     * 查根据变压器id查询低压柜id
     */
    public List<PageData> selectEquLowIdById(PageData pd)throws Exception;
    /**
     * 查电量
     */
    public List<PageData> findElectricity(PageData pd) throws Exception;

}
