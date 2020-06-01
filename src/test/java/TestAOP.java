import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

/**
 * 测试aop。
 */
public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.saveAccount();
        System.out.println("================================");
        accountService.updateAccount(1);
        System.out.println("================================");
        accountService.deleteAccount();
    }
}
