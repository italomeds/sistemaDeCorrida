CREATE TABLE `tb_corredor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `genero` varchar(150) NOT NULL,
  `id_equipe` bigint DEFAULT NULL,
  `idade` int NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7o3fa5gi0avmbh6y866pmtr80` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
