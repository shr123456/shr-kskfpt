package com.dkt.service.equtransformer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.equtransformer.EquTransformerManager;
import com.dkt.entity.equtransformer.EquTransformer;

/** 
 * 说明： equtransformer
 * @author：shr
 * @date：2018-01-12
 * @version
 */
@Service("equtransformerService")
public class EquTransformerService implements EquTransformerManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("EquTransformerMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("EquTransformerMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("EquTransformerMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("EquTransformerMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("EquTransformerMapper.listAll", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EquTransformerMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("EquTransformerMapper.deleteAll", ArrayDATA_IDS);
	}

	@Override
	public List<EquTransformer> findByTypeOne(PageData pd) throws Exception {
		return (List<EquTransformer>)dao.findForList("EquTransformerMapper.findByTypeOne", pd);
	}

	@Override
	public List<EquTransformer> findByTypeTwo(PageData pd) throws Exception {
		return (List<EquTransformer>)dao.findForList("EquTransformerMapper.findByTypeTwo", pd);
	}

	@Override
	public void editTypeOne(PageData pd) throws Exception {
		dao.update("EquTransformerMapper.editTypeOne", pd);
	}

	@Override
	public void editTypeTwo(PageData pd) throws Exception {
		dao.update("EquTransformerMapper.editTypeTwo", pd);
	}


}

