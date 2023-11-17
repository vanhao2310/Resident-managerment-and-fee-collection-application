package com.manager.payment_manager.Views;

import com.manager.payment_manager.Controllers.Leader.LeaderController;
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
    private final StringProperty leaderSelectedMenuItem;
    // View in leader
    private AnchorPane leaderDashboardView;
    private AnchorPane leaderManagingView;
    private AnchorPane leaderStatisticView;
    private AnchorPane addMemberView;
    // View in manager
    private AnchorPane managerDashboardView;
    private AnchorPane managerManagingView;
    private AnchorPane managerStatisticView;
    public ViewFactory() {
        this.managerSelectedMenuItem = new SimpleStringProperty("");
        this.leaderSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getManagerSelectedMenuItem() {
        return managerSelectedMenuItem;
    }
    public StringProperty getLeaderSelectedMenuItem() {
        return leaderSelectedMenuItem;
    }


    // TODO: LOGIN
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    // TODO: LEADER
    public void showLeaderWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/Leader.fxml"));
        LeaderController leaderController = new LeaderController();
        loader.setController(leaderController);
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
    public AnchorPane getLeaderDashboardView() {
        if(leaderDashboardView == null) {
            try {
                leaderDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderDashboard.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderDashboard");
                System.out.println(e.getMessage());
            }
        }
        return leaderDashboardView;
    }
    public AnchorPane getLeaderManagingView() {
        if(leaderManagingView == null) {
            try {
                leaderManagingView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderManaging.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderManaging");
                System.out.println(e.getMessage());
            }
        }
        return leaderManagingView;
    }
    public AnchorPane getLeaderStatisticView() {
        if (leaderStatisticView == null) {
            try {
                leaderStatisticView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderStatistic.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderStatistic");
                System.out.println(e.getMessage());
            }
        }
        return leaderStatisticView;
    }
    public AnchorPane getAddMemberView() {
        if (addMemberView == null) {
            try {
                addMemberView = new FXMLLoader(getClass().getResource("/Fxml/Leader/AddMember.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading addMember");
                System.out.println(e.getMessage());
            }
        }
        return addMemberView;
    }
    public AnchorPane getManagerDashboardView() {
        if (managerDashboardView == null) {
            try {
                managerDashboardView = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerDashboard.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading managerDashboard");
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
        }
        return managerManagingView;
    }



    // TODO: IGNORE THESE
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            System.out.println("Error while loading fxml");
            System.out.println(e.getMessage());
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
