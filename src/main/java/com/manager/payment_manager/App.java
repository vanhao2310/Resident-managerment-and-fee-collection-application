package com.manager.payment_manager;

import com.manager.payment_manager.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO: FILE App.java NÀY KHÔNG THÊM BẤT CỨ CÁI GÌ NỮA
public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
