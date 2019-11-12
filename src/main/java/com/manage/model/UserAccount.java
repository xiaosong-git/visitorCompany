package com.manage.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "tbl_user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 系统密码 密文
     */
    private String sysPwd;

    /**
     * 账户交易密码 密文
     */
    private String payPwd;

    /**
     * 当前余额
     */
    private BigDecimal balance;

    /**
     * 冻结余额
     */
    private BigDecimal freezeBalance;

    /**
     * 状态 normal:正常 freeze:冻结 del:删除
     */
    private String cstatus;

    /**
     * 原因
     */
    private String handleCause;

    /**
     * 操作时间
     */
    private String handleTime;

    /**
     * 操作人Id
     */
    private Long operId;

    /**
     * 手势密码
     */
    private String gesturePwd;


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
     * 获取用户
     *
     * @return userId - 用户
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户
     *
     * @param userId 用户
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取系统密码 密文
     *
     * @return sysPwd - 系统密码 密文
     */
    public String getSysPwd() {
        return sysPwd;
    }

    /**
     * 设置系统密码 密文
     *
     * @param sysPwd 系统密码 密文
     */
    public void setSysPwd(String sysPwd) {
        this.sysPwd = sysPwd == null ? null : sysPwd.trim();
    }

    /**
     * 获取账户交易密码 密文
     *
     * @return payPwd - 账户交易密码 密文
     */
    public String getPayPwd() {
        return payPwd;
    }

    /**
     * 设置账户交易密码 密文
     *
     * @param payPwd 账户交易密码 密文
     */
    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    /**
     * 获取当前余额
     *
     * @return balance - 当前余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置当前余额
     *
     * @param balance 当前余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取冻结余额
     *
     * @return freezeBalance - 冻结余额
     */
    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 设置冻结余额
     *
     * @param freezeBalance 冻结余额
     */
    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * 获取状态 normal:正常 freeze:冻结 del:删除
     *
     * @return cstatus - 状态 normal:正常 freeze:冻结 del:删除
     */
    public String getCstatus() {
        return cstatus;
    }

    /**
     * 设置状态 normal:正常 freeze:冻结 del:删除
     *
     * @param cstatus 状态 normal:正常 freeze:冻结 del:删除
     */
    public void setCstatus(String cstatus) {
        this.cstatus = cstatus == null ? null : cstatus.trim();
    }

    /**
     * 获取原因
     *
     * @return handleCause - 原因
     */
    public String getHandleCause() {
        return handleCause;
    }

    /**
     * 设置原因
     *
     * @param handleCause 原因
     */
    public void setHandleCause(String handleCause) {
        this.handleCause = handleCause == null ? null : handleCause.trim();
    }

    /**
     * 获取操作时间
     *
     * @return handleTime - 操作时间
     */
    public String getHandleTime() {
        return handleTime;
    }

    /**
     * 设置操作时间
     *
     * @param handleTime 操作时间
     */
    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime == null ? null : handleTime.trim();
    }

    /**
     * 获取操作人Id
     *
     * @return operId - 操作人Id
     */
    public Long getOperId() {
        return operId;
    }

    /**
     * 设置操作人Id
     *
     * @param operId 操作人Id
     */
    public void setOperId(Long operId) {
        this.operId = operId;
    }

    /**
     * 获取手势密码
     *
     * @return gesturePwd - 手势密码
     */
    public String getGesturePwd() {
        return gesturePwd;
    }

    /**
     * 设置手势密码
     *
     * @param gesturePwd 手势密码
     */
    public void setGesturePwd(String gesturePwd) {
        this.gesturePwd = gesturePwd == null ? null : gesturePwd.trim();
    }
}