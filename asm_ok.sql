USE [asm]
GO
/****** Object:  Table [dbo].[History]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[History](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[video_id] [int] NULL,
	[view_date] [datetime] NOT NULL,
	[is_like] [bit] NULL,
	[like_date] [datetime] NULL,
 CONSTRAINT [PK_Histories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[role] [bit] NOT NULL,
	[online] [bit] NOT NULL,
 CONSTRAINT [PK__Users__B9BE370F240672AE] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Video]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Video](
	[video_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NOT NULL,
	[description] [text] NULL,
	[poster] [varchar](500) NULL,
	[url] [varchar](100) NULL,
	[user_id] [int] NOT NULL,
	[online] [bit] NOT NULL,
	[share] [int] NULL,
 CONSTRAINT [PK__Video__E8F11E10455D620B] PRIMARY KEY CLUSTERED 
(
	[video_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[History] ON 

INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (1, 1, 1, CAST(N'2011-01-01T08:00:00.000' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (2, 2, 1, CAST(N'2024-04-08T22:50:17.507' AS DateTime), 1, CAST(N'2024-04-08T23:16:41.923' AS DateTime))
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (3, 1, 3, CAST(N'2024-04-08T23:43:57.477' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (4, 1, 2, CAST(N'2024-04-08T23:44:33.807' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (5, 3, 1, CAST(N'2024-04-09T00:43:15.533' AS DateTime), 1, CAST(N'2024-04-09T00:43:17.107' AS DateTime))
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (9, 1, 6, CAST(N'2024-04-10T13:30:41.390' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (10, 1, 8, CAST(N'2024-04-10T13:31:15.550' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (14, 1, 7, CAST(N'2024-04-10T13:31:50.817' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (15, 1, 5, CAST(N'2024-04-10T13:31:55.170' AS DateTime), 1, CAST(N'2024-04-10T13:31:57.103' AS DateTime))
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (16, 1, 7, CAST(N'2024-04-10T13:32:26.397' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (17, 1, 7, CAST(N'2024-04-10T13:32:44.600' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (18, 1, 7, CAST(N'2024-04-10T13:32:58.157' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (19, 1, 7, CAST(N'2024-04-10T13:33:04.227' AS DateTime), 0, NULL)
INSERT [dbo].[History] ([id], [user_id], [video_id], [view_date], [is_like], [like_date]) VALUES (20, 1, 10, CAST(N'2024-04-10T13:39:51.847' AS DateTime), 0, NULL)
SET IDENTITY_INSERT [dbo].[History] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (1, N'nguoi dung 1', N'1234                ', N'nguoidung1@example.com', 1, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (2, N'user2', N'password2           ', N'user2@example.com', 0, 0)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (3, N'user3', N'password3           ', N'user3@example.com', 1, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (4, N'user4', N'password4           ', N'user4@example.com', 0, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (5, N'user5', N'password5           ', N'user5@example.com', 1, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (6, N'user6', N'password6           ', N'user6@example.com', 0, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (7, N'user7', N'password7           ', N'user7@example.com', 0, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (8, N'user8', N'password8           ', N'user8@example.com', 0, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (9, N'user9', N'password9           ', N'user9@example.com', 1, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (10, N'user10', N'password10          ', N'user10@example.com', 0, 1)
INSERT [dbo].[User] ([user_id], [username], [password], [email], [role], [online]) VALUES (12, N'tai khoan 11', N'123                 ', N'user11@example.com', 0, 1)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
SET IDENTITY_INSERT [dbo].[Video] ON 

INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (1, N'Video 1', N'Description for Video 1111', N'https://th.bing.com/th/id/OIP.3l2nfzcHhMemSZooiH3B3AHaFj?rs=1&pid=ImgDetMain', N'mEU08ULNo5s?si=CaOCv5MJ5JctLptY', 1, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (2, N'Video 2', N'Description for Video 2', N'https://th.bing.com/th/id/R.fb5e7ff6ba759d1745042a8b82976d4e?rik=h1uRyv%2ff3gBCgA&pid=ImgRaw&r=0', N'X3U9QxMSRPU?si=2Rl3aPpQpDfU9DNn', 1, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (3, N'Video 3', N'Description for Video 3', N'https://th.bing.com/th/id/OIP.4cmK9d36bF0F7-V-SaVPnAHaG_?rs=1&pid=ImgDetMain', N'G0dUMTOALvU?si=dgnQgyCj6HmV4jOH', 3, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (4, N'Video 4', N'Description for Video 4', N'https://th.bing.com/th/id/OIP.QHQqJpPhz6co98WB7_angwHaE8?rs=1&pid=ImgDetMain', N'6acS2vOxmRI?si=Hmdr4SulCig6KN7x', 3, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (5, N'Video 5', N'Description for Video 5', N'https://th.bing.com/th/id/OIP.kIw--JvYdeb424lw1kPzfQHaEK?rs=1&pid=ImgDetMain', N'G0dUMTOALvU?si=dgnQgyCj6HmV4jOH', 3, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (6, N'Video 6', N'Description for Video 6', N'https://th.bing.com/th/id/OIP._cbimt2EtvdH_O1blQ5tYAHaE8?rs=1&pid=ImgDetMain', N'6acS2vOxmRI?si=Hmdr4SulCig6KN7x', 1, 0, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (7, N'Video 7', N'Description for Video 7', N'https://th.bing.com/th/id/R.f54349cd4207588262785b256adb72e3?rik=VEDGUDijEl%2bYlw&pid=ImgRaw&r=0', N'G0dUMTOALvU?si=dgnQgyCj6HmV4jOH', 1, 0, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (8, N'Video 8', N'Description for Video 8', N'https://www.pixelstalk.net/wp-content/uploads/2016/03/Cool-Wild-Animal-Wallpaper-For-Desktop.jpg', N'X3U9QxMSRPU?si=2Rl3aPpQpDfU9DNn', 9, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (9, N'Video 9', N'Description for Video 9', N'https://i.stack.imgur.com/vhoa0.jpg', N'mEU08ULNo5s?si=CaOCv5MJ5JctLptY', 9, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (10, N'Video 10', N'Description for Video 10', N'https://th.bing.com/th/id/OIP.-D5xt6nfX4BGup0qkTmyiAHaFI?rs=1&pid=ImgDetMain', N'G0dUMTOALvU?si=dgnQgyCj6HmV4jOH', 1, 1, 0)
INSERT [dbo].[Video] ([video_id], [title], [description], [poster], [url], [user_id], [online], [share]) VALUES (11, N'Video 1', N'Description for Video 1111', N'https://th.bing.com/th/id/OIP.3l2nfzcHhMemSZooiH3B3AHaFj?rs=1&pid=ImgDetMain', N'X3U9QxMSRPU?si=2Rl3aPpQpDfU9DNn', 1, 1, 0)
SET IDENTITY_INSERT [dbo].[Video] OFF
GO
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_Histories_Users] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([user_id])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_Histories_Users]
GO
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_Histories_Videos1] FOREIGN KEY([video_id])
REFERENCES [dbo].[Video] ([video_id])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_Histories_Videos1]
GO
/****** Object:  StoredProcedure [dbo].[sp_selectUsersLikedVideoByID]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_selectUsersLikedVideoByID](@IdVideo int)
as begin 
		SELECT u.user_id,u.username,u.email,u.online,h.like_date,h.view_date
		from video v LEFT JOIN history h ON h.video_id = v.video_id LEFT JOIN [user] u ON u.user_id = h.user_id
		WHERE
        v.video_id =@IdVideo AND u.online = 1 AND
        v.online = 1 AND h.is_like = 1
END
GO
/****** Object:  StoredProcedure [dbo].[sp_selectVideoLikes]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_selectVideoLikes]
AS
BEGIN
    SELECT v.video_id, v.title, v.url, v.share,COALESCE(SUM(CAST(h.is_like AS INT)), 0) AS totalLike
    FROM video v
    LEFT JOIN history h ON h.video_id = v.video_id
    WHERE v.online = 1
    GROUP BY v.video_id, v.title, v.url,v.share
    ORDER BY totalLike DESC
END
GO
/****** Object:  StoredProcedure [dbo].[sp_userhistory]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_userhistory](@id int)
AS
BEGIN
    SELECT v.video_id, v.title, v.url, v.share,COALESCE(v.description,'') as mes , view_date
	
    FROM video v
    LEFT JOIN history h ON h.video_id = v.video_id
    WHERE v.online = 1 and h.user_id = @id  and h.view_date is not null
	
    
END
GO
/****** Object:  StoredProcedure [dbo].[sp_uservideo]    Script Date: 4/10/2024 1:55:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_uservideo](@id int)
AS
BEGIN
    SELECT v.video_id, v.title, v.url, v.share,COALESCE(v.description,'') as mes,h.like_date , view_date
	
    FROM video v
    LEFT JOIN history h ON h.video_id = v.video_id
    WHERE v.online = 1 and h.user_id = @id and h.like_date is not null
	
    
END
GO
