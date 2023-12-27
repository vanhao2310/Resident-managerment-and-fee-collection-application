package com.manager.payment_manager.Views;

import com.manager.payment_manager.Controllers.Leader.*;
import com.manager.payment_manager.Controllers.Manager.*;
import com.manager.payment_manager.Models.Family;
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
    private LeaderManagingController leaderManagingController;
    private AnchorPane leaderStatisticView;
    private AnchorPane addFamilyView;
    private AnchorPane leaderGenderStatView;
    private AnchorPane leaderAgeStatView;
    private AnchorPane leaderTimeStatView;
    private AnchorPane leaderTemporaryStatView;
    private Scene changeDetailScene;
    private ChangeDetailController changeDetailController;
    // View in manager
    private AnchorPane managerDashboardView;
    private AnchorPane managerManagingView;
    private ManagerManagingController managerManagingController;
    private AnchorPane managerStatisticView;
    private ManagerStatisticController managerStatisticController;
    private AnchorPane managerMenuView;
    private Scene familyInfoScene;
    private FamilyInfoController familyInfoController;
    private LeaderStatisticController leaderStatisticController;
    private ManagerDashboardController managerDashboardController;

    private Scene familyFeeInfoScene;
    private FamilyFeeInfoController familyFeeInfoController;

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
    public void showFamilyDetail() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/FamilyInfo.fxml"));
        try {
            familyInfoScene = new Scene(loader.load());
            familyInfoController = loader.getController();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setScene(familyInfoScene);
        stage.show();
    }
    public void updateFamilyDetail(String id_ho) {
        // System.out.println("ViewFactory: " + id_ho);
        familyInfoController.updateFamilyInfo(id_ho);
    }

    public void showChangeDetail() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/ChangeDetail.fxml"));
        try {
            changeDetailScene = new Scene(loader.load());
            changeDetailController = loader.getController();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setScene(changeDetailScene);
        stage.show();
    }
    public void updateChangeDetail(int id_nguoi, int id_ho, String ten_loai, String change_date, String note) {
        changeDetailController.updateInfo(id_nguoi, id_ho, ten_loai, change_date, note);
    }

//    public void updateChangeList() {
//        System.out.println("update change list");
//       if (this.leaderStatisticController == null) {
//           FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderStatistic.fxml"));
//           try {
//                leaderStatisticView = loader.load();
//            } catch (Exception e) {
//                System.out.println("Error while loading leaderStatistic");
//                System.out.println(e.getMessage());
//            }
//            leaderStatisticController = loader.getController();
//        }
//        if (leaderStatisticController != null)
//            this.leaderStatisticController.loadChangeData();
//    }

    // TODO: SET MENU OPTION SCENE
    public AnchorPane getLeaderDashboardView() {
        if(leaderDashboardView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderDashboard.fxml"));
                leaderDashboardView = loader.load();
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderManaging.fxml"));
                leaderManagingView = loader.load();
                this.leaderManagingController = loader.getController();
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderStatistic.fxml"));
                leaderStatisticView = loader.load();
                leaderStatisticController = loader.getController();
            } catch (Exception e) {
                System.out.println("Error while loading leaderStatistic");
                System.out.println(e.getMessage());
            }
        }
        // TODO: LOAD CHANGE DATA HEREEEEEEEEEEEE
        leaderStatisticController.loadChangeData();
        return leaderStatisticView;
    }
    public AnchorPane getLeaderGenderStatView() {
        if (leaderGenderStatView == null) {
            try {
                leaderGenderStatView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderGenderStat.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderGenderStat");
                System.out.println(e.getMessage());
            }
        }
        return  leaderGenderStatView;
    }
    public AnchorPane getLeaderAgeStatView() {
        if (leaderAgeStatView == null) {
            try {
                leaderAgeStatView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderAgeStat.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderAgeStat");
                System.out.println(e.getMessage());
            }
        }
        return leaderAgeStatView;
    }
    public AnchorPane getLeaderTimeStatView() {
        if (leaderTimeStatView == null) {
            try {
                leaderTimeStatView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderTimeStat.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderTimeStat");
                System.out.println(e.getMessage());
            }
        }
        return leaderTimeStatView;
    }
    public AnchorPane getLeaderTemporaryStatView() {
        if (leaderTemporaryStatView == null) {
            try {
                leaderTemporaryStatView = new FXMLLoader(getClass().getResource("/Fxml/Leader/LeaderTempoStat.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading leaderTempoStat");
                System.out.println(e.getMessage());
            }
        }
        return leaderTemporaryStatView;
    }


    public AnchorPane getAddFamilyView() {
        if (addFamilyView == null) {
            try {
                addFamilyView = new FXMLLoader(getClass().getResource("/Fxml/Leader/AddFamily.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error while loading addFamily");
                System.out.println(e.getMessage());
            }
        }
        return addFamilyView;
    }
    public AnchorPane getManagerDashboardView() {
        if (managerDashboardView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerDashboard.fxml"));
                managerDashboardView = loader.load();
                managerDashboardController = loader.getController();
            } catch (Exception e) {
                System.out.println("Error while loading managerDashboard");
                System.out.println(e.getMessage());
            }
        }
        return managerDashboardView;
    }
    public AnchorPane getManagerManagingView() {
        if (managerManagingView == null || managerManagingController == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerManaging.fxml"));
                managerManagingView = loader.load();
                managerManagingController = loader.getController();
            } catch (Exception e) {
                System.out.println("Error while loading managerManaging");
                System.out.println(e.getMessage());
            }
        }
        managerManagingController.setComboboxData();
        return managerManagingView;
    }

    public void updateManagerManaging(String feeType, int phase) {
        managerManagingController.setComboboxData();
        managerManagingController.setComboItem(feeType);
        managerManagingController.loadFamily(feeType, phase);
    }

    public AnchorPane getManagerStatisticView() {
        if (managerStatisticView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerStatistic.fxml"));
                managerStatisticView = loader.load();
                managerStatisticController = loader.getController();
            } catch (Exception e) {
                System.out.println("Error loading managerStatistic");
                System.out.println(e.getMessage());
            }
        }
        managerStatisticController.loadType();
        return managerStatisticView;
    }
    public AnchorPane getManagerManageView(String content) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerManaging.fxml"));
            managerManagingView = loader.load();
            ManagerManagingController managerManagingController = loader.getController();
            managerManagingController.setComboItem(content);
            // System.out.println(content);
        } catch (Exception e) {
            System.out.println("Error while loading managerManaging");
            System.out.println(e.getMessage());
        }
        return managerManagingView;
    }
    public void updateManagerMenuView(String hBox) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerMenu.fxml"));
                managerMenuView = loader.load();
                ManagerMenuController managerMenuController = loader.getController();
                managerMenuController.setStyleButton(hBox);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    public void addNewFee(String newFee) {
        if (managerDashboardController == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/ManagerDashboard.fxml"));
                managerDashboardView = loader.load();
                managerDashboardController = loader.getController();
                managerDashboardController.addFee(newFee);
                System.out.println(newFee);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            managerDashboardController.addFee(newFee);
        }
    }

    public void showFamilyFeeInfo(Family family, String feeName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/FamilyFeeInfo.fxml"));
        try {
            familyFeeInfoScene = new Scene(loader.load());
            familyFeeInfoController = loader.getController();
            familyFeeInfoController.updateInfo(family, feeName);
        } catch (Exception e) {
            System.out.println("Error loading familyFeeInfo");
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setScene(familyFeeInfoScene);
        stage.show();
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

    public void updateListFamily(){
        this.leaderManagingController.loadFamily();
    }
}
