DROP DATABASE IF EXISTS QLYDANCU;
CREATE DATABASE QLYDANCU;
USE QLYDANCU;

create table HoKhau
(
    ID_HO int auto_increment,
    chu_ho nvarchar(100),
    dia_chi nvarchar(100),
    so_thanh_vien int,
    /*tt_nop_tien bool, */
    primary key(ID_HO)
);

insert into HoKhau
values
    (1, 'Nguyễn Văn A', 'Số nhà 20 - Ngách A /120 - Đường B', 4),
    (2, 'Nguyễn Thị Dung', 'Số nhà 58 - Ngách G/220 - Đường F', 5),
    (3, 'Trịnh Hoàng Hải', 'Số nhà 234 - Ngách A /342 - Đường T', 3),
    (4, 'Đoàn Trần Minh', 'Số nhà 356 - Ngách E  - Đường B', 4),
    (5, 'Lê Ngọc Mờ', 'Số nhà 520 - Ngách A /120 - Đường H', 4),
    (6, 'Trần Hữu Cơ', 'Số nhà 15 - Đường A', 5),
    (7, 'Lê Tuấn Hờ', 'Số nhà 145 - Đường B', 2);

INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('8', 'Nguyễn Chiến Thắng', 'Số nhà 30/4 - Đường H', '3');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('9', 'Đỗ Đại Học', 'Số nhà 1 - Đường Đại Cồ Việt', '4');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('10', 'Khổng Thanh Trúc', 'Số nhà 99 - Đường K', '3');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('11', 'Bắc Kiều Phong', 'Số nhà 100 - Phố H', '5');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('12', 'Mai Ze Đông', 'Số nhà 49/53 - Đường H', '1');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('13', 'Đỗ Nam Trung', 'Số nhà 3 - Đường ÚA', '3');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('14', 'Trịnh Trần Phương Tuấn', 'Số nhà 97 - Phố Đ', '4');
INSERT INTO `qlydancu`.`hokhau` (`ID_HO`, `chu_ho`, `dia_chi`, `so_thanh_vien`) VALUES ('15', 'Huỳnh Trấn Thành', 'Số nhà 15 - Phố Đ', '2');


create table NHANKHAU
(
    ID_NGUOI int auto_increment,
    ho_ten nvarchar(100),
    bi_danh nvarchar(100),
    ngay_sinh date,
    gioi_tinh nvarchar(5),
    noi_sinh nvarchar(100),
    nguyen_quan nvarchar(100),
    dan_toc nvarchar(100),
    nghe_nghiep nvarchar(100),
    noi_lam_viec nvarchar(100),
    CCCD varchar(20),
    ngay_cap_CCCD date,
    noi_cap_CCCD nvarchar(30),
    vai_tro nvarchar(20),
    date_thuong_tru date,
    dia_chi_cu nvarchar(100),
    primary key (ID_NGUOI),
    ID_HO int,
    trang_thai nvarchar(30),
    foreign key (ID_HO) references HOKHAU(ID_HO)
);

