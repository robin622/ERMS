package edu.gwu.com.erms.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gwu.com.erms.email.Mail;

public class MailTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSendMail() {
        try {
            Mail.sendMail("localhost", "wezhao@gwmail.gwu.edu", "wezhao", 
                    "wezhao@gwmail.gwu.edu", "", "Send Mail Test", "This is a test mail! Please ignore!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
