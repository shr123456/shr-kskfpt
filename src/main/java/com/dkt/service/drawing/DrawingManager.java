package com.dkt.service.drawing;

import java.util.List;
import com.dkt.entity.Page;
import com.dkt.entity.drawing.EquDrawingFile;
import com.dkt.util.PageData;

/** 
 * 说明： 图纸管理接口
 * @author：shr
 * @date：2018-02-28
 * @version
 */
public interface DrawingManager{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd, List<EquDrawingFile> files)throws Exception;
	
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

	/**列表 文件
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> listFile(Page page)throws Exception;

	/**删除文件
	 * @param fileId
	 * @throws Exception
	 */
	public void deleteFileById(String fileId)throws Exception;
	
}

