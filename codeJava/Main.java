import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main(String[] args){
    Random gen = new Random();
    //Ajustes de tamanho do arquivo, círculos(qtd. e tamanho) e losango(target)
    int ncircles = 5;
    int size = 100;
    int imagesize = ncircles*size*2;
    Svg imagew = new Svg(imagesize,imagesize);
    Target dart = new Target(gen.nextInt(imagesize),gen.nextInt(imagesize),size);
    //Geração dos círculos do tipo Circle, adicionando-os na ArrayList 'circles'
    ArrayList<Circle> circles = new ArrayList<Circle>();
    for(int aux = ncircles;aux >= 1;aux--){
      circles.add(new Circle(ncircles*size,ncircles*size,aux*size));
    }
    //Escrita no arquivo .svg
    try {
      File meuArq = new File("output.svg");
      FileWriter escritaArq = new FileWriter(meuArq.getName());
      escritaArq.write(imagew.svgBegin());
      //Cores dos círculos pseudo-aleatorias (RGB);
      for(Circle c : circles){
        escritaArq.write(c.svgCircle() + c.svgFillRgb(gen));
      }
      //Cores dos círculos alternando entre vermelho/branco;
      /*for(Circle c : circles){
        String str = (circles.indexOf(c) % 2 == 0) ? c.svgFillWhite() : c.svgFillRed();
        escritaArq.write(c.svgCircle() + str);
      }*/
      escritaArq.write(dart.svgTarget());
      escritaArq.close();
      System.out.println("Desenho no arquivo " + meuArq.getName());
    } catch(IOException e) {
      System.out.println("Erro na escrita do arquivo");
      e.printStackTrace();
    }
  }
}