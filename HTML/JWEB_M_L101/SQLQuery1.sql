
CREATE TABLE  Users (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(50),
    UserName VARCHAR(100),
    Password VARCHAR(50)
);
GO
GO
CREATE TABLE  User_Roles (
    User_role_id INT PRIMARY KEY,
    Authority VARCHAR(45),
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);


CREATE PROCEDURE [dbo].[usp_registerUser]
    @firstName VARCHAR(50),
    @lastName VARCHAR(50),
    @email VARCHAR(50),
    @userName VARCHAR(100),
    @password VARCHAR(50)
AS
BEGIN
    INSERT INTO Users (FirstName, LastName, Email, UserName, Password)
    VALUES (@firstName, @lastName, @email, @userName, @password);
END;
GO