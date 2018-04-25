package com.dkt.service.alarm.limit;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.util.PageData;

/** 
 * 说明： 越限告警接口
 * @author：shr
 * @date：2018-01-17
 * @version
 */
public interface LimitManager{
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**修改状态
	 * @param pd
	 * @throws Exception
	 */
	public void editTag(PageData pd)throws Exception;

}

