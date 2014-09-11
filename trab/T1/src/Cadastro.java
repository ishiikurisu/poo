import java.util.*;

public class Cadastro {
  private static RepositorioAluno repositorioAlunos = new RepositorioAluno();
  private static RepositorioCurso repositorioCursos = new RepositorioCurso();
  private static RepositorioMatricula repositorioMatriculas = new RepositorioMatricula();

  public Cadastro() {}

  /* ALUNOS */

  public void cadastrar(String nome, String endereco, String telefone, int idade) {
    Aluno aluno = new Aluno(nome, endereco, telefone, idade);
    repositorioAlunos.adicionar(aluno);
  }

  public Aluno procurarAluno(String nome) {
    return repositorioAlunos.procurar(nome);
  }

  public Aluno atualizar(String nome, String novoNome, String novoEndereco, String novoTelefone, int novaIdade) {
    Aluno aluno = this.procurarAluno(nome);
    if (aluno != null) {
      aluno.setNome(novoNome);
      aluno.setEndereco(novoEndereco);
      aluno.setTelefone(novoTelefone);
      aluno.setIdade(novaIdade);
    }

    return aluno;
  }

  public void descadastrarAluno(String nome) {
    repositorioAlunos.remover(nome);
  }

  /* CURSOS */
  public boolean existeCurso(String nome) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null)
      return true;
    else
      return false;
  }

  public void cadastrar(String codigo, String nome, String instrutor) {
    Curso curso = new Curso(codigo, nome, instrutor);
    repositorioCursos.adicionar(curso);
  }

  public String[] procurarCurso(String nome) {
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

  public void descadastrarCurso(String nome) {
    repositorioCursos.remover(nome);
  }

  public Curso atualizar(String nome, String novoCodigo, String novoNome, String novoInstrutor) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      curso.setCodigo(novoCodigo);
      curso.setNome(novoNome);
      curso.setInstrutor(novoInstrutor);
    }

    return curso;
  }
  /* MATRÍCULAS */
  public int matricularAluno(String nomeAluno, String nomeCurso) {
    Aluno aluno = repositorioAlunos.procurar(nomeAluno);
    Curso curso = repositorioCursos.procurar(nomeCurso);

    if (aluno == null || curso == null) {
      return 0;
    }

    Matricula matricula = new Matricula(aluno, curso);
    repositorioMatriculas.adicionar(matricula);

    return matricula.getNumero();
  }

  public String[] procurarMatricula(int numeroMatricula) {
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

  public void cancelarMatricula(int numeroMatricula) {
    repositorioMatriculas.remover(numeroMatricula);
  }

  /* LISTAGENS */
  public List listarMatriculas() { // Versão sem filtros
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

  public List listarCursos() { // Versão sem filtros
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

  public List listarAlunos() { // Versão sem filtros
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

  public List listarAlunos(String tipoFiltro, String filtro) { // Versão com filtros
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

  public List listarCursos(String tipoFiltro, String filtro) {
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

  public List listarMatriculas(String tipoFiltro, String filtro) {
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
