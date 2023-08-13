package uz.fatikhjan.bot;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        // Initialize the API context
//        ApiContextInitializer.init();

        // Instantiate the TelegramBotsApi
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        // Register your bot
        try {
            botsApi.registerBot(new MyBot());
            System.out.println("Bot is up and running!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}