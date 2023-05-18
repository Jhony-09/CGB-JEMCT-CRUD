---------------------------------------------------------- ACTUALIZACIONES -----------------------------------------------------

---------------------------RECOMENDACION-----------------------
Para visualizar una fila mayor de componentes porfavor ejecute el script para crear la base de datos y la tabla, tambien se
adjunta una lista de componentes para agregarlas a la tabla.
-----------------------------------------------------------------

------------------------------------------------------ AGREGADO -----------------------------------------------
En el método openNew() del bean ComponenteView, se inicializaron correctamente los campos del objeto selectedComponente. 
Ahora, los campos nombreComp, descripcionComp, precioComp y stockComp se establecen con valores predeterminados adecuados.

Se agregó el atributo required="true" al campo name en el formulario de creación y edición de componentes. 
Esto garantiza que el campo debe ser completado antes de enviar el formulario.

Se utilizó el atributo update="manage-product-content" en el botón "Save" del formulario. 
Esto permite actualizar el contenido del diálogo de administración del componente después de guardar los cambios, mostrando así los datos actualizados del componente guardado.


----------------------------------------- ERRORES SOLUCIONADOS ---------------------------------------------------------
Se a solucionado el error que impedia eliminar una lista de componentes seleccionados.
Se a solucionado el error que impedia eliminar solamente un componente.

--------------------------------------- ERRORES FALTANTES POR SOLUCIONAR --------------------------------------------------
Hace falta solucionar el error que impide editar un componente existente.
Hace falta solucionar el error que impide que los datos llenados al crear un nuevo componente se envíe correctamente.