package com.dkt.service.equdcscreenmonitoring;

import com.dkt.entity.equdcscreenmonitoring.EquDCScreenMonitoring;
import com.dkt.util.PageData;

import java.util.List;

/** 
 * 说明： equmetermonitoring 接口
 * @author：ssm
 * @date：2018-01-17
 * @version
 */
public interface EquDCScreenMonitoringManager{

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<EquDCScreenMonitoring> getDCMonitoringList(PageData pd)throws Exception;

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    public PageData findById(PageData pd)throws Exception;
}

