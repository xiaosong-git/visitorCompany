//package com.manage;
//
//import com.manage.dao.*;
//import com.manage.model.*;
//import com.manage.service.*;
//import com.manage.service.impl.ButtonService;
//import com.manage.service.impl.OperService;
//import com.manage.service.impl.RoleService;
//import com.manage.utils.MD5Util;
//import com.manage.utils.VerifyUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
////相当于  --spring.profiles.active=dev
//@ActiveProfiles(value="dev")
//public class ManageTestApplicationTests {
//
//	@Autowired
//	private ButtonMapping buttonMapping;
//
//	@Autowired
//	private MenuMapping menuMapping;
//
//	@Autowired
//	private OperService operService;
//
//	@Autowired
//	private RoleService roleService;
//
//	@Autowired
//	private ButtonService buttonService;
//
//	@Autowired
//	private IAuthService authService;
//
//	private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
//
//	@Autowired
//	private WebApplicationContext wac; // 注入WebApplicationContext
//
//	//Test
//	public void findById() {
//		System.out.println();
//		System.out.println(buttonMapping.selectByPrimaryKey(1L).getActionUrl());
//	}
//
//	@Test
//	public void test10() {
//		Org org = new Org();
//		org.setOrg_code("123456");
//		org.setOrg_name("123456");
//		org.setRealName("123456");
//		org.setPhone("123456");
//		org.setIdNO("123456");
//		org.setCardNo("123456");
//		org.setBankName("123456");
//		org.setBankPhone("123456");
//		org.setRelation_no("1."+ VerifyUtil.getNowDate(new Date(), "yyyyMMddHHmmss")+".");
//		org.setCreateDate(VerifyUtil.getNowDate(new Date(),"yyyy-MM-dd"));
//		org.setIdType("01");
//		org.setOrgType("agent");
//		org.setSstatus("0");
//		org.setIstop("F");
//		org.setSid(1L);
//
//		OrgAccount orgAccount = new OrgAccount();
//		orgAccount.setPayPwd("000000");
//		orgAccount.setBalance(new BigDecimal(0.00));
//		orgAccount.setFreezeBalance(new BigDecimal(0.00));
//		orgAccount.setCstatus("normal");
//
//		Oper oper = new Oper();
//		oper.setOper_code(org.getOrg_code());
//		oper.setOper_name(org.getOrg_code());
//		oper.setOrg_relation_no(org.getRelation_no());
//		oper.setRole_id(10L);
//		oper.setPwd(MD5Util.MD5("000000"));
//		oper.setSstatus("0");
//		oper.setLogin_name(org.getOrg_code());
//		oper.setOperPosition("terrace");
//
//		try {
//			System.out.println(orgService.addOrgAndOrgAccount(org,orgAccount,oper));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	@Autowired
//	private IOrgAccountService orgAccountService;
//	@Test
//	public void test11() throws Exception {
//		Org org = new Org();
//		org.setOrg_code("123456");
//		org.setOrg_name("123456");
//		org.setRealName("123456");
//		org.setPhone("123456");
//		org.setIdNO("123456");
//		org.setCardNo("123456");
//		org.setBankName("123456");
//		org.setBankPhone("123456");
//		org.setRelation_no("1."+ VerifyUtil.getNowDate(new Date(), "yyyyMMddHHmmss")+".");
//		org.setCreateDate(VerifyUtil.getNowDate(new Date(),"yyyy-MM-dd"));
//		org.setIdType("01");
//		org.setOrgType("agent");
//		org.setSstatus("0");
//		org.setIstop("F");
//		org.setSid(1L);
//
//		OrgAccount orgAccount = new OrgAccount();
//		orgAccount.setPayPwd("000000");
//		orgAccount.setBalance(new BigDecimal(0.00));
//		orgAccount.setFreezeBalance(new BigDecimal(0.00));
//		orgAccount.setCstatus("normal");
//
//		Oper oper = new Oper();
//		oper.setOper_code(org.getOrg_code());
//		oper.setOper_name(org.getOrg_code());
//		oper.setOrg_relation_no(org.getRelation_no());
//		oper.setRole_id(10L);
//		oper.setPwd(MD5Util.MD5("000000"));
//		oper.setSstatus("0");
//		oper.setLogin_name(org.getOrg_code());
//		oper.setOperPosition("terrace");
//
//		System.out.println(orgService.addOrg(org));
//		System.out.println(1/0);
//		System.out.println(orgAccountService.addOrgAccount(orgAccount));
//	}
//
//	//@Test
//	public void insert(){
//		Button btn=new Button();
//		btn.setBtnName("少壮不努力");
//		btn.setBtnCode("seems to be fadding away in my life");
//		btn.setActionUrl("http://www.csdn.com");
//		btn.setMenuId(1L);
//		Integer id = buttonMapping.insert(btn);
//		System.out.println();
//		System.out.println(id+"--"+btn.getId());
//		System.out.println(buttonMapping.selectByPrimaryKey(Long.valueOf(id)).getBtnCode());
//	}
//
//	@Test
//	public void test() throws Exception{
//		List<Auth> auths = new ArrayList<Auth>();
//		Auth auth = new Auth();
//		auth.setButton_id(0L);
//		auth.setMenu_id(0L);
//		auth.setRole_id(0L);
//		auths.add(auth);
//		Auth auth1 = new Auth();
//		auth1.setButton_id(0L);
//		auth1.setMenu_id(0L);
//		auth1.setRole_id(0L);
//		auths.add(auth1);
//		Auth auth2 = new Auth();
//		auth2.setButton_id(0L);
//		auth2.setMenu_id(0L);
//		auth2.setRole_id(0L);
//		auths.add(auth2);
//
//		System.out.println();
//		System.out.println(authService.batchInsert(auths));
//		for (Auth temp:auths) {
//			System.out.println(temp.getId());
//			System.out.println(temp.getButton_id());
//		}
//	}
//
//	@Autowired
//	private OperMapping operMapping;
//
//	@Autowired
//	private OrgMapping orgMapping;
//
//	@Autowired
//	private IOrgService orgService;
//
//	@Autowired
//	private IOrgAccountLsService orgAccountLsService;
//
//	@Autowired
//	private AuthMapping authMapping;
//
//	@Test
//	public void test1() throws Exception{
//		Org org = new Org();
//		org.setOrg_name("6666");
//		org.setSid(1L);
//		org.setIstop("F");
//		System.out.println();
//		System.out.println(org.getId());
//		Integer a =orgService.addOrg(org);
//		System.out.println(a);
//		System.out.println(org.getId());
//	}
//
//	@Test
//	public void test2() throws Exception{
//		TransLs transLs = new TransLs();
//		transLs.setRelationNo("1.");
//		//auth.setId(0);
////		auth.setButton_id(0L);
////		auth.setMenu_id(0L);
////		auth.setRole_id(0L);
//		//translsService.findByPageLeft(transLs);
//	}
//
//
//
//	@Test
//	public void test3() throws Exception{
//		Auth auth = new Auth();
//		//auth.setId(0);
////		auth.setButton_id(0L);
////		auth.setMenu_id(0L);
////		auth.setRole_id(0L);
//		authService.testAddGetKey(auth);
//	}
//
//	@Test
//	public void test4() throws Exception{
//		TransLs transLs = new TransLs();
//		transLs.setRelationNo("1.");
//		List<Map> maps=translsService.sumAndCountTransls(transLs);
//		for (Map<String, Object> map:maps) {
//			for (Map.Entry<String, Object> entry : map.entrySet()) {
//				System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//			}
//			System.out.println("-----------------------");
//		}
//
//	}
//	@Test
//	public void test5() throws Exception{
//		TransLs transLs = new TransLs();
//		transLs.setRelationNo("1.");
//		Map<String, Object> maps=translsService.sumAndCountTranslsByWithdrawalFee(transLs);
//		for (Map.Entry<String, Object> entry : maps.entrySet()) {
//			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//		}
//	}
//
//	@Autowired
//	ITransTypeService transTypeService;
//
//	@Autowired
//	ISettleService settleService;
//
//	@Test
//	public void test6() throws Exception{
//		//relationNo orgName beginDate endDate
//		Map map = new HashMap();
//		map.put("relationNo","1.");
//		//System.out.println(settleService.findByPageLeft(map).size());
//
//	}
//
//
//	@Autowired
//	IUserService userService;
//
//	@Test
//	public void test7() throws Exception{
//		//userService.findByIdLeft(10L);
//		User user = new User();
//		//user.setRelationNo("");
//		System.out.println(userService.findByPageLeft(user,1,100).size());
//	}
//
//	/*@Before // 在测试开始前初始化工作
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
//
//	@Test
//	public void testQ1() throws Exception {
//		Map<String, Object> map = new HashMap<>();
//		map.put("address", "合肥");
//
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/q1?address=合肥").content(JSONObject.toJSONString(map)))
//				.andExpect(WebApplicationContext.status().isOk())// 模拟向testRest发送get请求
//				.andExpect(WebApplicationContext.content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
//				.andReturn();// 返回执行请求的结果
//
//		System.out.println(result.getResponse().getContentAsString());
//	}
//
//	@Test
//	public void testSave() throws Exception {
//		Map<String, Object> map = new HashMap<>();
//		map.put("address", "合肥");
//		map.put("name", "测试");
//		map.put("age", 50);
//
//		MvcResult result = mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
//				.andExpect(status().isOk())// 模拟向testRest发送get请求
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
//				.andReturn();// 返回执行请求的结果
//
//		System.out.println(result.getResponse().getContentAsString());
//	}
//
//	@Test
//	public void testPage() throws Exception {
//		MvcResult result = mockMvc.perform(post("/page").param("pageNo", "1").param("pageSize", "2"))
//				.andExpect(status().isOk())// 模拟向testRest发送get请求
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
//				.andReturn();// 返回执行请求的结果
//
//		System.out.println(result.getResponse().getContentAsString());
//	}*/
//
//}
