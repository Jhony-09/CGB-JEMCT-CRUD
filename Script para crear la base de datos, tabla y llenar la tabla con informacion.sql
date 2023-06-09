Create database cgbjemct;

use cgbjemct;

CREATE TABLE componentes (
    ID_COMP INT NOT NULL AUTO_INCREMENT,
    NOMBRE_COMP VARCHAR(50),
    DESCRIPCION_COMP VARCHAR(100),
    PRECIO_COMP DECIMAL(8,2),
    STOCK_COMP INT,
    PRIMARY KEY (ID_COMP)
);


INSERT INTO componentes (NOMBRE_COMP, DESCRIPCION_COMP, PRECIO_COMP, STOCK_COMP)
VALUES
('Procesador Intel Core i5', 'Procesador de 6 núcleos para computadoras de escritorio', 250.00, 30),
('Procesador AMD Ryzen 7', 'Procesador de 8 núcleos para computadoras de escritorio', 300.00, 40),
('Memoria RAM DDR4 8GB', 'Memoria RAM de alta velocidad para computadoras de escritorio', 80.00, 80),
('Memoria RAM DDR4 32GB', 'Memoria RAM de alta capacidad para computadoras de escritorio', 250.00, 60),
('Disco duro HDD 1TB', 'Disco duro convencional de 1TB para almacenamiento de datos', 50.00, 100),
('Disco duro SSD 1TB', 'Disco duro de estado sólido de alta velocidad para almacenamiento de datos', 150.00, 50),
('Tarjeta gráfica NVIDIA GeForce GTX 1660', 'Tarjeta gráfica de gama media para juegos y edición de video', 300.00, 60),
('Tarjeta gráfica AMD Radeon RX 6800', 'Tarjeta gráfica de alta gama para juegos y renderización de video', 900.00, 20),
('Monitor LED 24"', 'Monitor de 24 pulgadas con tecnología LED', 150.00, 30),
('Monitor LED 27"', 'Monitor de 27 pulgadas con tecnología LED', 200.00, 25),
('Teclado mecánico', 'Teclado con interruptores mecánicos para mayor precisión y durabilidad', 80.00, 50),
('Mouse inalámbrico', 'Mouse óptico inalámbrico con tecnología Bluetooth', 40.00, 70),
('Altavoces 2.1', 'Sistema de altavoces estéreo 2.1 para computadoras', 50.00, 80),
('Impresora multifuncional', 'Impresora con funciones de impresión, escaneo y copiado', 100.00, 40),
('Cámara web HD', 'Cámara web de alta definición para videoconferencias', 60.00, 50),
('Fuente de poder 600W', 'Fuente de poder de 600W para computadoras de escritorio', 70.00, 30),
('Gabinete ATX', 'Gabinete de torre mediana para computadoras de escritorio', 80.00, 40),
('Ventilador de CPU', 'Ventilador de enfriamiento para procesadores de computadoras', 30.00, 60),
('Disipador de calor', 'Disipador de calor para tarjetas gráficas de alta potencia', 50.00, 50),
('Placa base AMD AM4', 'Placa base compatible con procesadores AMD AM4', 120.00, 30),
('Placa base Intel LGA1200', 'Placa base compatible con procesadores Intel LGA1200', 150.00, 25),
('Router Wi-Fi AC', 'Router inalámbrico de alta velocidad con tecnología Wi-Fi AC', 80.00, 35),
('Tarjeta de red Ethernet Gigabit', 'Tarjeta de red Ethernet con velocidad de 1 Gbps', 20.00, 60),
('Pendrive USB 3.0 32GB', 'Memoria USB de alta velocidad con capacidad de 32GB', 25.00, 70),
('Pendrive USB 3.0 128GB', 'Memoria USB de alta velocidad con capacidad de 128GB', 60.00, 40),
('Monitor curvo 32"', 'Monitor curvo de 32 pulgadas con tecnología LED', 350.00, 20),
('Monitor gaming 144Hz', 'Monitor de alta frecuencia de actualización para juegos', 250.00, 30),
('Teclado retroiluminado', 'Teclado con iluminación LED personalizable', 100.00, 45),
('Mouse gaming', 'Mouse óptico con botones programables para juegos', 60.00, 50),
('Auriculares inalámbricos', 'Auriculares inalámbricos con cancelación de ruido', 120.00, 30),
('Micrófono USB', 'Micrófono de condensador con conexión USB', 80.00, 40),
('Tarjeta de sonido externa', 'Tarjeta de sonido USB para mejorar la calidad de audio', 50.00, 50),
('Disco duro externo 1TB', 'Disco duro portátil de 1TB para almacenamiento externo', 70.00, 35),
('Disco duro externo 2TB', 'Disco duro portátil de 2TB para almacenamiento externo', 100.00, 25),
('Lector de tarjetas de memoria', 'Lector USB para tarjetas de memoria SD y microSD', 15.00, 80),
('Batería de respaldo', 'Batería externa para dispositivos móviles', 40.00, 60),
('Cargador USB de pared', 'Cargador de pared con puertos USB para dispositivos móviles', 20.00, 90),
('Adaptador HDMI a VGA', 'Adaptador para convertir señal HDMI a VGA', 15.00, 50),
('Cable de red Ethernet 5m', 'Cable de red Ethernet de 5 metros', 10.00, 100),
('Cable HDMI 2.0 2m', 'Cable HDMI de alta velocidad de 2 metros', 12.00, 80),
('Cable USB 3.0 1m', 'Cable USB de alta velocidad de 1 metro', 8.00, 120),
('Funda para portátil 15"', 'Funda protectora para portátiles de 15 pulgadas', 20.00, 50),
('Maletín para portátil 17"', 'Maletín acolchado para portátiles de 17 pulgadas', 30.00, 40),
('Silla ergonómica', 'Silla de escritorio ergonómica con ajustes de altura y respaldo', 150.00, 20),
('Escritorio de computadora', 'Escritorio amplio para computadoras de escritorio', 200.00, 15),
('Lámpara de escritorio LED', 'Lámpara de escritorio con iluminación LED regulable', 40.00, 30),
('Organizador de cables', 'Organizador de cables para mantener el escritorio ordenado', 10.00, 80),
('Base para portátil ajustable', 'Base ajustable para elevar la pantalla del portátil', 25.00, 60),
('Kit de limpieza de computadora', 'Kit de limpieza para mantener la computadora en buen estado', 15.00, 70),
('Software antivirus', 'Software de protección contra virus y malware', 50.00, 50),
('Licencia de Microsoft Office', 'Licencia para utilizar Microsoft Office en la computadora', 100.00, 30),
('Juego de teclas para teclado mecánico', 'Set de teclas adicionales para personalizar teclados mecánicos', 30.00, 40),
('Tarjeta de captura de video', 'Tarjeta para grabar y transmitir video desde la computadora', 80.00, 25);
