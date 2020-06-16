Prezados, boa tarde.

Segue abaixo algumas considerações sobre o projeto.
inicialmente agradeço muito pela oportunidade foi uma grande fonte de aprendizagem.
Iniciei o projeto na terça feira, e mesmo com algumas adversidades estou entregando a parte de front e back.

Qualquer dívida estou a disposição.


### OBSERVAÇÕES:  

1º - Não fiz os teste de banco, embora eu tenha tentado muito. Tive comproblemas com integração com o dropwizard(conheci o dropwizard  neste projeto).  


2º - Na parte de front, utilizei angular 9. Sei que como sugestão seria o angularJS. mas perdi um pouco de tempo com alguns problemas que enfrentei com DBuinit e dropWizard.  
	 Então, usei o angular 9 por ter um pouco mais de afinidade.


3º - Pensei em separar o atributo categoria em uma nova classe para organizar melhor o modelo. Mas não tive tempo.  



LINK BACK END:    https://github.com/JhonDonavan/Desafio_Produto_API_Back-End  

LINK FRONT END:   https://github.com/JhonDonavan/Desafio_Produto_API_Front-End 


ABAIXO SEGUE MAIORES DETALHES SOBRE A EXECUÇÃO DO PROJETO CASO PRECISEM.  


=======================================================  

### Parte BACK  
URL: https://github.com/JhonDonavan/Desafio_Produto_API_Back-End

Aplicação desenvolvida em dropwizard. Utilizei o maven para compilação.  

Ao realizar download no diretorio da aplicação rodar o comando 'MVN CLEAN INSTALL'.
Depois podem executar o comando 'java -jar target/ProdutoAPI-1.0-SNAPSHOT.jar db migrate  config.yml' para executar um script de banco de dados.
será necessário alterar as configurações de banco no arquivo config.yml, e logo en seguida rodar o comando 'java -jar target/ProdutoAPI-1.0-SNAPSHOT.jar serve  config.yml'
OBS: Usei o banco mysql.



### Endpoints

GET     /produtos  
POST    /produtos  
PUT     /produtos  
DELETE  /produtos/{id}  
GET     /produtos/{id}  
GET     /produtos/{categoria}  --> String com nome da categoria a ser pesquisada.  


=======================================================  


=======================================================  
### Parte  front:  
URL: https://github.com/JhonDonavan/Desafio_Produto_API_Front-End 

Para executar usar  comando NPM INSTALL e depois NG SERVE  
Provavelmente irá executar na port 4200.  

Aplicação está apontando para a http://8080/produtos/  

=======================================================    