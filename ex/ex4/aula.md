Strings e arrays
================

Estes objetos já pertencem à biblioteca java.lang.*;

Tipos
-----

+ Primitivos
  + Booleanos
  + Numéricos
+ Referências
  + Classes
  + Strings
  + Arrays

Strings
-------

São sequências de caracteres. Em Java, são tratadas como objetos.

### Métodos

O operador + é usado para concatenação. Variáveis que não são strings são
promovidas quando há concatenação destes valores.

O método this.equals() diz se duas strings possuem o mesmo conteúdo. É diferente
de usar o operador ==, que diz se dois objetos possuem a mesma referência.
Também há o método this.equalsIgnoreCase().

Outros métodos: this.length() retorna o tamanho da string; this.toLowerCase() e
this.toUpperCase() retornam a string com todas as strings, ou com todas as
as letras em minúsculo ou em maiúsculo; this.trim() tira os espaços nas pontas
da string.

Para lidar com índices e substrings: this.indexOf(); this.substring();
this.charAt().

Arrays
------

São usados como em C. Declara-se como

    int[] arrayImplicito = new int[5];
    int[] arrayExplicito = {1, 2, 3, 4, 5};

Um array é uma sequência de elementos do mesmo tipo. Podem ser multidimensionais:

    long[][] x = {{1,0},{2,3},{4,5},{6,7,8},{9,0}};

Aqui também há acessos inválidos. Eles levantam o erro IndexOutOfBoundsException.

Arquitetura em Camadas
======================

É uma abordagem para estruturar aplicações

Benefícios
----------
+ Modularidade
+ Separação por conceitos
+ Facilidade de manutenção

Uma camada deve fornecer suporte para a camada de cima. Uma camada inferior abs-
trai detalhes das camadas superiores. Um estilo arquitetural comum é:

+ Interface
+ Comunicação
+ Negócio
+ Dados

Outros estilo incluem MVC, pipes and filters...
