package Business.Utility;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACaf74fb24d02e53cd58ed4ef4b40665b7";
    public static final String AUTH_TOKEN =
            "058ec64095ae576443d17d2a798b174f";

    public static void sendSms(String toPhone, String msg) {
        System.out.println("Start");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        System.out.println("Start");
        Message message = Message
                .creator(new PhoneNumber("+1"+toPhone), // to
                        new PhoneNumber("+12513253059"), // from
                        msg)
                .create();
System.out.println("end");
        System.out.println(message.getSid());
    }
}