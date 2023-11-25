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

select *
from HoKhau



