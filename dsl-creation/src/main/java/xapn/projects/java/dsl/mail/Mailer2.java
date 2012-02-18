/**
 * 
 */
package xapn.projects.java.dsl.mail;

/**
 * Mailer DSL, second iteration: a more fluent Mailer, with a method chaining in
 * the Mailer API.</br>
 * So far there are still quite a few steps between you and sending mail. That
 * may be fine for a programmer, but not for a DSL user. What can we do to make
 * this API fluent, and more like a DSL? First, each of the methods of Mailer,
 * except the send() method, can return itself, so we can chain the calls.
 * 
 * @author Xavier Pigeon
 */
public class Mailer2 {
    
    /**
     * Sending mail with a new Mailer.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Mailer2().from("build@example.com").to("example@example.com").subject("build notification")
                .message("some details about build status").send();
    }
    
    public Mailer2 from(String fromAddress) {
        System.out.println("from: " + fromAddress);
        return this;
    }
    
    public Mailer2 message(String body) {
        System.out.println("message: " + body);
        return this;
    }
    
    public void send() {
        System.out.println("send.");
    }
    
    public Mailer2 subject(String theSubject) {
        System.out.println("subject: " + theSubject);
        return this;
    }
    
    public Mailer2 to(String toAddress) {
        System.out.println("to: " + toAddress);
        return this;
    }
}
