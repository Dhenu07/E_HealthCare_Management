-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 08, 2024 at 08:10 AM
-- Server version: 8.0.32
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcaremanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `AppointmentID` int NOT NULL,
  `Problem` varchar(50) DEFAULT NULL,
  `PatientId` int DEFAULT NULL,
  `DoctorID` int DEFAULT NULL,
  `PaymentStatus` varchar(33) DEFAULT NULL,
  `Appointment_Status` varchar(30) DEFAULT NULL,
  `appointment_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`AppointmentID`, `Problem`, `PatientId`, `DoctorID`, `PaymentStatus`, `Appointment_Status`, `appointment_time`) VALUES
(1, 'I had a vision problem', 22, 21, 'Payed', 'Completed', NULL),
(2, 'Breathing issues', 22, 25, 'Payed', 'Completed', NULL),
(3, 'Eye Problem', 26, 21, 'Payed', 'Completed', NULL),
(4, 'Kidney pain', 26, 26, 'Payed', 'Completed', NULL),
(5, 'fever', 26, 21, 'Payed', 'Completed', NULL),
(6, 'fever', 26, 21, 'Payed', 'Completed', NULL),
(7, 'cold', 28, 26, 'Payed', 'Pending', NULL),
(8, 'Eye pro', 28, 21, 'Payed', 'Pending', NULL),
(9, 'Eye Iritation', 26, 21, 'Payed', 'Pending', '2024-08-08 09:00:00'),
(10, 'Hand Pain', 26, 26, 'Payed', 'Pending', '2024-08-08 10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `DoctorID` int NOT NULL,
  `First_Name` varchar(30) DEFAULT NULL,
  `Last_Name` varchar(30) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `ContactNumber` varchar(11) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Entry_Charge` int DEFAULT NULL,
  `Qualification` varchar(50) DEFAULT NULL,
  `Doctor_Type` varchar(50) DEFAULT NULL,
  `Email_Id` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`DoctorID`, `First_Name`, `Last_Name`, `Gender`, `ContactNumber`, `Age`, `Entry_Charge`, `Qualification`, `Doctor_Type`, `Email_Id`) VALUES
(21, 'Dhenu', 'DS', 'M', '9677842990', 25, 200, 'Mbbs', 'Eyes', 'dhenuds2003@gmail.com'),
(25, 'Kishore', 'P K', 'M', '9898989898', 22, 1500, 'MBBS', 'Lungs', 'kishorepk@gmail.com'),
(26, 'Maaran', 'C T', 'M', '989898797', 20, 7000, 'mbbs,md', 'Kidney', 'maara@gmail.com'),
(27, 'Harsha', 'Vyas', 'M', '7373736095', 26, 1500, 'Mbbs', 'General', 'harshvardhan@gmail.com'),
(28, 'Kavi', 'R', 'M', '898989763', 25, 1000, 'Mbbs', 'Bone', 'kavi@gmail.com'),
(29, 'Guru Dev', 'Singh', 'M', '8674934724', 25, 1000, 'MBBS,MS', 'Heart', 'gurudev@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `PatientID` int DEFAULT NULL,
  `Points` int DEFAULT NULL,
  `Doc_Nature` varchar(200) DEFAULT NULL,
  `Location` varchar(200) DEFAULT NULL,
  `PatientComment` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`PatientID`, `Points`, `Doc_Nature`, `Location`, `PatientComment`) VALUES
(22, 8, 'Good', 'Tup', 'Good'),
(26, 10, 'Eye', 'Cbe', 'Great'),
(28, 10, 'Good', 'cbe', 'Good');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `PatientID` int NOT NULL,
  `First_Name` varchar(30) DEFAULT NULL,
  `Last_Name` varchar(30) DEFAULT NULL,
  `Gender` varchar(5) DEFAULT NULL,
  `ContactNumber` varchar(11) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `EmailID` varchar(30) DEFAULT NULL,
  `BloodGroup` varchar(5) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`PatientID`, `First_Name`, `Last_Name`, `Gender`, `ContactNumber`, `Age`, `EmailID`, `BloodGroup`, `Address`) VALUES
(22, 'Anirudh', 'RK', 'M', '7878787896', 23, 'ani@gmail.com', 'b+', 'mum'),
(26, 'Divesh', 'S', 'M', '9867676758', 22, 'diveshdivesh@gmail.com', 'AB+', '34/3 cross Street,Nerhu nagar,mettupalayam'),
(27, 'vanji', 'abc', 'm', '8989898989', 20, 'vanji@gmail.com', 'b+ve', '12nfndfn'),
(28, 'R', '898989567', 'M', 'O+', 20, 'dhanar@gmail.com', 'M', '34/23 Cbe');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `ReportID` int NOT NULL,
  `appointmentID` int DEFAULT NULL,
  `patientID` int DEFAULT NULL,
  `DoctorID` int DEFAULT NULL,
  `MedicinePrescribed` varchar(200) DEFAULT NULL,
  `DoctorComment` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`ReportID`, `appointmentID`, `patientID`, `DoctorID`, `MedicinePrescribed`, `DoctorComment`) VALUES
