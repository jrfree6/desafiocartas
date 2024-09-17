# Bem Vindo ao Desafio das Cartas

**Requisitos**

```sh
 -Java 17
 -Git
 -Docker
```

### Instruções

**Clonando o projeto**
```sh
git clone https://github.com/jrfree6/desafiocartas.git
```
**Gerar o Package**
```sh
cd desafiocartas
mvn clean package
```

**Construir a imagem docker**
```sh
docker build -t desafiocartas:latest .
```
**Rodar o container**
```sh
docker run -p 8080:8080 desafiocartas:latest
```
**Acesso ao endpoint**
http://localhost:8080/api/cartas/deal

**H2 Database**
Acessível apenas se rodar fora do container
Configurado: jdbc:h2:mem:testdb
