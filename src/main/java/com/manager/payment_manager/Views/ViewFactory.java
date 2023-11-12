package com.manager.payment_manager.Views;

import com.manager.payment_manager.Controllers.Manager.ManagerController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// TODO: MANAGE SCENE CHANGING
public class ViewFactory {

    // Manager View
    private final StringProperty managerSelectedMenuItem;
    private AnchorPane managerDashboardView;
    private AnchorPane managerManagingView;
    public ViewFactory() {
        this.managerSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getManagerSelectedMenuItem() {
        return managerSelectedMenuItem;
    }


    // TODO: LOGIN
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));

        createStage(loader);
    }

    // TODO: MANAGER
    public void showManagerWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/Manager.fxml"));
        ManagerController managerController = new ManagerController();
        loader.setController(managerController);
        createStage(loader);
    }

    // TODO: SET MENU OPTION SCENE
    public AnchorPane getManagerDashboardView() {
        if (managerDashboardView == null) {
            try {
                managerDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerDashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return managerDashboardView;
    }
    public AnchorPane getManagerManagingView() {
        if (managerManagingView == null) {
            try {
                managerManagingView = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerManaging.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading managerManaging");
                e.printStackTrace();
            }
        }
        return managerManagingView;
    }



    // IGNORE THESE
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            System.out.println("Error while loading fxml");
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Payment Manager");
        stage.show();
    }
    public void closeStage(Stage stage) {
        stage.close();
    }
}
