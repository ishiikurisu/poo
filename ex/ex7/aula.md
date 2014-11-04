    HOLY FUCKING CRAP YOU SHOULDN'T BE SO STUPID

Ok, don't be so hard on yourself:

> "Coding is closest thing we have to a superpower"

+ Drew Houston

# Arquivos

São uma maneira de tornar os dados persistentes.

A classe File
-------------

    import java.io.File;
    new File(String pathname);

Ela contém facilidades para poder alcançar a portabilidade entre sistemas
operacionais na hora de lidar com arquivos.

Streams
-------

São sequências de bytes lidos de forma sequencial. São sempre associados a
uma fonte de dados.

Em mais baixo nível, um stream é um conjunto de bytes sendo escritos e lidos.
FileInputStream e FileOutputStream são streams de baixo nível em Java.

Em mais alto nível, um stream é um conjunto de dados organizado. Streams de alto
nível não escrevem em dispositivos de entrada e saída diretamente: suas
abstrações precisam ser traduzidos antes de serem escritas ou lidas.
Incluem DataOutputStream e DataInputStream em Java: elas pegam dados fornecidos
em alto nível e os traduzem em dados que podem ser usados por um stream de baixo
nível, como o FileInputStream.

    FileOutputStream file = new FileOutputStream("hello.txt");
    DataOutputStream dos = new DataOutputStream(file);
    dos.writeBytes("hello joe");
    dos.writeByte('\n');
    dos.close();
    file.close();

Readers e writers
-----------------

São streams que se diferenciam dos demais por lidar com caracteres Unicode.
Devem ser usados para lidar com caracteres.

    Por acaso, eu já usava isto muito bem mas não sabia disto.

Um writer/reader importante é a RandomAcessFile, que define um ponteiro para
acessar posições arbitrárias do arquivo relativas ao início.

Serialização de objetos
-----------------------

Permite tornar objetos persistentes. Eles poderão ser salvos em arquivos para
eles poderem ser acessados mais tarde. Para tanto, cada objeto pode ter um
número serial (uma identificação) própria, que poderia ser usada para fazer
referências a um objeto.

Objetos e suas referências formam um grafo. Para que um objeto possa ser
serializado, eles devem implementar a classe "Serializable".

Atributos que não devem ser persistidos em um objeto
devem ser marcados com a palavra-chave "transient".

Propriedades
------------

São informações úteis para a execução do programa. Elas customizam a execução
da aplicação. Um arquivo de propriedades permite salvar estas decisões.
