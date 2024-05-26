package ru.gb.FoodStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class ConfigIntegration {
    /**
     * входной канал
     */
    @Bean
    public MessageChannel textInputChanel(){
        return new DirectChannel();
    }
    /**
     * выходной канал
     */
    @Bean
    public MessageChannel fileWriterChanel(){
        return new DirectChannel();
    }

    /**
     * 1) принимаем из входного потока inputChannel данные
     * 2) преобразуем текст в верхний регистр
     * 3) отдаем в выходной поток outputChannel
     */
    @Bean
    @Transformer(inputChannel = "textInputChanel",outputChannel = "fileWriterChane")
    public GenericTransformer<String, String> mainTransformer(){
        return text -> {text = text.toUpperCase();
            return text;
        };
    }

    /**
     * сохранение данных в файл
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChane")
    public FileWritingMessageHandler myHandler(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("..\\resorces\\"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

}
