package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.FeeLog;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.FeeLogService;
import com.manager.payment_manager.Services.FeeService;
import com.manager.payment_manager.Services.HoKhauService;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddFamilyController implements Initializable {
    public TextField family_id_field;

    public ComboBox<String> combobox; // feeName
    public TextField money_field;
    public ComboBox<Integer> combobox_phase;
    public Button add_done_btn;
    public Button cancel_btn;
    public Label warning_lbl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warning_lbl.setVisible(false);

        loadFeeNameData();

        combobox.setOnAction(actionEvent -> {
            String feeName = combobox.getValue();
            // System.out.println(feeName);
            loadPhaseData(feeName);
        });

        cancel_btn.setOnAction(actionEvent -> {
            clearData();
            Stage stage = (Stage) cancel_btn.getScene().getWindow();
            stage.close();
        });

        add_done_btn.setOnAction(actionEvent -> {
            if (!checkInput()) {
                // Nếu thiếu thông tin
                warning_lbl.setVisible(true);
            } else {
                warning_lbl.setVisible(false);
                // Lấy thông tin từ giao diện người dùng
                int hoId = Integer.parseInt(family_id_field.getText());
                String feeName = combobox.getValue();
                int soTien = Integer.parseInt(money_field.getText());
                int dotNop = combobox_phase.getValue();
                java.sql.Date ngayNop = new java.sql.Date(System.currentTimeMillis());//sửa nếu thêm Date và fxml

                // Chuyển đổi feeName thành loại tương ứng (int)
                int khoanThuId = FeeLogService.getIdKhoanThuFromKhoanThuLog(feeName);

                // Kiểm tra trùng lặp
                boolean isDuplicate = FeeLogService.checkDuplicate(hoId, khoanThuId);
                boolean isIdHoExists = HoKhauService.checkIdHoExists(hoId);
                if (isDuplicate) {
                    // Hiển thị cảnh báo nếu trùng lặp
                    showAlert(Alert.AlertType.WARNING, "Trùng lặp", "Hộ trên đã nộp khoản thu này rồi.");
                }
                if (isIdHoExists) {
                    showAlert(Alert.AlertType.WARNING, "Lỗi", "Hộ đóng góp không tồn tại");
                }
                else {
                    // Tạo đối tượng FeeLog
                    FeeLog feeLog = new FeeLog(hoId, khoanThuId, soTien, dotNop, ngayNop);

                    // Thực hiện thêm dữ liệu vào cơ sở dữ liệu
                    FeeLogService.addKhoanThuHo(feeLog);

                    // TODO: Load data
                    Model.getInstance().getViewFactory().updateManagerManaging(feeName, dotNop);

                    // Đóng cửa sổ
                    Stage stage = (Stage) add_done_btn.getScene().getWindow();
                    stage.close();

                }
            }
        });
    }

    private void loadFeeNameData() {
        combobox.getItems().clear();
        List<String> allFeeNameOption = FeeService.getAllFeeNameOption();
        for (String name : allFeeNameOption)
            combobox.getItems().add(name);
    }

    private void loadPhaseData(String feeName) {
        combobox_phase.getItems().clear();
        int maxPhase = FeeService.phaseMax(feeName);
        for (int i = 1; i <= maxPhase + 1; i++)
            combobox_phase.getItems().add(i);
    }

    public void setComboItem(String content) {
        combobox.setValue(content);
    }

    private void clearData() {
        family_id_field.clear();
        combobox.setValue("Ủng hộ ngày thương binh liệt sỹ 27/07");
        combobox_phase.setValue(Integer.parseInt("1"));
        money_field.clear();
    }

    boolean checkInput() {
        if (family_id_field.getText().isEmpty()) return false;
        if (combobox.getValue().equals("Ủng hộ ngày thương binh liệt sỹ 27/07") && money_field.getText().isEmpty()) return false;
        return combobox_phase.getValue() != null;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
