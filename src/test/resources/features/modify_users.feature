# language: es
Característica: Modificar usuarios
  como usuario de gorest
  quiero modificar información de usuarios
  para poder mantenerlos actualizados.

  Escenario: Modificar usuario exitosamente
    Dado que usuario admin registra usuario con datos correctos en la pagina
    Cuando modifica correctamente los datos del usuario
    Entonces el puede actualizar la información del usuario