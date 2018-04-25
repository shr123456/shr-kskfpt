package com.dkt.service.trendcurvemanagement.impl;

import com.dkt.dao.DaoSupport;
import com.dkt.entity.Page;
import com.dkt.service.trendcurvemanagement.TransformerManager;
import com.dkt.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("transformerService")
public class TransformerService implements TransformerManager {
    @Resource(name = "daoSupport")
    private DaoSupport dao;
    public List<PageData> findThreePhaseTemperature(PageData pd) throws Exception {
        return (List<PageData>)dao.findForList("TransformerMapper.findThreePhaseTemperature", pd);
    }
    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("TransformerMapper.selectListeqlow", page);
    }
    //查询最新添加设备作为默让加载设备
    public List<PageData> selEquTransNewId(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("TransformerMapper.selEquTransNewId", pd);
    }
    public List<PageData> selectEquLowIdById(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("TransformerMapper.selectEquLowIdById", pd);
    }
    public List<PageData> findElectricity(PageData pd) throws Exception {
        return (List<PageData>)dao.findForList("TransformerMapper.findElectricity", pd);
    }

}
