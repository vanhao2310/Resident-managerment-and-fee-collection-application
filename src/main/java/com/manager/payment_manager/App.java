package com.manager.payment_manager;

import com.manager.payment_manager.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO: DO NOT CHANGE ANYTHING IN HERE
public class App extends Application{
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
