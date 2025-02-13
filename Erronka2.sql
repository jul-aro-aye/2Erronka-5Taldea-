-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: erronka2
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `berria`
--

DROP TABLE IF EXISTS `berria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `berria` (
  `idBerria` int NOT NULL AUTO_INCREMENT,
  `izenburua` varchar(80) NOT NULL,
  `textua` longtext NOT NULL,
  `data` date NOT NULL,
  `Langilea_idLangilea` int NOT NULL,
  `title` varchar(80) DEFAULT NULL,
  `text` longtext,
  PRIMARY KEY (`idBerria`),
  KEY `fk_Berria_Langilea_idx` (`Langilea_idLangilea`),
  CONSTRAINT `fk_Berria_Langilea` FOREIGN KEY (`Langilea_idLangilea`) REFERENCES `langilea` (`idLangilea`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `berria`
--

LOCK TABLES `berria` WRITE;
/*!40000 ALTER TABLE `berria` DISABLE KEYS */;
INSERT INTO `berria` VALUES (1,'EkoTekno aurkezten du bere lehen mugikor ekologikoa','EkoTekno-k \"GreenPhone X\" izeneko mugikor jasangarria aurkeztu du. Erabat birziklatutako materialekin egina dago eta energia-eraginkortasuna maximizatzen du.','2025-02-04',1,'EkoTekno introduces its first eco-friendly smartphone.','EkoTekno has unveiled the \"GreenPhone X,\" a sustainable smartphone made entirely from recycled materials that maximizes energy efficiency.'),(2,'EkoTekno-k eguzki-kargagailu adimenduna merkaturatu du','Konpainiak \"EkoCharge\" izeneko gailu berri bat kaleratu du, eguzki-argiaren bidez gailu elektronikoak modu azkar eta eraginkorrean kargatzeko aukera ematen duena.','2025-02-03',8,'EkoTekno has launched a smart solar charger.','The company has released a new device called \"EkoCharge,\" which allows electronic devices to be charged quickly and efficiently using sunlight.'),(3,'EkoTekno eta AI: adimen artifizial jasangarria garatzen','EkoTekno-k AI bidezko energia optimizatzeko sistema berria garatu du, datu-zentroetan eta etxeko gailuetan energia-kontsumoa murrizteko helburuarekin.','2025-02-02',17,'EkoTekno and AI: Developing Sustainable Artificial Intelligence','EkoTekno has developed a new AI-powered energy optimization system aimed at reducing energy consumption in data centers and home devices.');
/*!40000 ALTER TABLE `berria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bezeroa`
--

DROP TABLE IF EXISTS `bezeroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bezeroa` (
  `idBezeroa` int NOT NULL AUTO_INCREMENT,
  `izenAbizenak` varchar(65) NOT NULL,
  `erabiltzailea` varchar(11) NOT NULL,
  `pasahitza` varchar(8) NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `emaila` varchar(45) DEFAULT NULL,
  `jaio_urtea` date DEFAULT NULL,
  PRIMARY KEY (`idBezeroa`),
  CONSTRAINT `chk_erabiltzailea` CHECK (regexp_like(`erabiltzailea`,_utf8mb3'^[a-zA-Z]{3}_[a-zA-Z]{3}_[a-zA-Z]{3}$'))
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bezeroa`
--

