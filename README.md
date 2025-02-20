# InviteUs - Home Invitation System


<img src="https://github.com/user-attachments/assets/83eb49b7-cb80-4073-9cb6-a1fde5f1ddb4" alt="InviteUs" width="400"/>

## Resumo do Projeto
InviteUs é uma API para gerenciamento de convites residenciais, como acesso a condomínios e apartamentos. O anfitrião gera um convite, e o convidado se cadastra pelo link associado ao ID do convite. O objetivo é tornar a organização de eventos mais prática, intuitiva e acessível.


## Abstract
Project: InviteUs - Home Invitation System
<br>The InviteUs API is designed to simplify residential invitations, such as entry into condominiums, apartments, and other restricted-access locations. A host generates an invitation, and the guest registers through a link that associates their information with the invitation ID. The goal is to facilitate event organization while ensuring a user-friendly and intuitive experience.
 
## 📝 UML
![image](https://github.com/user-attachments/assets/63ef510b-ff80-41a7-9cf1-583c27cc012b)


## Regras de Negócio
O convite é excluído do banco após 12 horas e um convidado pode ter apenas um convite simultaneamente, um anfitrião pode convidar até 15 pessoas semanalmente.

Regras de negócio:

Cada anfitrião tem um total de 15 convites por semana.

Um convite é criado temporariamente com validade de 12 horas a partir do momento em que é gerado.

Após 12 horas, o convite expira automaticamente e é contabilizado no limite semanal.

O limite é resetado automaticamente todo domingo à meia-noite.

O convite deve ser excluído do banco em 12 horas.

Um convidado pode ter apenas um convite simultaneamente.





## Autor / Author
<h3>Filipe Batista Ferreira 🎸 </h3> 

## ✔️ Técnicas e Tecnologias Utilizadas / Framework and Technologies

- **Java 21**
- **Intellij IDE**
- **Spring Framework**
- **Spring Data JPA**
- **Flyway**
- **Maven**
- **MySQL**
- **Programação Orientada a Objetos  OOP** 
