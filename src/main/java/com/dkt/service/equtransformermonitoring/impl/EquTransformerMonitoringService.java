package com.dkt.service.equtransformermonitoring.impl;

import com.dkt.dao.DaoSupport;
import com.dkt.service.equtransformermonitoring.EquTransformerMonitoringManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;
import com.dkt.entity.equtransformermonitoring.EquTtransformerMonitoring;
import javax.annotation.Resource;
import java.util.List;

/** 
 * 说明： equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 * @version
 */
@Service("equtransformermonitoringService")
public class EquTransformerMonitoringService implements EquTransformerMonitoringManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<EquTtransformerMonitoring> getTransformerLowListCount(PageData pd)throws Exception{
		return (List<EquTtransformerMonitoring>)dao.findForList("EquTransformerMonitoringMapper.getTransformerLowListCount", pd);
	}

	@SuppressWarnings("unchecked")
	public List<EquTtransformerMonitoring> getTransformerLowList(PageData pd)throws Exception{
		return (List<EquTtransformerMonitoring>)dao.findForList("EquTransformerMonitoringMapper.getTransformerLowList", pd);
	}

	@SuppressWarnings("unchecked")
	public List<EquTtransformerMonitoring> getTransformerHighListCount(PageData pd)throws Exception{
		return (List<EquTtransformerMonitoring>)dao.findForList("EquTransformerMonitoringMapper.getTransformerHighListCount", pd);
	}

	@SuppressWarnings("unchecked")
	public List<EquTtransformerMonitoring> getTransformerHighList(PageData pd)throws Exception{
		return (List<EquTtransformerMonitoring>)dao.findForList("EquTransformerMonitoringMapper.getTransformerHighList", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EquTransformerMonitoringMapper.findById", pd);
	}

}

