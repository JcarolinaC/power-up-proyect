INSERT INTO `person` (
    `id`,
    `name`,
    `lastname`,
    `email`,
    `phone`,
    `birthday`,
    `dni_number`,
    `password`,
    `idRole`,
  )
VALUES
  (
    '1',
    'Carolina',
    'Giraldo',
    'carol@gmail.com',
    '+3113985742',
    '1998-05-01',
    '123',
    '$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S',
    '1',
  );


INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'ROLE_OWNER', 'ROLE_OWNER');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('3', 'ROLE_EMPLOYEE', 'ROLE_EMPLOYEE');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('4', 'ROLE_CLIENT', 'ROLE_CLIENT');


INSERT INTO `user` (`id_person`, `id_role`) VALUES ('1', '1');