insert into NHANKHAU (ID_HO, ho_ten, ngay_sinh, gioi_tinh, dan_toc, nghe_nghiep, nguyen_quan, noi_sinh, noi_lam_viec, CCCD, ngay_cap_CCCD, noi_cap_CCCD, vai_tro)
values
    (3, 'Trịnh Hoàng Hải', '1985-5-1',	'Nam',	'Kinh', 'Kiến trúc sư', 'Lào Cai', 'Lào Cai', 'Hà Nội', '008430122322', '2020-1-15', 'Lào Cai', 'Chủ hộ'),
    (3, 'Trần Minh Nghi', '1988-8-9', 'Nữ', 'Kinh', 'Nội trợ', 'Bắc Ninh', 'Bắc Ninh',	'Hà Nội', '008923899023', '2020-7-6', 'Bắc Ninh',	'Vợ'),
    (3, 'Trịnh Mỹ Á', '2015-2-15',	'Nữ', 'Kinh',	'Học sinh', 'Lào Cai', 'Hà Nội',	'Hà Nội', NULL, NULL, NULL, 'Con'),
    (4, 'Đoàn Trần Minh', '1983-3-8', 'Nam', 'Kinh', 'Giảng viên', 'Bắc Ninh', 'Bắc Ninh', 'Hà Nội', '003420012232', '2019-8-17', 'Bắc Ninh', 'Chủ hộ'),
    (4, 'Từ An Vân', '1988-6-10', 'Nữ', 'Sán Dìu', 'Giáo viên',	'Bắc Ninh', 'Bắc Ninh', 'Hà Nội', '003823904827', '2018-5-16', 'Bắc Ninh', 'Vợ'),
    (4, 'Đoàn Văn Độ',	'2009-08-12', 'Nam', 'Kinh', 'Học sinh', 'Bắc Ninh', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Con'),
    (4, 'Đoàn Thế Lân', '2009-08-12', 'Nam', 'Kinh', 'Học sinh', 'Bắc Ninh', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Con'),
    (5, 'Lê Ngọc Mờ', '1990-9-19',	'Nam',	'Kinh', 'Kỹ sư', 'Thanh Hoá', 'Thanh Hoá', 'Hà Nội', '008943949012', '2021-5-19', 'Thanh Hoá', 'Chủ hộ'),
    (5, 'Lê Minh Nờ', '1990-2-2', 'Nữ', 'Kinh', 'Phóng viên', 'Nghệ An', 'Nghệ An', 'Hà Nội', '094832049483', '2021-2-5', 'Nghệ An', 'Vợ'),
    (5, 'Trần Thị Bành', '1965-1-9', 'Nữ', 'Kinh', 'Nghỉ hưu', 'Thanh Hoá', 'Thanh Hoá', 'Hà Nội', '003478232316', '2021-5-19', 'Thanh Hoá', 'Mẹ'),
    (5, 'Lê Ngọc Nét', '2016-2-29', 'Nam', 'Kinh', 'Học sinh', 'Thanh Hoá', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Con'),
    (6, 'Trần Hữu Cơ', '1958-8-5',	'Nam',	'Kinh', 'Nghỉ hưu', 'Hà Tĩnh', 'Hà Tĩnh', 'Hà Nội', '002340941233', '2022-6-3', 'Hà Tĩnh', 'Chủ hộ'),
    (6, 'Lê Thị Ngọc Liên', '1960-6-19', 'Nữ', 'Kinh', 'Nghỉ hưu', 'Hà Tĩnh', 'Hà Tĩnh', 'Hà Nội', '040343401323', '2022-5-5', 'Hà Tĩnh', 'Vợ'),
    (6, 'Trần Văn An',	'1990-8-8',	'Nam',	'Kinh', 'Kỹ sư', 'Hà Nội', 'Hà Nội', 'Hà Nội', '092421033023', '2021-8-8',	'Hà Nội', 'Con'),
    (6, 'Nguyễn Thị Hương Giang', '1992-2-9', 'Nữ', 'Kinh', 'Kỹ sư', 'Hà Nội',	'Hà Nội', 'Hà Nội', '034984239846', '2022-9-3', 'Hà Nội', 'Con'),
    (6, 'Trần Minh Đức', '2015-5-1', 'Nam', 'Kinh', 'Học sinh', 'Hà Nội', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Cháu'),
    (7, 'Lê Tuấn Hờ', '1960-6-19',	'Nam',	'Kinh', 'Nghỉ hưu', 'Ninh Bình', 'Ninh Bình', 'Hà Nội', '003403483474', '2015-5-5', 'Ninh Bình', 'Chủ hộ'),
    (7, 'Doãn Cẩm Hương', '1960-9-4', 'Nữ', 'Thái', 'Nghỉ hưu', 'Ninh Bình', 'Ninh Bình', 'Hà Nội', '002449210313', '2015-5-5', 'Ninh Bình', 'Vợ'),
    (2, 'Nguyễn Thị Dung', '1952-9-25', 'Nữ',	'Kinh', 'Nghỉ hưu', 'Ninh Bình', 'Ninh Bình', 'Hà Nội', '008234194049', '2020-6-12', 'Ninh Bình', 'Chủ hộ'),
    (2, 'Nguyễn Văn Trạng', '1975-4-30', 'Nam', 'Kinh', 'Công Nhân', 'Hải Dương', 'Hải Dương', 'Hà Nội', '002948034891',	'2020-6-12', 'Hải Dương', 'Con'),
    (2, 'Đinh Thị Vân', '1980-8-19', 'Nữ', 'Kinh', 'Kinh Doanh', 'Hưng Yên', 'Hưng Yên', 'Hà Nội', '039424030401', '2020-6-12', 'Hưng Yên', 'Con'),
    (2, 'Nguyễn Tuấn Đá', '2007-7-27',	'Nam',	'Kinh', 'Học sinh', 'Hải Dương', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Cháu'),
    (2, 'Nguyễn Ngọc Bảo Trâu', '2011-11-20', 'Nữ', 'Kinh', 'Học sinh',	'Hải Dương', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Cháu'),
    (1, 'Nguyễn Văn A', '1980-8-19', 'Nam',	'Kinh', 'Công nhân', 'Hà Nội', 'Hà Nội', 'Hà Nội', '090934938412', '2019-12-21', 'Hà Nội', 'Chủ hộ'),
    (1, 'Nguyễn Hải Hoa', '1983-3-18', 'Nữ', 'Tày',	'Công nhân', 'Hà Nội', 'Hà Nội',	'Hà Nội', '048500058341',	'2019-12-21', 'Hà Nội', 'Vợ'),
    (1, 'Nguyễn Ngọc Hà', '2005-5-20', 'Nữ', 'Kinh', 'Sinh viên', 'Hà Nội', 'Hà Nội', 'Hà Nội', '048004249032', '2023-09-15', 'Hà Nội', 'Con'),
    (1, 'Nguyễn Đức Thuận', '2008-10-28', 'Nam', 'Kinh', 'Học sinh', 'Hà Nội', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Con');

INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('28', 'Nguyễn Chiến Thắng', '1975-04-30', 'Nam', 'Hồ Chí Minh', 'Hà Nội', 'Kinh', 'Bộ đội', 'Khánh Hoá', '019753004841', '2015-07-05', 'Hà Nội', 'Chủ hộ', '8', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('29', 'Lê Độc Lập', '1979-09-19', 'Nữ', 'Hà Nội', 'Hà Nội', 'Kinh', 'Giáo viên', 'Hà Nội', '019450902123', '2016-05-19', 'Hà Nội', 'Vợ', '8', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('30', 'Nguyễn Tự Do', 'TD', '1999-12-31', 'Nam', 'Hà Nội', 'Hà Nội', 'Kinh', 'Kỹ sư', 'Hoà Bình', '012345678910', '2018-10-02', 'Hà Nội', 'Con', '8', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('31', 'Đỗ Đại Học', '1956-12-15', 'Nam', 'Hà Nội', 'Hà Nội', 'Kinh', 'Giảng viên', 'Hà Nội', '057896487952', '2010-06-02', 'Hà Nội', 'Chủ hộ', '9', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('32', 'Đã Tốt Nghiệp', '1956-12-16', 'Nữ', 'Nam Định', 'Nam Định', 'Kinh', 'Giảng viên', 'Hà Nội', '056796465487', '2012-02-09', 'Hà Nội', 'Vợ', '9', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('33', 'Đỗ Trường Đời', '1980-05-06', 'Nam', 'Nam Định ', 'Nam Định', 'Kinh', 'Tự do', 'Hồ Chí Minh', '023145887469', '2011-03-04', 'Hà Nội', 'Con', '9', 'Tạm vắng');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('34 ', 'Đỗ Sự Nghiệp', '2003-12-01', 'Nam', 'Hồ Chí Minh', 'Hà Nội', 'Nùng', 'Sinh viên', 'Hà Nội', '098765412332', '2021-05-03', 'Hà Nội', 'Cháu', '9', 'Tạm trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('35', 'Khổng Thanh Trúc', '2000-09-14', 'Nữ', 'Sơn La', 'Sơn La', 'Hoa', 'Sinh viên', 'Hà Nội', '054698771365', '2019-05-30', 'Sơn La', 'Chủ hộ', '10', 'Thường trú');
UPDATE `qlydancu`.`nhankhau` SET `date_thuong_tru` = '2010-10-10' WHERE (`ID_NGUOI` = '17');
UPDATE `qlydancu`.`nhankhau` SET `date_thuong_tru` = '2010-10-10' WHERE (`ID_NGUOI` = '18');
UPDATE `qlydancu`.`nhankhau` SET `date_thuong_tru` = '2016-3-1' WHERE (`ID_NGUOI` = '11');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('36', 'Khổng Tuấn Tú', '2018-10-12', 'Nam', 'Hà Nội', 'Sơn La', 'Hoa', 'Mầm non', 'Hà Nội', 'Con', '10', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('37', 'Khổng Thanh Diệu', '2019-12-03', 'Nữ', 'Hà Nội', 'Sơn La', 'Hoa', 'Mầm non', 'Hà Nội', '', 'Con', '10', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('38', 'Bắc Kiều Phong', 'Bang chủ', '1989-03-02', 'Nam', 'Lai Châu', 'Lai Châu', 'Hoa', 'Võ sư', 'Hà Nội', '065498697885', '2016-07-09', 'Hà Nội', 'Chủ hộ', '11', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('39', 'Bắc A Châu', '1995-11-01', 'Nữ', 'Điện Biên', 'Điện Biên', 'Dao', 'Nội trợ', 'Hà Nội', '024748754875', '2016-07-09', 'Hà Nội', 'Vợ', '11', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('40', 'Bắc Cái', '2012-06-05', 'Nam', 'Hà Nội', 'Lai Châu', 'Hoa', 'Học sinh', 'Hà Nội', 'Con', '11', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('41', 'Bắc Bang', '2013-06-08', 'Nam', 'Hà Nội', 'Lai Châu', 'Hoa', 'Học sinh', 'Hà Nộ', 'Con', '11', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('42', 'Bắc Á', '2015-01-03', 'Nữ', 'Hà Nội', 'Điện Biên', 'Dao', 'Học sinh', 'Hà Nội', 'Con', '11', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('43', 'Mai Ze Đông', 'Chủ tịch', '1949-07-31', 'Nam', 'Lạng Sơn', 'Lạng Sơn', 'Hoa', 'Tự do', 'Hà Nội', '098745659785', '2011-12-5', 'Hà Nội', 'Chủ hộ', '12', 'Tạm vắng');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('44', 'Đỗ Nam Trung', 'Trăm', '1944-04-04', 'Nam', 'Đồng Nai', 'Đồng Nai', 'Ê đê', 'Kinh doanh', 'Hồ Chí Minh', '087459965878', '2010-10-10', 'Đà Nẵng', 'Chủ hộ', '13', 'Tạm vắng');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('45', 'Đỗ Phu Nhân', '1945-05-05', 'Nữ', 'Bình Thuận', 'Bình Thuận', 'Hmông', 'Kinh doanh', 'Hồ Chí Minh', '045678784854', '2010-02-09', 'Hà Nội', 'Vợ', '13', 'Tạm vắng');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('46 ', 'Đỗ Bi Đan', '1999-02-02', 'Nam', 'Cà Mau', 'Hà Nội', 'Tày', 'Sinh viên', 'Hà Nội', '054874564585', '2018-01-05', 'Hà Nội', 'Cháu', '13', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('47', 'Trịnh Trần Phương Tuấn', 'J97', '1997-04-12', 'Nam', 'Bến Tre', 'Bến Tre', 'Kinh', 'Ca sĩ', 'Hồ Chí Minh', '045787846569', '2016-06-28', 'Hồ Chí Minh', 'Chủ hộ', '14', 'Tạm vắng');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `date_thuong_tru`, `ID_HO`, `trang_thai`) VALUES ('48', 'Nguyễn Thiên An', '1998-09-08', 'Nữ', 'Bình Dương', 'Bình Dương', 'Kinh', 'Người mẫu', 'Hồ Chí Minh', '478454875487', '2017-07-19', 'Hồ Chí Minh', 'Vợ', '2023-02-14', '14', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `vai_tro`, `date_thuong_tru`, `dia_chi_cu`, `ID_HO`, `trang_thai`) VALUES ('49', 'Nguyễn Thị Son', 'Sol', '2020-04-01', 'Nữ', 'Bình Dương', 'Bình Dương', 'Kinh', 'Mầm non', 'Hồ Chí Minh', NULL, NULL, 'Con', '2023-02-14', NULL, '14', 'Tạm trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `date_thuong_tru`, `ID_HO`, `trang_thai`) VALUES ('50', 'Nguyễn Bảo Khánh', 'KATM', '1999-07-24', 'Nam', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Kinh', 'Nhạc sĩ', 'Hồ Chí Minh', '457846599787', '2019-05-01', 'Hồ Chí Minh', 'Em trai', '2023-08-01', '14', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `bi_danh`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('51', 'Huỳnh Trấn Thành', 'Lộ Tể', '1987-02-05', 'Nam', 'Hồ Chí Minh', 'Hồ Chí Minh', 'Hoa', 'Diễn viên', 'Hồ Chí Minh', '495349534953', '2014-02-06', 'Hồ Chí Minh', 'Chủ hộ', '15', 'Thường trú');
INSERT INTO `qlydancu`.`nhankhau` (`ID_NGUOI`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `noi_sinh`, `nguyen_quan`, `dan_toc`, `nghe_nghiep`, `noi_lam_viec`, `CCCD`, `ngay_cap_CCCD`, `noi_cap_CCCD`, `vai_tro`, `ID_HO`, `trang_thai`) VALUES ('52', 'Hary Won', '1985-05-08', 'Nữ', 'Hàn Quốc', 'Hàn Quốc', 'Hàn', 'Ca sĩ', 'Hồ Chí Minh', '454787845487', '2019-02-24', 'Hà Nội', 'Vợ', '15', 'Thường trú');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Tạm vắng' WHERE (`ID_NGUOI` = '22');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Tạm vắng' WHERE (`ID_NGUOI` = '8');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '1');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '2');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '3');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '4');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '5');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '6');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '7');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '9');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '10');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '11');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '12');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '13');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '14');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '15');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '16');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '17');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '18');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '19');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '20');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '21');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '23');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '24');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '25');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '26');
UPDATE `qlydancu`.`nhankhau` SET `trang_thai` = 'Thường trú' WHERE (`ID_NGUOI` = '27');
create table user_account(
                             id int auto_increment primary key,
                             user_name varchar(50) not null unique,
                             user_password varchar(50) not null,
                             user_role char(20) not null
);


