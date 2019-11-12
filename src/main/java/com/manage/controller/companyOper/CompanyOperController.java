package com.manage.controller.companyOper;

import com.manage.controller.base.BaseController;
import com.manage.model.*;
import com.manage.service.ICompanyOperService;
import com.manage.service.ICompanyRoleService;
import com.manage.service.ISystemParamsService;
import com.manage.utils.RefectionUtil;
import com.manage.utils.StringUtil;
import com.manage.utils.mapper.SqlUtil;
import com.manage.utils.page.PageInfo;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import com.xdream.kernel.util.MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by L on 2017/8/12.
 */

@RequestMapping("/companyOper")
@RestController
public class CompanyOperController extends BaseController {

    @Autowired
    private ICompanyOperService companyOperService;

    @Autowired
    private ISystemParamsService systemParamService;

    @Autowired
    private ICompanyRoleService companyRoleService;

     /***
     * 新增客服管理
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/saveOper")
    public Result saveOper(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Company company = (Company) request.getSession().getAttribute("company");
        Long company_id = company.getId();
        String role_id = request.getParameter("role_id");
        String oper_name = request.getParameter("oper_name");
        String login_name = request.getParameter("login_name");

        if (StringUtils.isBlank(role_id)) {
            return ResultData.unDataResult("fail", "必须选择角色");
        }
        if (StringUtils.isBlank(oper_name)) {
            return ResultData.unDataResult("fail", "名称不能为空");
        }
        if (StringUtils.isBlank(login_name)) {
            return ResultData.unDataResult("fail", "登录名不能为空");
        }
        if (companyOperService.findByLoginName(login_name) != null) {
            return ResultData.unDataResult("fail", "登录名不能重复");
        } else if (!StringUtil.isNumAndLetterGroup(login_name)) {
            return ResultData.unDataResult("fail", "登录名只能是数字和字母的组合");
        }

        if (login_name != null && !login_name.trim().equals("")) {
            if (companyOperService.findByLoginName(login_name) != null) {
                return ResultData.unDataResult("fail", "编号不能重复");
            }
        }

        try {
            CompanyOper companyOper = new CompanyOper();
            companyOper.setOper_name(oper_name);
            companyOper.setLogin_name(login_name);
            companyOper.setCompany_id(company_id);
            companyOper.setRole_id(Long.parseLong(role_id));
            MD5 md5 = new MD5();
            String default_pwd = systemParamService.findByParamName("default_pwd").getParam_text();
            String pwd = md5.calcMD5(default_pwd);
            companyOper.setPwd(pwd);
            companyOper.setSstatus("0");

            companyOperService.addCompanyOper(companyOper);
            return ResultData.unDataResult("success", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.unDataResult("fail", "操作失败");
        }
    }


    @RequestMapping(value = "/updateOper")
    public Result updateOper(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String oper_name = request.getParameter("oper_name");
        String login_name = request.getParameter("login_name");
        String role_id = request.getParameter("role_id");

        if (StringUtils.isBlank(role_id)) {
            return ResultData.unDataResult("fail", "必须选择角色");
        }
        if (StringUtils.isBlank(id)) {
            return ResultData.unDataResult("fail", "参数不完整-id");
        }

        if (StringUtils.isBlank(oper_name)) {
            return ResultData.unDataResult("fail", "名称不能为空");
        }
        if (StringUtils.isBlank(login_name)) {
            return ResultData.unDataResult("fail", "登录名不能为空");
        } else if (!StringUtil.isNumAndLetterGroup(login_name)) {
            return ResultData.unDataResult("fail", "登录名只能是数字和字母的组合");
        }
        try {
            CompanyOper companyOper = companyOperService.findByLoginName(login_name);
            if (companyOper != null) {
                if (!id.equals(companyOper.getId().intValue())) {
                    return ResultData.unDataResult("fail", "登录名不能重复");
                }
            }

            CompanyOper insert = new CompanyOper();
            insert.setId(Long.parseLong(id));
            insert.setOper_name(oper_name);
            insert.setLogin_name(login_name);
            insert.setRole_id(Long.parseLong(role_id));
            companyOperService.updateById(insert);
            return ResultData.unDataResult("success", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.unDataResult("fail", "操作失败");
        }
    }

    @RequestMapping(value = "/resetPassWord")
    public Result resetPassWord(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");

        if (StringUtils.isBlank(id)) {
            return Result.unDataResult("fail", "参数不完整");
        }
        try {
            CompanyOper companyOper = new CompanyOper();
            companyOper.setId(Long.parseLong(id));
            MD5 md5 = new MD5();
            String default_pwd = systemParamService.findByParamName("default_pwd").getParam_text();
            String pwd = md5.calcMD5(default_pwd);
            companyOper.setPwd(pwd);

            Integer isReset = companyOperService.updateByPwd(companyOper);
            return isReset > 0 ? ResultData.unDataResult("success", "重置密码成功") : Result.unDataResult("fail", "重置密码失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.unDataResult("fail", "重置密码异常");
        }
    }

    /**
     * 获取操作员（只能是本机构的及其以下）
     *
     * @param request
     * @param response
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getOrgPageOper")
    public Result getOrgPageOper(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {
        HttpSession session = request.getSession();
        //包含查询条件的对象
//        CompanyOper searchOper = RefectionUtil.getObjectFromRequest(request, CompanyOper.class);
        //登录的操作员
        CompanyOper companyOper = (CompanyOper) session.getAttribute("companyOper");
        Long company_id = companyOper.getCompany_id();

        String oper_name = request.getParameter("oper_name");

        List<CompanyOper> opers = companyOperService.findByPage(oper_name,company_id, page, pageSize);
        Map<Long, Object> map = new HashMap<Long, Object>();

        for (CompanyOper tempOper : opers) {
            UUID uuid = UUID.randomUUID();
            tempOper.setToken(String.valueOf(uuid));
            map.put(tempOper.getId(), uuid);
        }
        session.setAttribute("rePwdVerify", map);
        PageInfo<CompanyOper> operPageInfo = new PageInfo<CompanyOper>(opers);
        return operPageInfo != null ? ResultData.dataResult("success", "分页读取操作员成功", operPageInfo) : Result.unDataResult("fail", "分页读取操作员失败");
    }

    @RequestMapping(value = "/delOperBatch")
    public Result delOperBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = request.getParameter("ids");
        if (StringUtils.isBlank(ids)) {
            return ResultData.unDataResult("fail", "缺少参数");
        }
        CompanyOper operSession = (CompanyOper) request.getSession().getAttribute("companyOper");
        String operId = String.valueOf(operSession.getId());
        List<String> id =  SqlUtil.getNoIdsList(operId,ids);
        if (id.size()<1){
            return ResultData.unDataResult("fail", "不能删除自己");
        }
        companyOperService.batchDelete(id);
        return ResultData.unDataResult("success", "批量删除操作员成功");
    }
}
