package com.abc.service.impl;

import org.springframework.stereotype.Service;
import com.abc.service.AccountService;

// 将AccountService类对象注入IoC容器
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    /**
     * 模拟保存账户。
     */
    public void saveAccount() {
        System.out.println("执行了保存！");
    }

    /**
     * 模拟更新用户。
     *
     * @param i 要更新的用户的id。
     */
    public void updateAccount(int i) {
        System.out.println("执行了更新！" + i);
    }

    /**
     * 模拟删除账户。
     *
     * @return 被删除账户的id。
     */
    public int deleteAccount() {
        System.out.println("执行了删除！");
        return 0;
    }
}
