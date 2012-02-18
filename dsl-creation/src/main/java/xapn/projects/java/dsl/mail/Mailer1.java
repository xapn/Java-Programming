/**
 * 
 */
package xapn.projects.java.dsl.mail;

/**
 * Mailer: a traditional Java API.</br>
 * This class will simply allow to specify the from, to, subject, and message
 * data.
 * 
 * @author Xavier Pigeon
 */
class Mailer1 {
    
    /**
     * Creating a new Mailer and sending mail.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Mailer1 mailer = new Mailer1();
        mailer.from("build@example.com");
        mailer.to("example@example.com");
        mailer.subject("build notification");
        mailer.message("some details about build status");
        mailer.send();
    }
    
    public void from(String fromAddress) {
        System.out.println("from: " + fromAddress);
    }
    
    public void message(String body) {
        System.out.println("message: " + body);
    }
    
    public void send() {
        System.out.println("send.");
    }
    
    public void subject(String theSubject) {
        System.out.println("subject: " + theSubject);
    }
    
    public void to(String toAddress) {
        System.out.println("to: " + toAddress);
    }
}
