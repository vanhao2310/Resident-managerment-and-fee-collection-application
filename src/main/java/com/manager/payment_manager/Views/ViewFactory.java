package com.manager.payment_manager.Views;

import com.manager.payment_manager.Controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private static ViewFactory instance;
    private final Stage stage;

    /* TODO: Quy ước đặt tên
    * Với biến Scene thì thêm đuôi Scene ở cuối
    * Với biến FXMLLoader thì thêm đuôi View ở cuối */
    private Scene loginScene;
    private LoginController loginController;


    private  ViewFactory() {
        stage = new Stage();

        FXMLLoader loginView = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));

        try {
            loginScene = new Scene(loginView.load());
            loginController = loginView.getController();
        } catch (IOException e) {
            System.out.println("Error to load fxml in ViewFactory");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        stage.setScene(loginScene);
        stage.setResizable(false);
        stage.setTitle("Payment Manager");
        stage.show();
    }

    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }

    // TODO: Change Scene
    public void routes(SCENES scene) {
        switch (scene) {
            case LOGIN: {
                stage.setScene(loginScene);
                break;
            }
        }
    }

    // Scenes List
    public enum SCENES {
        LOGIN
    }
}
