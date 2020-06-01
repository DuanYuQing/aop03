package service;

/**
 * 账户操作业务层。
 */
public interface AccountService {
    /**
     * 模拟保存账户。
     */
    void saveAccount();

    /**
     * 模拟更新用户。
     *
     * @param i 要更新的用户的id。
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户。
     *
     * @return 被删除账户的id。
     */
    int deleteAccount();
}
