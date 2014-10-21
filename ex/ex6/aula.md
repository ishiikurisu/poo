# Interfaces

Possibilitam uma abstração para classes que podem variar muito quanto ao uso.
É usada em classes abstratas. Classes abstratas não são expandidas; são
implementadas. O uso de interfaces representam decisões que não devem mudar
muito; ela é um contrato, pois somente possui as assinaturas dos métodos
que serão implementados pelas classes concretas. São usadas no padrão de
projeto "Bridge". Com as classes, agrupações definições de métodos, atributos,
construtores, tipos, etc.

# Pacotes

Agrupam definições de classes e interfaces relacionadas. Estruturam sistemas
extensos, facilitando a localização das classes e interfaces. Oferecem um nível
mais alto de abstração: há mais classes do que pacotes.

Existe uma relação entre pacotes e diretórios: cada pacote é associado a um
diretório do sistema operacional. Subdiretórios não correspondem a subpacotes.

Pacotes são definidos usando o mesmo cabeçalho em todas as classes do pacote.
O nome do pacote é parte do nome do seu diretório associado. Pacotes também
possuem modificadores de acesso. As declarações feitas em um arquivo são
visíveis em qualquer outro arquivo do mesmo pacote, a menos que elas sejam
privadas. Qualquer arquivo em um pacote pode usar definições visíveis de outros
pacotes através do mecanismo de importação de pacotes.

Existem pacotes na biblioteca padrão do Java, como os pacotes net, applet, awt,
swing, rmi, sql, lang, io e util.

Importação
----------

Em Java, usamos a keyword import.

Ela permite que usemos o nome curto de uma classe em outro pacote, desde que
não haja dentro deste uma classe com o mesmo nome caso a importação tenha sido
específica.

A importação explícita tem precedência com relação à implícita.

Estruturação
------------

Agrupar classes relacionadas com dependência entre as mesmas. Evitar dependência
mútua entre pacotes.

Em geral, temos vários pacotes para a interface com o usuário; um pacote para as
classes de negócio; para a classe fachada; para a classe de exceções; e para as
classes auxiliares de propósito geral. Por outro lado, podemos ter decomposições
verticais, que lidam mais conceitos. Este tipo de decomposição é mais usada em
projetos incrementais.
