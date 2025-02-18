InviteUs é uma API de convites residenciais como por exemplo entrada em condomínio, apartamentos e etc. Um anfitrião gera um convite e o convidado faz o cadastro pelo link vinculando o id do convite. O convite é excluído do banco após 12 horas e um convidado pode ter apenas um convite simultaneamente, um anfitrião pode convidar até 15 pessoas semanalmente.

Regras de negócio:

Cada anfitrião tem um total de 15 convites por semana.

Um convite é criado temporariamente com validade de 12 horas a partir do momento em que é gerado.

Após 12 horas, o convite expira automaticamente e é contabilizado no limite semanal.

O limite é resetado automaticamente todo domingo à meia-noite.

O convite deve ser excluído do banco em 12 horas.

Um convidado pode ter apenas um convite simultaneamente.
