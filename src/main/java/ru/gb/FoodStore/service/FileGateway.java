package ru.gb.FoodStore.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {
    /**
     * @param fileName - данные
     * @param data - метаданные
     * @Header(FileHeaders.FILENAME) - таким образом мы уточняем что fileName это имя файла
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
