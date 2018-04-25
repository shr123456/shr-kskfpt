package com.dkt.service.trendcurvemanagement;

import com.dkt.entity.Page;
import com.dkt.util.PageData;

import java.util.List;

public interface LowPressureCurveManager {
    /**查询微机保护数据
     * @param pd
     * @return
     * @throws Exception
     */
    public List<PageData> findThreePhaseCurrent(PageData pd) throws Exception;
    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> list(Page page)throws Exception;
    /**
     * 查最新一条设备id
     */
    public List<PageData> selectEqulowbNewId(PageData pd)throws Exception;
    /**
     * 查根据设备id查询设备
     */
    public List<PageData> selectEqulowbList(PageData pd)throws Exception;


}
