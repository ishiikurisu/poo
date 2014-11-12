package escola.cadastro;

import java.util.*;

import escola.aluno.Aluno;
import escola.aluno.RepositorioAluno;
import escola.curso.Curso;
import escola.curso.RepositorioCurso;
import escola.matricula.Matricula;
import escola.matricula.RepositorioMatricula;

/*
Esta classe lida com os repositórios da aplicação. Neste arquivo,
esta classe está divida em três partes: na parte de alunos, na parte
de cursos, na parte de matrículas e na parte de listagens. As três
primeiras partes lidam com os dados dos repositórios isoladamente,
tanto que há override de diversas funções, notavelmente a da função
cadastrar. A última parte gera listas que podem involver mais de um
repositório diferente.
*/
public class Cadastro {
  private static RepositorioAluno repositorioAlunos = new RepositorioAluno();
  private static RepositorioCurso repositorioCursos = new RepositorioCurso();
  private static RepositorioMatricula repositorioMatriculas = new RepositorioMatricula();

  public Cadastro() {}

  /* ALUNOS */

  /**
  * Checa se um aluno ja existe no cadastro
  */
  private static boolean existeAluno(String nome, String endereco, String telefone, int idade) {
    Aluno aluno = repositorioAlunos.procurar(nome);

    if (
      aluno != null && (
      aluno.getEndereco() == endereco ||
      aluno.getTelefone() == telefone ||
      aluno.getIdade() == idade)
    )
      return true;
    else
      return false;
  }

  /**
  * Esta função cadastra um novo aluno e o adiciona no repositório. Aqui, não
  * podem haver dois alunos com o mesmo nome.
  */
  public static void cadastrar(String nome, String endereco, String telefone, int idade) {
    if (!existeAluno(nome, endereco, telefone, idade)) {
      Aluno aluno = new Aluno(nome, endereco, telefone, idade);
      repositorioAlunos.adicionar(aluno);
    }
  }

  /**
  * Procura por um aluno no repositório dos alunos pelo nome.
  */
  public static Aluno procurarAluno(String nome) {
    return repositorioAlunos.procurar(nome);
  }

  /**
  * Muda informações de um determinado item do repositório
  */
  public static Aluno atualizar(String nome, String novoNome, String novoEndereco, String novoTelefone, int novaIdade) {
    Aluno aluno = procurarAluno(nome);
    if (aluno != null) {
      aluno.setNome(novoNome);
      aluno.setEndereco(novoEndereco);
      aluno.setTelefone(novoTelefone);
      aluno.setIdade(novaIdade);
    }

    return aluno;
  }

  /**
  * Remove um aluno do repositório
  */
  public static void descadastrarAluno(String nome) {
    repositorioAlunos.remover(nome);
  }

