package com.dkt.service.equmicromonitoring;


import com.dkt.entity.equmicromonitoring.EquMicroMonitoring;
import com.dkt.util.PageData;

import java.util.List;

/** 
 * 说明equmetermonitoring
 * @author：ssm
 * @date：2018-01-17
 * @version
 */
public interface EquMicroMonitoringManager{


    @SuppressWarnings("unchecked")
    public List<EquMicroMonitoring> getMicroMonitoringList(PageData pd)throws Exception;

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    public PageData findById(PageData pd)throws Exception;
}

