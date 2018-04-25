package com.dkt.service.equmicromonitoring.impl;

import com.dkt.dao.DaoSupport;
import com.dkt.entity.equmicromonitoring.EquMicroMonitoring;
import com.dkt.service.equmicromonitoring.EquMicroMonitoringManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 说明equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 * @version
 */
@Service("equmicromonitoringService")
public class EquMicroMonitoringService implements EquMicroMonitoringManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<EquMicroMonitoring> getMicroMonitoringList(PageData pd)throws Exception{
		return (List<EquMicroMonitoring>)dao.findForList("EquMicroMonitoringMapper.getMicroMonitoringList", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EquMicroMonitoringMapper.findById", pd);
	}
}