  /* CURSOS */
  /**
  * Checa se um curso já existe no repositório
  */
  public static boolean existeCurso(String nome) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null)
      return true;
    else
      return false;
  }

  /**
  * Cadastra um novo curso no repositório
  */
  public static void cadastrar(String codigo, String nome, String instrutor) {
    Curso curso = new Curso(codigo, nome, instrutor);
    repositorioCursos.adicionar(curso);
  }

  /**
  * Procura pela existência de um curso no repositório
  */
  public static String[] procurarCurso(String nome) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      String[] info = {
        "3",
        "Código", curso.getCodigo(),
        "Nome", curso.getNome(),
        "Instrutor", curso.getInstrutor()
      };
      return info;
    }
    else
      return null;
  }

  /**
  * Remove um curso do cadastro
  */
  public static void descadastrarCurso(String nome) {
    repositorioCursos.remover(nome);
  }

  /**
  * Altera as informações de um determinado curso
  */
  public static Curso atualizar(String nome, String novoCodigo, String novoNome, String novoInstrutor) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      curso.setCodigo(novoCodigo);
      curso.setNome(novoNome);
      curso.setInstrutor(novoInstrutor);
    }

    return curso;
  }
  /* MATRÍCULAS */
  /**
  * Gera uma nova matrícula
  */
  public static int matricularAluno(String nomeAluno, String nomeCurso) {
    Aluno aluno = repositorioAlunos.procurar(nomeAluno);
    Curso curso = repositorioCursos.procurar(nomeCurso);

    if (aluno == null || curso == null) {
      return 0;
    }

    Matricula matricula = new Matricula(aluno, curso);
    repositorioMatriculas.adicionar(matricula);

    return matricula.getNumero();
  }

  /**
  * Procura uma matrícula pelo seu número
  */
  public static String[] procurarMatricula(int numeroMatricula) {
    Matricula matricula = repositorioMatriculas.procurar(numeroMatricula);

    if (matricula == null) {
      return null;
    }
    else {
      String[] info = {
        "3",
        "Aluno", matricula.getAluno().getNome(),
        "Curso", matricula.getCurso().getNome(),
        "Número", "" + matricula.getNumero()
      };
      return info;
    }
  }

  /**
  * Apaga uma matrícula do cadastro
  */
  public static void cancelarMatricula(int numeroMatricula) {
    repositorioMatriculas.remover(numeroMatricula);
  }

  /* LISTAGENS */
  /**
  * Lista todas as matrículas existentes, sem distinção
  */
  public static List listarMatriculas() { // Versão sem filtros
    List list = new LinkedList<String[]>();

    for (int i = 0; i < repositorioMatriculas.tamanho(); ++i) {
      Matricula matricula = (Matricula) repositorioMatriculas.obter(i);
      String[] info = {
        "3",
        "Número", "" + matricula.getNumero(),
        "Aluno", matricula.getAluno().getNome(),
        "Curso", matricula.getCurso().getNome()
      };

      list.add(info);
    }

    return list;
  }

  /**
  * Lista todos os cursos existentes, sem distinção
  */
  public static List listarCursos() { // Versão sem filtros
    List list = new LinkedList<String[]>();

    for (int i = 0; i < repositorioCursos.tamanho(); ++i) {
      Curso curso = (Curso) repositorioCursos.obter(i);
      String[] info = {
        "3",
        "Código", curso.getCodigo(),
        "Nome", curso.getNome(),
        "Instrutor", curso.getInstrutor()
      };

      list.add(info);
    }

    return list;
  }

  /**
  * Lista todos os alunos existentes, sem distinção
  */
  public static List listarAlunos() { // Versão sem filtros
    List list = new LinkedList<String[]>();

    for (int i = 0; i < repositorioAlunos.tamanho(); ++i) {
      Aluno aluno = (Aluno) repositorioAlunos.obter(i);
      String[] info = {
        "4",
        "Nome", aluno.getNome(),
        "Endereço", aluno.getEndereco(),
        "Telefone", aluno.getTelefone(),
        "Idade", "" + aluno.getIdade()
      };

      list.add(info);
    }

    return list;
  }

  /**
  * Lista todos os alunos com base em um filtro. Aqui, temos três tipos de filtro:
  *   + curso
  *     Lista todos os alunos de um curso
  *   + todos
  *     Lista todos os alunos de todos os cursos
  *   + sem
  *     Lista os alunos que não estão matriculados em nada
  */
  public static List listarAlunos(String tipoFiltro, String filtro) { // Versão com filtros
    List lista = new LinkedList<String[]>();

    switch (tipoFiltro) {
      case "curso":
        for (int i = 0; i < repositorioMatriculas.tamanho(); ++i) {
          Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(i);

          if (matriculaAtual.getCurso().getNome().equals(filtro)) {
            String[] info = {
              "2",
              "Aluno", matriculaAtual.getAluno().getNome(),
              "Matrícula", "" + matriculaAtual.getNumero()
            };

            lista.add(info);
          }
        }
      break;

      case "todos":
        List parcial;

        for (int i = 0; i < repositorioCursos.tamanho(); ++i) {
          parcial = new LinkedList<String[]>();
          Curso cursoAtual = (Curso) repositorioCursos.obter(i);

          for (int j = 0; j < repositorioMatriculas.tamanho(); ++j) {
            Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(j);

            if (matriculaAtual.getCurso().getNome().equals(cursoAtual.getNome())) {
              String[] info = {
                "3",
                "Curso", cursoAtual.getNome(),
                "Aluno", matriculaAtual.getAluno().getNome(),
                "Matrícula", matriculaAtual.getNumero() + ""
              };
              parcial.add(info);
            }
          }
          for (int j = 0; j < parcial.size(); ++j) {
            lista.add(parcial.get(j));
          }
        }
      break;

      case "sem":
        for (int i = 0; i < repositorioAlunos.tamanho(); ++i) {
          Aluno alunoAtual = (Aluno) repositorioAlunos.obter(i);
          boolean flag = false;
          int it = 0;

          while (it < repositorioMatriculas.tamanho() && !flag) {
            Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(it);

            if (matriculaAtual.getAluno().getNome().equals(alunoAtual.getNome())) {
              flag = true;
            }
            else {
              it++;
            }
          }


          if (!flag) {
            String[] info = {
              "1",
              "Aluno", alunoAtual.getNome()
            };
            lista.add(info);
          }
        }
      break;
    }

    return lista;
  }

  /**
  * Lista todos os cursos que passarem em um filtro. Aqui, temos três tipos de
  * filtro:
  *   + alunos
  *     Lista todos os cursos nos quais um aluno está cadastrado
  *   + todos
  *     Lista todos os cursos nos quais todos os alunos estão cadastrados
  *   + sem
  *     Lista todos os cursos sem alunos
  */
  public static List listarCursos(String tipoFiltro, String filtro) {
    List lista = new LinkedList<String[]>();

    switch (tipoFiltro) {
      case "alunos":
        for (int i = 0; i < repositorioMatriculas.tamanho(); ++i) {
          Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(i);

          if (matriculaAtual.getAluno().getNome().equals(filtro)) {
            String[] info = {
              "2",
              "Curso", matriculaAtual.getCurso().getNome(),
              "Matrícula", "" + matriculaAtual.getNumero()
            };

            lista.add(info);
          }
        }
      break;

      case "todos":
        List parcial;

        for (int i = 0; i < repositorioAlunos.tamanho(); ++i) {
          parcial = new LinkedList<String[]>();
          Aluno alunoAtual = (Aluno) repositorioAlunos.obter(i);

          for (int j = 0; j < repositorioMatriculas.tamanho(); ++j) {
            Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(j);

            if (matriculaAtual.getAluno().getNome().equals(alunoAtual.getNome())) {
              String[] info = {
                "3",
                "Aluno", alunoAtual.getNome(),
                "Curso", matriculaAtual.getCurso().getNome(),
                "Matrícula", matriculaAtual.getNumero() + ""
              };
              parcial.add(info);
            }
          }
          for (int j = 0; j < parcial.size(); ++j) {
            lista.add(parcial.get(j));
          }
        }
      break;

      case "sem":
        for (int i = 0; i < repositorioCursos.tamanho(); ++i) {
          Curso cursoAtual = (Curso) repositorioCursos.obter(i);
          boolean flag = false;
          int it = 0;

          while (it < repositorioMatriculas.tamanho() && !flag) {
            Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(it);

            if (matriculaAtual.getCurso().getNome().equals(cursoAtual.getNome())) {
              flag = true;
            }
            else {
              it++;
            }
          }


          if (!flag) {
            String[] info = {
              "1",
              "Curso", cursoAtual.getNome()
            };
            lista.add(info);
          }
        }
      break;
    }

    return lista;
  }

  /**
  * Lista todas as matrículas de acordo com um filtro. Aqui, temos os seguintes
  * filtros:
  *   + aluno
  *     Lista todas as matrículas que um aluno possui
  *   + curso
  *     Lista todas as matrículas vinculadas a um curso
  */
  public static List listarMatriculas(String tipoFiltro, String filtro) {
    List lista = new LinkedList<String[]>();

    switch (tipoFiltro) {
      case "aluno":
        for (int i = 0; i < repositorioMatriculas.tamanho(); ++i) {
          Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(i);

          if (matriculaAtual.getAluno().getNome().equals(filtro)) {
            String[] info = {
              "2",
              "Matrícula", "" + matriculaAtual.getNumero(),
              "Curso", matriculaAtual.getCurso().getNome()
            };

            lista.add(info);
          }
        }
      break;

      case "curso":
        for (int i = 0; i < repositorioMatriculas.tamanho(); ++i) {
          Matricula matriculaAtual = (Matricula) repositorioMatriculas.obter(i);

          if (matriculaAtual.getCurso().getNome().equals(filtro)) {
            String[] info = {
              "2",
              "Matrícula", "" + matriculaAtual.getNumero(),
              "Aluno", matriculaAtual.getAluno().getNome()
            };

            lista.add(info);
          }
        }
      break;
    }

    return lista;
  }
}
