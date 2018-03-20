-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-03-2018 a las 19:58:32
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `voyager`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE `avion` (
  `idVuelo` int(11) NOT NULL,
  `Capacidad` int(11) DEFAULT NULL,
  `Estatus` int(11) DEFAULT NULL,
  `NombreAvion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleto`
--

CREATE TABLE `boleto` (
  `idVuelo` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `NumBoleto` int(11) NOT NULL,
  `Asiento` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `boleto`
--

INSERT INTO `boleto` (`idVuelo`, `idCliente`, `NumBoleto`, `Asiento`) VALUES
(2, 9, 1, 'A12'),
(2, 10, 2, 'A11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `NombreCli` varchar(45) DEFAULT NULL,
  `NacionalidadCli` varchar(45) DEFAULT NULL,
  `CiudadCli` varchar(45) DEFAULT NULL,
  `FechaNac` date DEFAULT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Usuario` varchar(45) DEFAULT NULL,
  `Contra` varchar(45) DEFAULT NULL,
  `Tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `NombreCli`, `NacionalidadCli`, `CiudadCli`, `FechaNac`, `Edad`, `Usuario`, `Contra`, `Tipo`) VALUES
(1, 'Andrés Vinicio Martínez López', 'Mexicano', 'Mazatlán', '1998-11-30', 19, 'andres.viny@voyager.com', '123456', 1),
(2, 'Aldahir Alejandro Gómez Beltrán', 'Mexicano', 'Mazatlán', '1997-02-11', 20, 'aldahir.alex@voyager.com', '123456', 1),
(3, 'David Geovanny Carrillo Rosales', 'Mexicano', 'Mazatlán', '1998-07-23', 19, 'david.geo@voyager.com', '123456', 1),
(4, 'Bryan Jesus Verde Osuna', 'Mexicano', 'Mazatlán', '1998-03-31', 19, 'verde.b@voyager.com', '123456', 1),
(5, 'Jesús Emmanuel Sauceda Pérez', 'Mexicano', 'Mazatlán', '1998-04-25', 19, 'manny.sad@voyager.com', '123456', 1),
(6, 'Marcos Javier Castro Carmona', 'Mexicano', 'Mazatlán', '1998-05-12', 19, 'mcastro@voyager.com', '123456', 3),
(7, 'Adrian Lizárraga Scott', 'Mexicano', 'Mazatlán', '1998-03-01', 20, 'scott@voyager.com', '123456', 3),
(8, 'Jesús Alfredo Espino Cárdenas', 'Mexicano', 'Mazatlán', '1998-05-06', 19, 'chuy.dios@voyager.com', '123456', 3),
(9, 'Fabiola Paez Aramburo', 'Mexicana', 'Mazatlán', '1998-09-22', 19, 'fabi@gmail.com', '123456', 2),
(10, 'Angeles Leva Rendón', 'Mexicana', 'Mazatlán', '1998-08-15', 19, 'leva@gmail.com', '123456', 2),
(11, 'Frida Guadalupe Lara Calero', 'Mexicana', 'Mazatlán', '1997-11-13', 20, 'frida@gmail.com', '123456', 2),
(12, 'Eduardo Campos Hubbard', 'Mexicano', 'Mazatlán', '1998-05-09', 19, 'hubbard_hubby@gmail.com', '123456', 2),
(13, 'Jesús Alejandro Ramírez Osuna', 'Mexicano', 'Mazatlán', '1998-11-16', 19, 'cofi@gmail.com', '123456', 2),
(14, 'Gustavo Adolfo Santos Torres', 'Mexicano', 'Mazatlán', '1998-07-15', 19, 'gustavo@gmail.com', '123456', 2),
(15, 'Cesar Ulises Cedillo Cerrano', 'Mexicano', 'Mazatlán', '1998-11-17', 19, 'cedishido@gmail.com', '123456', 2),
(16, 'Jesús Fidel Peinado Váldes', 'Mexicano', 'Mazatlán', '1998-12-31', 19, 'pichon@gmail.com', '123456', 2),
(17, 'Jesús Alfonso Pérez Quiñonez', 'Mexicano', 'Mazatlán', '1998-09-17', 19, 'ponshido@gmail.com', '123456', 2),
(18, 'Itzel Guadalupe Rendón Coronel', 'Mexicana', 'Mazatlán', '1998-10-14', 19, 'itzel@gmail.com', '123456', 2),
(19, 'Erick Medina Ramírez', 'Mexicano', 'Mazatlán', '1998-07-07', 19, 'Erick@gmail.com', '123456', 2),
(20, 'Jorge Armando Jaramillo Osuna', 'Mexicano', 'Mazatlán', '1998-06-30', 19, 'jarashido@gmail.com', '123456', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipaje`
--

CREATE TABLE `equipaje` (
  `idEquipaje` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVuelo` int(11) DEFAULT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `Peso` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `equipaje`
--

INSERT INTO `equipaje` (`idEquipaje`, `idCliente`, `idVuelo`, `Tipo`, `Peso`) VALUES
(1, 1, 2, 'Ligero', '5kg'),
(2, 2, 3, 'Pesado', '40kg'),
(3, 3, 4, 'Fragil', '7kg'),
(4, 4, 5, 'Pesado', '50kg'),
(5, 5, 6, 'Pesado', '50kg'),
(6, 6, 7, 'Fragil', '15kg'),
(7, 7, 8, 'Ligero', '20kg'),
(8, 8, 9, 'Ligero', '10kg'),
(9, 9, 2, 'Ligero', '10kg'),
(10, 10, 2, 'Fragil', '7kg'),
(11, 11, 12, 'Pesado', '40kg'),
(12, 12, 13, 'Pesado', '60kg'),
(13, 13, 14, 'Liviano', '20kg'),
(14, 14, 15, 'Liviano', '10kg'),
(15, 15, 16, 'Fragil', '14kg'),
(16, 16, 17, 'Pesado', '50kg'),
(17, 17, 18, 'Pesado', '50kg'),
(18, 18, 19, 'Ligero', '25kg'),
(19, 19, 20, 'Fragil', '17kg'),
(20, 20, 21, 'Pesado', '55kg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escalas`
--

CREATE TABLE `escalas` (
  `idVuelo` int(11) NOT NULL,
  `idEscalas` int(11) NOT NULL,
  `Ciudad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `escalas`
--

INSERT INTO `escalas` (`idVuelo`, `idEscalas`, `Ciudad`) VALUES
(3, 1, 'Los Ángeles'),
(5, 5, 'Seattle');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ficha`
--

CREATE TABLE `ficha` (
  `NumBoleto` int(11) NOT NULL,
  `Total` decimal(10,0) DEFAULT NULL,
  `NumFicha` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ficha`
--

INSERT INTO `ficha` (`NumBoleto`, `Total`, `NumFicha`) VALUES
(2, '10540', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ida`
--

CREATE TABLE `ida` (
  `idVuelo` int(11) NOT NULL,
  `FechaIda` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ida`
--

INSERT INTO `ida` (`idVuelo`, `FechaIda`) VALUES
(2, '2018-03-15'),
(3, '2018-03-25'),
(4, '2018-03-28'),
(5, '2018-03-28'),
(6, '2018-03-28'),
(7, '2018-03-30'),
(8, '2018-03-30'),
(9, '2018-04-05'),
(10, '2018-04-04'),
(11, '2018-04-04'),
(14, '2018-04-18'),
(16, '2018-04-20'),
(17, '2018-04-20'),
(18, '2018-04-20'),
(20, '2018-03-23'),
(21, '2018-04-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `redondo`
--

CREATE TABLE `redondo` (
  `idVuelo` int(11) NOT NULL,
  `FechaIda` date DEFAULT NULL,
  `FechaVuelta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `redondo`
--

INSERT INTO `redondo` (`idVuelo`, `FechaIda`, `FechaVuelta`) VALUES
(12, '2018-03-16', '2018-03-30'),
(13, '2018-03-23', '2018-04-16'),
(15, '2018-03-26', '2018-04-30'),
(19, '2018-03-19', '2018-04-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacion`
--

CREATE TABLE `reservacion` (
  `idCliente` int(11) NOT NULL,
  `idVuelo` int(11) DEFAULT NULL,
  `idBoleto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `reservacion`
--

INSERT INTO `reservacion` (`idCliente`, `idVuelo`, `idBoleto`) VALUES
(9, 2, 1),
(10, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `NumBoleto` int(11) NOT NULL,
  `Folio` varchar(45) DEFAULT NULL,
  `Total` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`NumBoleto`, `Folio`, `Total`) VALUES
(2, 'MAZMEX123HM90', '10540');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tripulacion`
--

CREATE TABLE `tripulacion` (
  `idTripulacion` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Puesto` varchar(45) DEFAULT NULL,
  `idVuelo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tripulacion`
--

INSERT INTO `tripulacion` (`idTripulacion`, `Nombre`, `Puesto`, `idVuelo`) VALUES
(1, 'José Sanchez', 'Piloto', 3),
(2, 'María Martínez', 'Azafata', 3),
(3, 'David Gonzalez', 'Copiloto', 3),
(4, 'Angelica', 'Azafata', 3),
(5, 'Sandra', 'Azafata', 3),
(6, 'Juan Saucedo', 'Piloto', 4),
(7, 'Emilio Serna', 'Copiloto', 4),
(8, 'Agustina Lara', 'Azafata', 4),
(9, 'Veronica Bedolla', 'Azafata', 4),
(10, 'Martha Medina', 'Azafata', 4),
(11, 'Javier Guzman', 'Piloto', 5),
(12, 'Ernesto Mayorquin', 'Copiloto', 5),
(13, 'Adilene Lopez', 'Azafata', 5),
(14, 'Ariana Martinez', 'Azafata', 5),
(15, 'Lupita Rojas', 'Azafata', 5),
(16, 'Hugo Peralta', 'Piloto', 7),
(17, 'Diego Azcona', 'Copiloto', 7),
(18, 'Cecia Morena', 'Azafata', 7),
(19, 'Linda Navarro', 'Azafata', 7),
(20, 'Esparza Tirado', 'Azafata', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idFicha` int(11) DEFAULT NULL,
  `idTarjeta` int(11) DEFAULT NULL,
  `idNombre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idFicha`, `idTarjeta`, `idNombre`) VALUES
(2, NULL, 9),
(NULL, 2, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `idVuelo` int(11) NOT NULL,
  `CiuOrigen` varchar(45) DEFAULT NULL,
  `CiuDestino` varchar(45) DEFAULT NULL,
  `idEscalas` int(11) DEFAULT NULL,
  `idTripulacion` int(11) DEFAULT NULL,
  `Fecha` date NOT NULL,
  `HoraSalida` time DEFAULT NULL,
  `HoraLlegada` time DEFAULT NULL,
  `Tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`idVuelo`, `CiuOrigen`, `CiuDestino`, `idEscalas`, `idTripulacion`, `Fecha`, `HoraSalida`, `HoraLlegada`, `Tipo`) VALUES
(2, 'Mazatlán', 'México', NULL, NULL, '2018-03-22', '07:30:00', '09:30:00', 1),
(3, 'Mazatlán', 'Nueva York', 3, NULL, '2018-03-31', '10:15:00', '17:40:00', 1),
(4, 'Mazatlán', 'Nueva York', NULL, NULL, '2018-03-30', '06:11:00', '10:30:00', 1),
(5, 'Mazatlán', 'Montreal', 5, NULL, '0000-00-00', '03:30:00', '15:30:00', 1),
(6, 'Guadalajara', 'Mazatlán', NULL, NULL, '0000-00-00', '01:00:00', '13:30:00', 1),
(7, 'Mazatlán', 'Ciudad de México', NULL, NULL, '0000-00-00', '10:00:00', '14:00:00', 1),
(8, 'Mazatlán', 'Durango', NULL, NULL, '0000-00-00', '08:00:00', '16:12:00', 1),
(9, 'Oregon', 'Mazatlán', 3, NULL, '0000-00-00', '06:19:00', '11:17:00', 1),
(10, 'Mazatlán', 'Mérida', NULL, NULL, '0000-00-00', '09:39:00', '12:20:00', 1),
(11, 'Mazatlán', 'Moscú', NULL, NULL, '0000-00-00', '03:13:00', '16:30:00', 1),
(12, 'Florida', 'Mazatlán', 3, NULL, '0000-00-00', '12:00:00', '14:40:00', 2),
(13, 'Nueva York', 'Mazatlán', NULL, NULL, '0000-00-00', '12:25:00', '19:50:00', 2),
(14, 'Guadalajara', 'Mazatlán', NULL, 3, '0000-00-00', '15:00:00', '17:30:00', 1),
(15, 'Moscú', 'Mazatlán', NULL, 3, '0000-00-00', '06:40:00', '10:50:00', 2),
(16, 'Mérida', 'Mazatlán', NULL, 3, '0000-00-00', '08:00:00', '12:00:00', 1),
(17, 'Mazatlán', 'Oregon', 3, 3, '0000-00-00', '11:00:00', '16:10:00', 1),
(18, 'Mazatlán', 'Florida', 3, 3, '0000-00-00', '16:50:00', '20:10:00', 1),
(19, 'Canada', 'Mazatlán', 5, 3, '0000-00-00', '08:00:00', '10:00:00', 2),
(20, 'Mazatlán', 'Canada', 5, 3, '0000-00-00', '06:40:00', '08:50:00', 1),
(21, 'Montreal', 'Mazatlán', 5, 3, '0000-00-00', '13:00:00', '15:30:00', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD KEY `idVuelo_idx` (`idVuelo`);

--
-- Indices de la tabla `boleto`
--
ALTER TABLE `boleto`
  ADD PRIMARY KEY (`NumBoleto`),
  ADD KEY `idCliente_idx` (`idCliente`),
  ADD KEY `idVuelo` (`idVuelo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `equipaje`
--
ALTER TABLE `equipaje`
  ADD PRIMARY KEY (`idEquipaje`),
  ADD KEY `idCliente_idx` (`idCliente`),
  ADD KEY `idVuelo_idx` (`idVuelo`);

--
-- Indices de la tabla `escalas`
--
ALTER TABLE `escalas`
  ADD PRIMARY KEY (`idEscalas`),
  ADD KEY `idVuelo` (`idVuelo`);

--
-- Indices de la tabla `ficha`
--
ALTER TABLE `ficha`
  ADD PRIMARY KEY (`NumBoleto`);

--
-- Indices de la tabla `ida`
--
ALTER TABLE `ida`
  ADD PRIMARY KEY (`idVuelo`);

--
-- Indices de la tabla `redondo`
--
ALTER TABLE `redondo`
  ADD PRIMARY KEY (`idVuelo`);

--
-- Indices de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `idVuelo_idx` (`idVuelo`),
  ADD KEY `idBoleto_idx` (`idBoleto`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`NumBoleto`);

--
-- Indices de la tabla `tripulacion`
--
ALTER TABLE `tripulacion`
  ADD PRIMARY KEY (`idTripulacion`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD KEY `fk_Ventas_Ficha1_idx` (`idFicha`),
  ADD KEY `fk_Ventas_Tarjeta1_idx` (`idTarjeta`),
  ADD KEY `idNombre` (`idNombre`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`idVuelo`),
  ADD KEY `idEscalas_idx` (`idEscalas`),
  ADD KEY `idTripulacion_idx` (`idTripulacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boleto`
--
ALTER TABLE `boleto`
  MODIFY `NumBoleto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `equipaje`
--
ALTER TABLE `equipaje`
  MODIFY `idEquipaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `escalas`
--
ALTER TABLE `escalas`
  MODIFY `idEscalas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ficha`
--
ALTER TABLE `ficha`
  MODIFY `NumBoleto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ida`
--
ALTER TABLE `ida`
  MODIFY `idVuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `redondo`
--
ALTER TABLE `redondo`
  MODIFY `idVuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `NumBoleto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tripulacion`
--
ALTER TABLE `tripulacion`
  MODIFY `idTripulacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `idVuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `avion`
--
ALTER TABLE `avion`
  ADD CONSTRAINT `avion_ibfk_1` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `boleto`
--
ALTER TABLE `boleto`
  ADD CONSTRAINT `boleto_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `boleto_ibfk_2` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `equipaje`
--
ALTER TABLE `equipaje`
  ADD CONSTRAINT `equipaje_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `equipaje_ibfk_2` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `escalas`
--
ALTER TABLE `escalas`
  ADD CONSTRAINT `idVuelo` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ficha`
--
ALTER TABLE `ficha`
  ADD CONSTRAINT `ficha_ibfk_1` FOREIGN KEY (`NumBoleto`) REFERENCES `boleto` (`NumBoleto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ida`
--
ALTER TABLE `ida`
  ADD CONSTRAINT `ida_ibfk_1` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `redondo`
--
ALTER TABLE `redondo`
  ADD CONSTRAINT `redondo_ibfk_1` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD CONSTRAINT `reservacion_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `reservacion_ibfk_2` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `reservacion_ibfk_3` FOREIGN KEY (`idBoleto`) REFERENCES `boleto` (`NumBoleto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`NumBoleto`) REFERENCES `boleto` (`NumBoleto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idFicha`) REFERENCES `ficha` (`NumBoleto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`NumBoleto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`idNombre`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `idEscalas` FOREIGN KEY (`idEscalas`) REFERENCES `escalas` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idTripulacion` FOREIGN KEY (`idTripulacion`) REFERENCES `tripulacion` (`idTripulacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
