> Para fazer evolução de software, devemos fazer análise de impacto

# Arquivos de configuração

Em Java, a configuração de uma aplicação é feita por meio de reflexão
computacional: lê-se um arquivo de configuração e, na fachada, atribuimos
um valor de string como nome da classe concreta a ser usada na aplicação.

Reflexão computacional
----------------------

"Fazer o código reconhecer seu código".

    classeAbstrata clsAbs;
    try {
      Class clsCon = Class.forName("classeConcreta");
      clsAbs = (classeAbstrata) clsCon.newInstance();
    }
    catch (ClassNotFoundException e) {
      */ shit /*
      */ nota: os comentários neste markdown
      estão invertidos /*
    }

Possui outras utilidades como metaobjetos e distribuição de código, em especial
o MOP (metaobject protocol).

O paradigma de programação orientada a aspectos usa bastante esta ideia de
reflexão computacional.

Padrão de Projeto Factory
-------------------------

Seu objetivo é recuperar uma instância de uma classe.

O código a seguir é o exemplo dado em sala de aula:

    // na fachada...
    private void initCadastro() {
      RepositorioContas repositorio = RepositorioContasFactory.create();
      contas = new CadastroContas(repositorio);
    }

    // na classe RepositorioContasFactory...
    public class RepositorioContasFactory {
      // ...
      public static RepositorioContas create() {
        Properties prop = new Properties();
        RepositorioContas repositorio;
        String nomeClassePersistencia;
        String nomeConfig = System.getProperty("user.dir") + File.separator +
          "config"; // também pode ser parametrizado

        try {
          prop.load(new FileInputStream(nomeConfig));
        } catch (IOException ioe) {}

        nomeClassePersistencia = prop.getProperty("persistencia-classe-conta");
        try {
          Class classeRepositorio = Class.forName(nomeClassePersistencia);
          repositorio = (RepositorioContas) classeRepositorio.getInstance();
        } catch (ClassNotFoundException cntfe) {}

        return repositorio;
      }
      // ...
    }

Leva-nos ao polimorfismo paramétrico, onde podemos unificar factories. Outra
forma de parametrizar este código é usar Object como tipo dos objetos.
