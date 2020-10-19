package utils;

import javax.mail.*;
import java.util.Properties;

public class GmailConnection {
    /* WORK In PROGRESS.. Still exploring on this from a youtube channel --> https://www.youtube.com/watch?v=tuJCXNqwUhY */

    public static void connectWithGmail()
    {
        Folder inbox= null;
        Store store= null;

        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol","imaps");
        Session emailSession = Session.getInstance(properties);
        emailSession.setDebug(true);
        try {
            store=emailSession.getStore("imaps");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            store.connect("accounts.google.com","manish89aryatest001@gmail.com","Test@1234");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            inbox= store.getFolder("Inbox");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            inbox.open(Folder.READ_ONLY);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        Message message = null;
        try {
            Message[] messages = inbox.getMessages();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
