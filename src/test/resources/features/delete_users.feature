# language: es
Característica: Eliminar usuarios
  como usuario de gorest
  quiero eliminar usuarios
  para poder no conservar usuarios que no deban estar en el sistema.

  Escenario: Eliminar usuario exitosamente
    Dado que usuario admin obtiene aleatoreamente un usuario a eliminar
    Cuando elimina el usuario
    Entonces el puede confirmar la eliminación del usuario