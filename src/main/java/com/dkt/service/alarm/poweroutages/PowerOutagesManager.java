package com.dkt.service.alarm.poweroutages;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.util.PageData;

/** 
 * 说明： 断电告警接口
 * @author：shr
 * @date：2018-01-18
 * @version
 */
public interface PowerOutagesManager{
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

