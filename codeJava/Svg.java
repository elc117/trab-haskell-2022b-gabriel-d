import java.util.Random;

public class Svg {
  
  private int height;
  private int width;
  private int maxRgb = 255;
  
  public Svg(){
  }
  
  public Svg(int height, int width){
    this.height = height;
    this.width = width;
  }

  public String svgBegin(){
    return "<svg height='" + String.valueOf(height) + "' width='" + String.valueOf(width) + "' xmlns='http://www.w3.org/2000/svg'>\n";
  }

  public String svgEnd(){
    return "</svg>";
  }

  public String svgFillRgb(Random rand){
    return "fill='rgb(" + String.valueOf(rand.nextInt(maxRgb)) + "," + String.valueOf(rand.nextInt(maxRgb)) + "," + String.valueOf(rand.nextInt(maxRgb)) + ")'/>\n";
  }

  public String svgFillRed(){
    return "fill='rgb(" + String.valueOf(maxRgb) + "," + String.valueOf(0) + "," + String.valueOf(0) + ")'/>\n";
  }

  public String svgFillWhite(){
    return "fill='rgb(" + String.valueOf(maxRgb) + "," + String.valueOf(maxRgb) + "," + String.valueOf(maxRgb) + ")'/>\n";
  }
  
}