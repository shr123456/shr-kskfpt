package com.dkt.service.alarm.poweroutages.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.alarm.poweroutages.PowerOutagesManager;

/** 
 * 说明： 断电告警
 * @author：shr
 * @date：2018-01-18
 * @version
 */
@Service("poweroutagesService")
public class PowerOutagesService implements PowerOutagesManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("PowerOutagesMapper.datalistPage", page);
	}
	/**修改状态
	 * @param pd
	 * @throws Exception
	 */
	public void editTag(PageData pd)throws Exception{
		dao.update("PowerOutagesMapper.editTag", pd);
	}
}

