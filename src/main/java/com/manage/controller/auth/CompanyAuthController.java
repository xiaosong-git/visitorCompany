package com.manage.controller.auth;

import com.manage.model.*;
import com.manage.service.ICompanyAuthService;
import com.manage.utils.VerifyUtil;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import com.xdream.kernel.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/8/9.
 */

@RequestMapping("/companyAuth")
@RestController
public class CompanyAuthController extends BaseController {

    @Autowired
    private ICompanyAuthService companyAuthService;

    @RequestMapping(value="/getAuth")
    public Result getAuth(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
       CompanyOper companyOper=(CompanyOper)session.getAttribute("companyOper");

        if(companyOper==null){
            return Result.unDataResult("fail","读取权限失败");
        }
        CompanyRole companyRole = companyAuthService.findCompanyRole(companyOper.getRole_id());

        return companyRole!=null ? ResultData.dataResult("success","读取权限成功", companyRole) : Result.unDataResult("fail","读取权限失败");
    }

    @RequestMapping(value="/getRoleAuth")
    public Result getRoleAuth(HttpServletRequest request, HttpServletResponse response) throws Exception{

       String roleId = request.getParameter("roleId");

        if(roleId!=null && !VerifyUtil.isInteger(roleId)){
            return Result.unDataResult("fail","参数异常");
        }

        CompanyRole companyRole =  companyAuthService.findCompanyRole(Long.valueOf(roleId));

        return ResultData.dataResult("success","读取角色权限成功", companyRole);
    }
}
