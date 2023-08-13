package uz.fatikhjan.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            long chatId = message.getChatId();


            if (message.getChat().isGroupChat()) {
                if (update.getMessage().hasPhoto()) {
                    message = update.getMessage();
                    chatId = message.getChatId();
                    String receivedText = message.getCaption();
                    if (receivedText.startsWith("+"))
                        sendResponseWithReplay(chatId, message.getMessageId(), "Fotih");
                }
            } else {
                String receivedText = message.getText();
                if (receivedText.equals("/start")) {

                    System.out.println(update.getMessage().getFrom().getFirstName() + String.valueOf(chatId) + "\n ");
                    sendResponse(chatId, "if you want to use this bot you need to add it to Telegram bot )) ");
                } else {
                    String responseText = "You said: " + receivedText;
                    sendResponse(chatId, responseText);
                }
            }




        }


    }


    private void sendResponseWithReplay(long chatId, Integer messageId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        sendMessage.setReplyToMessageId(messageId); // Set the ID of the message to which you want to reply

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void clearWebhook() throws TelegramApiRequestException {

    }

    @Override
    public String getBotUsername() {
        return "http://t.me/fatikhjan_Test_bot";
    }

    @Override
    public String getBotToken() {
        return "6383888482:AAGqXWMoDB_5476EHdIlOnvigHzDjsZ7dts";
    }

    private void sendResponse(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
