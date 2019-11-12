package com.manage.controller.companyRole;

import com.manage.controller.base.BaseController;
import com.manage.model.CompanyOper;
import com.manage.model.CompanyRole;
import com.manage.service.ICompanyRoleService;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import com.xdream.kernel.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 角色管理
 * Created by L on 2017/8/9.
 */
@RequestMapping("/companyRole")
@RestController
public class CompanyRoleController extends BaseController {

    @Autowired
    private ICompanyRoleService companyRoleService;

    @RequestMapping(value="/getAllRole")
    public Result getAuth(HttpServletRequest request, HttpServletResponse response) throws Exception{
        /**
         * 获取当前登录的操作员的角色RelationNo
         */
        CompanyOper oper = (CompanyOper)request.getSession().getAttribute("companyOper");
        Long roleId = oper.getRole_id();
        CompanyRole role = companyRoleService.findById(roleId);
        if(role == null){
            return Result.unDataResult("fail","查询操作员角色失败");
        }
        /**
         * 查询本级以及子孙级的角色
         */
        List<CompanyRole> roles = companyRoleService.findLowerRole(role.getRole_relation_no());
        return roles!=null ? ResultData.dataResult("success","读取角色成功",roles) : Result.unDataResult("fail","读取角色失败");
    }

    /**
     * 作用：添加或修改
     * @param request
     * @param response
     */
    @RequestMapping(value = "/addOrEdit")
    public Result addOrEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String addOrEdit = request.getParameter("addOrEdit");
        String id = request.getParameter("id");
        String sid = request.getParameter("sid");
        String role_name = request.getParameter("role_name");
        try {
            //判断参数完整
            if(StringUtils.isBlank(sid) || StringUtils.isBlank(role_name)){
                return Result.unDataResult("fail", "参数不完整");
            }
            else{
                CompanyRole upRole = companyRoleService.findById(Long.valueOf(sid));
                CompanyRole role = new CompanyRole();
                if(!StringUtils.isBlank(id)){
                    role.setId(Long.parseLong(id));
                }
                role.setSid(Long.valueOf(sid));
                role.setRole_name(role_name);
                //判断是添加还是修改请求
                if("add".equals(addOrEdit)){
                    String relationNo = upRole.getRole_relation_no()+StringUtil.formatDate(new Date(), "yyyyMMddHHmmss")+".";
                    role.setRole_relation_no(relationNo);
                    Integer result = companyRoleService.add(role);
                    //判断是否添加成功
                    if (result > 0) {
                        //添加成功
                        return Result.unDataResult("success", "添加成功");
                    } else{
                        //添加失败
                        return Result.unDataResult("success", "添加失败");
                    }
                }
                else if("edit".equals(addOrEdit)){
                    Integer editResult = companyRoleService.update(role);
                    //判断是否修改成功
                    if (editResult > 0) {
                        return Result.unDataResult("success", "修改成功");
                    }
                    else{
                        //修改失败
                        return Result.unDataResult("success", "修改失败");
                    }
                }
            }
            return Result.unDataResult("fail", "操作失败");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.unDataResult("fail", "系统异常");
        }
    }
    /**
     * 作用：删除
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/del")
    public Result del(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String id = request.getParameter("id");
            String role_relation_no = request.getParameter("role_relation_no");
            if (StringUtils.isBlank(id) && StringUtils.isBlank(role_relation_no)) {
                return Result.unDataResult("fail", "参数不完整");
            }
            CompanyRole role = companyRoleService.findByRoleRelationNo(role_relation_no);
            if (role!=null){
                return Result.unDataResult("fail", "该角色还有子角色，无法删除");
            }
            companyRoleService.batchDelete(id);
            return Result.unDataResult("success", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.unDataResult("fail", "系统错误");
        }
    }
}
