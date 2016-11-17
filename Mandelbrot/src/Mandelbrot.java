import java.awt.*;
import java.applet.*;

public class Mandelbrot extends Applet{
  

    //C-Werte checken nach Zn+1 = Zn^2 + C, Zo = 0. 30 Iterationen.
    public static int checkC(double reC,double imC) {
        double reZ=0,imZ=0,reZ_minus1=0,imZ_minus1=0;
        int i;
        for (i=0;i<30;i++) {
            imZ=2*reZ_minus1*imZ_minus1+imC;
            reZ=reZ_minus1*reZ_minus1-imZ_minus1*imZ_minus1+reC;
            if (reZ*reZ+imZ*imZ>4) return i;
            reZ_minus1=reZ;
            imZ_minus1=imZ;
        }
        return i;
    }

  
    
	  public void paint (Graphics g) {
        double reC, imC, zelle=0.00625; //Ein Pixel = 0.00625
        int x,y;
        Color colAppleman = new Color(0,129,190); //Farbe Apfelmännchen

        imC=-1.1; //oberer Rand
        for (y=0;y<350;y++) {
            reC=-2.1; //linker Rand
            for (x=0;x<440;x++) {
                if(checkC(reC,imC)==30) {
                    g.setColor(colAppleman);
                    g.drawLine(x,y,x,y);
                }
                reC=reC+zelle; //nächste Spalte
            }
            imC=imC+zelle; //nächste Zeile
        }
    }
}
