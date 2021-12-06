
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Create by ranzd on 2017/12/26
 *
 * @author zdRan
 */
public class EmailAuthenticator  extends Authenticator {
    private String username;
    private String password;
    public EmailAuthenticator(String username,String pwd){
        this.username=username;
        this.password=pwd;
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(this.username,this.password);
    }
}
