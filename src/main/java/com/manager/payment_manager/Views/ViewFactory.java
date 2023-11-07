package com.manager.payment_manager.Views;

import com.manager.payment_manager.Controllers.Client.ClientController;
import com.manager.payment_manager.Controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    private static ViewFactory instance;
    private final Stage stage;
    private Scene loginScene;
    private Scene clientScene;
    private LoginController loginController;
    private ClientController clientController;

    private ViewFactory() {
        stage = new Stage();

        // TODO: Load all the FXML file
        FXMLLoader loginView = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        FXMLLoader clientView = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));

        try {
            // TODO: Create Scene and Controller
            // Login
            loginScene = new Scene(loginView.load());
            loginController = loginView.getController();

            // Client Dashboard
            clientScene = new Scene(clientView.load());
            clientController = clientView.getController();

        } catch (Exception e) {
            System.out.println("Error to load fxml in ViewFactory");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        stage.setScene(loginScene);
        stage.setTitle("Payment Manager");
        stage.show();
    }

    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }

    public void routes(SCENE scene) {
        stage.close();
        switch (scene) {
            case LOGIN: {
                stage.setScene(loginScene);
                break;
            }
            case CLIENT_DASHBOARD: {
                stage.setScene(clientScene);
                break;
            }
        }
        stage.show();
    }

    public enum SCENE {
        LOGIN,
        CLIENT_DASHBOARD
    }
}
