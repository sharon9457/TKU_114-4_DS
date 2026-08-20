interface MessageSender{
    void send(String receiver,String messge);
}

class EmailSender implements MessageSender{
    public void send(String receiver,String message){
        System.out.println("收件人"+receiver+"訊息內容"+message);
    }
}
class SmsSender implements MessageSender{
    public void send(String receiver,String message){
        System.out.println("手機號碼:"+receiver+"訊息內容"+message);
 }
}
class ConsoleSender implements MessageSender{
    public void send(String receiver,String message){
        System.out.println("目標:"+receiver+"系統日誌"+message);
    }
}

public class MessageSenderSystem {
    static void  notify(MessageSender sender,String receiver,String message){
        if(receiver == null||receiver.trim().isEmpty()){
            System.out.println("失敗");
            return;
        }
        if(message == null||message.trim().isEmpty()){
            System.out.println("失敗");
            return;
        }
        sender.send(receiver, message);
    }
    public static void main(String[] args) {
        MessageSender email=new EmailSender();
        MessageSender sms =new SmsSender();
        MessageSender console = new ConsoleSender();

        notify(email, "aaa@gmail.com", "嗨你好");
        notify(sms,"1111111","不是詐騙");
        notify(console,"404","正常");

        notify(email,"","     ");
        notify(sms,"   ","     ");
        notify(console,null,null);

    }
}