(1, 1, 22, 21, 'Drink carrot juice daily and dont use mobile', 'take tablet123'),
(2, 2, 22, 25, 'dfefrf', 'erfeer'),
(3, 4, 26, 26, 'abc', 'nothijng'),
(4, 3, 26, 21, 'dolo', 'no'),
(5, 5, 26, 21, 'Dolo150', 'Take rest'),
(6, 6, 26, 21, 'Dolo', 'Nothing');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int NOT NULL,
  `userType` varchar(100) NOT NULL,
  `Password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `userType`, `Password`) VALUES
(2, 'Patient', 'Two'),
(3, 'Doctor', 'Three'),
(3, 'Patient', 'Three'),
(4, 'Doctor', 'Four'),
(4, 'Patient', 'Four'),
(5, 'Doctor', 'Five'),
(5, 'Patient', 'Five'),
(6, 'Doctor', 'Six'),
(6, 'Patient', 'Six'),
(7, 'Doctor', 'Seven'),
(7, 'Patient', 'Seven'),
(8, 'Doctor', 'Eight'),
(8, 'Patient', 'Eight'),
(9, 'Doctor', 'Nine'),
(9, 'Patient', 'Nine'),
(10, 'Doctor', 'Ten'),
(10, 'Patient', 'Ten'),
(11, 'Doctor', 'Eleven'),
(11, 'Patient', 'Eleven'),
(12, 'Doctor', 'Twelve'),
(12, 'Patient', 'Twelve'),
(13, 'Doctor', 'Thirteen'),
(13, 'Patient', 'Thirteen'),
(14, 'Doctor', 'Fourteen'),
(14, 'Patient', 'Fourteen'),
(15, 'Doctor', 'Fifteen'),
(15, 'Patient', 'Fifteen'),
(16, 'Doctor', 'Sixteen'),
(16, 'Patient', 'Sixteen'),
(17, 'Doctor', 'Seventeen'),
(17, 'Patient', 'Seventeen'),
(18, 'Doctor', 'Eighteen'),
(18, 'Patient', 'Eighteen'),
(19, 'Doctor', 'Nineteen'),
(19, 'Patient', 'Nineteen'),
(20, 'Doctor', 'Twenty'),
(20, 'Patient', 'Twenty'),
(21, 'Doctor', 'Doc21'),
(21, 'Patient', 'Thisisme'),
(22, 'Doctor', '12345'),
(22, 'Patient', '1234'),
(23, 'Doctor', 'maaran123'),
(24, 'Doctor', 'kishore123'),
(25, 'Doctor', 'kishore123'),
(26, 'Doctor', 'maara'),
(26, 'Patient', 'comeonbro'),
(27, 'Doctor', 'harsh'),
(27, 'Patient', '12345'),
(28, 'Doctor', 'kavi'),
(28, 'Patient', 'iamhere'),
(29, 'Doctor', 'Guru');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`AppointmentID`),
  ADD KEY `FK_p` (`PatientId`),
  ADD KEY `FK_docid` (`DoctorID`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`DoctorID`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD KEY `FK_pid` (`PatientID`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`PatientID`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`ReportID`),
  ADD KEY `FK_apid_Reports` (`appointmentID`),
  ADD KEY `FK_p_Reports` (`patientID`),
  ADD KEY `FK_docid_Reports` (`DoctorID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`,`userType`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `FK_docid` FOREIGN KEY (`DoctorID`) REFERENCES `doctors` (`DoctorID`),
  ADD CONSTRAINT `FK_p` FOREIGN KEY (`PatientId`) REFERENCES `patients` (`PatientID`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `FK_pid` FOREIGN KEY (`PatientID`) REFERENCES `patients` (`PatientID`);

--
-- Constraints for table `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `FK_apid_Reports` FOREIGN KEY (`appointmentID`) REFERENCES `appointments` (`AppointmentID`),
  ADD CONSTRAINT `FK_docid_Reports` FOREIGN KEY (`DoctorID`) REFERENCES `doctors` (`DoctorID`),
  ADD CONSTRAINT `FK_p_Reports` FOREIGN KEY (`patientID`) REFERENCES `patients` (`PatientID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
