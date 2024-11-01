CREATE TABLE `tb_coach` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `genero` varchar(150) NOT NULL,
  `id_equipe` bigint NOT NULL,
  `idade` int NOT NULL,
  `login` varchar(255) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1e897b7ec2wgpy13unsdhm9gp` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
