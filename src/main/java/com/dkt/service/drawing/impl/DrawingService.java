package com.dkt.service.drawing.impl;

import java.util.List;
import javax.annotation.Resource;

import com.dkt.entity.drawing.EquDrawingFile;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.drawing.DrawingManager;

/** 
 * 说明： 图纸管理
 * @author：shr
 * @date：2018-02-28
 * @version
 */
@Service("drawingService")
public class DrawingService implements DrawingManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd, List<EquDrawingFile> files)throws Exception{
		dao.save("DrawingMapper.save", pd);
		for(EquDrawingFile equDrawingFile : files){
			dao.save("DrawingMapper.saveFile", equDrawingFile);
		}
	}

	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("DrawingMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("DrawingMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("DrawingMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("DrawingMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DrawingMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("DrawingMapper.deleteAll", ArrayDATA_IDS);
	}

	@Override
	public List<PageData> listFile(Page page) throws Exception {
		return (List<PageData>)dao.findForList("DrawingMapper.listFilePage", page);
	}

	@Override
	public void deleteFileById(String fileId) throws Exception {
		dao.delete("DrawingMapper.deleteFileById", fileId);
	}

}

