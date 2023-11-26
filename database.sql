DROP DATABASE IF EXISTS QLYDANCU;
CREATE DATABASE QLYDANCU;
USE QLYDANCU;

create table HoKhau
(
	ID_HO int identity(1, 1), 
	chu_ho nvarchar(100), 
	dia_chi nvarchar(100),
	so_thanh_vien int,
	primary key(ID_HO)
)

insert into HoKhau
values
	(N'Nguyễn Văn An', N'Số nhà 20 - Ngách A /120 - Đường B - Quận C - Thành phố D', 4),
	(N'Nguyễn Thị Dung', N'Số nhà 58 - Ngách G/220 - Đường F - Quận C - Thành phố D', 5),
	(N'Trịnh Hoàng Hải', N'Số nhà 234 - Ngách A /342 - Đường T - Quận C - Thành phố D', 3),
	(N'Đoàn Trần Minh', N'Số nhà 356 - Ngách E  - Đường B - Quận C - Thành phố D', 4),
	(N'Lê Ngọc Mờ', N'Số nhà 520 - Ngách A /120 - Đường H - Quận B - Thành phố D', 4),
	(N'Trần Hữu Cơ', N'Số nhà 15 - Đường A - Quận B - Thành phố D', 5),
	(N'Lê Tuấn Hờ', N'Số nhà 145 - Đường B - Quận A - Thành phố D', 2);

--------------------------------------------------------------------------------------------------
--#update 2023/11/26

create table NHANKHAU
(
	ID_NGUOI int identity(1, 1),
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
	ID_HO int foreign key references HOKHAU(ID_HO)
)

