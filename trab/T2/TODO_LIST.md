# TO DO LIST

+ [ ] Reestrutar as camadas superiores do programa.
  - Basicamente, esta tarefa consiste em reescrever a interface gráfica
    para poder ler a entrada e mostrar a saída para o usuário e implemetar
    a camada de fachada, cuja única função é chamar as classes de cadastro,
    pelo menos por enquanto.

+ [ ] Implementar o repositório baseado em arquivos.
  - Reescrever a classe Repositorio como uma classe abstrata.
  - Recriar as classes de repositório para que elas possam aceitar
    tanto arquivos como estruturas de dados não-persistentes (como
    se chamam mesmo?).
  - Criar um padrão para que possamos ler e escrever dados persistentes. Talvez
    seja uma boa ideia estudar um pouco de bancos de dados.
  - Podemos criar, para cada repositório, um arquivo específico.

+ [ ] Implementar exceções nas classes de repositórios e de cadastro.
  - Fazer com que a classe de interface gráfica lide com estas exceções.
  - Dúvida: quem deverá lidar com as exceções? Como elas deverão ser
    trabalhadas.

+ [ ] Aprender a usar o mecanismo de pacotes em Java.

+ [ ] Escrever o arquivo principal.
