package com.dkt.service.trendcurvemanagement.impl;

import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.service.trendcurvemanagement.MonitManageManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("monitmanageService")
public class MonitManageService implements MonitManageManager {
    @Resource(name = "daoSupport")
    private DaoSupport dao;
    @Override
    public List<PageData> findThreePhaseCurrent(PageData pd) throws Exception {
       return (List<PageData>)dao.findForList("MonitManageMapper.findThreePhaseCurrent", pd);
    }
    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("MonitManageMapper.selectListEquMonit", page);
    }
    public List<PageData> selectEquMonitNewId(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("MonitManageMapper.selectEquMonitNewId", pd);
    }
    public List<PageData> selectEquMonitList(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("MonitManageMapper.selectEquMonitList", pd);
    }
}
