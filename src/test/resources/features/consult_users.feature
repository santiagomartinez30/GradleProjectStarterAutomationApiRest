# language: es
Característica: Consulta de usuarios
  como usuario de gorest
  quiero consultar los diferentes usuarios
  para verificar su información

  Escenario: Consultar usuario existente
    Dado que usuario admin consulta un usuario por id 3523
    Entonces el puede obtener información de usuario

  Escenario: Consultar usuario no existente
    Dado que usuario admin consulta un usuario por id 9999
    Entonces el no puede obtener información de usuario