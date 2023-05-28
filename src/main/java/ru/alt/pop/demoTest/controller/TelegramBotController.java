package ru.alt.pop.demoTest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.alt.pop.demoTest.service.TelegramBotService;

@Slf4j
@Component
public class TelegramBotController extends TelegramLongPollingBot {
    @Value("${service.telegram.bot.username}")
    private String userName;

    @Value("${service.telegram.bot.id}")
    private String botId;

    @Value("${service.telegram.bot.password}")
    private String botPassword;

    private TelegramBotService telegramBotService;

    @Autowired
    public TelegramBotController(TelegramBotService telegramBotService,
                                 DefaultBotOptions defaultBotOptions,
                                 TelegramBotsApi telegramBotsApi,
                                 @Value("${service.telegram.bot.username}") String userName,
                                 @Value("${service.telegram.bot.id}") String botId,
                                 @Value("${service.telegram.bot.password}") String botPassword) throws TelegramApiException {
        super(defaultBotOptions);
        this.telegramBotService = telegramBotService;
        this.userName = userName;
        this.botId = botId;
        this.botPassword = botPassword;
        telegramBotsApi.registerBot(this);

    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Received message: {}", update);

        update.getMessage().getText();
    }

    @Override
    public void onClosing() {
        log.info("Received message2");
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return botId + ":" + botPassword;
    }
}

