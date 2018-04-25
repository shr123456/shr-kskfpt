package com.dkt.service.trendcurvemanagement.impl;

import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.service.trendcurvemanagement.LowPressureCurveManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("lowpressurecurveService")
public class LowPressureCurveServic implements LowPressureCurveManager {
    @Resource(name = "daoSupport")
    private DaoSupport dao;
    @Override
    public List<PageData> findThreePhaseCurrent(PageData pd) throws Exception {
        return (List<PageData>)dao.findForList("LowPressureCurveMapper.findThreePhaseCurrent", pd);
    }
    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("LowPressureCurveMapper.selectListeqlow", page);
    }
    public List<PageData> selectEqulowbNewId(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("LowPressureCurveMapper.selectEqulowbNewId", pd);
    }
    public List<PageData> selectEqulowbList(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("LowPressureCurveMapper.selectEqulowbList", pd);
    }
}

