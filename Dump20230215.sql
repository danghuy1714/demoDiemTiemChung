-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: diemtiemchung
-- ------------------------------------------------------
-- Server version	8.0.32-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bacsi`
--

DROP TABLE IF EXISTS `bacsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bacsi` (
  `madinhdanh` varchar(20) NOT NULL,
  `tenbacsi` varchar(20) NOT NULL,
  `tuoi` int NOT NULL,
  `chucdanh` varchar(20) NOT NULL,
  `sdt` varchar(20) NOT NULL,
  PRIMARY KEY (`madinhdanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bacsi`
--

LOCK TABLES `bacsi` WRITE;
/*!40000 ALTER TABLE `bacsi` DISABLE KEYS */;
INSERT INTO `bacsi` VALUES ('BS001','Trần Văn A',40,'Trường Khoa','0746382773'),('BS002','Trần Thị A',31,'Bác sĩ','0744535773'),('BS003','Trần Văn B',27,'Bác sĩ','0956464556'),('BS004','Trần Thị B',33,'Phó Khoa','0734562773'),('BS005','Trần Văn C',28,'Bác sĩ','0936463273'),('BS006','Trần Thị C',27,'Bác sĩ','0986544322'),('BS007','Trần Văn D',35,'Bác sĩ','0888342364'),('BS008','Trần Thị D',29,'Bác sĩ','0932747324'),('BS009','Trần Văn E',31,'Bác sĩ','0936345454'),('BS010','Trần Thị E',31,'Bác sĩ','0927625222'),('BS11','nguyen a',20,'Bác sĩ','12312'),('BS12','a',20,'Bác sĩ','0912312');
/*!40000 ALTER TABLE `bacsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benhnhan`
--

DROP TABLE IF EXISTS `benhnhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benhnhan` (
  `ID_benh_nhan` varchar(20) NOT NULL,
  `hoten` varchar(20) NOT NULL,
  `cccd` varchar(20) NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(20) NOT NULL,
  `gioitinh` varchar(5) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_benh_nhan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benhnhan`
--

LOCK TABLES `benhnhan` WRITE;
/*!40000 ALTER TABLE `benhnhan` DISABLE KEYS */;
INSERT INTO `benhnhan` VALUES ('BN01','Nguyễn Văn A','03630202345','2000-10-20','0931245465','Nam','drastra3102@gmail.com'),('BN02','Nguyễn Thị A','03612203345','2000-11-20','0945645222','Nữ','nta@gmail.com'),('BN03','Nguyễn Văn B','03486543345','2000-12-20','0353947563','Nam','nvb@gmail.com'),('BN04','Nguyễn Thị B','03987654345','2000-10-20','0917463284','Nữ','ntb@gmail.com'),('BN05','Nguyễn Văn C','03630111111','2000-09-20','0943846378','Nam','nvc@gmail.com'),('BN06','Nguyễn Thị C','03223344345','2000-08-20','0887433334','Nữ','ntc@gmail.com'),('BN07','Nguyễn Văn D','01010102345','2000-07-20','0935645645','Nam','nvd@gmail.com'),('BN08','Nguyễn Thị D','03630555544','2000-06-20','0978764535','Nữ','ntd@gmail.com'),('BN09','Nguyễn Văn E','03630222234','2000-05-20','0954765745','Nam','nve@gmail.com'),('BN10','Nguyễn Thị E','01454333333','2000-04-20','0909834957','Nữ','nte@gmail.com'),('BN11','Nguyen van a','0123456789','3900-02-01','092020202020','Nam','abc@gmail.com'),('BN12','Nguyen Van B','09213','3902-02-01','0912312','Nam','abc@gmail.com');
/*!40000 ALTER TABLE `benhnhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieutiem`
--

DROP TABLE IF EXISTS `phieutiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieutiem` (
  `ID_phieutiem` varchar(20) NOT NULL,
  `ID_benh_nhan` varchar(20) NOT NULL,
  `madinhdanh` varchar(20) NOT NULL,
  `masothuoc` varchar(20) NOT NULL,
  `somuidatiem` int NOT NULL,
  `ngaydatiem` date DEFAULT NULL,
  `ngaytiem` date NOT NULL,
  PRIMARY KEY (`ID_phieutiem`),
  KEY `ID_benh_nhan` (`ID_benh_nhan`),
  KEY `madinhdanh` (`madinhdanh`),
  KEY `masothuoc` (`masothuoc`),
  CONSTRAINT `phieutiem_ibfk_1` FOREIGN KEY (`ID_benh_nhan`) REFERENCES `benhnhan` (`ID_benh_nhan`),
  CONSTRAINT `phieutiem_ibfk_2` FOREIGN KEY (`madinhdanh`) REFERENCES `bacsi` (`madinhdanh`),
  CONSTRAINT `phieutiem_ibfk_3` FOREIGN KEY (`masothuoc`) REFERENCES `thuoctiem` (`masothuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieutiem`
--

LOCK TABLES `phieutiem` WRITE;
/*!40000 ALTER TABLE `phieutiem` DISABLE KEYS */;
INSERT INTO `phieutiem` VALUES ('PT001','BN01','BS001','ID001',1,'2022-07-10','2023-01-10'),('PT002','BN02','BS002','ID002',0,NULL,'2023-02-11'),('PT003','BN03','BS003','ID003',1,'2022-05-18','2022-07-12'),('PT004','BN04','BS004','ID004',0,NULL,'2022-08-13'),('PT005','BN05','BS005','ID005',1,'2022-03-16','2022-09-14'),('PT006','BN06','BS006','ID006',0,NULL,'2022-10-15'),('PT007','BN07','BS007','ID007',1,'2022-01-14','2022-09-16'),('PT008','BN08','BS008','ID008',0,NULL,'2022-09-17'),('PT009','BN09','BS009','ID009',1,'2022-09-12','2023-08-18'),('PT010','BN10','BS010','ID010',0,NULL,'2023-05-19');
/*!40000 ALTER TABLE `phieutiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoctiem`
--

DROP TABLE IF EXISTS `thuoctiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoctiem` (
  `masothuoc` varchar(20) NOT NULL,
  `tenthuoc` varchar(20) NOT NULL,
  `soluong` float NOT NULL,
  `somuicantiem` int NOT NULL,
  `songaytiemmuitiep` int DEFAULT NULL,
  `dongia` float NOT NULL,
  PRIMARY KEY (`masothuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoctiem`
--

LOCK TABLES `thuoctiem` WRITE;
/*!40000 ALTER TABLE `thuoctiem` DISABLE KEYS */;
INSERT INTO `thuoctiem` VALUES ('ID001','Pfizer',2500,2,30,25000),('ID002','Morena',2000,2,40,55000),('ID003','Astra',3500,2,60,25000),('ID004','Bio',5500,2,30,30000),('ID005','Cecas',6500,2,30,40000),('ID006','Sputnik',2700,2,45,35000),('ID007','Sinopharm',3000,2,90,25000),('ID008','Spikevax',5000,2,90,50000),('ID009','H5N1',4000,2,90,45000),('ID010','Abdala',1500,2,50,60000),('ID11','ab',12,12,12,1222);
/*!40000 ALTER TABLE `thuoctiem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-15 20:55:32
