public class Circle extends Svg{
  private int x,y,r;

  public Circle(){
  }
  
  public Circle (int x, int y, int r){
    this.x = x;
    this.y = y;
    this.r = r;
  }

  public String svgCircle(){
    return "<circle cx='" + String.valueOf(x) + "' cy='" + String.valueOf(y) + "' r='" + String.valueOf(r) + "' ";
  }

}