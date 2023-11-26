DROP DATABASE IF EXISTS QLYDANCU;
CREATE DATABASE QLYDANCU;
USE QLYDANCU;

create table HoKhau
(
    ID_HO int auto_increment,
    chu_ho nvarchar(100),
    dia_chi nvarchar(100),
    so_thanh_vien int,
    primary key(ID_HO)
);

insert into HoKhau
values
    (1, 'Nguyễn Văn A', 'Số nhà 20 - Ngách A /120 - Đường B - Quận C - Thành phố D', 4),
    (2, 'Nguyễn Thị Dung', 'Số nhà 58 - Ngách G/220 - Đường F - Quận C - Thành phố D', 5),
    (3, 'Trịnh Hoàng Hải', 'Số nhà 234 - Ngách A /342 - Đường T - Quận C - Thành phố D', 3),
    (4, 'Đoàn Trần Minh', 'Số nhà 356 - Ngách E  - Đường B - Quận C - Thành phố D', 4),
    (5, 'Lê Ngọc Mờ', 'Số nhà 520 - Ngách A /120 - Đường H - Quận B - Thành phố D', 4),
    (6, 'Trần Hữu Cơ', 'Số nhà 15 - Đường A - Quận B - Thành phố D', 5),
    (7, 'Lê Tuấn Hờ', 'Số nhà 145 - Đường B - Quận A - Thành phố D', 2);

--------------------------------------------------------------------------------------------------
--#update 2023/11/26

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
    dia_chi_cu nvarchar(30),
    primary key (ID_NGUOI),
    ID_HO int,
    foreign key (ID_HO) references HOKHAU(ID_HO)
);

