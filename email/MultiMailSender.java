
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Create by ranzd on 2017/12/26
 * 带附件发送邮件
 * @author zdRan
 */
public class MultiMailSender {

    public boolean sendAnnexMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        EmailAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new EmailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro,authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            InternetAddress[] tos = null;
            if (mailInfo.getSubmitTo()!=null){
                tos = InternetAddress.parse(mailInfo.getSubmitTo());
            }
            mailMessage.setRecipients(Message.RecipientType.TO,tos);
            // 设置邮件抄送地址
            InternetAddress[]  address = null;
            if (mailInfo.getCarbonCopy()!=null){
                address = InternetAddress.parse(mailInfo.getCarbonCopy());
            }
            mailMessage.setRecipients(Message.RecipientType.CC,address);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());

            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            //邮件正文
            contentPart.setContent(mailInfo.getContent(), "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            //设置附件
            if (mailInfo.getAttachFileNames()!=null){
                for (String path:mailInfo.getAttachFileNames()) {
                    File file = new File(path);
                    BodyPart attachmentPart = new MimeBodyPart();
                    DataSource source = new FileDataSource(file);
                    attachmentPart.setDataHandler(new DataHandler(source));
                    //避免中文乱码的处理
                    attachmentPart.setFileName(MimeUtility.encodeWord(file.getName()));
                    multipart.addBodyPart(attachmentPart);
                }
            }
            mailMessage.setContent(multipart);
            mailMessage.saveChanges();
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
