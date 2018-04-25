package com.dkt.service.weixin.mymenu;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.util.PageData;

/** 
 * 说明： 微信自定义菜单接口
 * @author：shr
 * @date：2016-10-30
 * @version
 */
public interface MyMenuManager{

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
	
	/**修改一级菜单
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	/**修改二级菜单
	 * @param pd
	 * @throws Exception
	 */
	public void editTwo(PageData pd)throws Exception;

	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**列表(一级菜单全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listOneAll(PageData pd)throws Exception;
	/**列表(二级菜单全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listTwoAll(PageData pd)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;

	/**通过父id获取子菜单数据
	 * @param pd
	 * @throws
	 */

	public List<PageData> findByParentId(PageData pd)throws Exception;


	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
}

