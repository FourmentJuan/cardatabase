Para configurar la base de datos de MySQL ejecutar estos comandos

SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';
SELECT @@global.time_zone, @@session.time_zone;