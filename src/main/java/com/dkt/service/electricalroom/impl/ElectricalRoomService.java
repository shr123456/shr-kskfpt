package com.dkt.service.electricalroom.impl;

import java.util.List;
import javax.annotation.Resource;

import com.dkt.entity.electricalroom.ElectricalRoom;
import org.springframework.stereotype.Service;
import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.service.electricalroom.ElectricalRoomManager;

/** 
 * 说明： electricalroom
 * @author：shr
 * @date：2018-01-08
 * @version
 */
@Service("electricalroomService")
public class ElectricalRoomService implements ElectricalRoomManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("ElectricalRoomMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("ElectricalRoomMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("ElectricalRoomMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ElectricalRoomMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ElectricalRoomMapper.listAll", pd);
	}

	/**根据用户查询列表
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ElectricalRoom> listByCustomerId(PageData pd)throws Exception{
		return (List<ElectricalRoom>)dao.findForList("ElectricalRoomMapper.listByCustomerId", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ElectricalRoomMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ElectricalRoomMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

