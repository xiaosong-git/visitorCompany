package com.manage.model;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;

@Table(name = "tbl_user")
@NameStyle(value = Style.normal)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属机构
     */
    //@Column(name = "orgId")
    private Long orgId;

    /**
     * 机构关联 方便查看无限下级
     */
    //@Column(name = "relationNo")
    private String relationNo;

    /**
     * 真实姓名
     */
    //@Column(name = "realName")
    private String realName;
    /**
     * 性别
     */
    //@Column(name = "sex")
    private String sex;
    /**
     * 昵称
     */
    //@Column(name = "niceName")
    private String niceName;

    /**
     * 登录账号
     */
    //@Column(name = "loginName")
    private String loginName;

    /**
     * 证件类型 默认就是身份证 01
     */
    //@Column(name = "idType")
    private String idType;

    /**
     * 证件号 用密钥加密，取出来再解密
     */
    //@Column(name = "idNO")
    private String idNO;

    /**
     * 联系手机号
     */
    private String phone;

    /**
     * 建立日期 yyyy-MM-dd
     */
    //@Column(name = "createDate")
    private String createDate;

    /**
     * 建立时间 HH:mm:ss
     */
    //@Column(name = "createTime")
    private String createTime;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String area;

    /**
     * 地址
     */
    private String addr;

    /**
     * 是否实名 F:未实名 T：实名
     */
    //@Column(name = "isAuth")
    private String isAuth;

    /**
     * 实名日期 yyyy-MM-dd
     */
    //@Column(name = "authDate")
    private String authDate;

    /**
     * 实名时间 HH:mm:ss
     */
    //@Column(name = "authTime")
    private String authTime;

    /**
     * 证件正面照
     */
    //@Column(name = "idFrontImgUrl")
    private String idFrontImgUrl;

    /**
     * 证件反面照
     */
    //@Column(name = "idOppositeImgUrl")
    private String idOppositeImgUrl;

    /**
     * 手持证件照
     */
    //@Column(name = "idHandleImgUrl")
    private String idHandleImgUrl;

    /**
     * 银行卡正面照
     */
    //@Column(name = "bankCardImgUrl")
    private String bankCardImgUrl;

    //@Column(name = "headImgUrl")
    private String headImgUrl;

    private String token;

    /**
     * 密钥 用于加解密身份证号、卡号
     */
    //@Column(name = "workKey")
    private String workKey;

    /**
     * 是否设置支付密码 T：设置 F：未设置
     */
    //@Column(name = "isSetTransPwd")
    private String isSetTransPwd;

    /**
     * 二维码存放地址
     */
    //@Column(name = "qrcodeUrl")
    private String qrcodeUrl;

    /**
     * 公司id
     */
    //@Column(name = "companyId")
    private Long companyId;

    /**
     * staff:普通员工,manage:管理员,front:前台
     */
    //@Column(name = "role")
    private String role;

    /**
     * 用户唯一标识码
     */
    //@Column(name = "soleCode")
    private String soleCode;


    //非数据库映射
    @Transient
    private String orgName;
    @Transient
    private String isAuthName;
    @Transient
    private String userAccountStatusName;
    @Transient
    private String companyName;

    public User() {
    }

    public String getSoleCode() {
        return soleCode;
    }

    public void setSoleCode(String soleCode) {
        this.soleCode = soleCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserAccountStatusName() {
        return userAccountStatusName;
    }

    public void setUserAccountStatusName(String userAccountStatusName) {
        this.userAccountStatusName = userAccountStatusName;
    }

    public String getIsSetTransPwd() {
        return isSetTransPwd;
    }

    public void setIsSetTransPwd(String isSetTransPwd) {
        this.isSetTransPwd = isSetTransPwd;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIsAuthName() {
        return isAuthName;
    }

    public void setIsAuthName(String isAuthName) {
        this.isAuthName = isAuthName;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取所属机构
     *
     * @return orgId - 所属机构
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 设置所属机构
     *
     * @param orgId 所属机构
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取机构关联 方便查看无限下级
     *
     * @return relationNo - 机构关联 方便查看无限下级
     */
    public String getRelationNo() {
        return relationNo;
    }

    /**
     * 设置机构关联 方便查看无限下级
     *
     * @param relationNo 机构关联 方便查看无限下级
     */
    public void setRelationNo(String relationNo) {
        this.relationNo = relationNo == null ? null : relationNo.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return realName - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
     * 获取昵称
     *
     * @return niceName - 昵称
     */
    public String getNiceName() {
        return niceName;
    }

    /**
     * 设置昵称
     *
     * @param niceName 昵称
     */
    public void setNiceName(String niceName) {
        this.niceName = niceName == null ? null : niceName.trim();
    }

    /**
     * 获取登录账号
     *
     * @return loginName - 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录账号
     *
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取证件类型 默认就是身份证 01
     *
     * @return idType - 证件类型 默认就是身份证 01
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型 默认就是身份证 01
     *
     * @param idType 证件类型 默认就是身份证 01
     */
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    /**
     * 获取证件号 用密钥加密，取出来再解密
     *
     * @return idNO - 证件号 用密钥加密，取出来再解密
     */
    public String getIdNO() {
        return idNO;
    }

    /**
     * 设置证件号 用密钥加密，取出来再解密
     *
     * @param idNO 证件号 用密钥加密，取出来再解密
     */
    public void setIdNO(String idNO) {
        this.idNO = idNO == null ? null : idNO.trim();
    }

    /**
     * 获取联系手机号
     *
     * @return phone - 联系手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系手机号
     *
     * @param phone 联系手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取建立日期 yyyy-MM-dd
     *
     * @return createDate - 建立日期 yyyy-MM-dd
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 设置建立日期 yyyy-MM-dd
     *
     * @param createDate 建立日期 yyyy-MM-dd
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 获取建立时间 HH:mm:ss
     *
     * @return createTime - 建立时间 HH:mm:ss
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置建立时间 HH:mm:ss
     *
     * @param createTime 建立时间 HH:mm:ss
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取县
     *
     * @return area - 县
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置县
     *
     * @param area 县
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取地址
     *
     * @return addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 获取是否实名 F:未实名 T：实名
     *
     * @return isAuth - 是否实名 F:未实名 T：实名
     */
    public String getIsAuth() {
        return isAuth;
    }

    /**
     * 设置是否实名 F:未实名 T：实名
     *
     * @param isAuth 是否实名 F:未实名 T：实名
     */
    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth == null ? null : isAuth.trim();
    }

    /**
     * 获取实名日期 yyyy-MM-dd
     *
     * @return authDate - 实名日期 yyyy-MM-dd
     */
    public String getAuthDate() {
        return authDate;
    }

    /**
     * 设置实名日期 yyyy-MM-dd
     *
     * @param authDate 实名日期 yyyy-MM-dd
     */
    public void setAuthDate(String authDate) {
        this.authDate = authDate == null ? null : authDate.trim();
    }

    /**
     * 获取实名时间 HH:mm:ss
     *
     * @return authTime - 实名时间 HH:mm:ss
     */
    public String getAuthTime() {
        return authTime;
    }

    /**
     * 设置实名时间 HH:mm:ss
     *
     * @param authTime 实名时间 HH:mm:ss
     */
    public void setAuthTime(String authTime) {
        this.authTime = authTime == null ? null : authTime.trim();
    }

    /**
     * 获取证件正面照
     *
     * @return idFrontImgUrl - 证件正面照
     */
    public String getIdFrontImgUrl() {
        return idFrontImgUrl;
    }

    /**
     * 设置证件正面照
     *
     * @param idFrontImgUrl 证件正面照
     */
    public void setIdFrontImgUrl(String idFrontImgUrl) {
        this.idFrontImgUrl = idFrontImgUrl == null ? null : idFrontImgUrl.trim();
    }

    /**
     * 获取证件反面照
     *
     * @return idOppositeImgUrl - 证件反面照
     */
    public String getIdOppositeImgUrl() {
        return idOppositeImgUrl;
    }

    /**
     * 设置证件反面照
     *
     * @param idOppositeImgUrl 证件反面照
     */
    public void setIdOppositeImgUrl(String idOppositeImgUrl) {
        this.idOppositeImgUrl = idOppositeImgUrl == null ? null : idOppositeImgUrl.trim();
    }

    /**
     * 获取手持证件照
     *
     * @return idHandleImgUrl - 手持证件照
     */
    public String getIdHandleImgUrl() {
        return idHandleImgUrl;
    }

    /**
     * 设置手持证件照
     *
     * @param idHandleImgUrl 手持证件照
     */
    public void setIdHandleImgUrl(String idHandleImgUrl) {
        this.idHandleImgUrl = idHandleImgUrl == null ? null : idHandleImgUrl.trim();
    }

    /**
     * 获取银行卡正面照
     *
     * @return bankCardImgUrl - 银行卡正面照
     */
    public String getBankCardImgUrl() {
        return bankCardImgUrl;
    }

    /**
     * 设置银行卡正面照
     *
     * @param bankCardImgUrl 银行卡正面照
     */
    public void setBankCardImgUrl(String bankCardImgUrl) {
        this.bankCardImgUrl = bankCardImgUrl == null ? null : bankCardImgUrl.trim();
    }

    /**
     * @return headImgUrl
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * @param headImgUrl
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    /**
     * 获取密钥 用于加解密身份证号、卡号
     *
     * @return workKey - 密钥 用于加解密身份证号、卡号
     */
    public String getWorkKey() {
        return workKey;
    }

    /**
     * 设置密钥 用于加解密身份证号、卡号
     *
     * @param workKey 密钥 用于加解密身份证号、卡号
     */
    public void setWorkKey(String workKey) {
        this.workKey = workKey == null ? null : workKey.trim();
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", relationNo='" + relationNo + '\'' +
                ", realName='" + realName + '\'' +
                ", niceName='" + niceName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", idType='" + idType + '\'' +
                ", idNO='" + idNO + '\'' +
                ", phone='" + phone + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createTime='" + createTime + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", addr='" + addr + '\'' +
                ", isAuth='" + isAuth + '\'' +
                ", authDate='" + authDate + '\'' +
                ", authTime='" + authTime + '\'' +
                ", idFrontImgUrl='" + idFrontImgUrl + '\'' +
                ", idOppositeImgUrl='" + idOppositeImgUrl + '\'' +
                ", idHandleImgUrl='" + idHandleImgUrl + '\'' +
                ", bankCardImgUrl='" + bankCardImgUrl + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", workKey='" + workKey + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}