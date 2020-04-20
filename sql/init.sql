CREATE USER 'derek'@'localhost' IDENTIFIED BY 'motorolamb525';
GRANT ALL PRIVILEGES ON kenba.* TO 'derek'@'localhost';

CREATE USER 'derek'@'172.19.0.3' IDENTIFIED BY 'motorolamb525';
GRANT ALL PRIVILEGES ON kenba.* TO 'derek'@'172.19.0.1';

CREATE USER 'derek'@'172.19.0.3' IDENTIFIED BY 'motorolamb525';
GRANT ALL PRIVILEGES ON kenba.* TO 'derek'@'172.19.0.3';