insert into NHANKHAU (ID_HO, ho_ten, ngay_sinh, gioi_tinh, dan_toc, nghe_nghiep, nguyen_quan, noi_sinh, noi_lam_viec, CCCD, ngay_cap_CCCD, noi_cap_CCCD, vai_tro)
values
	(3, N'Trịnh Hoàng Hải', '1985-5-1',	N'Nam',	N'Kinh', N'Kiến trúc sư', N'Lào Cai', N'Lào Cai', N'Hà Nội', '008430122322', '2020-1-15', N'Lào Cai', N'Chủ hộ'),
	(3, N'Trần Minh Nghi', '1988-8-9', N'Nữ', N'Kinh', N'Nội trợ', 'Bắc Ninh', N'Bắc Ninh',	N'Hà Nội', '008923899023', '2020-7-6', N'Bắc Ninh',	N'Vợ'),
	(3, N'Trịnh Mỹ Á', '2015-2-15',	N'Nữ', N'Kinh',	N'Học sinh', N'Lào Cai', N'Hà Nội',	N'Hà Nội', NULL, NULL, NULL, N'Con'),
	(4, N'Đoàn Trần Minh', '1983-3-8', N'Nam', N'Kinh', N'Giảng viên', N'Bắc Ninh', N'Bắc Ninh', N'Hà Nội', '003420012232', '2019-8-17', N'Bắc Ninh', N'Chủ hộ'),
	(4, N'Từ An Vân', '1988-6-10', N'Nữ', N'Sán Dìu', N'Giáo viên',	N'Bắc Ninh', N'Bắc Ninh', N'Hà Nội', '003823904827', '2018-5-16', N'Bắc Ninh', N'Vợ'),
	(4, N'Đoàn Văn Độ',	'2009-08-12', N'Nam', N'Kinh', N'Học sinh', N'Bắc Ninh', N'Hà Nội', N'Hà Nội', NULL, NULL, NULL, N'Con'),
	(4, N'Đoàn Thế Lân', '2009-08-12', N'Nam', N'Kinh', N'Học sinh', N'Bắc Ninh', N'Hà Nội', N'Hà Nội', NULL, NULL, NULL, N'Con'),
	(5, N'Lê Ngọc Mờ', '1990-9-19',	N'Nam',	N'Kinh', N'Kỹ sư', N'Thanh Hoá', N'Thanh Hoá', N'Hà Nội', '008943949012', '2021-5-19', N'Thanh Hoá', N'Chủ hộ'),
	(5, N'Lê Minh Nờ', '1990-2-2', N'Nữ', N'Kinh', 	N'Phóng viên', N'Nghệ An', N'Nghệ An', N'Hà Nội', '094832049483', '2021-2-5', N'Nghệ An', N'Vợ'),
	(5, N'Trần Thị Bành', '1965-1-9', N'Nữ', N'Kinh', N'Nghỉ hưu', N'Thanh Hoá', N'Thanh Hoá', N'Hà Nội', '003478232316', '2021-5-19', N'Thanh Hoá', N'Mẹ'),
	(5, N'Lê Ngọc Nét', '2016-2-29', N'Nam', N'Kinh', N'Học sinh', N'Thanh Hoá', N'Hà Nội', N'Hà Nội', NULL, NULL, NULL, N'Con'),
	(6, N'Trần Hữu Cơ', '1958-8-5',	N'Nam',	N'Kinh', N'Nghỉ hưu', N'Hà Tĩnh', N'Hà Tĩnh', N'Hà Nội', '002340941233', '2022-6-3', N'Hà Tĩnh', N'Chủ hộ'),
	(6, N'Lê Thị Ngọc Liên', '1960-6-19', N'Nữ', N'Kinh', N'Nghỉ hưu', N'Hà Tĩnh', N'Hà Tĩnh', N'Hà Nội', '040343401323', '2022-5-5', N'Hà Tĩnh', N'Vợ'),
	(6, N'Trần Văn An',	'1990-8-8',	N'Nam',	N'Kinh', N'Kỹ sư', N'Hà Nội', N'Hà Nội', N'Hà Nội', '092421033023', '2021-8-8',	N'Hà Nội', N'Con'),
	(6, N'Nguyễn Thị Hương Giang', '1992-2-9', N'Nữ', N'Kinh', N'Kỹ sư', N'Hà Nội',	N'Hà Nội', N'Hà Nội', '034984239846', '2022-9-3', N'Hà Nội', N'Con'),
	(6, N'Trần Minh Đức', '2015-5-1', N'Nam', N'Kinh', N'Học sinh', N'Hà Nội', N'Hà Nội', N'Hà Nội', NULL, NULL, NULL, N'Cháu'),
	(7, N'Lê Tuấn Hờ', '1960-6-19',	N'Nam',	N'Kinh', N'Nghỉ hưu', N'Ninh Bình', N'Ninh Bình', N'Hà Nội', '003403483474', '2015-5-5', N'Ninh Bình', N'Chủ hộ'),
	(7, N'Doãn Cẩm Hững', '1960-9-4', N'Nữ', 'Thái', N'Nghỉ hưu', N'Ninh Bình',	N'Ninh Bình', N'Hà Nội', '002449210313', '2015-5-5', N'Ninh Bình', N'Vợ'),	
	(2, N'Nguyễn Thị Dung', '1952-9-25', N'Nữ',	N'Kinh', N'Nghỉ hưu', N'Ninh Bình',	N'Ninh Bình', N'Hà Nội', '008234194049', '2020-6-12', N'Ninh Bình',	N'Chủ hộ'),
	(2, N'Nguyễn Văn Trạng', '1975-4-30', N'Nam', N'Kinh', N'Công Nhân', N'Hải Dương', N'Hải Dương', N'Hà Nội', '002948034891',	'2020-6-12', N'Hải Dương', N'Con'),
	(2, N'Đinh Thị Vân', '1980-8-19', N'Nữ', N'Kinh', N'Kinh Doanh', N'Hưng Yên', N'Hưng Yên', N'Hà Nội', '039424030401', '2020-6-12',	N'Hưng Yên', N'Con'),
	(2, N'Nguyễn Tuấn Đá', '2007-7-27',	N'Nam',	N'Kinh', N'Học sinh', N'Hải Dương',	N'Hà Nội', N'Hà Nội', NULL, NULL, NULL,	N'Cháu'),
	(2, N'Nguyễn Ngọc Bảo Trâu', '2011-11-20', N'Nữ', N'Kinh', N'Học sinh',	N'Hải Dương', N'Hà Nội', N'Hà Nội', NULL, NULL, NULL, N'Cháu'),
	(1, N'Nguyễn Văn An', '1980-8-19',	N'Nam',	N'Kinh', N'Công nhân',	N'Hà Nội', N'Hà Nội', N'Hà Nội', '090934938412', '2019-12-21', N'Hà Nội', N'Chủ hộ'),
	(1, N'Nguyễn Hải Hoa', '1983-3-18', N'Nữ', N'Tày',	N'Công nhân', N'Hà Nội', N'Hà Nội',	N'Hà Nội', '048500058341',	'2019-12-21', N'Hà Nội', N'Vợ'),
	(1, N'Nguyễn Ngọc Hà', '2005-5-20', N'Nữ', N'Kinh',	N'Sinh viên', N'Hà Nội', N'Hà Nội', N'Hà Nội', '048004249032', '2023-09-15', N'Hà Nội', N'Con'),
	(1, N'Nguyễn Đức Thuận', '2008-10-28', N'Nam', N'Kinh', N'Học sinh', N'Hà Nội', N'Hà Nội', N'Hà Nội', NULL, NULL, NULL, N'Con');



