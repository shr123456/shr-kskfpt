package com.dkt.service.equtransformermonitoring;

import com.dkt.entity.equmetermonitoring.ElectricalRoomMeter;
import com.dkt.entity.equtransformermonitoring.EquTtransformerMonitoring;
import com.dkt.util.PageData;


import java.util.List;

/** 
 * 说明： equmetermonitoring 接口
 * @author：ssm
 * @date：2018-01-17
 * @version
 */
public interface EquTransformerMonitoringManager{

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<EquTtransformerMonitoring> getTransformerLowListCount(PageData pd)throws Exception;

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<EquTtransformerMonitoring> getTransformerLowList(PageData pd)throws Exception;

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<EquTtransformerMonitoring> getTransformerHighListCount(PageData pd)throws Exception;

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<EquTtransformerMonitoring> getTransformerHighList(PageData pd)throws Exception;

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    public PageData findById(PageData pd)throws Exception;

}

