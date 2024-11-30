-- Tạo cơ sở dữ liệu
CREATE DATABASE StudentManagement;
GO

-- Sử dụng cơ sở dữ liệu vừa tạo
USE StudentManagement;
GO

-- Tạo bảng Department
CREATE TABLE Department (
    DepartmentID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
    DepartmentName NVARCHAR(100) NOT NULL,
    Location NVARCHAR(100) NOT NULL
);
GO

-- Tạo bảng User
CREATE TABLE [dbo].[User] (
  [UserID] INT NOT NULL IDENTITY(1,1),
  [Username] NVARCHAR(255) NULL,
  [Email] NVARCHAR(255) NULL,
  [Password] NVARCHAR(255) NULL,
  [VerifyCode] NVARCHAR(255) NULL,
  [Status] NVARCHAR(255) DEFAULT '',
  CONSTRAINT [PK_user] PRIMARY KEY ([UserID])
);
GO

-- Tạo bảng Subject
CREATE TABLE Subject (
    SubjectID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
    SubjectName NVARCHAR(100) NOT NULL,
    Credits INT NOT NULL,
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);
GO

-- Tạo bảng Class
CREATE TABLE Class (
    ClassID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
    ClassName NVARCHAR(100) NOT NULL,
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);
GO

-- Tạo bảng Lecture
CREATE TABLE Lecture (
    LectureID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);
GO

-- Tạo bảng Student
CREATE TABLE Student (
    StudentID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    Birthday DATE NOT NULL,
    ClassID INT,
    FOREIGN KEY (ClassID) REFERENCES Class(ClassID)
);
GO

-- Tạo bảng Score
CREATE TABLE Score (
    MarkID INT PRIMARY KEY NOT NULL IDENTITY(1,1),
    StudentID INT,
    SubjectID INT,
    Marks DECIMAL(5,2),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (SubjectID) REFERENCES Subject(SubjectID)
);
GO

-- Thêm dữ liệu vào bảng Department
INSERT INTO Department (DepartmentName, Location) VALUES
('Computer Science', 'Building A'),
('Mathematics', 'Building B'),
('Physics', 'Building C'),
('Chemistry', 'Building D'),
('Biology', 'Building E');

-- Thêm dữ liệu vào bảng User
INSERT INTO [User] (Username, Email, Password, VerifyCode, Status) VALUES
('john_doe', 'john@example.com', 'password123', 'abc123', 1),
('jane_doe', 'jane@example.com', 'password456', 'def456', 1),
('admin', 'admin@example.com', 'adminpass', 'xyz789', 1),
('user1', 'user1@example.com', 'userpass1', 'uvw456', 1),
('user2', 'user2@example.com', 'userpass2', 'rst123', 1);

-- Thêm dữ liệu vào bảng Subject
INSERT INTO Subject (SubjectName, Credits, DepartmentID) VALUES
('Data Structures', 3, 1),
('Calculus', 4, 2),
('Classical Mechanics', 3, 3),
('Organic Chemistry', 4, 4),
('Genetics', 3, 5);

-- Thêm dữ liệu vào bảng Class
INSERT INTO Class (ClassName, DepartmentID) VALUES
('CS101', 1),
('MATH101', 2),
('PHYS101', 3),
('CHEM101', 4),
('BIO101', 5);

-- Thêm dữ liệu vào bảng Lecture
INSERT INTO Lecture (Name, DepartmentID) VALUES
('Dr. Smith', 1),
('Prof. Johnson', 2),
('Dr. Brown', 3),
('Dr. White', 4),
('Prof. Black', 5);

-- Thêm dữ liệu vào bảng Student
INSERT INTO Student (Name, Birthday, ClassID) VALUES
('Alice', '2000-01-01', 1),
('Bob', '1999-05-15', 2),
('Charlie', '2001-03-20', 1),
('David', '2000-10-10', 3),
('Eva', '1998-12-05', 4);

-- Thêm dữ liệu vào bảng Score
INSERT INTO Score (StudentID, SubjectID, Marks) VALUES
(1, 1, 85.50),
(1, 2, 90.00),
(2, 1, 78.00),
(3, 3, 88.75),
(4, 2, 92.00),
(5, 4, 76.50),
(1, 5, 80.00),
(2, 3, 85.00),
(3, 1, 90.50),
(4, 5, 89.00);