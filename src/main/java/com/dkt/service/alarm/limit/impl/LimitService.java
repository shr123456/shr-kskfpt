package com.dkt.service.alarm.limit.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.alarm.limit.LimitManager;

/** 
 * 说明： 越限告警
 * @author：shr
 * @date：2018-01-17
 * @version
 */
@Service("limitService")
public class LimitService implements LimitManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("LimitMapper.datalistPage", page);
	}
	/**修改状态
	 * @param pd
	 * @throws Exception
	 */
	public void editTag(PageData pd)throws Exception{
		dao.update("LimitMapper.editTag", pd);
	}
}

