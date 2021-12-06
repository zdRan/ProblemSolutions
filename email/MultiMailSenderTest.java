
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Create by ranzd on 2017/12/26
 *
 * @author zdRan
 */
public class MultiMailSenderTest {
    @Test
    public void sendAnnexMail() throws Exception {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.qq.com");
        mailInfo.setMailServerPort("465");
        mailInfo.setValidate(true);
        mailInfo.setUserName("111111@qq.com");
        mailInfo.setPassword("*****************");//授权码
        mailInfo.setFromAddress("111111@qq.com");//必须跟userName一致
        mailInfo.setSubmitTo("xxx@xxx.xxx,xxx@xxx.xxx");
        mailInfo.setCarbonCopy("xxx@xxx.xxx,xxx@xxx.xxx");
        mailInfo.setSubject("这是一份测试附件发送的邮件");
        mailInfo.setContent("测试邮件附件发送是否成功，来自qq邮箱");
        String[] path = new String[]{"D:\\xxx\\xxx.txt","D:\\xxx\\xxx.txt"};
        mailInfo.setAttachFileNames(path);

        MultiMailSender sender = new MultiMailSender();
        sender.sendAnnexMail(mailInfo);
    }
}
