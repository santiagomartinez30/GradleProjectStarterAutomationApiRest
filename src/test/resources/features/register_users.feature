# language: es
Característica: Registro de usuarios
  como usuario de gorest
  quiero registrar usuarios
  para poder darlos de alta en la pagina.

  Escenario: Registro de usuario exitoso
    Dado que usuario admin ingresa datos correctos de usuario
    Entonces el puede registrar usuario en la pagina

  Escenario: Registro de usuario con datos incorrectos
    Dado que usuario admin ingresa datos incorrectos de usuario
    Entonces el no puede registrar usuario en la pagina con datos incorrectos

  Escenario: Registro de usuario con datos existentes
    Dado que usuario admin ingresa datos existentes de usuario
    Entonces el no puede registrar usuario en la pagina con datos existentes