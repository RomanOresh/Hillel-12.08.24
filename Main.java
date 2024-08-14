public class Main {
    public static void main(String[] args) {
        MessagePrinter printer = new MessagePrinter();
        MessagePrinter.Message message = new MessagePrinter.Message("", "");
        printer.print(message);

    }
}
class MessagePrinter implements Printer {
    public void print(Message message) {
        if (message.getText() == null && message.getSender() == null || message.getText().isEmpty() && message.getSender().isEmpty()) {
            EmptyMessage emptyMessage = new EmptyMessage(){
                public void resolveEmptyMessage() {
                    System.out.println("Пустое сообщение от анонимного пользователя обрабатывается");
                }
            };
            emptyMessage.resolveEmptyMessage();
        } else if (message.getSender() == null || message.getSender().isEmpty()) {
            System.out.println("Анонимный пользователь отправил сообщение: " + message.getText());
        } else {
            System.out.println("Пользователь " + message.getSender() + " отправил сообщение: " + message.getText());
        }
    }


    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }
}


