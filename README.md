# PROJETO
  API de gerenciamento de abastecimentos e tanques de combustíveis do posto ABCD.
  
# REQUISITOS
- Repositório Front-End da aplicação: https://github.com/adautomoises/controle-posto-front
- Spring Boot 3.1.8
- Instalar dependências MAVEN
- JAVA 17
 
![image](https://github.com/adautomoises/controle-posto-back/assets/74927238/840ea0e4-ceed-4b8e-a6b0-92718b2c24b2)

# DOCUMENTAÇÃO
- SWAGGER: http://localhost:8080/swagger-ui/index.html

# INFORMAÇÕES ADICIONAIS
  Faz-se necessário criar um banco de dados com o nome "postoabcd".

  No arquivo application.properties, há duas coisas para substituir, sendo a primeira a senha do seu SGBD (SUA-SENHA-AQUI) e a segunda uma chave secreta para codificação do token (SUA-CHAVE-AQUI).

  O relatário vai ser gerado como um PDF (abastecimentos.pdf) dentro da pasta resources do projeto.
  
  Um usuário "Gerente" foi inserido no banco.
  - Usuário: admin
  - Senha: admin
    
  Há necessidade de cadastrar um usuário "Frentista"  para realizar um abastecimento.
