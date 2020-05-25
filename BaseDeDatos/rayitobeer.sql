-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 25-05-2020 a las 03:51:13
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rayitobeer`
--
CREATE DATABASE IF NOT EXISTS `rayitobeer` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci;
USE `rayitobeer`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `IdReceipt` int(5) NOT NULL,
  `Amount` float(6,2) NOT NULL,
  `CurrentBox` float(7,2) NOT NULL,
  `FinalBox` float(7,2) NOT NULL,
  `TransactionDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comidas`
--

CREATE TABLE `comidas` (
  `IdFood` int(3) UNSIGNED ZEROFILL NOT NULL,
  `Name` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Type` int(2) NOT NULL,
  `Stock` int(3) DEFAULT NULL,
  `Price_Unit` float(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `comidas`
--

INSERT INTO `comidas` (`IdFood`, `Name`, `Type`, `Stock`, `Price_Unit`) VALUES
(001, 'Agua 1/2 L', 1, 26, 0.50),
(002, 'Agua 1 L', 1, 29, 1.00),
(003, 'Coca Cola', 1, 72, 1.20),
(004, 'Fanta Naranja', 1, 72, 1.20),
(005, 'Fanta Limón', 1, 71, 1.20),
(006, 'Nestea', 1, 30, 1.50),
(007, 'Aquarius', 1, 30, 1.50),
(008, 'Tinto Verano', 1, 30, 1.50),
(009, 'Caña', 2, 100, 1.10),
(010, 'Tubo', 2, 100, 1.20),
(011, '3/5', 2, 100, 1.50),
(012, 'Cerv Vaso Sidra', 2, 100, 1.80),
(013, 'Jarra Fría', 2, 100, 2.00),
(014, 'Frizzante', 3, 40, 1.50),
(015, 'Árabe', 3, 40, 1.50),
(016, 'Marques de Victoria', 4, 40, 1.80),
(017, 'Ramón Bilbao', 4, 40, 2.50),
(018, 'Ramón Bilbao Verdejo', 5, 40, 2.50),
(019, 'Javier Sanz Verdejo', 5, 30, 3.00),
(020, 'La Guita', 6, 49, 1.50),
(021, 'Barbariana', 6, 46, 1.50),
(022, 'Tío Pepe', 6, 47, 2.00),
(023, 'Ensaladilla Rusa', 7, 30, 2.50),
(024, 'Ensaladilla Pulpo', 7, 30, 2.50),
(025, 'Papas aliñas', 7, 40, 2.50),
(026, 'Papa alioli', 7, 40, 2.50),
(027, 'Coctel marisco', 7, 30, 3.00),
(028, 'Salpicón de marisco', 7, 30, 2.50),
(029, 'Jamón', 8, 60, 8.00),
(030, 'Queso', 8, 40, 7.00),
(031, 'Caña de lomo', 8, 40, 7.00),
(032, 'Surtido Ibérico', 8, 50, 12.50),
(033, 'Gambas', 9, 40, 9.00),
(034, 'Gambones', 9, 45, 10.00),
(035, 'Lubina', 10, 20, 12.00),
(036, 'Adobo', 10, 60, 6.00),
(037, 'Chocos', 10, 60, 6.00),
(038, 'Puntillitas', 10, 40, 5.00),
(039, 'Pez espada', 10, 40, 7.00),
(040, 'Chipirones', 10, 60, 5.00),
(041, 'Solomillo', 11, 40, 7.00),
(042, 'Presa', 11, 30, 11.00),
(043, 'Lagartito', 11, 30, 9.00),
(044, 'Venado', 11, 30, 13.00),
(045, 'Novillo Argentino', 11, 20, 14.00),
(046, 'Magret Pato', 11, 23, 15.00),
(047, 'Paella', 12, 10, 6.00),
(049, 'Tarta 3 chocolates', 13, 20, 4.50),
(050, 'Tarta galletas', 13, 20, 4.50),
(051, 'Flan casero', 13, 16, 3.50),
(052, 'Natilla', 13, 20, 3.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `IdTable` int(3) NOT NULL,
  `IdFood` int(3) UNSIGNED ZEROFILL NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Commentary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci,
  `Price` float(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE `recibos` (
  `IdReceipt` int(5) UNSIGNED ZEROFILL NOT NULL,
  `IdTable` int(3) NOT NULL,
  `IdUser` int(3) UNSIGNED ZEROFILL NOT NULL,
  `NameWaiter` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Price` float(6,2) NOT NULL,
  `TransactionDate` date NOT NULL,
  `WayToPay` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `IdUser` int(3) UNSIGNED ZEROFILL NOT NULL,
  `First_name` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Last_name` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Date_of_birth` date NOT NULL,
  `DNI` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Number_tlf` int(9) NOT NULL,
  `Registered_day` date NOT NULL,
  `Password` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Rol` int(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`IdUser`, `First_name`, `Last_name`, `Date_of_birth`, `DNI`, `Number_tlf`, `Registered_day`, `Password`, `Rol`) VALUES
(001, 'Enrique', 'Rapela Castejon', '1997-02-12', '48120363Q', 655427365, '2020-04-28', 'admin123', 101),
(018, 'Gabriel', 'Super Programador', '3893-03-17', '12345678A', 656747838, '2020-05-22', '1234', 101);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comidas`
--
ALTER TABLE `comidas`
  ADD PRIMARY KEY (`IdFood`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD KEY `FK_FOODS` (`IdFood`);

--
-- Indices de la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD PRIMARY KEY (`IdReceipt`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comidas`
--
ALTER TABLE `comidas`
  MODIFY `IdFood` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `IdReceipt` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  MODIFY `IdUser` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
