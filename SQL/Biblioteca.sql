/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.11-MariaDB : Database - biblioteca
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `biblioteca`;

/*Table structure for table `autores` */

DROP TABLE IF EXISTS `autores`;

CREATE TABLE `autores` (
  `cod_autor` int(3) NOT NULL AUTO_INCREMENT,
  `nom_autor` varchar(128) DEFAULT NULL,
  `pseu_autor` varchar(128) DEFAULT NULL,
  `app_autor` varchar(128) DEFAULT NULL,
  `apm_autor` varchar(128) DEFAULT NULL,
  `cod_nac` int(3) NOT NULL,
  PRIMARY KEY (`cod_autor`),
  KEY `cod_nac` (`cod_nac`),
  CONSTRAINT `autores_ibfk_1` FOREIGN KEY (`cod_nac`) REFERENCES `nacionautor` (`cod_nac`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

/*Data for the table `autores` */

insert  into `autores`(`cod_autor`,`nom_autor`,`pseu_autor`,`app_autor`,`apm_autor`,`cod_nac`) values (11,'Rodrigo','RO','Villas','Maturana',7),(13,'Alonso','Loncho','Rojas','Villaroel',9),(15,'Hyong','Hellcase','Wasabi','',11),(19,'Sofia','lily','','',8);

/*Table structure for table `autorlibro` */

DROP TABLE IF EXISTS `autorlibro`;

CREATE TABLE `autorlibro` (
  `cod_autor` int(5) NOT NULL,
  `cod_libro` int(5) NOT NULL,
  PRIMARY KEY (`cod_autor`,`cod_libro`),
  KEY `cod_libro` (`cod_libro`),
  CONSTRAINT `autorlibro_ibfk_1` FOREIGN KEY (`cod_autor`) REFERENCES `autores` (`cod_autor`),
  CONSTRAINT `autorlibro_ibfk_2` FOREIGN KEY (`cod_libro`) REFERENCES `libro` (`cod_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `autorlibro` */

insert  into `autorlibro`(`cod_autor`,`cod_libro`) values (11,2),(11,41),(11,44),(13,39),(13,43),(15,42);

/*Table structure for table `boletaofactura` */

DROP TABLE IF EXISTS `boletaofactura`;

CREATE TABLE `boletaofactura` (
  `cod_bof` int(4) NOT NULL AUTO_INCREMENT,
  `folio` varchar(50) NOT NULL,
  `precio_neto` int(10) NOT NULL,
  `costoiva` int(10) NOT NULL,
  `precio_iva` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(5) NOT NULL,
  `cod_tipobf` int(5) NOT NULL,
  `cod_metod` int(1) NOT NULL,
  PRIMARY KEY (`cod_bof`),
  KEY `cod_tipoo` (`cod_tipobf`),
  KEY `cod_metod` (`cod_metod`),
  CONSTRAINT `boletaofactura_ibfk_1` FOREIGN KEY (`cod_tipobf`) REFERENCES `tipobf` (`cod_tipobf`),
  CONSTRAINT `boletaofactura_ibfk_2` FOREIGN KEY (`cod_metod`) REFERENCES `metodopago` (`cod_metod`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Data for the table `boletaofactura` */

insert  into `boletaofactura`(`cod_bof`,`folio`,`precio_neto`,`costoiva`,`precio_iva`,`fecha`,`hora`,`cod_tipobf`,`cod_metod`) values (8,'0014785',3500,665,4165,'2020-07-04','22:13',2,3),(9,'00145',3600,684,4284,'2020-07-04','22:16',1,4),(12,'001212',3000,570,3570,'2020-06-23','13:00',1,3),(13,'04528',3000,570,3570,'2020-06-21','15:45',1,1),(14,'00181920',3000,570,3570,'2020-07-13','12:33',1,4),(16,'01515',3000,570,3570,'2020-07-06','15:45',1,1);

/*Table structure for table `cargos` */

DROP TABLE IF EXISTS `cargos`;

CREATE TABLE `cargos` (
  `cod_cargos` int(5) NOT NULL AUTO_INCREMENT,
  `nom_cargo` varchar(128) NOT NULL,
  PRIMARY KEY (`cod_cargos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cargos` */

insert  into `cargos`(`cod_cargos`,`nom_cargo`) values (1,'Administrador'),(2,'Inventario'),(3,'Vendedor'),(4,'Cliente');

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `cod_cate` int(3) NOT NULL AUTO_INCREMENT,
  `nom_cate` varchar(40) NOT NULL,
  PRIMARY KEY (`cod_cate`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `categoria` */

insert  into `categoria`(`cod_cate`,`nom_cate`) values (1,'Fantasía'),(2,'Ciencia Ficcion'),(3,'Autoayuda'),(4,'Psicología'),(5,'Terror');

/*Table structure for table `categorialibro` */

DROP TABLE IF EXISTS `categorialibro`;

CREATE TABLE `categorialibro` (
  `cod_libro` int(3) NOT NULL,
  `cod_categoria` int(3) NOT NULL,
  PRIMARY KEY (`cod_libro`,`cod_categoria`),
  KEY `cod_categoria` (`cod_categoria`),
  CONSTRAINT `categorialibro_ibfk_1` FOREIGN KEY (`cod_libro`) REFERENCES `libro` (`cod_libro`),
  CONSTRAINT `categorialibro_ibfk_2` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`cod_cate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `categorialibro` */

insert  into `categorialibro`(`cod_libro`,`cod_categoria`) values (2,1),(26,4),(31,2),(39,3),(41,2),(42,1),(43,1),(44,2);

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `cod_cliente` int(4) NOT NULL AUTO_INCREMENT,
  `rut_cliente` varchar(50) NOT NULL,
  `nom_cliente` varchar(128) NOT NULL,
  `direc1_cliente` varchar(150) NOT NULL,
  `direc2_cliente` varchar(150) DEFAULT NULL,
  `tel1_cliente` varchar(20) NOT NULL,
  `tel2_cliente` varchar(20) DEFAULT NULL,
  `co_cliente` varchar(128) NOT NULL,
  `fecn_cliente` date NOT NULL,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cliente` */

insert  into `cliente`(`cod_cliente`,`rut_cliente`,`nom_cliente`,`direc1_cliente`,`direc2_cliente`,`tel1_cliente`,`tel2_cliente`,`co_cliente`,`fecn_cliente`) values (1,'15.635.925-5','Ramon Horlando Gutierres','Av Soledad #123','','+56987521436','','Ramon3.Horl@gmail.com','1985-07-01'),(5,'15.252.120-6','Ignacio Lara Fuenzalida','Av Matrix #234','','+56925364184','2 152145','Nacho.F@gmail.com','1994-02-01'),(6,'14.235.265-6','Alonso Marchant','Av Holanda #12','','+56912454785','2 221458','A.Marchant@gmail.com','1995-02-01');

/*Table structure for table `compra` */

DROP TABLE IF EXISTS `compra`;

CREATE TABLE `compra` (
  `cod_compra` int(5) NOT NULL AUTO_INCREMENT,
  `comentarios` varchar(128) DEFAULT NULL,
  `cod_fact` int(5) NOT NULL,
  `cod_orden` int(5) NOT NULL,
  PRIMARY KEY (`cod_compra`),
  KEY `cod_fact` (`cod_fact`),
  KEY `cod_orden` (`cod_orden`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`cod_fact`) REFERENCES `factura` (`cod_factura`),
  CONSTRAINT `compra_ibfk_3` FOREIGN KEY (`cod_orden`) REFERENCES `orden_compra` (`cod_orden`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `compra` */

insert  into `compra`(`cod_compra`,`comentarios`,`cod_fact`,`cod_orden`) values (2,'1 torre oscura 1 bella y la bestia',2,9),(4,'1 Alicia en el Pais de las Maravillas',3,9);

/*Table structure for table `comuna` */

DROP TABLE IF EXISTS `comuna`;

CREATE TABLE `comuna` (
  `cod_comuna` int(3) NOT NULL AUTO_INCREMENT,
  `nom_comuna` varchar(30) NOT NULL,
  `cod_provincia` int(3) NOT NULL,
  PRIMARY KEY (`cod_comuna`),
  KEY `cod_provincia` (`cod_provincia`),
  CONSTRAINT `comuna_ibfk_1` FOREIGN KEY (`cod_provincia`) REFERENCES `provincia` (`cod_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comuna` */

insert  into `comuna`(`cod_comuna`,`nom_comuna`,`cod_provincia`) values (1,'Arica',1),(2,'Camarones',1),(3,'General Lagos',2),(4,'Putre',2),(5,'Alto Hospicio',3),(6,'Iquique',3),(7,'Camiña',4),(8,'Colchane',4),(9,'Huara',4),(10,'Pica',4),(11,'Pozo Almonte',4),(12,'Antofagasta',5),(13,'Mejillones',5),(14,'Sierra Gorda',5),(15,'Taltal',5),(16,'Calama',6),(17,'Ollague',6),(18,'San Pedro de Atacama',6),(19,'María Elena',7),(20,'Tocopilla',7),(21,'Chañaral',8),(22,'Diego de Almagro',8),(23,'Caldera',9),(24,'Copiapó',9),(25,'Tierra Amarilla',9),(26,'Alto del Carmen',10),(27,'Freirina',10),(28,'Huasco',10),(29,'Vallenar',10),(30,'Canela',11),(31,'Illapel',11),(32,'Los Vilos',11),(33,'Salamanca',11),(34,'Andacollo',12),(35,'Coquimbo',12),(36,'La Higuera',12),(37,'La Serena',12),(38,'Paihuaco',12),(39,'Vicuña',12),(40,'Combarbalá',13),(41,'Monte Patria',13),(42,'Ovalle',13),(43,'Punitaqui',13),(44,'Río Hurtado',13),(45,'Isla de Pascua',14),(46,'Calle Larga',15),(47,'Los Andes',15),(48,'Rinconada',15),(49,'San Esteban',15),(50,'La Ligua',16),(51,'Papudo',16),(52,'Petorca',16),(53,'Zapallar',16),(54,'Hijuelas',17),(55,'La Calera',17),(56,'La Cruz',17),(57,'Limache',17),(58,'Nogales',17),(59,'Olmué',17),(60,'Quillota',17),(61,'Algarrobo',18),(62,'Cartagena',18),(63,'El Quisco',18),(64,'El Tabo',18),(65,'San Antonio',18),(66,'Santo Domingo',18),(67,'Catemu',19),(68,'Llaillay',19),(69,'Panquehue',19),(70,'Putaendo',19),(71,'San Felipe',19),(72,'Santa María',19),(73,'Casablanca',20),(74,'Concón',20),(75,'Juan Fernández',20),(76,'Puchuncaví',20),(77,'Quilpué',20),(78,'Quintero',20),(79,'Valparaíso',20),(80,'Villa Alemana',20),(81,'Viña del Mar',20),(82,'Colina',21),(83,'Lampa',21),(84,'Tiltil',21),(85,'Pirque',22),(86,'Puente Alto',22),(87,'San José de Maipo',22),(88,'Buin',23),(89,'Calera de Tango',23),(90,'Paine',23),(91,'San Bernardo',23),(92,'Alhué',24),(93,'Curacaví',24),(94,'María Pinto',24),(95,'Melipilla',24),(96,'San Pedro',24),(97,'Cerrillos',25),(98,'Cerro Navia',25),(99,'Conchalí',25),(100,'El Bosque',25),(101,'Estación Central',25),(102,'Huechuraba',25),(103,'Independencia',25),(104,'La Cisterna',25),(105,'La Granja',25),(106,'La Florida',25),(107,'La Pintana',25),(108,'La Reina',25),(109,'Las Condes',25),(110,'Lo Barnechea',25),(111,'Lo Espejo',25),(112,'Lo Prado',25),(113,'Macul',25),(114,'Maipú',25),(115,'Ñuñoa',25),(116,'Pedro Aguirre Cerda',25),(117,'Peñalolén',25),(118,'Providencia',25),(119,'Pudahuel',25),(120,'Quilicura',25),(121,'Quinta Normal',25),(122,'Recoleta',25),(123,'Renca',25),(124,'San Miguel',25),(125,'San Joaquín',25),(126,'San Ramón',25),(127,'Santiago',25),(128,'Vitacura',25),(129,'El Monte',26),(130,'Isla de Maipo',26),(131,'Padre Hurtado',26),(132,'Peñaflor',26),(133,'Talagante',26),(134,'Codegua',27),(135,'Coínco',27),(136,'Coltauco',27),(137,'Doñihue',27),(138,'Graneros',27),(139,'Las Cabras',27),(140,'Machalí',27),(141,'Malloa',27),(142,'Mostazal',27),(143,'Olivar',27),(144,'Peumo',27),(145,'Pichidegua',27),(146,'Quinta de Tilcoco',27),(147,'Rancagua',27),(148,'Rengo',27),(149,'Requínoa',27),(150,'San Vicente de Tagua Tagua',27),(151,'La Estrella',28),(152,'Litueche',28),(153,'Marchihue',28),(154,'Navidad',28),(155,'Peredones',28),(156,'Pichilemu',28),(157,'Chépica',29),(158,'Chimbarongo',29),(159,'Lolol',29),(160,'Nancagua',29),(161,'Palmilla',29),(162,'Peralillo',29),(163,'Placilla',29),(164,'Pumanque',29),(165,'San Fernando',29),(166,'Santa Cruz',29),(167,'Cauquenes',30),(168,'Chanco',30),(169,'Pelluhue',30),(170,'Curicó',31),(171,'Hualañé',31),(172,'Licantén',31),(173,'Molina',31),(174,'Rauco',31),(175,'Romeral',31),(176,'Sagrada Familia',31),(177,'Teno',31),(178,'Vichuquén',31),(179,'Colbún',32),(180,'Linares',32),(181,'Longaví',32),(182,'Parral',32),(183,'Retiro',32),(184,'San Javier',32),(185,'Villa Alegre',32),(186,'Yerbas Buenas',32),(187,'Constitución',33),(188,'Curepto',33),(189,'Empedrado',33),(190,'Maule',33),(191,'Pelarco',33),(192,'Pencahue',33),(193,'Río Claro',33),(194,'San Clemente',33),(195,'San Rafael',33),(196,'Talca',33),(197,'Arauco',34),(198,'Cañete',34),(199,'Contulmo',34),(200,'Curanilahue',34),(201,'Lebu',34),(202,'Los Álamos',34),(203,'Tirúa',34),(204,'Alto Biobío',35),(205,'Antuco',35),(206,'Cabrero',35),(207,'Laja',35),(208,'Los Ángeles',35),(209,'Mulchén',35),(210,'Nacimiento',35),(211,'Negrete',35),(212,'Quilaco',35),(213,'Quilleco',35),(214,'San Rosendo',35),(215,'Santa Bárbara',35),(216,'Tucapel',35),(217,'Yumbel',35),(218,'Chiguayante',36),(219,'Concepción',36),(220,'Coronel',36),(221,'Florida',36),(222,'Hualpén',36),(223,'Hualqui',36),(224,'Lota',36),(225,'Penco',36),(226,'San Pedro de La Paz',36),(227,'Santa Juana',36),(228,'Talcahuano',36),(229,'Tomé',36),(230,'Bulnes',37),(231,'Chillán',37),(232,'Chillán Viejo',37),(233,'Cobquecura',37),(234,'Coelemu',37),(235,'Coihueco',37),(236,'El Carmen',37),(237,'Ninhue',37),(238,'Ñiquen',37),(239,'Pemuco',37),(240,'Pinto',37),(241,'Portezuelo',37),(242,'Quillón',37),(243,'Quirihue',37),(244,'Ránquil',37),(245,'San Carlos',37),(246,'San Fabián',37),(247,'San Ignacio',37),(248,'San Nicolás',37),(249,'Treguaco',37),(250,'Yungay',37),(251,'Carahue',38),(252,'Cholchol',38),(253,'Cunco',38),(254,'Curarrehue',38),(255,'Freire',38),(256,'Galvarino',38),(257,'Gorbea',38),(258,'Lautaro',38),(259,'Loncoche',38),(260,'Melipeuco',38),(261,'Nueva Imperial',38),(262,'Padre Las Casas',38),(263,'Perquenco',38),(264,'Pitrufquén',38),(265,'Pucón',38),(266,'Saavedra',38),(267,'Temuco',38),(268,'Teodoro Schmidt',38),(269,'Toltén',38),(270,'Vilcún',38),(271,'Villarrica',38),(272,'Angol',39),(273,'Collipulli',39),(274,'Curacautín',39),(275,'Ercilla',39),(276,'Lonquimay',39),(277,'Los Sauces',39),(278,'Lumaco',39),(279,'Purén',39),(280,'Renaico',39),(281,'Traiguén',39),(282,'Victoria',39),(283,'Corral',40),(284,'Lanco',40),(285,'Los Lagos',40),(286,'Máfil',40),(287,'Mariquina',40),(288,'Paillaco',40),(289,'Panguipulli',40),(290,'Valdivia',40),(291,'Futrono',41),(292,'La Unión',41),(293,'Lago Ranco',41),(294,'Río Bueno',41),(295,'Ancud',42),(296,'Castro',42),(297,'Chonchi',42),(298,'Curaco de Vélez',42),(299,'Dalcahue',42),(300,'Puqueldón',42),(301,'Queilén',42),(302,'Quemchi',42),(303,'Quellón',42),(304,'Quinchao',42),(305,'Calbuco',43),(306,'Cochamó',43),(307,'Fresia',43),(308,'Frutillar',43),(309,'Llanquihue',43),(310,'Los Muermos',43),(311,'Maullín',43),(312,'Puerto Montt',43),(313,'Puerto Varas',43),(314,'Osorno',44),(315,'Puero Octay',44),(316,'Purranque',44),(317,'Puyehue',44),(318,'Río Negro',44),(319,'San Juan de la Costa',44),(320,'San Pablo',44),(321,'Chaitén',45),(322,'Futaleufú',45),(323,'Hualaihué',45),(324,'Palena',45),(325,'Aisén',46),(326,'Cisnes',46),(327,'Guaitecas',46),(328,'Cochrane',47),(329,'O\'higgins',47),(330,'Tortel',47),(331,'Coihaique',48),(332,'Lago Verde',48),(333,'Chile Chico',49),(334,'Río Ibáñez',49),(335,'Antártica',50),(336,'Cabo de Hornos',50),(337,'Laguna Blanca',51),(338,'Punta Arenas',51),(339,'Río Verde',51),(340,'San Gregorio',51),(341,'Porvenir',52),(342,'Primavera',52),(343,'Timaukel',52),(344,'Natales',53),(345,'Torres del Paine',53);

/*Table structure for table `detalleventas` */

DROP TABLE IF EXISTS `detalleventas`;

CREATE TABLE `detalleventas` (
  `cod_detventa` int(5) NOT NULL AUTO_INCREMENT,
  `cod_venta` int(5) NOT NULL,
  `cod_libro` int(5) NOT NULL,
  PRIMARY KEY (`cod_detventa`),
  KEY `cod_venta` (`cod_venta`),
  KEY `cod_libro` (`cod_libro`),
  CONSTRAINT `detalleventas_ibfk_2` FOREIGN KEY (`cod_libro`) REFERENCES `libro` (`cod_libro`),
  CONSTRAINT `detalleventas_ibfk_3` FOREIGN KEY (`cod_venta`) REFERENCES `opcion` (`cod_opcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `detalleventas` */

insert  into `detalleventas`(`cod_detventa`,`cod_venta`,`cod_libro`) values (2,3,29),(3,11,43);

/*Table structure for table `detarriendo` */

DROP TABLE IF EXISTS `detarriendo`;

CREATE TABLE `detarriendo` (
  `cod_detarriendo` int(5) NOT NULL AUTO_INCREMENT,
  `cod_arriendo` int(5) NOT NULL,
  `cod_libro` int(5) NOT NULL,
  `fec_entrega` date NOT NULL,
  `fec_estimada` date NOT NULL,
  PRIMARY KEY (`cod_detarriendo`),
  KEY `cod_arriendo` (`cod_arriendo`),
  KEY `cod_libro` (`cod_libro`),
  CONSTRAINT `detarriendo_ibfk_2` FOREIGN KEY (`cod_libro`) REFERENCES `libro` (`cod_libro`),
  CONSTRAINT `detarriendo_ibfk_3` FOREIGN KEY (`cod_arriendo`) REFERENCES `opcion` (`cod_opcion`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `detarriendo` */

insert  into `detarriendo`(`cod_detarriendo`,`cod_arriendo`,`cod_libro`,`fec_entrega`,`fec_estimada`) values (12,8,2,'2020-06-23','2020-06-30'),(13,8,26,'2020-06-23','2020-06-30'),(15,13,41,'2020-07-06','2020-07-09');

/*Table structure for table `distribuidor` */

DROP TABLE IF EXISTS `distribuidor`;

CREATE TABLE `distribuidor` (
  `cod_dist` int(3) NOT NULL AUTO_INCREMENT,
  `rut_dist` varchar(20) NOT NULL,
  `nom_dist` varchar(40) NOT NULL,
  `dir_dist` varchar(120) NOT NULL,
  `tel_dist` varchar(20) NOT NULL,
  `tiempo_dist` int(6) NOT NULL,
  `email_dist` varchar(128) DEFAULT NULL,
  `contacto_dist` varchar(128) DEFAULT NULL,
  `cod_comuna` int(3) NOT NULL,
  `cod_pais` int(4) NOT NULL,
  PRIMARY KEY (`cod_dist`),
  KEY `cod_ciudad` (`cod_comuna`),
  KEY `cod_pais` (`cod_pais`),
  CONSTRAINT `distribuidor_ibfk_2` FOREIGN KEY (`cod_pais`) REFERENCES `pais` (`cod_pais`),
  CONSTRAINT `distribuidor_ibfk_3` FOREIGN KEY (`cod_comuna`) REFERENCES `comuna` (`cod_comuna`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `distribuidor` */

insert  into `distribuidor`(`cod_dist`,`rut_dist`,`nom_dist`,`dir_dist`,`tel_dist`,`tiempo_dist`,`email_dist`,`contacto_dist`,`cod_comuna`,`cod_pais`) values (2,'18.652.352-2','Libreros S.A cl','Hermano Palacios #045','+592352481',2,'A.arrollo@gmail.com','+56945263214',1,1);

/*Table structure for table `editoral` */

DROP TABLE IF EXISTS `editoral`;

CREATE TABLE `editoral` (
  `cod_edit` int(3) NOT NULL AUTO_INCREMENT,
  `nom_edit` varchar(60) NOT NULL,
  PRIMARY KEY (`cod_edit`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `editoral` */

insert  into `editoral`(`cod_edit`,`nom_edit`) values (1,'Alba Editores'),(5,'Apostrophes Ediciones'),(8,'Arrayán Ediciones'),(9,'Ctro. Literario Ánden'),(10,'Editorial Final');

/*Table structure for table `estado_orden` */

DROP TABLE IF EXISTS `estado_orden`;

CREATE TABLE `estado_orden` (
  `cod_estado` int(1) NOT NULL AUTO_INCREMENT,
  `nom_estado` varchar(60) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `estado_orden` */

insert  into `estado_orden`(`cod_estado`,`nom_estado`) values (1,'Aprobada'),(2,'Anulada'),(3,'En proceso');

/*Table structure for table `estadolibro` */

DROP TABLE IF EXISTS `estadolibro`;

CREATE TABLE `estadolibro` (
  `cod_estado` int(1) NOT NULL AUTO_INCREMENT,
  `nom_estado` varchar(60) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `estadolibro` */

insert  into `estadolibro`(`cod_estado`,`nom_estado`) values (1,'EN STOCK'),(3,'ARRENDADO'),(4,'EN COMPRA'),(5,'EN REPOSICION'),(6,'VENDIDO');

/*Table structure for table `estadomorosidad` */

DROP TABLE IF EXISTS `estadomorosidad`;

CREATE TABLE `estadomorosidad` (
  `cod_estadom` int(1) NOT NULL AUTO_INCREMENT,
  `nom_estadom` varchar(60) NOT NULL,
  PRIMARY KEY (`cod_estadom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `estadomorosidad` */

insert  into `estadomorosidad`(`cod_estadom`,`nom_estadom`) values (1,'Pagada'),(2,'No Pagada');

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `cod_factura` int(5) NOT NULL AUTO_INCREMENT,
  `prec_neto` int(10) NOT NULL,
  `costo_iva` int(10) NOT NULL,
  `precio_iva` int(10) NOT NULL,
  `fec_compra` date NOT NULL,
  `cod_dist` int(3) NOT NULL,
  `cod_metodo` int(1) NOT NULL,
  PRIMARY KEY (`cod_factura`),
  KEY `cod_dist` (`cod_dist`),
  KEY `cod_metodo` (`cod_metodo`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`cod_dist`) REFERENCES `distribuidor` (`cod_dist`),
  CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`cod_metodo`) REFERENCES `mediopago` (`cod_mediop`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `factura` */

insert  into `factura`(`cod_factura`,`prec_neto`,`costo_iva`,`precio_iva`,`fec_compra`,`cod_dist`,`cod_metodo`) values (1,200000,38000,238000,'2020-05-13',2,1),(2,10000,1900,11900,'2020-07-12',2,2),(3,3000,570,3570,'2020-07-13',2,2);

/*Table structure for table `idioma` */

DROP TABLE IF EXISTS `idioma`;

CREATE TABLE `idioma` (
  `cod_idioma` int(4) NOT NULL AUTO_INCREMENT,
  `nom_idioma` varchar(40) NOT NULL,
  PRIMARY KEY (`cod_idioma`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `idioma` */

insert  into `idioma`(`cod_idioma`,`nom_idioma`) values (1,'Español ES'),(2,'Español LAT'),(3,'Ingles'),(4,'Frances'),(5,'Aleman');

/*Table structure for table `idiomalibro` */

DROP TABLE IF EXISTS `idiomalibro`;

CREATE TABLE `idiomalibro` (
  `cod_idioma` int(3) NOT NULL,
  `cod_libro` int(3) NOT NULL,
  PRIMARY KEY (`cod_idioma`,`cod_libro`),
  KEY `cod_libro` (`cod_libro`),
  CONSTRAINT `idiomalibro_ibfk_1` FOREIGN KEY (`cod_libro`) REFERENCES `libro` (`cod_libro`),
  CONSTRAINT `idiomalibro_ibfk_2` FOREIGN KEY (`cod_idioma`) REFERENCES `idioma` (`cod_idioma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `idiomalibro` */

insert  into `idiomalibro`(`cod_idioma`,`cod_libro`) values (1,2),(1,26),(1,31),(2,39),(2,41),(2,42),(2,44),(3,43);

/*Table structure for table `libro` */

DROP TABLE IF EXISTS `libro`;

CREATE TABLE `libro` (
  `cod_libro` int(5) NOT NULL AUTO_INCREMENT,
  `isbn_libro` varchar(128) NOT NULL,
  `titulo_libro` varchar(128) NOT NULL,
  `pag_libro` int(4) NOT NULL,
  `precio_libro` int(10) NOT NULL,
  `cod_estado` int(1) NOT NULL,
  `cod_edit` int(3) NOT NULL,
  PRIMARY KEY (`cod_libro`),
  KEY `cod_edit` (`cod_edit`),
  KEY `cod_estado` (`cod_estado`),
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`cod_edit`) REFERENCES `editoral` (`cod_edit`),
  CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`cod_estado`) REFERENCES `estadolibro` (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

/*Data for the table `libro` */

insert  into `libro`(`cod_libro`,`isbn_libro`,`titulo_libro`,`pag_libro`,`precio_libro`,`cod_estado`,`cod_edit`) values (2,'ISBN12B3N4','Juego de Tronos 1',600,13990,1,1),(26,'ISBN41SN34','El arte de la guerra',650,12000,1,1),(29,'ISBN90SN11','Juego de Tronos 3',1250,20990,6,1),(30,'ISBN1209SN76','La Bella y la Bestia',150,5990,5,1),(31,'ISBN454SN83','Luna de Pluton',1240,19990,1,9),(39,'Isbn123','EjemploFinal',15,12000,1,5),(40,'ISBN12sn6363','La Torre Oscura',305,10000,5,1),(41,'ISBNfinal1','La Torre Oscura',305,15000,1,1),(42,'ISBNfinal2','La Bella y la Bestia',150,5990,3,1),(43,'ISBNFINALPROYECTO','Alicia en el Pais de Las Maravillas',12,3000,6,10),(44,'ISBN123SN5433','La Torre Oscura',305,15000,1,1);

/*Table structure for table `mediopago` */

DROP TABLE IF EXISTS `mediopago`;

CREATE TABLE `mediopago` (
  `cod_mediop` int(3) NOT NULL AUTO_INCREMENT,
  `nom_mediop` varchar(128) NOT NULL,
  PRIMARY KEY (`cod_mediop`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `mediopago` */

insert  into `mediopago`(`cod_mediop`,`nom_mediop`) values (1,'Transferencia Bancaria'),(2,'Visa '),(3,'MaterCard'),(4,'Efectivo');

/*Table structure for table `metodopago` */

DROP TABLE IF EXISTS `metodopago`;

CREATE TABLE `metodopago` (
  `cod_metod` int(1) NOT NULL AUTO_INCREMENT,
  `nom_metod` varchar(64) NOT NULL,
  PRIMARY KEY (`cod_metod`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `metodopago` */

insert  into `metodopago`(`cod_metod`,`nom_metod`) values (1,'Visa'),(2,'Mastercard'),(3,'Transferencia Electronica'),(4,'Efectivo');

/*Table structure for table `morosidad` */

DROP TABLE IF EXISTS `morosidad`;

CREATE TABLE `morosidad` (
  `cod_morosidad` int(3) NOT NULL AUTO_INCREMENT,
  `dias_morosidad` int(3) NOT NULL,
  `monto_morosidad` int(10) NOT NULL,
  `cod_arriendo` int(3) NOT NULL,
  `cod_estado` int(1) NOT NULL,
  PRIMARY KEY (`cod_morosidad`),
  KEY `cod_estado` (`cod_estado`),
  KEY `cod_arriendo` (`cod_arriendo`),
  CONSTRAINT `morosidad_ibfk_2` FOREIGN KEY (`cod_estado`) REFERENCES `estadomorosidad` (`cod_estadom`),
  CONSTRAINT `morosidad_ibfk_3` FOREIGN KEY (`cod_arriendo`) REFERENCES `detarriendo` (`cod_detarriendo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

/*Data for the table `morosidad` */

insert  into `morosidad`(`cod_morosidad`,`dias_morosidad`,`monto_morosidad`,`cod_arriendo`,`cod_estado`) values (21,6,18000,12,1),(23,6,18000,12,1),(24,4,12000,15,1);

/*Table structure for table `nacionautor` */

DROP TABLE IF EXISTS `nacionautor`;

CREATE TABLE `nacionautor` (
  `cod_nac` int(3) NOT NULL AUTO_INCREMENT,
  `nom_nac` varchar(50) NOT NULL,
  `cod_pais` int(3) NOT NULL,
  PRIMARY KEY (`cod_nac`),
  KEY `cod_pais` (`cod_pais`),
  CONSTRAINT `nacionautor_ibfk_1` FOREIGN KEY (`cod_pais`) REFERENCES `paisautor` (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `nacionautor` */

insert  into `nacionautor`(`cod_nac`,`nom_nac`,`cod_pais`) values (7,'Chileno',46),(8,'Aleman',4),(9,'Peruano',173),(10,'Colombiano',52),(11,'Chino',47),(12,'Belga',24);

/*Table structure for table `opcion` */

DROP TABLE IF EXISTS `opcion`;

CREATE TABLE `opcion` (
  `cod_opcion` int(5) NOT NULL AUTO_INCREMENT,
  `cod_traba` int(5) NOT NULL,
  `cod_cliente` int(5) NOT NULL,
  `cod_bof` int(5) NOT NULL,
  `cod_tipoo` int(5) NOT NULL,
  PRIMARY KEY (`cod_opcion`),
  KEY `cod_cliente` (`cod_cliente`),
  KEY `cod_bof` (`cod_bof`),
  KEY `cod_tipoo` (`cod_tipoo`),
  KEY `cod_traba` (`cod_traba`),
  CONSTRAINT `opcion_ibfk_2` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `opcion_ibfk_3` FOREIGN KEY (`cod_bof`) REFERENCES `boletaofactura` (`cod_bof`),
  CONSTRAINT `opcion_ibfk_4` FOREIGN KEY (`cod_tipoo`) REFERENCES `tipoopcion` (`cod_tipoo`),
  CONSTRAINT `opcion_ibfk_5` FOREIGN KEY (`cod_traba`) REFERENCES `trabajador` (`cod_traba`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `opcion` */

insert  into `opcion`(`cod_opcion`,`cod_traba`,`cod_cliente`,`cod_bof`,`cod_tipoo`) values (3,1,1,8,1),(4,1,1,9,2),(6,1,1,8,2),(7,1,1,8,2),(8,1,1,12,2),(11,1,6,14,1),(12,1,6,14,2),(13,3,5,16,2);

/*Table structure for table `orden_compra` */

DROP TABLE IF EXISTS `orden_compra`;

CREATE TABLE `orden_compra` (
  `cod_orden` int(5) NOT NULL AUTO_INCREMENT,
  `folio_orden` varchar(30) NOT NULL,
  `fecha_emision` date NOT NULL,
  `cod_distribuidor` int(5) NOT NULL,
  `cod_trabajador` int(5) NOT NULL,
  `cod_estado` int(1) NOT NULL,
  PRIMARY KEY (`cod_orden`),
  KEY `cod_trabajador` (`cod_trabajador`),
  KEY `cod_distribuidor` (`cod_distribuidor`),
  KEY `cod_estado` (`cod_estado`),
  CONSTRAINT `orden_compra_ibfk_1` FOREIGN KEY (`cod_trabajador`) REFERENCES `trabajador` (`cod_traba`),
  CONSTRAINT `orden_compra_ibfk_2` FOREIGN KEY (`cod_distribuidor`) REFERENCES `distribuidor` (`cod_dist`),
  CONSTRAINT `orden_compra_ibfk_3` FOREIGN KEY (`cod_estado`) REFERENCES `estado_orden` (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `orden_compra` */

insert  into `orden_compra`(`cod_orden`,`folio_orden`,`fecha_emision`,`cod_distribuidor`,`cod_trabajador`,`cod_estado`) values (8,'Folio123','2020-06-22',2,1,1),(9,'FolioFinal','2020-07-12',2,3,1),(11,'FolioFinal','2020-07-13',2,1,1);

/*Table structure for table `ordenc_libro` */

DROP TABLE IF EXISTS `ordenc_libro`;

CREATE TABLE `ordenc_libro` (
  `cod_libro` int(5) NOT NULL,
  `cod_orden` int(5) NOT NULL,
  `precio` int(10) NOT NULL,
  PRIMARY KEY (`cod_libro`,`cod_orden`),
  KEY `cod_orden` (`cod_orden`),
  CONSTRAINT `ordenc_libro_ibfk_1` FOREIGN KEY (`cod_libro`) REFERENCES `libro` (`cod_libro`),
  CONSTRAINT `ordenc_libro_ibfk_2` FOREIGN KEY (`cod_orden`) REFERENCES `orden_compra` (`cod_orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `ordenc_libro` */

insert  into `ordenc_libro`(`cod_libro`,`cod_orden`,`precio`) values (30,9,5990),(40,9,10000),(43,11,3000);

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `cod_pais` int(3) NOT NULL AUTO_INCREMENT,
  `iso1_pais` varchar(2) NOT NULL,
  `nom_pais` varchar(40) NOT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pais` */

insert  into `pais`(`cod_pais`,`iso1_pais`,`nom_pais`) values (1,'AF','Afganistán'),(2,'AX','Islas Gland'),(3,'AL','Albania'),(4,'DE','Alemania'),(5,'AD','Andorra'),(6,'AO','Angola'),(7,'AI','Anguilla'),(8,'AQ','Antártida'),(9,'AG','Antigua y Barbuda'),(10,'AN','Antillas Holandesas'),(11,'SA','Arabia Saudí'),(12,'DZ','Argelia'),(13,'AR','Argentina'),(14,'AM','Armenia'),(15,'AW','Aruba'),(16,'AU','Australia'),(17,'AT','Austria'),(18,'AZ','Azerbaiyán'),(19,'BS','Bahamas'),(20,'BH','Bahréin'),(21,'BD','Bangladesh'),(22,'BB','Barbados'),(23,'BY','Bielorrusia'),(24,'BE','Bélgica'),(25,'BZ','Belice'),(26,'BJ','Benin'),(27,'BM','Bermudas'),(28,'BT','Bhután'),(29,'BO','Bolivia'),(30,'BA','Bosnia y Herzegovina'),(31,'BW','Botsuana'),(32,'BV','Isla Bouvet'),(33,'BR','Brasil'),(34,'BN','Brunéi'),(35,'BG','Bulgaria'),(36,'BF','Burkina Faso'),(37,'BI','Burundi'),(38,'CV','Cabo Verde'),(39,'KY','Islas Caimán'),(40,'KH','Camboya'),(41,'CM','Camerún'),(42,'CA','Canadá'),(43,'CF','República Centroafricana'),(44,'TD','Chad'),(45,'CZ','República Checa'),(46,'CL','Chile'),(47,'CN','China'),(48,'CY','Chipre'),(49,'CX','Isla de Navidad'),(50,'VA','Ciudad del Vaticano'),(51,'CC','Islas Cocos'),(52,'CO','Colombia'),(53,'KM','Comoras'),(54,'CD','República Democrática del Congo'),(55,'CG','Congo'),(56,'CK','Islas Cook'),(57,'KP','Corea del Norte'),(58,'KR','Corea del Sur'),(59,'CI','Costa de Marfil'),(60,'CR','Costa Rica'),(61,'HR','Croacia'),(62,'CU','Cuba'),(63,'DK','Dinamarca'),(64,'DM','Dominica'),(65,'DO','República Dominicana'),(66,'EC','Ecuador'),(67,'EG','Egipto'),(68,'SV','El Salvador'),(69,'AE','Emiratos Árabes Unidos'),(70,'ER','Eritrea'),(71,'SK','Eslovaquia'),(72,'SI','Eslovenia'),(73,'ES','España'),(74,'UM','Islas ultramarinas de Estados Unidos'),(75,'US','Estados Unidos'),(76,'EE','Estonia'),(77,'ET','Etiopía'),(78,'FO','Islas Feroe'),(79,'PH','Filipinas'),(80,'FI','Finlandia'),(81,'FJ','Fiyi'),(82,'FR','Francia'),(83,'GA','Gabón'),(84,'GM','Gambia'),(85,'GE','Georgia'),(86,'GS','Islas Georgias del Sur y Sandwich del Su'),(87,'GH','Ghana'),(88,'GI','Gibraltar'),(89,'GD','Granada'),(90,'GR','Grecia'),(91,'GL','Groenlandia'),(92,'GP','Guadalupe'),(93,'GU','Guam'),(94,'GT','Guatemala'),(95,'GF','Guayana Francesa'),(96,'GN','Guinea'),(97,'GQ','Guinea Ecuatorial'),(98,'GW','Guinea-Bissau'),(99,'GY','Guyana'),(100,'HT','Haití'),(101,'HM','Islas Heard y McDonald'),(102,'HN','Honduras'),(103,'HK','Hong Kong'),(104,'HU','Hungría'),(105,'IN','India'),(106,'ID','Indonesia'),(107,'IR','Irán'),(108,'IQ','Iraq'),(109,'IE','Irlanda'),(110,'IS','Islandia'),(111,'IL','Israel'),(112,'IT','Italia'),(113,'JM','Jamaica'),(114,'JP','Japón'),(115,'JO','Jordania'),(116,'KZ','Kazajstán'),(117,'KE','Kenia'),(118,'KG','Kirguistán'),(119,'KI','Kiribati'),(120,'KW','Kuwait'),(121,'LA','Laos'),(122,'LS','Lesotho'),(123,'LV','Letonia'),(124,'LB','Líbano'),(125,'LR','Liberia'),(126,'LY','Libia'),(127,'LI','Liechtenstein'),(128,'LT','Lituania'),(129,'LU','Luxemburgo'),(130,'MO','Macao'),(131,'MK','ARY Macedonia'),(132,'MG','Madagascar'),(133,'MY','Malasia'),(134,'MW','Malawi'),(135,'MV','Maldivas'),(136,'ML','Malí'),(137,'MT','Malta'),(138,'FK','Islas Malvinas'),(139,'MP','Islas Marianas del Norte'),(140,'MA','Marruecos'),(141,'MH','Islas Marshall'),(142,'MQ','Martinica'),(143,'MU','Mauricio'),(144,'MR','Mauritania'),(145,'YT','Mayotte'),(146,'MX','México'),(147,'FM','Micronesia'),(148,'MD','Moldavia'),(149,'MC','Mónaco'),(150,'MN','Mongolia'),(151,'MS','Montserrat'),(152,'MZ','Mozambique'),(153,'MM','Myanmar'),(154,'NA','Namibia'),(155,'NR','Nauru'),(156,'NP','Nepal'),(157,'NI','Nicaragua'),(158,'NE','Níger'),(159,'NG','Nigeria'),(160,'NU','Niue'),(161,'NF','Isla Norfolk'),(162,'NO','Noruega'),(163,'NC','Nueva Caledonia'),(164,'NZ','Nueva Zelanda'),(165,'OM','Omán'),(166,'NL','Países Bajos'),(167,'PK','Pakistán'),(168,'PW','Palau'),(169,'PS','Palestina'),(170,'PA','Panamá'),(171,'PG','Papúa Nueva Guinea'),(172,'PY','Paraguay'),(173,'PE','Perú'),(174,'PN','Islas Pitcairn'),(175,'PF','Polinesia Francesa'),(176,'PL','Polonia'),(177,'PT','Portugal'),(178,'PR','Puerto Rico'),(179,'QA','Qatar'),(180,'GB','Reino Unido'),(181,'RE','Reunión'),(182,'RW','Ruanda'),(183,'RO','Rumania'),(184,'RU','Rusia'),(185,'EH','Sahara Occidental'),(186,'SB','Islas Salomón'),(187,'WS','Samoa'),(188,'AS','Samoa Americana'),(189,'KN','San Cristóbal y Nevis'),(190,'SM','San Marino'),(191,'PM','San Pedro y Miquelón'),(192,'VC','San Vicente y las Granadinas'),(193,'SH','Santa Helena'),(194,'LC','Santa Lucía'),(195,'ST','Santo Tomé y Príncipe'),(196,'SN','Senegal'),(197,'CS','Serbia y Montenegro'),(198,'SC','Seychelles'),(199,'SL','Sierra Leona'),(200,'SG','Singapur'),(201,'SY','Siria'),(202,'SO','Somalia'),(203,'LK','Sri Lanka'),(204,'SZ','Suazilandia'),(205,'ZA','Sudáfrica'),(206,'SD','Sudán'),(207,'SE','Suecia'),(208,'CH','Suiza'),(209,'SR','Surinam'),(210,'SJ','Svalbard y Jan Mayen'),(211,'TH','Tailandia'),(212,'TW','Taiwán'),(213,'TZ','Tanzania'),(214,'TJ','Tayikistán'),(215,'IO','Territorio Británico del Océano Índico'),(216,'TF','Territorios Australes Franceses'),(217,'TL','Timor Oriental'),(218,'TG','Togo'),(219,'TK','Tokelau'),(220,'TO','Tonga'),(221,'TT','Trinidad y Tobago'),(222,'TN','Túnez'),(223,'TC','Islas Turcas y Caicos'),(224,'TM','Turkmenistán'),(225,'TR','Turquía'),(226,'TV','Tuvalu'),(227,'UA','Ucrania'),(228,'UG','Uganda'),(229,'UY','Uruguay'),(230,'UZ','Uzbekistán'),(231,'VU','Vanuatu'),(232,'VE','Venezuela'),(233,'VN','Vietnam'),(234,'VG','Islas Vírgenes Británicas'),(235,'VI','Islas Vírgenes de los Estados Unidos'),(236,'WF','Wallis y Futuna'),(237,'YE','Yemen'),(238,'DJ','Yibuti'),(239,'ZM','Zambia'),(240,'ZW','Zimbabue');

/*Table structure for table `paisautor` */

DROP TABLE IF EXISTS `paisautor`;

CREATE TABLE `paisautor` (
  `cod_pais` int(3) NOT NULL AUTO_INCREMENT,
  `iso_pais` varchar(2) NOT NULL,
  `nom_pais` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4;

/*Data for the table `paisautor` */

insert  into `paisautor`(`cod_pais`,`iso_pais`,`nom_pais`) values (1,'AF','Afganistán'),(2,'AX','Islas Gland'),(3,'AL','Albania'),(4,'DE','Alemania'),(5,'AD','Andorra'),(6,'AO','Angola'),(7,'AI','Anguilla'),(8,'AQ','Antártida'),(9,'AG','Antigua y Barbuda'),(10,'AN','Antillas Holandesas'),(11,'SA','Arabia Saudí'),(12,'DZ','Argelia'),(13,'AR','Argentina'),(14,'AM','Armenia'),(15,'AW','Aruba'),(16,'AU','Australia'),(17,'AT','Austria'),(18,'AZ','Azerbaiyán'),(19,'BS','Bahamas'),(20,'BH','Bahréin'),(21,'BD','Bangladesh'),(22,'BB','Barbados'),(23,'BY','Bielorrusia'),(24,'BE','Bélgica'),(25,'BZ','Belice'),(26,'BJ','Benin'),(27,'BM','Bermudas'),(28,'BT','Bhután'),(29,'BO','Bolivia'),(30,'BA','Bosnia y Herzegovina'),(31,'BW','Botsuana'),(32,'BV','Isla Bouvet'),(33,'BR','Brasil'),(34,'BN','Brunéi'),(35,'BG','Bulgaria'),(36,'BF','Burkina Faso'),(37,'BI','Burundi'),(38,'CV','Cabo Verde'),(39,'KY','Islas Caimán'),(40,'KH','Camboya'),(41,'CM','Camerún'),(42,'CA','Canadá'),(43,'CF','República Centroafricana'),(44,'TD','Chad'),(45,'CZ','República Checa'),(46,'CL','Chile'),(47,'CN','China'),(48,'CY','Chipre'),(49,'CX','Isla de Navidad'),(50,'VA','Ciudad del Vaticano'),(51,'CC','Islas Cocos'),(52,'CO','Colombia'),(53,'KM','Comoras'),(54,'CD','República Democrática del Congo'),(55,'CG','Congo'),(56,'CK','Islas Cook'),(57,'KP','Corea del Norte'),(58,'KR','Corea del Sur'),(59,'CI','Costa de Marfil'),(60,'CR','Costa Rica'),(61,'HR','Croacia'),(62,'CU','Cuba'),(63,'DK','Dinamarca'),(64,'DM','Dominica'),(65,'DO','República Dominicana'),(66,'EC','Ecuador'),(67,'EG','Egipto'),(68,'SV','El Salvador'),(69,'AE','Emiratos Árabes Unidos'),(70,'ER','Eritrea'),(71,'SK','Eslovaquia'),(72,'SI','Eslovenia'),(73,'ES','España'),(74,'UM','Islas ultramarinas de Estados Unidos'),(75,'US','Estados Unidos'),(76,'EE','Estonia'),(77,'ET','Etiopía'),(78,'FO','Islas Feroe'),(79,'PH','Filipinas'),(80,'FI','Finlandia'),(81,'FJ','Fiyi'),(82,'FR','Francia'),(83,'GA','Gabón'),(84,'GM','Gambia'),(85,'GE','Georgia'),(86,'GS','Islas Georgias del Sur y Sandwich del Sur'),(87,'GH','Ghana'),(88,'GI','Gibraltar'),(89,'GD','Granada'),(90,'GR','Grecia'),(91,'GL','Groenlandia'),(92,'GP','Guadalupe'),(93,'GU','Guam'),(94,'GT','Guatemala'),(95,'GF','Guayana Francesa'),(96,'GN','Guinea'),(97,'GQ','Guinea Ecuatorial'),(98,'GW','Guinea-Bissau'),(99,'GY','Guyana'),(100,'HT','Haití'),(101,'HM','Islas Heard y McDonald'),(102,'HN','Honduras'),(103,'HK','Hong Kong'),(104,'HU','Hungría'),(105,'IN','India'),(106,'ID','Indonesia'),(107,'IR','Irán'),(108,'IQ','Iraq'),(109,'IE','Irlanda'),(110,'IS','Islandia'),(111,'IL','Israel'),(112,'IT','Italia'),(113,'JM','Jamaica'),(114,'JP','Japón'),(115,'JO','Jordania'),(116,'KZ','Kazajstán'),(117,'KE','Kenia'),(118,'KG','Kirguistán'),(119,'KI','Kiribati'),(120,'KW','Kuwait'),(121,'LA','Laos'),(122,'LS','Lesotho'),(123,'LV','Letonia'),(124,'LB','Líbano'),(125,'LR','Liberia'),(126,'LY','Libia'),(127,'LI','Liechtenstein'),(128,'LT','Lituania'),(129,'LU','Luxemburgo'),(130,'MO','Macao'),(131,'MK','ARY Macedonia'),(132,'MG','Madagascar'),(133,'MY','Malasia'),(134,'MW','Malawi'),(135,'MV','Maldivas'),(136,'ML','Malí'),(137,'MT','Malta'),(138,'FK','Islas Malvinas'),(139,'MP','Islas Marianas del Norte'),(140,'MA','Marruecos'),(141,'MH','Islas Marshall'),(142,'MQ','Martinica'),(143,'MU','Mauricio'),(144,'MR','Mauritania'),(145,'YT','Mayotte'),(146,'MX','México'),(147,'FM','Micronesia'),(148,'MD','Moldavia'),(149,'MC','Mónaco'),(150,'MN','Mongolia'),(151,'MS','Montserrat'),(152,'MZ','Mozambique'),(153,'MM','Myanmar'),(154,'NA','Namibia'),(155,'NR','Nauru'),(156,'NP','Nepal'),(157,'NI','Nicaragua'),(158,'NE','Níger'),(159,'NG','Nigeria'),(160,'NU','Niue'),(161,'NF','Isla Norfolk'),(162,'NO','Noruega'),(163,'NC','Nueva Caledonia'),(164,'NZ','Nueva Zelanda'),(165,'OM','Omán'),(166,'NL','Países Bajos'),(167,'PK','Pakistán'),(168,'PW','Palau'),(169,'PS','Palestina'),(170,'PA','Panamá'),(171,'PG','Papúa Nueva Guinea'),(172,'PY','Paraguay'),(173,'PE','Perú'),(174,'PN','Islas Pitcairn'),(175,'PF','Polinesia Francesa'),(176,'PL','Polonia'),(177,'PT','Portugal'),(178,'PR','Puerto Rico'),(179,'QA','Qatar'),(180,'GB','Reino Unido'),(181,'RE','Reunión'),(182,'RW','Ruanda'),(183,'RO','Rumania'),(184,'RU','Rusia'),(185,'EH','Sahara Occidental'),(186,'SB','Islas Salomón'),(187,'WS','Samoa'),(188,'AS','Samoa Americana'),(189,'KN','San Cristóbal y Nevis'),(190,'SM','San Marino'),(191,'PM','San Pedro y Miquelón'),(192,'VC','San Vicente y las Granadinas'),(193,'SH','Santa Helena'),(194,'LC','Santa Lucía'),(195,'ST','Santo Tomé y Príncipe'),(196,'SN','Senegal'),(197,'CS','Serbia y Montenegro'),(198,'SC','Seychelles'),(199,'SL','Sierra Leona'),(200,'SG','Singapur'),(201,'SY','Siria'),(202,'SO','Somalia'),(203,'LK','Sri Lanka'),(204,'SZ','Suazilandia'),(205,'ZA','Sudáfrica'),(206,'SD','Sudán'),(207,'SE','Suecia'),(208,'CH','Suiza'),(209,'SR','Surinam'),(210,'SJ','Svalbard y Jan Mayen'),(211,'TH','Tailandia'),(212,'TW','Taiwán'),(213,'TZ','Tanzania'),(214,'TJ','Tayikistán'),(215,'IO','Territorio Británico del Océano Índico'),(216,'TF','Territorios Australes Franceses'),(217,'TL','Timor Oriental'),(218,'TG','Togo'),(219,'TK','Tokelau'),(220,'TO','Tonga'),(221,'TT','Trinidad y Tobago'),(222,'TN','Túnez'),(223,'TC','Islas Turcas y Caicos'),(224,'TM','Turkmenistán'),(225,'TR','Turquía'),(226,'TV','Tuvalu'),(227,'UA','Ucrania'),(228,'UG','Uganda'),(229,'UY','Uruguay'),(230,'UZ','Uzbekistán'),(231,'VU','Vanuatu'),(232,'VE','Venezuela'),(233,'VN','Vietnam'),(234,'VG','Islas Vírgenes Británicas'),(235,'VI','Islas Vírgenes de los Estados Unidos'),(236,'WF','Wallis y Futuna'),(237,'YE','Yemen'),(238,'DJ','Yibuti'),(239,'ZM','Zambia'),(240,'ZW','Zimbabue');

/*Table structure for table `provincia` */

DROP TABLE IF EXISTS `provincia`;

CREATE TABLE `provincia` (
  `cod_provincia` int(3) NOT NULL AUTO_INCREMENT,
  `nom_provincia` varchar(30) NOT NULL,
  `cod_region` int(2) NOT NULL,
  PRIMARY KEY (`cod_provincia`),
  KEY `cod_region` (`cod_region`),
  CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`cod_region`) REFERENCES `region` (`cod_region`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

/*Data for the table `provincia` */

insert  into `provincia`(`cod_provincia`,`nom_provincia`,`cod_region`) values (1,'Arica',1),(2,'Parinacota',1),(3,'Iquique',2),(4,'El Tamarugal',2),(5,'Antofagasta',3),(6,'El Loa',3),(7,'Tocopilla',3),(8,'Chañaral',4),(9,'Copiapó',4),(10,'Huasco',4),(11,'Choapa',5),(12,'Elqui',5),(13,'Limarí',5),(14,'Isla de Pascua',6),(15,'Los Andes',6),(16,'Petorca',6),(17,'Quillota',6),(18,'San Antonio',6),(19,'San Felipe de Aconcagua',6),(20,'Valparaiso',6),(21,'Chacabuco',7),(22,'Cordillera',7),(23,'Maipo',7),(24,'Melipilla',7),(25,'Santiago',7),(26,'Talagante',7),(27,'Cachapoal',8),(28,'Cardenal Caro',8),(29,'Colchagua',8),(30,'Cauquenes',9),(31,'Curicó',9),(32,'Linares',9),(33,'Talca',9),(34,'Arauco',10),(35,'Bio Bío',10),(36,'Concepción',10),(37,'Ñuble',10),(38,'Cautín',11),(39,'Malleco',11),(40,'Valdivia',12),(41,'Ranco',12),(42,'Chiloé',13),(43,'Llanquihue',13),(44,'Osorno',13),(45,'Palena',13),(46,'Aisén',14),(47,'Capitán Prat',14),(48,'Coihaique',14),(49,'General Carrera',14),(50,'Antártica Chilena',15),(51,'Magallanes',15),(52,'Tierra del Fuego',15),(53,'Última Esperanza',15);

/*Table structure for table `region` */

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `cod_region` int(2) NOT NULL AUTO_INCREMENT,
  `nom_region` varchar(30) NOT NULL,
  `ord_region` varchar(5) NOT NULL,
  PRIMARY KEY (`cod_region`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `region` */

insert  into `region`(`cod_region`,`nom_region`,`ord_region`) values (1,'Arica y Parinacota','XV'),(2,'Tarapacá','I'),(3,'Antofagasta','II'),(4,'Atacama','III'),(5,'Coquimbo','IV'),(6,'Valparaiso','V'),(7,'Metropolitana de Santiago','RM'),(8,'Libertador General Bernardo O\'','VI'),(9,'Maule','VII'),(10,'Biobío','VIII'),(11,'La Araucanía','IX'),(12,'Los Ríos','XIV'),(13,'Los Lagos','X'),(14,'Aisén del General Carlos Ibáñe','XI'),(15,'Magallanes y de la Antártica C','XII');

/*Table structure for table `roles_trabajador` */

DROP TABLE IF EXISTS `roles_trabajador`;

CREATE TABLE `roles_trabajador` (
  `cod_rol` int(1) NOT NULL AUTO_INCREMENT,
  `nom_rol` varchar(35) NOT NULL,
  PRIMARY KEY (`cod_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `roles_trabajador` */

insert  into `roles_trabajador`(`cod_rol`,`nom_rol`) values (1,'Vendedor'),(2,'Contador'),(3,'Inventario');

/*Table structure for table `tipobf` */

DROP TABLE IF EXISTS `tipobf`;

CREATE TABLE `tipobf` (
  `cod_tipobf` int(1) NOT NULL AUTO_INCREMENT,
  `nom_tipobf` varchar(35) NOT NULL,
  PRIMARY KEY (`cod_tipobf`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipobf` */

insert  into `tipobf`(`cod_tipobf`,`nom_tipobf`) values (1,'Boleta'),(2,'Factura');

/*Table structure for table `tipoopcion` */

DROP TABLE IF EXISTS `tipoopcion`;

CREATE TABLE `tipoopcion` (
  `cod_tipoo` int(1) NOT NULL AUTO_INCREMENT,
  `nom_tipoo` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_tipoo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipoopcion` */

insert  into `tipoopcion`(`cod_tipoo`,`nom_tipoo`) values (1,'Venta'),(2,'Arriendo');

/*Table structure for table `trabajador` */

DROP TABLE IF EXISTS `trabajador`;

CREATE TABLE `trabajador` (
  `cod_traba` int(5) NOT NULL AUTO_INCREMENT,
  `rut_traba` varchar(50) NOT NULL,
  `nom_traba` varchar(150) NOT NULL,
  `direc1_traba` varchar(150) NOT NULL,
  `direc2_traba` varchar(150) DEFAULT NULL,
  `tel1_traba` varchar(30) NOT NULL,
  `tel2_traba` varchar(30) DEFAULT NULL,
  `correo_traba` varchar(128) NOT NULL,
  `fecini_traba` date NOT NULL,
  `cod_rol` int(1) NOT NULL,
  PRIMARY KEY (`cod_traba`),
  KEY `cod_rol` (`cod_rol`),
  CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`cod_rol`) REFERENCES `roles_trabajador` (`cod_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `trabajador` */

insert  into `trabajador`(`cod_traba`,`rut_traba`,`nom_traba`,`direc1_traba`,`direc2_traba`,`tel1_traba`,`tel2_traba`,`correo_traba`,`fecini_traba`,`cod_rol`) values (1,'18.256.965-8','Guillermo Tapia Benavides','Villa los Palmos #156','','+56948521365','2 225638','G.Tapia@gmail.com','2013-06-25',1),(3,'18.254.201-6','Jose Rene Ponce Perez','Villa Prat Dpto #23','','+56925361478','','J.PonceP12@gmail.com','2019-01-10',1);

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `cod_usu` int(5) NOT NULL AUTO_INCREMENT,
  `nom_usu` varchar(30) NOT NULL,
  `pass_usu` varchar(256) NOT NULL,
  `cod_cargo` int(5) NOT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `cod_cargo` (`cod_cargo`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`cod_cargo`) REFERENCES `cargos` (`cod_cargos`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `usuarios` */

insert  into `usuarios`(`cod_usu`,`nom_usu`,`pass_usu`,`cod_cargo`) values (1,'Carlos1','123',1),(3,'Alonso1','123',2),(4,'Guzan12','',2),(14,'Ro12','123',3),(16,'Litios1','123',4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