insert into user_account values
                             (1, 'admin', 'admin', 'leader'),
                             ( 2,'manager', 'manager', 'manager'),
                             (3, 'vanhao', '2310', 'leader'),
                             (4, 'dodat', 'dodat', 'leader');


create table data_log(
		id int auto_increment primary key,
        loai int not null,
        ten_loai nvarchar(50) not null, 
        ID_NGUOI int,
        ghi_chu nvarchar(200),
		noi_den nvarchar(100),
        ngay_thay_doi date,
        ngay_ket_thuc date,
        foreign key (ID_NGUOI) references NHANKHAU(ID_NGUOI)
);

insert into data_log values
						 (1, 1, 'Đăng ký thường trú', 11,  'Mới sinh', 'Số nhà 520 - Ngách A /120 - Đường H', '2016-3-1', NULL),
						 (2, 2, 'Đăng ký tạm trú', 22, NULL, 'Số nhà 58 - Ngách G/220 - Đường F', '2022-1-1', '2024-1-1'),
                         (3, 3, 'Đăng ký tạm vắng', 8, NULL, 'Thanh Hoá', '2023-6-5', NULL),
                         (4, 4, 'Xoá nhân khẩu', 13, 'Đã mất', NULL, '2023-9-5', NULL),
                         (5, 5, 'Thay đổi hộ', 17, 'Tách hộ', 'Số nhà 145 - Đường B', '2010-10-10', NULL),
                         (6, 5, 'Thay đổi hộ', 18, 'Tách hộ', 'Số nhà 145 - Đường B', '2010-10-10', NULL),
                         (7, 5, 'Thay đổi hộ', 8, 'Đổi chủ hộ', NULL, '2023-1-1', NULL),
                         (8, 1, 'Đăng ký thường trú', 17, 'Hộ mới', 'Số nhà 145 - Đường B', '2010-10-10', NULL),
						 (9, 1, 'Đăng ký thường trú', 18, 'Hộ mới', 'Số nhà 145 - Đường B', '2010-10-10', NULL),
                         (10, 3, 'Đăng ký tạm vắng', 22, 'Đi tù', 'Số nhà 58 - Ngách G/220 - Đường F', '2023-1-1', '2026-1-1');

INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('11', '3', 'Đăng ký tạm vắng', '33', 'Hồ Chí Minh', '2022-04-01', '2025-04-01');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('12', '2', 'Đăng ký tạm trú', '34', 'Số nhà 1 - Đường Đại Cồ Việt', '2023-02-04', '2025-02-04');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `ghi_chu`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('13', '3', 'Đăng ký tạm vắng', '43', 'Đi tù', 'Côn đảo', '2019-12-30', '2024-12-30');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('14', '3', 'Đăng ký tạm vắng', '44', 'Bình Dương', '2020-03-06', '2024-03-02');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('15', '3', 'Đằng ký tạm vắng', '45', 'Đồng Nai', '2020-06-03', '2023-12-31');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('16', '1', 'Đăng ký thường trú', '46', 'Số nhà 3 - Đường ÚA', '2023-07-03', NULL);
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `ghi_chu`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('17', '3', 'Đăng ký tạm vắng', '47', 'Bỏ con', 'Thanh Hoá', '2023-11-01', '2026-01-01');
UPDATE `qlydancu`.`data_log` SET `noi_den` = 'Côn Đảo' WHERE (`id` = '10');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`) VALUES ('18', '1', 'Đăng ký thường trú', '48', 'Số nhà 97 - Phố Đ', '2023-02-14');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `ghi_chu`, `noi_den`, `ngay_thay_doi`, `ngay_ket_thuc`) VALUES ('19', '2', 'Đăng ký tạm trú', '49', 'Mới sinh', 'Số nhà 97 - Phố Đ', '2023-02-14', '2026-02-14');
INSERT INTO `qlydancu`.`data_log` (`id`, `loai`, `ten_loai`, `ID_NGUOI`, `noi_den`, `ngay_thay_doi`) VALUES ('20', '1', 'Đăng ký thường trú', '50', 'Số nhà 97 - Phố Đ', '2023-08-01');


create table Khoan_thu(
					  id_khoan_thu int auto_increment primary key,
                      loai int not null,
                      ten nvarchar(50) not null,
                      don_gia int,
                      ngay_bat_dau date,
                      ngay_ket_thuc date
);

insert into Khoan_thu values
						(1, 1, 'Phí vệ sinh', 6000, NULL, NULL),
                        (2, 1, 'Phí an ninh', 10000, NULL, NULL),
                        (3, 1, 'Phí xã hội', 5000, NULL, NULL),
                        (4, 0, 'Ủng hộ ngày tết thiếu nhi', NULL, '2023-05-01', '2023-05-25'),
                        (5, 0, 'Ủng hộ vì người nghèo', NULL, '2023-10-01', '2023-12-31'),
                        (6, 0, 'Trợ giúp đồng bào bị ảnh hưởng bão lụt', NULL, '2023-07-07', '2023-08-30'),
                        (7, 0, 'Ủng hộ ngày thương binh-liệt sỹ 27/07', NULL, '2023-06-15', '2023-07-20');

create table Khoan_thu_log(
						ID_HO int,
                        id_khoan_thu int, 
                        so_tien int,
                        dot_nop int,
                        ngay_nop date,
                        primary key (ID_HO, id_khoan_thu),
                        foreign key (ID_HO) references HOKHAU(ID_HO),
                        foreign key (id_khoan_thu) references Khoan_thu(id_khoan_thu)
);

insert into Khoan_thu_log values
						(1, 1, 288000, 1, '2023-01-15'),
                        (2, 1, 360000, 3, '2023-03-12'),
                        (4, 1, 288000, 1, '2023-01-19'),
                        (5, 1, 288000, 1, '2023-01-29'),
                        (7, 1, 144000, 5, '2023-05-19'),
                        (8, 1, 216000, 8, '2023-08-17'),
                        (9, 1, 288000, 9, '2023-09-04'),
                        (10, 1, 216000, 12, '2023-12-02'),
                        (11, 1, 360000, 4, '2023-04-21'),
                        (12, 1, 72000, 2, '2023-02-06'),
                        (13, 1, 216000, 6, '2023-06-08'),
                        (15, 1, 144000, 10, '2023-10-29'),
                        (1, 2, 480000, 1, '2023-01-15'),
                        (2, 2, 600000, 2, '2023-02-25'),
                        (3, 2, 360000, 9, '2023-09-09'),
                        (4, 2, 480000, 4, '2023-04-30'),
                        (6, 2, 600000, 8, '2023-08-12'),
                        (8, 2, 360000, 12, '2023-12-08'),
                        (9, 2, 480000, 3, '2023-03-16'),
                        (10, 2, 360000, 4, '2023-04-05'),
                        (11, 2, 600000, 7, '2023-07-17'),
                        (12, 2, 120000, 2, '2023-02-06'),
                        (13, 2, 360000, 10, '2023-10-11'),
                        (15, 2, 240000, 6, '2023-06-11'),
                        (1, 3, 240000, 1, '2023-01-15'),
                        (3, 3, 180000, 3, '2023-03-08'),
                        (4, 3, 240000, 7, '2023-07-27'),
                        (5, 3, 240000, 5, '2023-05-20'),
                        (8, 3, 180000, 12, '2023-12-08'),
                        (9, 3, 240000, 2, '2023-02-28'),
                        (10, 3, 180000, 9, '2023-09-19'),
                        (11, 3, 300000, 6, '2023-06-25'),
                        (12, 3, 60000, 1, '2023-01-30'),
                        (13, 3, 180000, 8, '2023-08-16'),
                        (15, 3, 120000, 11, '2023-11-12'),
                        (1, 7, 20000, 6, '2023-06-30'),
                        (1, 5, 40000, 11, '2023-11-11'),
                        (2, 6, 100000, 8, '2023-08-08'),
						(2, 4, 50000, 5, '2023-05-15'),	
                        (3, 5, 30000, 10, '2023-10-21'),
                        (3, 6, 100000, 8, '2023-08-16'),
                        (4, 4, 500000, 5, '2023-05-25'),
                        (4, 6, 200000, 7, '2023-07-29'),
                        (5, 7, 20000, 6, '2023-06-19'),
                        (6, 6, 200000, 8, '2023-08-01'),
                        (7, 4, 20000, 5, '2023-05-05'),
                        (7, 7, 50000, 7, '2023-07-09'),
                        (8, 4, 25000, 5, '2023-05-14'),
                        (11, 4, 30000, 5, '2023-05-24'),
                        (13, 4, 100000, 5, '2023-05-01'),
                        (14, 4, 120000, 5, '2023-05-01'),
                        (9, 5, 70000, 10, '2023-10-09'),
                        (10, 5, 75000, 10, '2023-10-11'),
                        (11, 5, 100000, 12, '2023-12-09'),
                        (15, 5, 600000, 12, '2023-12-31'),
                        (8, 6, 100000, 7, '2023-07-07'),
                        (9, 6, 50000, 7, '2023-07-27'),
                        (11, 6, 30000, 7, '2023-08-15'),
                        (15, 6, 120000, 8, '2023-08-30'),
                        (8, 7, 1000000, 7, '2023-07-02'),
                        (13, 7, 100000, 6, '2023-06-15'),
                        (10, 7, 65000, 6, '2023-06-29'),
                        (15, 7, 600000, 7, '2023-07-20');
