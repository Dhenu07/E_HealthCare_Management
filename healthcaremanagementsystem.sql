-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2024 at 06:28 PM
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
  `DoctorName` varchar(20) DEFAULT NULL,
  `DoctorID` int DEFAULT NULL,
  `DoctorType` varchar(20) DEFAULT NULL,
  `Qualification` varchar(20) DEFAULT NULL,
  `DoctorFees` int DEFAULT NULL,
  `PaymentStatus` varchar(33) DEFAULT NULL,
  `Appointment_Status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`AppointmentID`, `Problem`, `PatientId`, `DoctorName`, `DoctorID`, `DoctorType`, `Qualification`, `DoctorFees`, `PaymentStatus`, `Appointment_Status`) VALUES
(1, 'I had a vision problem', 22, 'Dhenu', 21, 'Eye', 'Mbbs', 200, 'Payed', 'Completed'),
(2, 'Breathing issues', 22, 'Kishor', 25, 'Lungs', 'Mbbs', 1500, 'Payed', 'Completed'),
(3, 'Eye Problem', 26, 'Dhenu', 21, 'Eyes', 'Mbbs', 200, 'Payed', 'Pending');

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
(25, 'Kishore', 'P K', 'M', '9898989898', 22, 1500, 'MBBS', 'Lungs', 'kishorepk@gmail.com');

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
(22, 8, 'Good', 'Tup', 'Good');

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
(26, 'Divesh', 'S', 'M', '9867676758', 22, 'diveshdivesh@gmail.com', 'AB+', '34/3 cross Street,Nerhu nagar,mettupalayam');

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
(2, 2, 22, 25, 'dfefrf', 'erfeer');

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
(26, 'Patient', 'comeonbro');

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
