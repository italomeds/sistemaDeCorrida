CREATE TABLE `tb_espectador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(150) NOT NULL,
  `genero` varchar(150) NOT NULL,
  `idade` int NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4242vhr359dx75m05d6xa2kna` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
