package com.manager.payment_manager;

import com.manager.payment_manager.Views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO: FILE App.java NÀY KHÔNG THÊM BẤT CỨ CÁI GÌ NỮA
public class App extends Application{
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
        ViewFactory.getInstance();
    }
}
