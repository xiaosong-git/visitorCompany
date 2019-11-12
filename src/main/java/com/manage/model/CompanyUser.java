package com.manage.model;

import javax.persistence.*;

@Table(name = "tbl_company_user")
public class CompanyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 部门id
     */
    private Long sectionId;
    /**
     * 岗位id
     */
    private Long postId;
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 创建日期yy:MM:dd
     */
    private String createDate;

    /**
     * 创建时间HH:mm:ss
     */
    private String createTime;

    /**
     * 角色:(staff:普通员工,manage:管理员,front:前台)
     */
    private String roleType;

    /**
     * 状态：确认:applySuc/未确认:applying/确认不通过:applyFail
     */
    private String status;
    /**
     * 用户当前状态： deleted/删除，normal/正常
     */
    private String currentStatus;

//    private String secucode;
//    private String authtype;

    private String applyfailansaesn;

	@Transient
    private String phone;
    @Transient
    private String sectionName;

    private String sex;
    @Transient
    private String addr;



    public CompanyUser() {
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
     * 获取公司id
     *
     * @return companyId - 公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取部门id
     *
     * @return sectionId - 部门id
     */
    public Long getSectionId() {
        return sectionId;
    }

    /**
     * 设置部门id
     *
     * @param sectionId 部门id
     */
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
     * 获取用户Id
     *
     * @return userId - 用户Id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名
     *
     * @return userName - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取创建日期yy:MM:dd
     *
     * @return createDate - 创建日期yy:MM:dd
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期yy:MM:dd
     *
     * @param createDate 创建日期yy:MM:dd
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 获取创建时间HH:mm:ss
     *
     * @return createTime - 创建时间HH:mm:ss
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间HH:mm:ss
     *
     * @param createTime 创建时间HH:mm:ss
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取角色:(staff:普通员工,manage:管理员,front:前台)
     *
     * @return roleType - 角色:(staff:普通员工,manage:管理员,front:前台)
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 设置角色:(staff:普通员工,manage:管理员,front:前台)
     *
     * @param roleType 角色:(staff:普通员工,manage:管理员,front:前台)
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * 获取状态：确认:applySuc/未确认:applying/确认不通过:applyFail
     *
     * @return status - 状态：确认:applySuc/未确认:applying/确认不通过:applyFail
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态：确认:applySuc/未确认:applying/确认不通过:applyFail
     *
     * @param status 状态：确认:applySuc/未确认:applying/确认不通过:applyFail
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }



	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getApplyfailansaesn() {
        return applyfailansaesn;
    }

    public void setApplyfailansaesn(String applyfailansaesn) {
        this.applyfailansaesn = applyfailansaesn == null ? null : applyfailansaesn.trim();
    }
}