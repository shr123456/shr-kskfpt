package com.dkt.controller.weixin.mymenu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.dkt.entity.weixin.Menu;
import com.dkt.util.weixin.Weixin;
import net.sf.json.JSONObject;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dkt.controller.base.BaseController;
import com.dkt.entity.Page;
import com.dkt.util.AppUtil;
import com.dkt.util.ObjectExcelView;
import com.dkt.util.PageData;
import com.dkt.util.Jurisdiction;
import com.dkt.util.weixin.MenuUtil;
import com.dkt.service.weixin.key.KeyManager;
import com.dkt.service.weixin.mymenu.MyMenuManager;

/**
 * 说明：微信自定义菜单
 * @author：shr
 * @date：2016-10-30
 */
@Controller
@RequestMapping(value="/mymenu")
public class MyMenuController extends BaseController {
//	private static final long MAX_TIME = 7200 * 1000;// 微信允许最长Access_token有效时间（ms）
//	private static final String TAG = "WeixinApiTest";// TAG
//	private static final String APPID = "wx3ab9c69bae07ca87";// APPID
//	private static final String SECERT = "7a62238555f610049fee1047ce83677d";// 秘钥

	@Resource(name="mymenuService")
	private MyMenuManager mymenuService;
	@Resource(name="keyService")
	private KeyManager keyService;

	/**进入编辑菜单页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditMenu")
	public ModelAndView goEditMenu()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData>	varList = mymenuService.listOneAll(pd);
		List<PageData>	varListsub = mymenuService.listTwoAll(pd);
		mv.setViewName("weixin/mymenu/mymenu_edit");
		mv.addObject("pd", pd);
		mv.addObject("varList", varList);
		mv.addObject("varListsub", varListsub);
		return mv;
	}

	/**
	 * 新增修改一级菜单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/SetOnemenu")
	@ResponseBody
	public int setMyfirstMenu()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String key = "mk"+System.currentTimeMillis();
		pd = this.getPageData();
		if(!(pd.get("MYMENU_ID").equals(""))){
			int MYMENUID=Integer.parseInt(pd.get("MYMENU_ID").toString());
			if(MYMENUID>0){
				mymenuService.edit(pd);
			}}else {
			if(pd.get("TYPE").equals("click")){
				pd.put("CONTENT",key);
			}
			pd.remove("MYMENU_ID");
			mymenuService.save(pd);
		}
		return 1;
	}
	/**
	 * 新增修改二级菜单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveTwoMenu")
	@ResponseBody
	public int saveTwoMenu()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String key = "mk"+System.currentTimeMillis();
		if(!(pd.get("MYMENU_ID").equals(""))){
			int MYMENUID=Integer.parseInt(pd.get("MYMENU_ID").toString());
			if(MYMENUID>0){
				mymenuService.editTwo(pd);
			}}else {
			if(pd.get("TYPE").equals("click")){
				pd.put("CONTENT",key);
			}
			pd.remove("MYMENU_ID");
			mymenuService.save(pd);
		}
		return 1;
	}
	/**删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public int delete() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除MyMenu");
		PageData pd = new PageData();
		pd = this.getPageData();
		mymenuService.delete(pd);
		return 1;
	}
	/**
	 * 生成菜单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/createmenu")
	@ResponseBody
	public int createM()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData>	varList = mymenuService.listOneAll(pd);
		PageData keydata=keyService.findById(pd);
		StringBuffer option=new StringBuffer();
		List<PageData> list=new ArrayList<PageData>();
		int numdata=varList.size();
		if(varList.size()>0){
			option.append("{'button': [");
			for(int i=0;i<varList.size();i++){
				PageData data=varList.get(i);
				pd.put("PARENT_ID",data.get("MYMENU_ID"));
				List<PageData>	datasub = mymenuService.findByParentId(pd);
				if(datasub.size()>0){
					option.append("{'name': '"+data.get("TITLE")+"','sub_button': [");
					for(int j=0;j<datasub.size();j++){
						option.append("{'type': '"+datasub.get(j).get("TYPE")+"','name': '"+datasub.get(j).get("TITLE")+"',");
						if(datasub.size()==1){
							if(datasub.get(j).get("TYPE").equals("click")){
								option.append("'key': '"+datasub.get(j).get("CONTENT")+"'}");
							}else if(datasub.get(j).get("TYPE").equals("view")){
								option.append("'url': '"+datasub.get(j).get("CONTENT")+"'}");
							}
						}else {
							if(j<datasub.size()-1){
								if(datasub.get(j).get("TYPE").equals("click")){
									option.append("'key': '"+datasub.get(j).get("CONTENT")+"'},");
								}else if(datasub.get(j).get("TYPE").equals("view")){
									option.append("'url': '"+datasub.get(j).get("CONTENT")+"'},");
								}
							}else{
								if(datasub.get(j).get("TYPE").equals("click")){
									option.append("'key': '"+datasub.get(j).get("CONTENT")+"'}");
								}else if(datasub.get(j).get("TYPE").equals("view")){
									option.append("'url': '"+datasub.get(j).get("CONTENT")+"'}");
								}
							}
						}
					}
					if(numdata==1){
						option.append("]}");
					}else{
						if(i<numdata-1){
							option.append("]},");
						}else {
							option.append("]}");
						}
					}
				}else {
					option.append(" {'type': '"+data.get("TYPE")+"','name': '"+data.get("TITLE")+"',");
					if(numdata==1){
						if(data.get("TYPE").equals("click")){
							option.append("'key': '"+data.get("CONTENT")+"'}");
						}else if(data.get("TYPE").equals("view")){
							option.append("'url': '"+data.get("CONTENT")+"'}");
						}
					}else {
						if(i<numdata-1){
							if(data.get("TYPE").equals("click")){
								option.append("'key': '"+data.get("CONTENT")+"'},");
							}else if(data.get("TYPE").equals("view")){
								option.append("'url': '"+data.get("CONTENT")+"'},");
							}
						}else {
							if(data.get("TYPE").equals("click")){
								option.append("'key': '"+data.get("CONTENT")+"'}");
							}else if(data.get("TYPE").equals("view")){
								option.append("'url': '"+data.get("CONTENT")+"'}");
							}
						}

					}
				}

			}
			option.append("]}");
		}
		String  optionList = option.toString().replaceAll(" +","");
		int status=MyMenuController.createMenu(optionList,keydata.get("APPID").toString(),keydata.get("APPSECRET").toString());
		if(status==0){
			return 0;
		}else if (status==1){
			return 1;
		}else {
			return 3;
		}
	}


	/**
	 * 	创建自定义菜单(每天限制1000次)
	 * */
	public static int createMenu(String menu, String appid, String appsecret){

		String jsonMenu= JSONObject.fromObject(menu).toString();

		int status=0;

		//System.out.println("菜单："+jsonMenu);
		Weixin wx = new Weixin();
		String token=wx.getAccess_token(appid, appsecret);
		if(!(token.equals("errer"))){
		String path="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;
		try {
			URL url=new URL(path);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(jsonMenu.getBytes("UTF-8"));
			os.close();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] bt = new byte[size];
			is.read(bt);
			String message=new String(bt,"UTF-8");
			JSONObject jsonMsg = JSONObject.fromObject(message);
			status = Integer.parseInt(jsonMsg.getString("errcode"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else {
			status=1;
		}
		return status;
	}

}
