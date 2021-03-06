USE [Airline]
GO
/****** Object:  Table [dbo].[City]    Script Date: 04/04/2019 08:58:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[City](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[City] ON
INSERT [dbo].[City] ([id], [name]) VALUES (1, N'Ha Noi                                                                                                                                                ')
INSERT [dbo].[City] ([id], [name]) VALUES (2, N'Ho Chi Minh                                                                                                                                           ')
INSERT [dbo].[City] ([id], [name]) VALUES (3, N'Da Nang                                                                                                                                               ')
INSERT [dbo].[City] ([id], [name]) VALUES (4, N'Da Lat                                                                                                                                                ')
SET IDENTITY_INSERT [dbo].[City] OFF
/****** Object:  Table [dbo].[Users]    Script Date: 04/04/2019 08:58:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[email] [varchar](150) NOT NULL,
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[password] [varchar](max) NOT NULL,
	[firstname] [varchar](150) NULL,
	[lastname] [varchar](150) NULL,
	[address] [varchar](150) NULL,
	[phone] [varchar](150) NULL,
	[sex] [bit] NULL,
	[cardNumber] [varchar](150) NULL,
	[age] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON
INSERT [dbo].[Users] ([email], [ID], [password], [firstname], [lastname], [address], [phone], [sex], [cardNumber], [age]) VALUES (N'abc@gmail.com', 1, N'123', N'An', N'Hoang', N'Ha Noi', N'0972079516', 1, N'12345', 20)
INSERT [dbo].[Users] ([email], [ID], [password], [firstname], [lastname], [address], [phone], [sex], [cardNumber], [age]) VALUES (N'abcd@gmail.com', 2, N'1234', N'Quynh', N'Kieu', N'Ha Tay', N'9876543123', 1, N'123456', 4)
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Table [dbo].[FlightTime]    Script Date: 04/04/2019 08:58:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FlightTime](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[fromCity] [int] NULL,
	[toCity] [int] NULL,
	[dateFlight] [date] NULL,
	[depart] [varchar](150) NULL,
	[arrival] [varchar](150) NULL,
	[roundTime] [varchar](150) NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[FlightTime] ON
INSERT [dbo].[FlightTime] ([ID], [fromCity], [toCity], [dateFlight], [depart], [arrival], [roundTime], [price]) VALUES (1, 1, 2, CAST(0x803F0B00 AS Date), N'03:00 PM', N'04:30 PM', N'1h30', 123)
INSERT [dbo].[FlightTime] ([ID], [fromCity], [toCity], [dateFlight], [depart], [arrival], [roundTime], [price]) VALUES (2, 2, 1, CAST(0x813F0B00 AS Date), N'03:00 PM', N'04:30 PM', N'1h30', 456)
INSERT [dbo].[FlightTime] ([ID], [fromCity], [toCity], [dateFlight], [depart], [arrival], [roundTime], [price]) VALUES (3, 1, 2, CAST(0x803F0B00 AS Date), N'05:00 PM', N'06:30 PM', N'1h30', 567)
SET IDENTITY_INSERT [dbo].[FlightTime] OFF
/****** Object:  Table [dbo].[booking]    Script Date: 04/04/2019 08:58:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[booking](
	[bookID] [int] IDENTITY(1,1) NOT NULL,
	[reservationCode] [varchar](150) NULL,
	[userID] [int] NULL,
	[flight1ID] [int] NULL,
	[flight2ID] [int] NULL,
	[timeBook] [varchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[bookID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[booking] ON
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (1, N'ES25B2', 1, 3, NULL, N'Sun Mar 17 20:01:35 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (2, N'QJS3AZ', 1, 1, 2, N'Sun Mar 17 20:02:08 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (3, N'5PC9QL', 1, 3, 2, N'Sun Mar 17 20:03:56 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (4, N'KEI3KX', 1, 3, NULL, N'Sun Mar 17 20:44:25 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (5, N'0RKHJ1', 1, 3, 2, N'Sun Mar 17 20:46:52 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (6, N'888QRK', 1, 3, 2, N'Sun Mar 17 22:08:36 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (7, N'JXGCKD', 1, 3, NULL, N'Mon Mar 18 10:07:46 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (8, N'7208ZQ', 1, 3, NULL, N'Mon Mar 18 20:27:59 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (9, N'M7OHJP', 1, 1, NULL, N'Mon Mar 25 23:02:34 ICT 2019')
INSERT [dbo].[booking] ([bookID], [reservationCode], [userID], [flight1ID], [flight2ID], [timeBook]) VALUES (10, N'X0TQ8I', 1, 3, NULL, N'Mon Mar 25 23:08:57 ICT 2019')
SET IDENTITY_INSERT [dbo].[booking] OFF
/****** Object:  ForeignKey [FK__booking__flight1__3F466844]    Script Date: 04/04/2019 08:58:54 ******/
ALTER TABLE [dbo].[booking]  WITH CHECK ADD FOREIGN KEY([flight1ID])
REFERENCES [dbo].[FlightTime] ([ID])
GO
/****** Object:  ForeignKey [FK__booking__flight2__403A8C7D]    Script Date: 04/04/2019 08:58:54 ******/
ALTER TABLE [dbo].[booking]  WITH CHECK ADD FOREIGN KEY([flight2ID])
REFERENCES [dbo].[FlightTime] ([ID])
GO
/****** Object:  ForeignKey [FK__booking__userID__3E52440B]    Script Date: 04/04/2019 08:58:54 ******/
ALTER TABLE [dbo].[booking]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([ID])
GO
/****** Object:  ForeignKey [FK__FlightTim__fromC__0CBAE877]    Script Date: 04/04/2019 08:58:54 ******/
ALTER TABLE [dbo].[FlightTime]  WITH CHECK ADD FOREIGN KEY([fromCity])
REFERENCES [dbo].[City] ([id])
GO
/****** Object:  ForeignKey [FK__FlightTim__toCit__0DAF0CB0]    Script Date: 04/04/2019 08:58:54 ******/
ALTER TABLE [dbo].[FlightTime]  WITH CHECK ADD FOREIGN KEY([toCity])
REFERENCES [dbo].[City] ([id])
GO