insert into NHANKHAU (ID_HO, ho_ten, ngay_sinh, gioi_tinh, dan_toc, nghe_nghiep, nguyen_quan, noi_sinh, noi_lam_viec, CCCD, ngay_cap_CCCD, noi_cap_CCCD, vai_tro)
values
    (3, 'Trịnh Hoàng Hải', '1985-5-1',	'Nam',	'Kinh', 'Kiến trúc sư', 'Lào Cai', 'Lào Cai', 'Hà Nội', '008430122322', '2020-1-15', 'Lào Cai', 'Chủ hộ'),
    (3, 'Trần Minh Nghi', '1988-8-9', 'Nữ', 'Kinh', 'Nội trợ', 'Bắc Ninh', 'Bắc Ninh',	'Hà Nội', '008923899023', '2020-7-6', 'Bắc Ninh',	'Vợ'),
    (3, 'Trịnh Mỹ Á', '2015-2-15',	'Nữ', 'Kinh',	'Học sinh', 'Lào Cai', 'Hà Nội',	'Hà Nội', NULL, NULL, NULL, 'Co'),
    (4, 'Đoàn Trần Minh', '1983-3-8', 'Nam', 'Kinh', 'Giảng viê', 'Bắc Ninh', 'Bắc Ninh', 'Hà Nội', '003420012232', '2019-8-17', 'Bắc Ninh', 'Chủ hộ'),
    (4, 'Từ An Vâ', '1988-6-10', 'Nữ', 'Sán Dìu', 'Giáo viê',	'Bắc Ninh', 'Bắc Ninh', 'Hà Nội', '003823904827', '2018-5-16', 'Bắc Ninh', 'Vợ'),
    (4, 'Đoàn Văn Độ',	'2009-08-12', 'Nam', 'Kinh', 'Học sinh', 'Bắc Ninh', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Co'),
    (4, 'Đoàn Thế Lâ', '2009-08-12', 'Nam', 'Kinh', 'Học sinh', 'Bắc Ninh', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Co'),
    (5, 'Lê Ngọc Mờ', '1990-9-19',	'Nam',	'Kinh', 'Kỹ sư', 'Thanh Hoá', 'Thanh Hoá', 'Hà Nội', '008943949012', '2021-5-19', 'Thanh Hoá', 'Chủ hộ'),
    (5, 'Lê Minh Nờ', '1990-2-2', 'Nữ', 'Kinh', 	'Phóng viê', 'Nghệ A', 'Nghệ A', 'Hà Nội', '094832049483', '2021-2-5', 'Nghệ A', 'Vợ'),
    (5, 'Trần Thị Bành', '1965-1-9', 'Nữ', 'Kinh', 'Nghỉ hưu', 'Thanh Hoá', 'Thanh Hoá', 'Hà Nội', '003478232316', '2021-5-19', 'Thanh Hoá', 'Mẹ'),
    (5, 'Lê Ngọc Nét', '2016-2-29', 'Nam', 'Kinh', 'Học sinh', 'Thanh Hoá', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Co'),
    (6, 'Trần Hữu Cơ', '1958-8-5',	'Nam',	'Kinh', 'Nghỉ hưu', 'Hà Tĩnh', 'Hà Tĩnh', 'Hà Nội', '002340941233', '2022-6-3', 'Hà Tĩnh', 'Chủ hộ'),
    (6, 'Lê Thị Ngọc Liê', '1960-6-19', 'Nữ', 'Kinh', 'Nghỉ hưu', 'Hà Tĩnh', 'Hà Tĩnh', 'Hà Nội', '040343401323', '2022-5-5', 'Hà Tĩnh', 'Vợ'),
    (6, 'Trần Văn A',	'1990-8-8',	'Nam',	'Kinh', 'Kỹ sư', 'Hà Nội', 'Hà Nội', 'Hà Nội', '092421033023', '2021-8-8',	'Hà Nội', 'Co'),
    (6, 'Nguyễn Thị Hương Giang', '1992-2-9', 'Nữ', 'Kinh', 'Kỹ sư', 'Hà Nội',	'Hà Nội', 'Hà Nội', '034984239846', '2022-9-3', 'Hà Nội', 'Co'),
    (6, 'Trần Minh Đức', '2015-5-1', 'Nam', 'Kinh', 'Học sinh', 'Hà Nội', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Cháu'),
    (7, 'Lê Tuấn Hờ', '1960-6-19',	'Nam',	'Kinh', 'Nghỉ hưu', 'Ninh Bình', 'Ninh Bình', 'Hà Nội', '003403483474', '2015-5-5', 'Ninh Bình', 'Chủ hộ'),
    (7, 'Doãn Cẩm Hững', '1960-9-4', 'Nữ', 'Thái', 'Nghỉ hưu', 'Ninh Bình',	'Ninh Bình', 'Hà Nội', '002449210313', '2015-5-5', 'Ninh Bình', 'Vợ'),
    (2, 'Nguyễn Thị Dung', '1952-9-25', 'Nữ',	'Kinh', 'Nghỉ hưu', 'Ninh Bình',	'Ninh Bình', 'Hà Nội', '008234194049', '2020-6-12', 'Ninh Bình',	'Chủ hộ'),
    (2, 'Nguyễn Văn Trạng', '1975-4-30', 'Nam', 'Kinh', 'Công Nhâ', 'Hải Dương', 'Hải Dương', 'Hà Nội', '002948034891',	'2020-6-12', 'Hải Dương', 'Co'),
    (2, 'Đinh Thị Vâ', '1980-8-19', 'Nữ', 'Kinh', 'Kinh Doanh', 'Hưng Yê', 'Hưng Yê', 'Hà Nội', '039424030401', '2020-6-12',	'Hưng Yê', 'Co'),
    (2, 'Nguyễn Tuấn Đá', '2007-7-27',	'Nam',	'Kinh', 'Học sinh', 'Hải Dương',	'Hà Nội', 'Hà Nội', NULL, NULL, NULL,	'Cháu'),
    (2, 'Nguyễn Ngọc Bảo Trâu', '2011-11-20', 'Nữ', 'Kinh', 'Học sinh',	'Hải Dương', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Cháu'),
    (1, 'Nguyễn Văn A', '1980-8-19',	'Nam',	'Kinh', 'Công nhâ',	'Hà Nội', 'Hà Nội', 'Hà Nội', '090934938412', '2019-12-21', 'Hà Nội', 'Chủ hộ'),
    (1, 'Nguyễn Hải Hoa', '1983-3-18', 'Nữ', 'Tày',	'Công nhâ', 'Hà Nội', 'Hà Nội',	'Hà Nội', '048500058341',	'2019-12-21', 'Hà Nội', 'Vợ'),
    (1, 'Nguyễn Ngọc Hà', '2005-5-20', 'Nữ', 'Kinh',	'Sinh viê', 'Hà Nội', 'Hà Nội', 'Hà Nội', '048004249032', '2023-09-15', 'Hà Nội', 'Co'),
    (1, 'Nguyễn Đức Thuậ', '2008-10-28', 'Nam', 'Kinh', 'Học sinh', 'Hà Nội', 'Hà Nội', 'Hà Nội', NULL, NULL, NULL, 'Co');



