/**
 * 
 */
package xapn.projects.java.dsl.mail;

/**
 * Mailer DSL, third iteration: a fluent, context aware DSL.</br>
 * That's a notch better; however, it would be nice to eliminate the use of new.
 * After all, as a user of this DSL your main interest is in sending out emails,
 * not in creating objects. We want to eliminate as much verbosity from the DSL
 * as possible.
 * 
 * @author Xavier Pigeon
 */
class Mailer3 {
    
    /**
     * We want to eliminate as much verbosity from the DSL as possible.
     * 
     * @return a {@link Mailer3} object
     */
    public static Mailer3 mail() {
        return new Mailer3();
    }
    
    /**
     * Mailer sends mail!
     * 
     * @param args
     */
    public static void main(String[] args) {
        mail().from("build@example.com").to("example@example.com").subject("build notification")
                .message("some details about build status").send();
    }
    
    public Mailer3 from(String fromAddress) {
        System.out.println("from: " + fromAddress);
        return this;
    }
    
    public Mailer3 message(String body) {
        System.out.println("message: " + body);
        return this;
    }
    
    public void send() {
        System.out.println("send.");
    }
    
    public Mailer3 subject(String theSubject) {
        System.out.println("subject: " + theSubject);
        return this;
    }
    
    public Mailer3 to(String toAddress) {
        System.out.println("to: " + toAddress);
        return this;
    }
}
