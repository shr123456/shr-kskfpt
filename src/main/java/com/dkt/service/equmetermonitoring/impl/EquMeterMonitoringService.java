package com.dkt.service.equmetermonitoring.impl;

import java.util.List;
import javax.annotation.Resource;

import com.dkt.entity.equmetermonitoring.ElectricalRoomMeter;
import com.dkt.entity.equmetermonitoring.EquMeterMonitoring;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.equmetermonitoring.EquMeterMonitoringManager;

/** 
 * 说明： equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 * @version
 */
@Service("equmetermonitoringService")
public class EquMeterMonitoringService implements EquMeterMonitoringManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<EquMeterMonitoring> getMeterListMonitoringByCustomerId(PageData pd)throws Exception{
		return (List<EquMeterMonitoring>)dao.findForList("EquMeterMonitoringMapper.getMeterListMonitoringByCustomerId", pd);
	}

	@SuppressWarnings("unchecked")
	public List<ElectricalRoomMeter> getSmartMeterListByCustomerId(String CUSTOMER_ID)throws Exception{
		return (List<ElectricalRoomMeter>)dao.findForList("EquMeterMonitoringMapper.getSmartMeterListByCustomerId", CUSTOMER_ID);
	}

	@SuppressWarnings("unchecked")
	public List<EquMeterMonitoring> getMeterListMonitoringOwn(PageData pd)throws Exception{
		return (List<EquMeterMonitoring>)dao.findForList("EquMeterMonitoringMapper.getMeterListMonitoringOwn", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EquMeterMonitoringMapper.findById", pd);
	}
}

