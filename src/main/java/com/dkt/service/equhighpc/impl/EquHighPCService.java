package com.dkt.service.equhighpc.impl;

import java.util.List;
import javax.annotation.Resource;

import com.dkt.entity.equhighpc.EquHighPC;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.equhighpc.EquHighPCManager;

/** 
 * 说明： equhighpc
 * @author：shr
 * @date：2018-01-09
 * @version
 */
@Service("equhighpcService")
public class EquHighPCService implements EquHighPCManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("EquHighPCMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("EquHighPCMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("EquHighPCMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("EquHighPCMapper.datalistPage", page);
	}

	/**根据用户查询列表
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EquHighPC> listByCustomerId(PageData pd)throws Exception {
		return (List<EquHighPC>)dao.findForList("EquHighPCMapper.listByCustomerId", pd);
	}


	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("EquHighPCMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EquHighPCMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("EquHighPCMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

