package com.manage.controller.company;

import com.manage.controller.base.BaseController;
import com.manage.model.Company;
import com.manage.model.User;
import com.manage.model.UserAccount;
import com.manage.service.*;
import com.manage.utils.NumberUtil;
import com.manage.utils.OrderNoUtil;
import com.manage.utils.page.PageInfo;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/company")
@RestController
public class CompanyController extends BaseController {
    @Autowired
    private ICompanyService companyService;

    @RequestMapping(value = "/exitApplyType")
    public Result exitApplyType(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Company company = (Company) request.getSession().getAttribute("company");
        Long company_id = company.getId();
        String applyType = request.getParameter("applyType");

        if (StringUtils.isBlank(applyType)) {
            return ResultData.unDataResult("fail", "缺少参数");
        }
        int update = companyService.updateApplyType(company_id, applyType);
        return update > 0 ? ResultData.unDataResult("success", "修改成功") : Result.unDataResult("fail", "修改失败");
    }
}
