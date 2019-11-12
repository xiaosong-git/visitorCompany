package com.manage.controller.companyUser;

import com.manage.controller.base.BaseController;
import com.manage.model.*;
import com.manage.service.*;
import com.manage.utils.NumberUtil;
import com.manage.utils.OrderNoUtil;
import com.manage.utils.ReadExcel;
import com.manage.utils.ResponseObj;
import com.manage.utils.page.PageInfo;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import com.xdream.kernel.util.JsonUtil;
import com.xdream.kernel.util.MD5;
import com.xdream.kernel.util.ResponseUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

@RequestMapping("/companyUser")
@RestController
public class CompanyUserController extends BaseController {

    @Autowired
    private ICompanyUserService companyUserService;
    
    @Autowired
    private ICompanySectionService companySectionService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ISystemParamsService systemParamService;

    @Autowired
    private IUserAccountService userAccountService;
    
    @Autowired
    private IParamsService paramsService;
    
    @Autowired
    private ICompanyPostService companyPostService;

    /**
     * 分页查询公司
     */
    @RequestMapping(value = "/findByPage")
    public Result findByPage(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {
        CompanyOper companyOper = (CompanyOper)request.getSession().getAttribute("companyOper");
        Long companyId = companyOper.getCompany_id();
        String companyName = request.getParameter("companyName");
        String sectionName = request.getParameter("sectionName");
        String userName = request.getParameter("userName");
        List<CompanyUser> companyUsers = companyUserService.findByPage(companyId, companyName, sectionName, userName, page, pageSize);
        PageInfo<CompanyUser> companySectionPageInfo = new PageInfo<CompanyUser>(companyUsers);
        return companySectionPageInfo != null ? ResultData.dataResult("success", "读取公司员工信息成功", companySectionPageInfo) : Result.unDataResult("fail", "读取公司员工信息失败");
    }
    /**
     * 文件上传
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST,consumes = "multipart/form-data")
    public Result upload(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		boolean isSucc = true;
		CompanyOper companyOper = (CompanyOper)request.getSession().getAttribute("companyOper");
        Long companyId = companyOper.getCompany_id();
		MultipartHttpServletRequest multipartRequest = null;
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multipartRequest.getFileNames();
			MultipartFile myfile = null;
			String json = "";
			String realFileName = "";
			File files = null;
			try {
				if (iter.hasNext()) {
					String key = iter.next();
					myfile = multipartRequest.getFile(key);
					if (myfile.isEmpty()) {

					} else {
						String originalFilename = myfile.getOriginalFilename();
						if (!originalFilename.matches(".+(.xls|.xlsx)$")) {
							isSucc = false;
						} else {
							String realPath = paramsService.findByParamName("fileClientPath");
							System.out.println("文件存储的路径:"+realPath);
							File file = new File(realPath);
							if (!file.exists()) {
								file.mkdirs();
							}
							// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
							String newFileName = System.currentTimeMillis() + "";
							int index = originalFilename.lastIndexOf(".");
							String fileNameType = originalFilename.substring(index, originalFilename.length());
							realFileName = newFileName + fileNameType;
							files = new File(realPath, realFileName);
							FileUtils.copyInputStreamToFile(myfile.getInputStream(), files);
						}
					}
				}
				if (isSucc) {
					if(files==null) {
						return ResultData.unDataResult("fail", "没有文件上传");
					}
					//String backJson=pictureService.getCardData(files.getAbsolutePath(),userId);
					ReadExcel readExcel = new ReadExcel();
					System.out.println("读取的excel文件路径:"+files.getAbsolutePath());
					//map格式每行存储excel中的一行数据，以键值对方式存在。
					Map<Integer,Map<String,Object>> maps=readExcel.read(files.getAbsolutePath());
					if(maps==null||maps.size()==0) {
						return ResultData.unDataResult("fail", "导入的excel表格为空");
					}
					int falseCount=0;
					int totalCount=maps.size();
					for(int i=1;i<=maps.size();i++) {
						Map<String,Object> dmaps=maps.get(i);
						boolean isAdd= true;

                        String phone="";
						try {
                            DecimalFormat df =new DecimalFormat("#");
                            phone = df.format(dmaps.get("手机号"));
                        }catch (Exception e){
                            return ResultData.unDataResult("fail", "手机号填写格式解析不了");
                        }

                        String name="";
                        try {
                             name = (String) dmaps.get("姓名");
                        }catch (Exception e){
                            return ResultData.unDataResult("fail", "姓名填写格式解析不了");
                        }


                        String role="";
                        try {
                            role = String.valueOf(dmaps.get("员工属性"));
                        }catch (Exception e){
                            return ResultData.unDataResult("fail", "员工属性填写格式解析不了");
                        }


                        String sex="";
                        try {
                             sex  = (String)dmaps.get("性别");
                        }catch (Exception e){
                            return ResultData.unDataResult("fail", "性别填写格式解析不了");
                        }


                        String sectionName="";
                        try {
                             sectionName = (String)dmaps.get("部门名称");
                        }catch (Exception e){
                            return ResultData.unDataResult("fail", "部门名称填写格式解析不了");
                        }


                        String post="";
                        try {
                             post = (String)dmaps.get("岗位");
                        }catch (Exception e){
                            return ResultData.unDataResult("fail", "岗位填写格式解析不了");
                        }

                        String shemi  = (String) dmaps.get("涉密部门");
                        String shouq =(String) dmaps.get("授权类型");

                        Long postId = null;
						System.out.println("即将添加的这条记录是:"+name+" "+phone+" "+role+" "+dmaps.get("部门名称")+" "+sex+" "+post);
						Long sectionId=null;
						CompanySection companySection=companySectionService.findBySectionNameAndcompanyId(sectionName, companyId);//公司部门表
						System.out.println(companySection);
						if(companySection!=null) {
						sectionId=companySection.getId();
						}
						CompanyPost companyPost=companyPostService.findByName(post);//岗位表 company_post
						if(sectionId==null||phone==null||phone.isEmpty()||name==null||role==null||sex==null) {
							isAdd=false;
						}
						if(companyPost!=null) {
							postId=companyPost.getId();
						}
						if(isAdd) {
						CompanyUser companyUser =new CompanyUser();
						companyUser.setCompanyId(Long.valueOf(companyId));
						companyUser.setStatus("applySuc");
						companyUser.setCurrentStatus("normal");
						companyUser.setPostId(postId);
						if(sectionId!=null) {
						    companyUser.setSectionId(sectionId);//设置部门ID
						}
						if(role!=null) {
							role=role;
						}
						if(sex.equals("男")) {
							sex="male";
						}
						if(sex.equals("女")) {
							sex="female";
						}
//						if(shemi.equals("可以被访问")){
//						    shemi="0";
//                        }else {
//						    shemi="1";
//                        }
//
//						if(shouq.equals("为自己授权")){
//						    shouq="0";
//                        }else if(shouq.equals("不可授权")){
//						    shouq="1";
//                        }else if(shouq.equals("为本部门授权")){
//						    shouq="2";
//                        }else {
//						    shouq="3";
//                        }
						
						Date date = new Date();
                        String createDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        String createTime = new SimpleDateFormat("HH:mm:ss").format(date);
                        companyUser.setPhone(phone);
                        companyUser.setRoleType(role);
                        companyUser.setUserName(name);
//                        companyUser.setSecucode(shemi);
//                        companyUser.setAuthtype(shouq);

                        User user = userService.findByPhone(phone);//用户表：手机号是否已经存在
                        //查找用户，不存在就创建一个
                        if(user ==null) {
                        	//添加用户
                        	 Org org = (Org)request.getSession().getAttribute("org"); //机构表
                             String relationNo = org.getRelation_no();
                             Long orgId = org.getId();
                             User user1 = new User();
                             user1.setOrgId(orgId);
                             user1.setRelationNo(relationNo);
                             user1.setRealName(name);
                             user1.setLoginName(phone);
                             user1.setSex(sex);
                             user1.setPhone(phone);
                             user1.setCreateDate(createDate);
                             user1.setCreateTime(createTime);
                             user1.setIsAuth("F");
                             user1.setIsSetTransPwd("F");
//                             user1.setCompanyId(companyId);
//                             user1.setRole(role);
                             user1.setToken(UUID.randomUUID().toString());
                             user1.setWorkKey(NumberUtil.getRandomWorkKey(10));
                             user1.setSoleCode(OrderNoUtil.genOrderNo("C", 16));
                             userService.addUser(user1);
                             User user2 = userService.findByPhone(phone);
                             //添加用户账户表
                             UserAccount userAccount = new UserAccount();
                             userAccount.setUserId(user2.getId());
                             String default_pwd = systemParamService.findByParamName("default_pwd").getParam_text();
                             String sysPwd = new MD5().calcMD5(default_pwd);
                             userAccount.setSysPwd(sysPwd);
                             userAccount.setCstatus("normal");
                             userAccountService.addUserAccount(userAccount);
                             companyUser.setUserId(user2.getId());
                        }else {//存在则绑定到已有用户上
                            companyUser.setUserId(user.getId());
                        }

                        companyUser.setCreateDate(createDate);
                        companyUser.setCreateTime(createTime);
                        companyUserService.add(companyUser);
						}else {
                            falseCount++;
                        }

					}
					int successCount = totalCount-falseCount;
					return ResultData.unDataResult("success", "总共导入了"+totalCount+"条记录，其中成功的条数是:"+successCount+"，失败的条数是："+falseCount+"。可能的失败原因：添加记录的格式不正确或必填的字段未填写。");
				} else {
					return ResultData.unDataResult("fail", "文件格式不正确");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResultData.unDataResult("fail", "系统异常");
			}
		} else {
			return ResultData.unDataResult("fail", "没有文件上传");
		}
    }
    @RequestMapping(value = "/addOrExit")
    public Result addOrExit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String addOrEdit = request.getParameter("addOrEdit");
        String id = request.getParameter("id");
        String sectionId = request.getParameter("sectionId");
        String phone = request.getParameter("phone");
        String roleType = request.getParameter("roleType");
        String userName = request.getParameter("userName");
        String sex = request.getParameter("sex");
        System.out.println("添加的id是"+id);
        CompanyOper companyOper = (CompanyOper)request.getSession().getAttribute("companyOper");
        Long companyId = companyOper.getCompany_id();

        if (StringUtils.isBlank(sectionId) || StringUtils.isBlank(roleType) || StringUtils.isBlank(userName)) {
            return ResultData.unDataResult("fail", "缺少参数");
        }

        CompanyUser companyUser = new CompanyUser();
        if (!StringUtils.isBlank(id)) {
            companyUser.setId(Long.parseLong(id));
        }
        companyUser.setSectionId(Long.valueOf(sectionId));
        companyUser.setUserName(userName);
        companyUser.setRoleType(roleType);
        companyUser.setSex(sex);
        if ("add".equals(addOrEdit)) {
            companyUser.setCompanyId(Long.valueOf(companyId));
            companyUser.setStatus("applyComfirm");
            companyUser.setCurrentStatus("normal");
            Date date = new Date();
            String createDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String createTime = new SimpleDateFormat("HH:mm:ss").format(date);
            User user = userService.findByPhone(phone);
            if (user == null){
                //添加用户
                Org org = (Org)request.getSession().getAttribute("org");
                String relationNo = org.getRelation_no();
                Long orgId = org.getId();

                User user1 = new User();
                user1.setOrgId(orgId);
                user1.setRelationNo(relationNo);
                user1.setRealName(userName);
                user1.setLoginName(phone);
                user1.setPhone(phone);
                user1.setCreateDate(createDate);
                user1.setCreateTime(createTime);
                user1.setIsAuth("F");
                user1.setIsSetTransPwd("F");
//                user1.setCompanyId(companyId);
//                user1.setRole(roleType);
                user1.setToken(UUID.randomUUID().toString());
                user1.setWorkKey(NumberUtil.getRandomWorkKey(10));
                user1.setSoleCode(OrderNoUtil.genOrderNo("C", 16));

                userService.addUser(user1);

                User user2 = userService.findByPhone(phone);
                //添加用户账户表
                UserAccount userAccount = new UserAccount();
                userAccount.setUserId(user2.getId());
                String default_pwd = systemParamService.findByParamName("default_pwd").getParam_text();
                String sysPwd = new MD5().calcMD5(default_pwd);
                userAccount.setSysPwd(sysPwd);
                userAccount.setCstatus("normal");
                userAccountService.addUserAccount(userAccount);

                companyUser.setUserId(user2.getId());
            }else{
                companyUser.setUserId(user.getId());
            }
            companyUser.setCreateDate(createDate);
            companyUser.setCreateTime(createTime);
            int insert = companyUserService.add(companyUser);
            return insert > 0 ? ResultData.unDataResult("success", "插入成功") : Result.unDataResult("fail", "插入失败");
        } else if ("edit".equals(addOrEdit)) {
            companyUser.setStatus("applyComfirm");
            int update = companyUserService.update(companyUser);
            CompanyUser companyUser1 = companyUserService.findById(Long.valueOf(id));
            User user2 = userService.findById(companyUser1.getUserId());
            if ("applySuc".equals(companyUser1.getStatus()) && companyUser1.getCompanyId().equals(user2.getCompanyId())){
                userService.updateRole(roleType,companyUser1.getUserId());
            }
            return update > 0 ? ResultData.unDataResult("success", "修改成功") : Result.unDataResult("fail", "修改失败");
        } else {
            return ResultData.unDataResult("fail", "系统异常");
        }
    }

    /**
     * 删除公司员工数据
     */
    @RequestMapping(value = "/delete")
    public Result deleteNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String id=request.getParameter("id");
            if(StringUtils.isBlank(id)){
                return ResultData.unDataResult("fail","缺少参数");
            }
            List<Long> list=new ArrayList<Long>();
            String[] ids = id.split(",");
            for(String s : ids){
                CompanyUser companyUser1 = companyUserService.findById(Long.valueOf(s));
                User user2 = userService.findById(companyUser1.getUserId());
                if ("applySuc".equals(companyUser1.getStatus()) && companyUser1.getCompanyId().equals(user2.getCompanyId()) && "normal".equals(companyUser1.getCurrentStatus())){
                    userService.updateByUserId(null,null,companyUser1.getUserId());
                }
                list.add(Long.valueOf(s));
            }
            Integer delete = companyUserService.del(list);
            return delete > 0 ? ResultData.unDataResult("success", "删除成功") : Result.unDataResult("fail", "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.unDataResult("fail", "系统异常");
        }
    }
    /**
	 * @param url              请求的Url
	 * @param paramMap         参数
	 * @param file             文件
	 * @param fileRequestParam form表单对应的文件name属性名
	 * @return
	 * @throws Exception
	 */
	public static Connection.Response doPostFileRequest(String url, Map<String, String> paramMap, File file, String
			fileRequestParam) throws Exception {
		if (StringUtils.isBlank(url)) {
			throw new Exception("The request URL is blank.");
		}
		// Https请求
		if (StringUtils.startsWith(url, "https")) {
			trustEveryone();
		}
		Connection connection = Jsoup.connect(url);
		connection.method(Connection.Method.POST);
		connection.timeout(12000);
		connection.header("Content-Type", "multipart/form-data");
		connection.ignoreHttpErrors(true);
		connection.ignoreContentType(true);
		if (paramMap != null && !paramMap.isEmpty()) {
			connection.data(paramMap);
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			//FileInputStream fiss = new FileInputStream(new File(""));
			//connection.data(fileRequestParam, file.getName(), fiss);
			connection.data(fileRequestParam, file.getName(), fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection.Response response = connection.execute();
			if (response.statusCode() != HttpStatus.SC_OK) {
				throw new Exception("http请求响应码:" + response.statusCode() + "");
			}
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 解决Https请求,返回404错误
	 */
	private static void trustEveryone() {
		try {
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[]{new X509TrustManager() {

				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			}}, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
