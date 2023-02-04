public class Target extends Svg{
  private int xr,yr,size;

  public Target(){
  }
  
  public Target(int xr, int yr, int size){
    this.xr = xr;
    this.yr = yr;
    this.size = size/2;
  }

  public String svgTarget(){
    return "<polygon points='" + String.valueOf(xr) + "," + String.valueOf(yr-size) + " " + String.valueOf(xr-size) + "," + String.valueOf(yr) + " " + String.valueOf(xr) + "," + String.valueOf(yr+size) + " " + String.valueOf(xr+size) + "," + String.valueOf(yr) + "' stroke='black' " + super.svgFillRed() + super.svgEnd();
  }
  
}