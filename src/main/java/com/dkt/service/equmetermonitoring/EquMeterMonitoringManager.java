package com.dkt.service.equmetermonitoring;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.entity.equmetermonitoring.ElectricalRoomMeter;
import com.dkt.entity.equmetermonitoring.EquMeterMonitoring;
import com.dkt.util.PageData;

/** 
 * 说明： equmetermonitoring 接口
 * @author：ssm
 * @date：2018-01-17
 * @version
 */
public interface EquMeterMonitoringManager{

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<EquMeterMonitoring> getMeterListMonitoringByCustomerId(PageData pd)throws Exception;

    /**根据用户查询列表
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<ElectricalRoomMeter> getSmartMeterListByCustomerId(String CUSTOMER_ID)throws Exception;

    @SuppressWarnings("unchecked")
    public List<EquMeterMonitoring> getMeterListMonitoringOwn(PageData pd)throws Exception;

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    public PageData findById(PageData pd)throws Exception;

}

