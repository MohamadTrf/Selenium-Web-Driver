# Selenium-Web-Driver
Automatizando testes para uma aplicação real com selenium webDriver(Java)


--Como configurar o selenium GRID

Acesso o Link:http://selenium-release.storage.googleapis.com/index.html?path=3.4/

Faça o  downoload do selenium-server-standalone

Abra um terminal na pasta onde você guardou o arquivo baixado.

Execute o seguinte comando no terminal:
java -jar selenium-server-standalone-3.4.0.jar -role hub

esse comando irá deixar seu Grid "Online"

Verifique se executou seu grid atráves do localhost com  a porta do mesmo

Para conectar uma máquina ao grid abra outro terminal na pasta onde está o arquivo 
e execute o seguinte comando:

java -jar selenium-server-standalone-3.4.0.jar -role node

Para conectar outras máquinas o processo é o mesmo, em caso de problemas você deve adicionar a porta da sua máquina

Exemplo: java -jar selenium-server-standalone-3.4.0.jar -role node -port sua porta

