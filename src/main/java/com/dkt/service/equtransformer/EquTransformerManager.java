package com.dkt.service.equtransformer;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.entity.equtransformer.EquTransformer;
import com.dkt.util.PageData;

/** 
 * 说明： equtransformer接口
 * @author：shr
 * @date：2018-01-12
 * @version
 */
public interface EquTransformerManager{

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

	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<EquTransformer> findByTypeOne(PageData pd)throws Exception;


	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<EquTransformer> findByTypeTwo(PageData pd)throws Exception;


	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void editTypeOne(PageData pd)throws Exception;


	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void editTypeTwo(PageData pd)throws Exception;









}

