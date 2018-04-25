package com.dkt.controller.drawing;

import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dkt.entity.drawing.EquDrawingFile;
import com.dkt.entity.system.User;
import com.dkt.util.*;
import org.apache.shiro.session.Session;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import com.dkt.controller.base.BaseController;
import com.dkt.entity.Page;
import com.dkt.service.drawing.DrawingManager;

/** 
 * 说明：图纸管理
 * @author：shr
 * @date：2018-02-28
 */
@Controller
@RequestMapping(value="/drawing")
public class DrawingController extends BaseController {
	
	String menuUrl = "drawing/list.do"; //菜单地址(权限用)
	@Resource(name="drawingService")
	private DrawingManager drawingService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Drawing");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);
		String id = this.get32UUID();
		pd.put("DRAWING_ID", id);	//主键
		pd.put("CREATOR", user.getUSER_ID());
		pd.put("CREATE_TIME", DateUtil.getTime());
		String[] fileNames = request.getParameterValues("fileName");
		String[] fileUrls = request.getParameterValues("fileUrl");
		List<EquDrawingFile> files = new ArrayList<EquDrawingFile>();
		for(int i = 0; i < fileNames.length; i ++){
			EquDrawingFile equDrawingFile = new EquDrawingFile();
			equDrawingFile.setFILE_ID(this.get32UUID());
			equDrawingFile.setFILE_URL(fileUrls[i]);
			equDrawingFile.setFILE_NAME(fileNames[i]);
			equDrawingFile.setCREATOR(user.getUSER_ID());
			equDrawingFile.setCREATE_TIME(DateUtil.getTime());
			equDrawingFile.setDRAWING_ID(id);
			files.add(equDrawingFile);
		}
		drawingService.save(pd, files);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Drawing");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		drawingService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Drawing");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		drawingService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Drawing");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = drawingService.list(page);	//列出Drawing列表
		mv.setViewName("drawing/drawing_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("drawing/drawing_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = drawingService.findById(pd);	//根据ID读取
		mv.setViewName("drawing/drawing_file_list");
		mv.addObject("msg", "editFile");
		mv.addObject("pd", pd);
		return mv;
	}

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/listFile")
	public ModelAndView listFile(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Drawing");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		String id = pd.getString("DRAWING_ID");
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = drawingService.listFile(page);	//列出Drawing列表
		mv.setViewName("drawing/drawing_file_list");
		PropertiesUtil.initFile("classpath:file.properties");
		mv.addObject("filePath", PropertiesUtil.getProperty("upload_path"));
		mv.addObject("varList", varList);
		mv.addObject("drawingId", id);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Drawing");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			drawingService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}

	/**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteFile")
	@ResponseBody
	public Object deleteFile() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除DrawingFile");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String fileId = pd.getString("fileId");
		if(null != fileId && !"".equals(fileId)){
			drawingService.deleteFileById(fileId);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Drawing到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("文件名称");	//1
		titles.add("文件上传时名称");	//2
		titles.add("文件存放路径");	//3
		titles.add("文件格式");	//4
		titles.add("创建人");	//5
		titles.add("创建时间");	//6
		titles.add("备注");	//7
		dataMap.put("titles", titles);
		List<PageData> varOList = drawingService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("FILE_NAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("FORMERLY_NAME"));	    //2
			vpd.put("var3", varOList.get(i).getString("FILE_URL"));	    //3
			vpd.put("var4", varOList.get(i).getString("SUFFIX"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATOR"));	    //5
			vpd.put("var6", varOList.get(i).getString("CREATE_TIME"));	    //6
			vpd.put("var7", varOList.get(i).getString("REMARK"));	    //7
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}

	@RequestMapping("fileUpload")
	@ResponseBody
	private List<EquDrawingFile> fileUpload(HttpServletRequest request) throws IllegalStateException, IOException {
		List<EquDrawingFile> fileVoList = new ArrayList<EquDrawingFile>();
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		//检查form中是否有enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)){
			//将request变成多部分request
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			//获取multiRequest 中所有的文件名
			Iterator iter=multiRequest.getFileNames();
			PropertiesUtil.initFile("classpath:file.properties");
			while(iter.hasNext()){
				//一次遍历所有文件
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				if(file!=null)
				{
					String mkdirPath = PropertiesUtil.getProperty("file_mkdir")+ "/"+ DateUtil.getDay() ;
					String filePath = PropertiesUtil.getProperty("upload_path") + mkdirPath;
					File newFile = new File(filePath);
					if(!newFile.exists()){
						newFile.mkdirs();
					}
					int length = file.getOriginalFilename().lastIndexOf(".");
					String suffix = file.getOriginalFilename().substring(length);
					suffix = "/" + new Date().getTime() + suffix;
					String path= filePath + suffix;
					EquDrawingFile drawingFile = new EquDrawingFile();
					drawingFile.setFILE_NAME(file.getOriginalFilename());
					drawingFile.setFILE_URL(mkdirPath +suffix);
					fileVoList.add(drawingFile);
					//上传
					file.transferTo(new File(path));
				}

			}

		}
		return fileVoList;
	}

	@RequestMapping(value="/downloadFile")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
		PropertiesUtil.initFile("classpath:file.properties");
		PageData pd = new PageData();
		pd = this.getPageData();
		String url = pd.getString("url");
		File file = new File(PropertiesUtil.getProperty("upload_path") + url);
		byte[] body = null;
		InputStream is = new FileInputStream(file);
		body = new byte[is.available()];
		is.read(body);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attchement;filename=" + file.getName());
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
		return entity;
	}
}
