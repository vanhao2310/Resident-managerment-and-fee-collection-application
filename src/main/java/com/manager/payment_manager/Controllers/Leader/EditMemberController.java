package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.ChangeInfo;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Models.NhanKhau;
import com.manager.payment_manager.Services.ChangeInfoService;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class EditMemberController implements Initializable {
    public ComboBox<String> gender_combobox;
    public TextField note_field;
    public DatePicker change_info_date;
    public TextField role_field;
    private String id_ho;
    private String id_nguoi;
    public ComboBox<String> status_combo_box;
    public AnchorPane back_btn;
    public TextField full_name_field;
    public TextField nick_name_field;
    public DatePicker birth_date_picker;
    public TextField born_field;
    public TextField nation_field;
    public TextField native_field;
    public TextField job_field;
    public TextField work_place_field;
    public TextField id_field;
    public DatePicker create_date_picker;
    public TextField create_place_field;
    public DatePicker sign_up_date_picker;
    public TextField prev_address_field;
    public Label warning_label;
    public Button edit_done_btn;
    public Button edit_cancel_btn;
    public ImageView back_bt;
    private NhanKhau nhanKhau;
    private boolean isChange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadStatus();
        loadGender();
        isChange = false;
        warning_label.setVisible(false);
        back_btn.setOnMouseClicked(mouseEvent -> this.getBackToFamilyInfo());
        back_bt.setOnMouseClicked(mouseEvent -> this.getBackToFamilyInfo());
        edit_cancel_btn.setOnMouseClicked(mouseEvent -> this.getBackToFamilyInfo());
        edit_done_btn.setDisable(true);

        full_name_field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue.equals(newValue))
                edit_done_btn.setDisable(false);
        });
        full_name_field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue.equals(newValue))
                edit_done_btn.setDisable(false);
        });

        status_combo_box.setOnAction(actionEvent -> isChange = true);

        edit_done_btn.setOnMouseClicked(mouseEvent -> {
            // TODO: UPDATE INFORMATION
            if (checkValidation()) {
                warning_label.setVisible(false);
//                this.nhanKhau = new NhanKhau(Integer.parseInt(this.id_ho),
//                        full_name_field.getText(), nick_name_field.getText(),
//                        java.sql.Date.valueOf(birth_date_picker.getValue()),
//                        gender_combobox.getValue(),
//                        born_field.getText(),
//                        native_field.getText(),
//                        nation_field.getText(),
//                        job_field.getText(),
//                        work_place_field.getText(),
//                        id_field.getText(),
//                        java.sql.Date.valueOf(create_date_picker.getValue()), create_place_field.getText(),
//                        java.sql.Date.valueOf(sign_up_date_picker.getValue()), prev_address_field.getText());

                this.nhanKhau.setIdHo(Integer.parseInt(this.id_ho));
                this.nhanKhau.setHoTen(full_name_field.getText());
                this.nhanKhau.setBiDanh(nick_name_field.getText());
                this.nhanKhau.setNgaySinh(java.sql.Date.valueOf(birth_date_picker.getValue()));
                this.nhanKhau.setGioiTinh(gender_combobox.getValue());
                this.nhanKhau.setNoiSinh(born_field.getText());
                this.nhanKhau.setDanToc(nation_field.getText());
                this.nhanKhau.setNguyenQuan(native_field.getText());
                this.nhanKhau.setNgheNghiep(job_field.getText());
                this.nhanKhau.setNoiLamViec(work_place_field.getText());
                this.nhanKhau.setCCCD(id_field.getText());
                this.nhanKhau.setTrangThai(status_combo_box.getValue());
                if((create_date_picker.getValue()) != null){
                    this.nhanKhau.setNgayCap(java.sql.Date.valueOf(create_date_picker.getValue()));
                }
                this.nhanKhau.setNoiCap(create_place_field.getText());
                if(sign_up_date_picker.getValue() != null){
                    this.nhanKhau.setNgayDangKiThuongTru(java.sql.Date.valueOf(sign_up_date_picker.getValue()));
                }
                if(prev_address_field.getText() != null){
                    this.nhanKhau.setDiaChiTruoc(prev_address_field.getText());
                }
                this.nhanKhau.setId(id_nguoi);


                NhanKhauService.updateNhanKhau(this.nhanKhau);
                if (isChange)
                    updateDataLog(Integer.parseInt(this.id_nguoi));

                getBackToFamilyInfo();
            } else {
                warning_label.setVisible(true);
            }
        });
    }

    public void saveID(String id_ho, String id_nguoi) {
        System.out.println("saved");
        this.id_ho = id_ho;
        this.id_nguoi = id_nguoi;
        System.out.println("saved id_ho: " + id_ho + " and id_nguoi: " + id_nguoi);
    }

    private void getBackToFamilyInfo() {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();
        Model.getInstance().getViewFactory().showFamilyDetail();
        Model.getInstance().getViewFactory().updateFamilyDetail(this.id_ho);
    }

    private void loadStatus() {
        status_combo_box.getItems().add("Thường trú");
        status_combo_box.getItems().add("Tạm trú");
        status_combo_box.getItems().add("Tạm vắng");
    }
    private void loadGender() {
        gender_combobox.getItems().addAll("Nam", "Nữ");
    }

    private boolean checkValidation() {
        if (full_name_field.getText().isEmpty()) return false;
        // if (nick_name_field.getText().isEmpty()) return false;
        if (born_field.getText().isEmpty()) return false;
        // gender
        if (native_field.getText().isEmpty()) return false;
        if (nation_field.getText().isEmpty()) return false;
        if (job_field.getText().isEmpty()) return false;
        if (work_place_field.getText().isEmpty()) return false;
        ///koong cann check cccd dô duoi 18 tuoi co the chưa co cccd
        //if (id_field.getText().isEmpty()) return false;
        //if (create_place_field.getText().isEmpty()) return false;
        //return !prev_address_field.getText().isEmpty();
        return true;
    }

    public void fillOldInfo(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;

        full_name_field.setText(nhanKhau.getHoTen());
        nick_name_field.setText(nhanKhau.getBiDanh());
        born_field.setText(nhanKhau.getNoiSinh());
        gender_combobox.setValue(nhanKhau.getGioiTinh());
        role_field.setText(nhanKhau.getVaiTro());
        nation_field.setText(nhanKhau.getDanToc());
        native_field.setText(nhanKhau.getNguyenQuan());
        job_field.setText(nhanKhau.getNgheNghiep());
        work_place_field.setText(nhanKhau.getNoiLamViec());
        id_field.setText(nhanKhau.getCCCD());
        create_place_field.setText(nhanKhau.getNoiCap());
        prev_address_field.setText(nhanKhau.getDiaChiTruoc());
        status_combo_box.setValue(nhanKhau.getTrangThai());


        LocalDate localDate = LocalDate.of(nhanKhau.getNgaySinh().getYear() + 1900, nhanKhau.getNgaySinh().getMonth() + 1, nhanKhau.getNgaySinh().getDate());
        birth_date_picker.setValue(localDate);
        if (nhanKhau.getNgayCap() != null) {
            localDate = LocalDate.of(nhanKhau.getNgayCap().getYear() + 1900, nhanKhau.getNgayCap().getMonth() + 1, nhanKhau.getNgayCap().getDate());
            create_date_picker.setValue(localDate);
        }


        if (nhanKhau.getNgayDangKiThuongTru() != null) {
            Date ngayDangKyThuongTru = nhanKhau.getNgayDangKiThuongTru();
            localDate = LocalDate.of(ngayDangKyThuongTru.getYear() + 1900, ngayDangKyThuongTru.getMonth() + 1, ngayDangKyThuongTru.getDate());
            sign_up_date_picker.setValue(localDate);
        }
    }
    private void updateDataLog(int id_nguoi) {
        int loai = 0;
        String ten_loai = "";
        if (status_combo_box.getValue().equals("Tạm trú")) {
            loai = 2;
            ten_loai = "Đăng ký tạm trú";
        }
        else if (status_combo_box.getValue().equals("Tạm vắng")) {
            loai = 3;
            ten_loai = "Đăng ký tạm vắng";
        }
        else if (status_combo_box.getValue().equals("Thường trú")) {
            loai = 1;
            ten_loai = "Đăng ký thường trú";
        }
        ChangeInfo changeInfo = new ChangeInfo(loai, ten_loai, id_nguoi, note_field.getText(), java.sql.Date.valueOf(change_info_date.getValue()));
        ChangeInfoService.addChangeInfor(changeInfo);
    }
}
