package com.dkt.service.trendcurvemanagement.impl;

import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.service.trendcurvemanagement.DcPanelManager;
import com.dkt.service.trendcurvemanagement.TransformerManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("dcpanelService")
public class DcPanelService implements DcPanelManager {
    @Resource(name = "daoSupport")
    private DaoSupport dao;
    public List<PageData> findDcPanelList(PageData pd) throws Exception {
        return (List<PageData>)dao.findForList("DcPanelMapper.findDcPanelList", pd);
    }
    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("DcPanelMapper.selListEquDcSreen", page);
    }
    //查询最新添加设备作为默让加载设备
    public List<PageData> selEquDcSreenNewId(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("DcPanelMapper.selEquDcSreenNewId", pd);
    }

}
