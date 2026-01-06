# Sistema de Cadastro – Desafios

Este projeto consiste em um sistema de cadastro de **usuários** e **desafios**, onde os desafios podem ser atribuídos a cada usuário de forma livre e personalizada.
Os desafios podem ser classificados por **níveis**, definidos pelo próprio usuário, dando total liberdade na criação. Por exemplo, é possível criar níveis como *“cereja”*, *“tamarino”* ou qualquer outro nome. Aqui, a criatividade é o limite.
Os usuários cadastrados devem conter **CPF** e **e-mail**, garantindo um controle mais rígido da quantidade de usuários no sistema e evitando duplicidades, tanto de CPF quanto de e-mail.
---
## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes ferramentas:

- **Spring Boot** – utilizado como API principal, estruturando todo o sistema voltado para uso web  
- **H2 Database** – banco de dados simples, ideal para testes e desenvolvimento  
- **Thymeleaf** – responsável pela criação e renderização das páginas HTML  
- **Swagger** – utilizado para documentar as funcionalidades e endpoints da aplicação  
---
## Linguagens Utilizadas

- **Java**
- **HTML**
- **CSS**
- **SQL**
---
## Considerações sobre o Projeto

O desenvolvimento foi propositalmente simples, pois o objetivo principal é servir como **projeto base** para futuras expansões. A partir dele, é possível evoluir para algo maior ou manter a simplicidade, dependendo da necessidade.
Algumas possibilidades de expansão incluem:

- Sistema de pontuação entre desafios  
- Cadastro de alunos e controle de provas realizadas  
- Ranking ou níveis de progressão  
- Integração com outros bancos de dados  

Durante todo o projeto, houve uma preocupação constante com o **essencial**, principalmente em relação à **segurança e organização do código**. O sistema segue o padrão **CRUD**, com separação clara de camadas, uso de **DTOs** e evitando o acesso direto do usuário ao banco de dados, reduzindo conflitos e melhorando a manutenção.
No geral, o projeto foi pensado para ser uma **base sólida**, fácil de entender, manter e evoluir para soluções mais complexas no futuro.
---
## Contato

📧 **ayrton.souzaprofissional@gmail.com**
