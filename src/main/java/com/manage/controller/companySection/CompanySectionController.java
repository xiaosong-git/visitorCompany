package com.manage.controller.companySection;

import com.manage.controller.base.BaseController;
import com.manage.dao.CompanyDepeMapper;
import com.manage.model.*;
import com.manage.service.*;
import com.manage.utils.page.PageInfo;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
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

@RequestMapping("/companySection")
@RestController
public class CompanySectionController extends BaseController {

    @Autowired
    private ICompanySectionService companySectionService;

    @Autowired
    private ICompanyUserService companyUserService;

    @Autowired
    private CompanyDepeMapper depeMapper;

    /**
     * 分页查询公司
     */
    @RequestMapping(value = "/findByPage")
    public Result findByPage(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {
        CompanyOper companyOper = (CompanyOper)request.getSession().getAttribute("companyOper");
        long companyId = companyOper.getCompany_id();
        String sectionName = request.getParameter("sectionName");
        List<CompanySection> companySections = companySectionService.findByPage(companyId, sectionName, page, pageSize);
        PageInfo<CompanySection> companySectionPageInfo = new PageInfo<CompanySection>(companySections);
        return companySectionPageInfo != null ? ResultData.dataResult("success", "读取部门信息成功", companySectionPageInfo) : Result.unDataResult("fail", "读取部门信息失败");
    }

    @RequestMapping(value = "/addOrExit")
    public Result addNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String addOrEdit = request.getParameter("addOrEdit");
        String id = request.getParameter("id");
//        String sectionCode = request.getParameter("sectionCode");
        String sectionName = request.getParameter("sectionName");
        CompanyOper companyOper = (CompanyOper)request.getSession().getAttribute("companyOper");
        long companyId = companyOper.getCompany_id();

        if (StringUtils.isBlank(sectionName)) {
            return ResultData.unDataResult("fail", "缺少参数");
        }

        CompanySection companySection = new CompanySection();
        if (!StringUtils.isBlank(id)) {
            companySection.setId(Long.parseLong(id));
        }
//        CompanyDepeExample example=new CompanyDepeExample();
//        example.createCriteria().andSectionnameEqualTo(sectionName);
//        List<CompanyDepe> companyDepes = depeMapper.selectByExample(example);
        List<CompanySection> companyDepes = companySectionService.findByPage(companyId, sectionName, 1, 2);
        if(companyDepes.size()>0){
            return   Result.unDataResult("fail", "部门名称已使用，请更换！");
        }
        companySection.setSectionCode(ToFirstChar(sectionName).toUpperCase());
        companySection.setSectionName(sectionName);
        companySection.setCompanyId(Long.valueOf(companyId));

        if ("add".equals(addOrEdit)) {
            int insert = companySectionService.add(companySection);
            return insert > 0 ? ResultData.unDataResult("success", "插入成功") : Result.unDataResult("fail", "插入失败");
        } else if ("edit".equals(addOrEdit)) {
            int update = companySectionService.update(companySection);
            return update > 0 ? ResultData.unDataResult("success", "修改成功") : Result.unDataResult("fail", "修改失败");
        } else {
            return ResultData.unDataResult("fail", "系统异常");
        }
    }

    /**
     * 删除公司部门数据
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
                List<CompanyUser> companyUsers = companyUserService.findBySectionId(Long.valueOf(s));
                if (companyUsers.size()>0){
                    return ResultData.unDataResult("fail","此公司有用户存在，不能操作！");
                }
                list.add(Long.valueOf(s));
            }
            Integer delete = companySectionService.del(list);
            return delete > 0 ? ResultData.unDataResult("success", "删除成功") : Result.unDataResult("fail", "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.unDataResult("fail", "系统异常");
        }
    }

    /**
     * 分页查询公司(不分页)
     */
    @RequestMapping(value = "/findByAll")
    public Result findByAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CompanyOper companyOper = (CompanyOper)request.getSession().getAttribute("companyOper");
        long companyId = companyOper.getCompany_id();
        List<CompanySection> companySections = companySectionService.findByAll(companyId);
        return companySections != null ? ResultData.dataResult("success", "读取部门信息成功", companySections) : Result.unDataResult("fail", "读取部门信息失败");
    }


    /**
     *      * 获取字符串拼音的第一个字母      * @param chinese      * @return     
     */
    public static String ToFirstChar(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr;
    }

    /**
          * 汉字转为拼音
          * @param chinese
          * @return
          */
    public static String ToPinyin(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                }catch (BadHanyuPinyinOutputFormatCombination e){
                    e.printStackTrace();
                }
            }else{
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr;

    }
}
