package com.manage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.manage.controller.base.BaseController;
import com.manage.dao.companyUserInfoMapper;
import com.manage.dao.loginInfoMapper;
import com.manage.dao.yaoRecordMapper;
import com.manage.model.*;
import com.manage.service.YaoyueService;
import com.manage.utils.HttpClientUtil;
import com.manage.utils.QRCodeUtil;
import com.manage.utils.page.PageInfo;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/yaoyue")
@RestController
public class YaoyueController extends BaseController {
    @Autowired
    private yaoRecordMapper yaoRecordMapper;

    @Autowired
    private loginInfoMapper loginInfoMapper;

    @Autowired
    private companyUserInfoMapper userInfoMapper;

    @Autowired
    private YaoyueService yaoyueService;

    @Value("${shenhe.url}")
    private String shenHeUrl;

    @Value("${sms.urlEncoded}")
    private String smsType;

    @RequestMapping("/getReason")
    public Result getReason(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        HttpSession session = request.getSession();
        //登录的操作员
        CompanyOper companyOper = (CompanyOper) session.getAttribute("companyOper");
        try{
            boolean flag=true;
            String s1 = request.getParameter("id");
//            loginInfoExample example=new loginInfoExample();
//            example.createCriteria().andLoginNameEqualTo(companyOper.getLogin_name());
//            List<loginInfo> infos = loginInfoMapper.selectByExample(example);
//            Long id = infos.get(0).getCompanyId();
//            companyUserInfoExample example2 =new companyUserInfoExample();
//            example2.createCriteria().andIdEqualTo(id).andIsyaoyueEqualTo("1");
//            List<companyUserInfo> infos1 = userInfoMapper.selectByExample(example2);
//            if(infos1.size()==0){
//                flag=false;
//            }
            if(flag){
                if(s1 !=null){
                    String opt = request.getParameter("opt");
                    if(opt.equals("0")){
                        opt="applySuccess";
                    }else {
                        opt="applyFail";
                    }
                    yaoRecord rc=new yaoRecord();
                    rc.setId(Long.parseLong(s1));
                    rc.setCstatus(opt);
                    int i = yaoRecordMapper.updateByPrimaryKeySelective(rc);
                    return i>0? ResultData.unDataResult("success", "审核成功"):ResultData.unDataResult("fail", "审核失败");
                }else {
                    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date d =new Date();
                    String s = sdf.format(d);
                    Long company_id = companyOper.getCompany_id();
                    String yaoyuetitle = request.getParameter("yaoyuetitle");
                    String visitDate = request.getParameter("visitDate");
                    String visitDate2 = request.getParameter("visitDate2");
                    String reason = request.getParameter("reason");
                    String mobliephone = request.getParameter("mobliephone");
                    yaoRecord yaoRecord=new yaoRecord();
                    yaoRecord.setYaoyuetitle(yaoyuetitle);//姓名
                    yaoRecord.setVisitdate(visitDate);//开始时间
                    yaoRecord.setAnswercontent(visitDate2);//结束时间
                    yaoRecord.setReason(reason);//备注
                    yaoRecord.setUserid(companyOper.getLogin_name());//当前登录人登录账号
                    yaoRecord.setCompanyid(company_id);//当前登录人companyId
                    yaoRecord.setOrgcode(mobliephone);//手机号
                    yaoRecord.setEnddate(s);    //操作人的当前时间
                    int i = yaoRecordMapper.insertSelective(yaoRecord);
                    Long recordId = yaoRecord.getId();
                    System.out.println("新增数据的ID列为："+recordId);
                    Map<String,String> map=new HashMap<String, String>();
                    map.put("name",yaoyuetitle);
                    map.put("phone",mobliephone);
                    map.put("desc",reason);
                    map.put("startTime",visitDate);
                    map.put("endTime",visitDate2);
                    map.put("companyId",String.valueOf(company_id));
                    map.put("loginName",companyOper.getLogin_name());
                    map.put("id",String.valueOf(recordId));

                    //把二维码图片地址发送到短信上

                    String sendParams="http://192.168.10.113:801/visitor-company/#/app/yaoyue/create2?yaoyuetitle="+yaoyuetitle+"&visitDate="+visitDate+"&visitDate2="+visitDate2+"&reason="+reason+"&mobliephone="+mobliephone+"&id="+recordId;
                    // 生成的二维码的路径及名称
                    String destPath = "E:\\qrcodeimgs/";
                  //  destPath+="/"+new Random().nextInt(99999999)+".jpg";
                    String jpgName=new Random().nextInt(99999999)+".jpg";
                    //生成二维码
                    QRCodeUtil.encode(sendParams, null, destPath+jpgName, true);

                    String newUrl="http://127.0.0.1/res/"+jpgName;
                    map.put("qrcodePath",newUrl);
                    String str = HttpClientUtil.sendPost(shenHeUrl, map, smsType);
                    if(str!=null){
                        System.out.println("返回的结果是："+str.toString());
                    }
                    return i>0? ResultData.unDataResult("success", "邀约成功"):ResultData.unDataResult("fail", "新增失败");
                }
            }else{
                return  ResultData.unDataResult("fail", "没有邀约权限！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultData.unDataResult("fail", "操作失败");
        }

    }

    @RequestMapping("/hasRuleYaoyue")
    public Result hasRuleYaoyue(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {


        HttpSession session = request.getSession();
        //包含查询条件的对象
//        CompanyOper searchOper = RefectionUtil.getObjectFromRequest(request, CompanyOper.class);
        CompanyOper companyOper = (CompanyOper) session.getAttribute("companyOper");
        Long company_id = companyOper.getCompany_id();

        Page<yaoRecord> byPage = yaoyueService.findByPage(page, pageSize);
        PageInfo<yaoRecord> operPageInfo = new PageInfo<yaoRecord>(byPage);
        return operPageInfo != null ? ResultData.dataResult("success", "分页读取操作员成功", operPageInfo) : Result.unDataResult("fail", "分页读取操作员失败");
    }

    //TODO
    @RequestMapping("/isyaoyueone")
    public Result isyaoyueone(HttpServletRequest request,HttpServletResponse response) throws Exception{
                try {
            HttpSession session = request.getSession();
            //登录的操作员
            CompanyOper companyOper = (CompanyOper) session.getAttribute("companyOper");
            loginInfoExample example=new loginInfoExample();
            example.createCriteria().andLoginNameEqualTo(companyOper.getLogin_name());
            List<loginInfo> infos = loginInfoMapper.selectByExample(example);
            boolean flag=false;
            Long id = infos.get(0).getCompanyId();
            companyUserInfoExample example2 =new companyUserInfoExample();
            example2.createCriteria().andIdEqualTo(id).andIsyaoyueEqualTo("1");
            List<companyUserInfo> infos1 = userInfoMapper.selectByExample(example2);
            if(infos1.size()>0){
                flag=true;
            }
            if(flag){
                return ResultData.unDataResult("success", "操作成功");
            }else{
                return ResultData.unDataResult("success", "没有邀约权限！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultData.unDataResult("fail", "操作失败");
        }

    }


}
