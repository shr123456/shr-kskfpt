package com.dkt.service.trendcurvemanagement;

import com.dkt.entity.Page;
import com.dkt.util.PageData;

import java.util.List;

public interface DcPanelManager {
    /**查询
     * @param pd
     * @return
     * @throws Exception
     */
    public List<PageData> findDcPanelList(PageData pd) throws Exception;
    /**列表
     * @param page
     * @throws Exception
     */
    public List<PageData> list(Page page)throws Exception;
    /**
     * 查最新一条设备id
     */
    public List<PageData> selEquDcSreenNewId(PageData pd)throws Exception;


}
