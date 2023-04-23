/*
 * ***** Compilar e executar *****
 * Para compilar o codigo java nome_do_arquivo.java é utilizado o comando javac ( JavaCompiler )
 * Ex.: javac NomeDaClasse.java
 * 
 * Para executar o binario recem compilado é utilizado o comando java
 * Ex.: java NomeDaClasse
 * 
 * Para adicionar bibliotecas externas na execução do binario é necessário informar o nome do arquivo jar no classpath da execucao
 * Ex.: java -classpath arquivo.jar:. NomeDaClasse
 * 
 * Para que o binario da classe que esta sendo executado funcione, a classe necessita ter um metodo estatico void chamado main:
 * public static void main(String args[]){}
 * 
 * OBS:
 * Java segue um padrao forte de nomenclatura das classes integrado com o sistema de arquivos. Fique atento a isso.
 * 
 */

import java.util.*;
import models.*;
import database.*;
import utils.*;

public class JavaApp {
  
  public static void main(String args[]) {
    System.out.println(args.length);
    
    int x=10;
    int y=25;
    int z=x+y;
    System.out.println("Sum of x+y = " + z);

    Pessoa p1 = new Pessoa();
    p1.setFirstName("Ricardo");
    p1.setSecondName("Silveira");
    p1.setEmail("rsilveira1987@gmail.com");
    System.out.println(p1.toString());
    System.out.println(p1.toMap());


    MysqlDatabase.selectExample();
    // MysqlDatabase.insertExample("PrimeiroNome","SegundoNome","email@gmail.com");
    // MysqlDatabase.deleteExample(10);
    // MysqlDatabase.updateExample(1,"PrimeiroNome","SegundoNome","email@gmail.com");

  }
}
