DESCRIÇÃO GERAL

Este aplicativo Android foi desenvolvido para gerenciar alunos, treinos e exercícios de uma academia. Ele utiliza o Room Database para persistência local dos dados, 
com relacionamentos entre as entidades e operações CRUD completas.


ENTIDADES

A entidade Aluno representa o aluno cadastrado na academia. Ela possui os campos id, que é a chave primária e identifica o aluno de forma única, nome, que armazena 
o nome do aluno, e idade, que indica a idade. Um aluno pode ter vários treinos associados, configurando assim uma relação de um para muitos (1:N) entre Aluno e Treino.

A entidade Treino representa o plano de treino definido para cada aluno. Ela contém os campos id, que é a chave primária, nome, que identifica o treino, objetivo, que 
descreve a finalidade do treino (como hipertrofia, resistência, emagrecimento, etc.), e alunoId, que é a chave estrangeira referenciando o aluno responsável por aquele treino. 
Cada treino pertence a um único aluno, mas pode conter vários exercícios, estabelecendo relações do tipo muitos para um (N:1) com Aluno e um para muitos (1:N) com Exercicio.

A entidade Exercicio representa cada exercício pertencente a um treino. Ela inclui os campos id como chave primária, nome para o nome do exercício, grupoMuscular que indica 
o grupo muscular trabalhado e treinoId, que é a chave estrangeira referenciando o treino ao qual o exercício pertence. Cada exercício está vinculado a apenas um treino, 
configurando uma relação de muitos para um (N:1).


FUNCIONALIDADES CRUD

O sistema permite o cadastro, listagem, edição e exclusão de registros para as entidades Aluno, Treino e Exercicio. É possível cadastrar novos alunos, associar treinos a esses alunos 
e, dentro de cada treino, adicionar exercícios. Dessa forma, o aplicativo oferece um gerenciamento completo das informações da academia, mantendo a estrutura relacional entre os dados.