LOCK TABLES `bezeroa` WRITE;
/*!40000 ALTER TABLE `bezeroa` DISABLE KEYS */;
INSERT INTO `bezeroa` VALUES (1,'Juan Pérez Garatea','jua_per_gar','JuanpeGa','612345678','juan.perez@gmail.com','1985-02-12'),(2,'Emily Johnson Mathews','emi_joh_mat','EmiJohnM','975556789','emily.johnson@gmail.com','1978-07-14'),(3,'Kenji Tanaka Arasaki','ken_tan_ara','kentanar','903456789','kenji.tanaka@gmail.com','1999-12-22'),(4,'Fatima Al-Farsi Rahmani','fat_alf_rah','fatimaAl','505678123','fatima.farsi@gmail.com','1975-04-17'),(5,'Patricia Gonzlalez Silva','pat_gon_sil','PatriSil','678021245','patri.gonza@gmail.com','1968-06-29');
/*!40000 ALTER TABLE `bezeroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaera`
--

DROP TABLE IF EXISTS `eskaera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaera` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kopurua` int NOT NULL,
  `data` date NOT NULL,
  `Langilea_idLangilea` int DEFAULT NULL,
  `Bezeroa_idBezeroa` int NOT NULL,
  `Garraioa_idGarraioa` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Eskaera_Langilea1_idx` (`Langilea_idLangilea`),
  KEY `fk_Eskaera_Bezeroa1_idx` (`Bezeroa_idBezeroa`),
  KEY `fk_Eskaera_Garraioa1_idx` (`Garraioa_idGarraioa`),
  CONSTRAINT `fk_Eskaera_Bezeroa1` FOREIGN KEY (`Bezeroa_idBezeroa`) REFERENCES `bezeroa` (`idBezeroa`),
  CONSTRAINT `fk_Eskaera_Garraioa1` FOREIGN KEY (`Garraioa_idGarraioa`) REFERENCES `garraioa` (`idGarraioa`),
  CONSTRAINT `fk_Eskaera_Langilea1` FOREIGN KEY (`Langilea_idLangilea`) REFERENCES `langilea` (`idLangilea`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaera`
--

LOCK TABLES `eskaera` WRITE;
/*!40000 ALTER TABLE `eskaera` DISABLE KEYS */;
INSERT INTO `eskaera` VALUES (1,3,'2025-02-10',2,1,1),(2,7,'2025-02-10',7,5,7),(3,1,'2025-02-10',14,2,28),(4,2,'2025-02-10',22,3,13),(5,4,'2025-02-10',25,4,16),(6,8,'2025-02-10',27,1,4),(7,1,'2025-02-10',30,2,21);
/*!40000 ALTER TABLE `eskaera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garraioa`
--

DROP TABLE IF EXISTS `garraioa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garraioa` (
  `idGarraioa` int NOT NULL AUTO_INCREMENT,
  `enpresaIzena` varchar(45) NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `emaila` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idGarraioa`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garraioa`
--

LOCK TABLES `garraioa` WRITE;
/*!40000 ALTER TABLE `garraioa` DISABLE KEYS */;
INSERT INTO `garraioa` VALUES (1,'TechExpress','600123456','kontaktua@techexpress.com'),(2,'DigitalMovil','611234567','info@digitalmovil.com'),(3,'LogiTechno','622345678','laguntza@logitechno.com'),(4,'ElectroTrans','633456789','eskaerak@electrotrans.com'),(5,'BanaketaTech','644567890','bezeroak@banakettatech.com'),(6,'FastGadget','655678901','bidalketak@fastgadget.com'),(7,'Innovalogic','666789012','kontaktua@innovalogic.com'),(8,'ExpressDigital','677890123','zerbitzua@expressdigital.com'),(9,'ElektroFlash','688901234','laguntza@elektroflash.com'),(10,'GigaEntrega','699012345','info@gigaentrega.com'),(11,'SmartShip','610123456','bezeroak@smartship.com'),(12,'SpeedyTech','621234567','eskaerak@speedytech.com'),(13,'DigitalGo','632345678','kontaktua@digitalgo.com'),(14,'TechDistrib','643456789','laguntza@techdistrib.com'),(15,'RapidGadget','654567890','bidalketak@rapidgadget.com'),(16,'ElektroBidalketa','665678901','zerbitzua@elektrobidalketa.com'),(17,'ConnectaTech','676789012','info@connectatech.com'),(18,'HiSpeedTech','687890123','bezeroak@hispeedtech.com'),(19,'ElektroPack','698901234','laguntza@elektropack.com'),(20,'SmartLogis','609012345','eskaerak@smartlogis.com'),(21,'Techtiva','611112222','kontaktua@techtiva.com'),(22,'GadgeTrans','622223333','bidalketak@gadgetrans.com'),(23,'ElektroZoom','633334444','info@elektrozoom.com'),(24,'ByteExpress','644445555','laguntza@byteexpress.com'),(25,'PCMovil','655556666','eskaerak@pcmovil.com'),(26,'FastTechno','666667777','bezeroak@fasttechno.com'),(27,'MegaBanaketa','677778888','zerbitzua@megabanaketa.com'),(28,'CyberShip','688889999','kontaktua@cybership.com'),(29,'TecnoCourier','699990000','info@tecnocourier.com'),(30,'GigaExpress','600001111','laguntza@gigaexpress.com');
/*!40000 ALTER TABLE `garraioa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hornitzailea`
--

DROP TABLE IF EXISTS `hornitzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hornitzailea` (
  `idHornitzailea` int NOT NULL AUTO_INCREMENT,
  `enpresaIzena` varchar(50) NOT NULL,
  `kokapena` varchar(80) NOT NULL,
  `banatzaileKop` int NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `emaila` varchar(45) DEFAULT NULL,
  `egoera` varchar(30) NOT NULL,
  PRIMARY KEY (`idHornitzailea`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hornitzailea`
--

LOCK TABLES `hornitzailea` WRITE;
/*!40000 ALTER TABLE `hornitzailea` DISABLE KEYS */;
INSERT INTO `hornitzailea` VALUES (1,'Tech Renew','Bilbao, España',5,'944123456','techrenew@gmail.com','Onartuta'),(2,'Gadget Reuse','Toronto, Canadá',3,'466543210','gadgetreuse@gmail.com','EzOnartuta'),(3,'ElectroSecond','Londres, Reino Unido',7,'279876543','electrosecond@gmail.com','Onartuta'),(4,'EcoTech','Ciudad de México, México',4,'551122334','ecotech@gmail.com','Onartuta'),(5,'ReviveTech','Madrid, España',10,'911223344','revivetech@gmail.com','Onartuta'),(6,'Smart Used','Sídney, Australia',6,'292334455','smartused@gmail.com','EzOnartuta'),(7,'RefurbishPro','São Paulo, Brasil',8,'135566778','refurbishpro@gmail.com','Onartuta'),(8,'SecondLife Tech','Seúl, Corea del Sur',5,'254778899','secondlifetech@gmail.com','Onartuta'),(9,'GadgetCycle','Berlín, Alemania',3,'309889900','gadgetcycle@gmail.com','EzOnartuta'),(10,'Reuse Electronics','Nueva York, EE.UU.',7,'216677889','reuseelectronics@gmail.com','Onartuta'),(11,'Green Tech','París, Francia',4,'142445566','greentech@gmail.com','Onartuta'),(12,'ReciclaTech','Roma, Italia',6,'065334455','reciclatech@gmail.com','EzOnartuta'),(13,'FutureSecond','Tokio, Japón',9,'358223344','futuresecond@gmail.com','Onartuta'),(14,'TechCycle','Ámsterdam, Países Bajos',5,'202112233','techcycle@gmail.com','EzOnartuta'),(15,'ReuseTech','Dublín, Irlanda',2,'144556677','reusetech@gmail.com','Onartuta'),(16,'Second Use','Buenos Aires, Argentina',3,'155667788','seconduse@gmail.com','EzOnartuta'),(17,'ElectroGreen','Viena, Austria',6,'172778899','electrogreen@gmail.com','Onartuta'),(18,'TechReborn','Estocolmo, Suecia',4,'812889900','techreborn@gmail.com','Onartuta'),(19,'Upcycle Tech','Bangkok, Tailandia',5,'225667788','upcycletech@gmail.com','EzOnartuta'),(20,'SmartRenew','El Cairo, Egipto',7,'223344556','smartrenew@gmail.com','Onartuta'),(21,'DigitalSecond','Johannesburgo, Sudáfrica',3,'112223344','digitalsecond@gmail.com','Onartuta'),(22,'UsedSmart','Oslo, Noruega',2,'226112233','usedsmart@gmail.com','EzOnartuta'),(23,'RenewGadget','Helsinki, Finlandia',8,'942445566','renewgadget@gmail.com','Onartuta'),(24,'GreenGizmo','Delhi, India',6,'114556677','greengizmo@gmail.com','EzOnartuta'),(25,'RebootTech','Lisboa, Portugal',4,'212778899','reboottech@gmail.com','Onartuta'),(26,'TechReclaim','Santiago, Chile',5,'223889900','techreclaim@gmail.com','Onartuta'),(27,'RecycleGadgets','Moscú, Rusia',3,'456677889','recyclegadgets@gmail.com','EzOnartuta'),(28,'ElectroReuse','Wellington, Nueva Zelanda',7,'450334455','electroreuse@gmail.com','Onartuta'),(29,'EcoRenew','Dubai, Emiratos Árabes Unidos',2,'423223344','ecorenew@gmail.com','Onartuta'),(30,'UpTech','Los Ángeles, EE.UU.',5,'301122334','uptech@gmail.com','EzOnartuta');
/*!40000 ALTER TABLE `hornitzailea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langilea`
--

DROP TABLE IF EXISTS `langilea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `langilea` (
  `idLangilea` int NOT NULL AUTO_INCREMENT,
  `izenAbizenak` varchar(80) NOT NULL,
  `erabiltzailea` varchar(11) NOT NULL,
  `pasahitza` varchar(8) NOT NULL,
  `telefonoa` varchar(9) NOT NULL,
  `emaila` varchar(45) DEFAULT NULL,
  `mota` char(1) NOT NULL,
  PRIMARY KEY (`idLangilea`),
  CONSTRAINT `chk_mota` CHECK ((`mota` in (_utf8mb4'A',_utf8mb4'K',_utf8mb4'L')))
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langilea`
--

LOCK TABLES `langilea` WRITE;
/*!40000 ALTER TABLE `langilea` DISABLE KEYS */;
INSERT INTO `langilea` VALUES (1,'Aitor Etxebarria Mendizabal','ait_etx_men','A1*t0r!e','687459321','aitor.etxe@gmail.com','A'),(2,'Maialen Zubizarreta Odriozola','mai_zub_odr','M@i@l3n$','643218795','maialen.zubi@gmail.com','K'),(3,'Iñaki Otxoa Arrieta','ina_otx_arr','I#n@k!78','675839201','inaki.otx@gmail.com','L'),(4,'Ane Elorza Garmendia','ane_elo_gar','A^n3E!lo','698745123','ane.elo@gmail.com','L'),(5,'Jon Agirre Egaña','jon_agi_ega','J0n#A$G!','612398745','jon.agi@gmail.com','L'),(6,'Miren Goikoetxea Urrutia','mir_goi_urr','M!r3n*G@','689745321','miren.goik@gmail.com','L'),(7,'Asier Olabarria Legarreta','asi_ola_leg','A$!er_78','623189745','asier.ola@gmail.com','K'),(8,'Leire Arrizabalaga Aranguren','lei_arr_ara','L3!r#@78','635987412','leire.arri@gmail.com','A'),(9,'Gorka Urrutia Larrañaga','gor_urr_lar','G@rk!U78','679854123','gorka.urr@gmail.com','L'),(10,'Nerea Egaña Zuloaga','ner_ega_zul','N#r34!G@','647812365','nerea.ega@gmail.com','L'),(11,'Unai Bengoetxea Albisu','una_ben_alb','U&n@1B78','658741239','unai.beng@gmail.com','L'),(12,'Haizea Mendia Beistegi','hai_men_bei','H4izE!@M','621478935','haizea.mend@gmail.com','L'),(13,'Iker Zuloaga Aristorena','ike_zul_ari','I@k#Z!78','678514239','iker.zulo@gmail.com','L'),(14,'Ainhoa Larrañaga Arrieta','ain_lar_arr','A!nh@L78','634125987','ainhoa.larr@gmail.com','K'),(15,'Julen Txurruka Lizarraga','jul_txu_liz','J#ul3nT@','678945123','julen.txu@gmail.com','L'),(16,'Oihane Berasategi Uribe','oih_ber_uri','O!h@n3B$','654789123','oihane.bera@gmail.com','L'),(17,'Ander Zabaleta Iturbe','and_zab_itu','A#nd3r@Z','691478523','ander.zab@gmail.com','A'),(18,'Maite Uribe Garmendia','mai_uri_gar','M@it3U78','657894312','maite.urib@gmail.com','L'),(19,'Beñat Arrieta Ugalde','ben_arr_uga','B3#n@t78','612347895','benat.arri@gmail.com','A'),(20,'Olatz Garmendia Odriozola','ola_gar_odr','O!l@tzG#','645789123','olatz.gar@gmail.com','L'),(21,'Ekain Aranguren Bengoetxea','eka_ara_ben','E#k@1n78','672314589','ekain.aran@gmail.com','L'),(22,'Garazi Lizarraga Urrutia','gar_liz_urr','G@r#z!78','638951274','garazi.liza@gmail.com','K'),(23,'Xabier Albisu Mendizabal','xab_alb_men','X#@b!e78','654128937','xabier.alb@gmail.com','L'),(24,'Naiara Ugalde Arrizabalaga','nai_uga_arr','N!@r4U78','681237495','naiara.uga@gmail.com','L'),(25,'Eneko Legarreta Zabaleta','ene_leg_zab','E#n@k!78','692314785','eneko.leg@gmail.com','K'),(26,'Maddi Odriozola Aristorena','mad_odr_ari','M@d#iO78','619487523','maddi.odr@gmail.com','L'),(27,'Peio Aristorena Zuloaga','pei_ari_zul','P#3!oA78','625147893','peio.aris@gmail.com','K'),(28,'Uxue Aranguren Lizarraga','uxu_ara_liz','U@x#u!78','678914253','uxue.aran@gmail.com','L'),(29,'Lander Iturbe Legarreta','lan_itu_leg','L#@nd!78','631478952','lander.itu@gmail.com','A'),(30,'Izaro Beistegi Mendia','iza_bei_men','I!z@r#78','649815237','izaro.beis@gmail.com','K');
/*!40000 ALTER TABLE `langilea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktua`
--

DROP TABLE IF EXISTS `produktua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produktua` (
  `idProduktua` int NOT NULL AUTO_INCREMENT,
  `izena` varchar(65) NOT NULL,
  `mota` varchar(30) NOT NULL,
  `marka` varchar(30) NOT NULL,
  `modeloa` varchar(20) NOT NULL,
  `stock` int NOT NULL,
  `prezioa` double NOT NULL,
  `Hornitzailea_idHornitzailea` int NOT NULL,
  PRIMARY KEY (`idProduktua`),
  KEY `fk_Produktua_Hornitzailea1_idx` (`Hornitzailea_idHornitzailea`),
  CONSTRAINT `fk_Produktua_Hornitzailea1` FOREIGN KEY (`Hornitzailea_idHornitzailea`) REFERENCES `hornitzailea` (`idHornitzailea`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktua`
--

LOCK TABLES `produktua` WRITE;
/*!40000 ALTER TABLE `produktua` DISABLE KEYS */;
INSERT INTO `produktua` VALUES (1,'iPhone 12','Mugikorra','Apple','A2172',10,499.99,1),(2,'Galaxy S21','Mugikorra','Samsung','SM-G991B',8,449.99,3),(3,'ThinkPad X1 Carbon','Portatila','Lenovo','Gen 9',5,899.99,4),(4,'MacBook Pro 13','Portatila','Apple','M1 2020',6,1099.99,5),(5,'iPad Air 4','Tableta','Apple','A2316',7,599.99,7),(6,'Surface Pro 7','Tableta','Microsoft','VNX-00016',4,749.99,8),(7,'PS5 Digital Edition','Kontsola','Sony','CFI-1015B',3,349.99,10),(8,'Xbox Series X','Kontsola','Microsoft','RRT-00001',5,399.99,11),(9,'Nintendo Switch','Kontsola','Nintendo','HAC-001(-01)',7,299.99,13),(10,'Dell XPS 13','Portatila','Dell','9310',5,899.99,15),(11,'OnePlus 9','Mugikorra','OnePlus','LE2113',6,399.99,17),(12,'Google Pixel 6','Mugikorra','Google','GA02900-US',5,499.99,18),(13,'ASUS ROG Strix G15','Portatila','ASUS','G513QR',4,999.99,20),(14,'Google Pixel 9','Mugikorra','Google','M1 2024',3,1249.99,21),(15,'HP Spectre x360','Portatila','HP','14-ea0023dx',5,849.99,23),(16,'Huawei Mate Pad','Tableta','Huawei','345-HMP',4,809.99,25),(17,'Xiaomi Redmi 12 pro','Mugikorra','Xiaomi','980-XRN',7,239.99,26),(18,'Asus Rog Ally X','Kontsola','Asus','2024.7\"',8,949.99,28),(19,'Bose QuietComfort 45','Aurikularrak','Bose','QC45',6,329.99,29),(20,'Galaxy S23','Mugikorra','Samsung','S23 Ultra',18,1199.99,1),(21,'PlayStation 4 Pro','Kontsola','Sony','PS4 Pro',25,289.99,3),(22,'Xbox One','Kontsola','Microsoft','One Green ',22,249.99,4),(23,'HP EliteBook','Portatila','HP','G5',12,398.99,5),(24,'Lenovo Tab M10','Tableta','Lenovo','3rd Gen',15,124.99,7),(25,'Honor MagicPad2','Tableta','Honor','Pad2 Black',10,559.99,8),(26,'Huawei FreeBuds','Aurikularrak','Huawei','Pro 4 ',9,199.99,10),(27,'JBL Tune','Aurikularrak','JBL','720BT',16,70.99,11),(28,'Play Station Vita','Kontsola','Sony','PS Vita',12,99.99,13),(29,'Poco M6','Mugikorra','Xiaomi','M6 8 ',5,159.99,15),(30,'Apple Airpods Pro','Aurikularrak','Apple','2024 4 gen',13,139.99,17);
/*!40000 ALTER TABLE `produktua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktua_has_eskaera`
--

DROP TABLE IF EXISTS `produktua_has_eskaera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produktua_has_eskaera` (
  `id` int NOT NULL AUTO_INCREMENT,
  `produktua_idProduktua` int NOT NULL,
  `eskaera_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produktua_has_eskaera_eskaera1_idx` (`eskaera_id`),
  KEY `fk_produktua_has_eskaera_produktua1_idx` (`produktua_idProduktua`),
  CONSTRAINT `fk_produktua_has_eskaera_eskaera1` FOREIGN KEY (`eskaera_id`) REFERENCES `eskaera` (`id`),
  CONSTRAINT `fk_produktua_has_eskaera_produktua1` FOREIGN KEY (`produktua_idProduktua`) REFERENCES `produktua` (`idProduktua`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktua_has_eskaera`
--

LOCK TABLES `produktua_has_eskaera` WRITE;
/*!40000 ALTER TABLE `produktua_has_eskaera` DISABLE KEYS */;
INSERT INTO `produktua_has_eskaera` VALUES (1,24,3),(2,1,2),(3,5,1),(4,11,7),(5,9,3);
/*!40000 ALTER TABLE `produktua_has_eskaera` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-13 19:24:28
