package T2;
import T2.src.ui.Interface;

/**
* Classe principal do 2o projeto da matéria Programação Orientada a Objetos
* <p>
* O objetivo deste trabalho é criar um sistema de cadastro para uma escola baseado
* nas espeficicações fornecidas pelo professor.
* </p>
* <p>
* Aqui, vamos lidar com o cadastro de alunos, de cursos e as matrículas associadas
* a estes. Para tanto, criamos uma classe para cada um destes tipos e um classe de
* repositório para lidar com grandes quantidades de cada um destes objetos.
* </p>
* <p>
* Para usar o programa, criamos uma classe de interface do tipo textual, que
* permite o usuário usar todas as funcionalidades permitidas pelo programa a
* partir de um menu principal. É chamando esta classe que temos a execução da
* aplicação.
* </p>
* @author Cristiano Silva Jr - 13/0070629 <cristianoalvesjr@gmail.com>
*/
public class Main {
  public static final void main(String[] args) {
    new Interface();
  }
}
