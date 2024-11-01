CREATE TABLE `tb_patrocinador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(150) NOT NULL,
  `id_equipe` bigint DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK59wxv8dh9cjsr36jpydtgltqx` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
