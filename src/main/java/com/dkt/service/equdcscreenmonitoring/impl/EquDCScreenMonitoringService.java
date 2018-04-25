package com.dkt.service.equdcscreenmonitoring.impl;

import com.dkt.dao.DaoSupport;

import com.dkt.entity.equdcscreenmonitoring.EquDCScreenMonitoring;
import com.dkt.service.equdcscreenmonitoring.EquDCScreenMonitoringManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 说明： equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 * @version
 */
@Service("equdcscreenmonitoringService")
public class EquDCScreenMonitoringService implements EquDCScreenMonitoringManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<EquDCScreenMonitoring> getDCMonitoringList(PageData pd)throws Exception{
		return (List<EquDCScreenMonitoring>)dao.findForList("EquDCScreenMonitoringMapper.getDCMonitoringList", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EquDCScreenMonitoringMapper.findById", pd);
	}

}

