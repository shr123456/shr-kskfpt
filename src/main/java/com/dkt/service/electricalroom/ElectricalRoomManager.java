package com.dkt.service.electricalroom;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.entity.electricalroom.ElectricalRoom;
import com.dkt.util.PageData;

/** 
 * 说明： electricalroom接口
 * @author：shr
 * @date：2018-01-08
 * @version
 */
public interface ElectricalRoomManager{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;

	/**根据用户查询列表
	 * @param  pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ElectricalRoom> listByCustomerId(PageData pd)throws Exception;

	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
}

