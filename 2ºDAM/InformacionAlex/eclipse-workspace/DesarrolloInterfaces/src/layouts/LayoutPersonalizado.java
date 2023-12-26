package layouts;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
 
 
public class LayoutPersonalizado implements LayoutManager {
 
  private static final int MARGEN_SUPERIOR = 30;
 
private static final int MARGEN_IZQUIERDO = 100;
 
 
  private int       anchoIzquierdoMaximo;
  private int       anchoDerechoMaximo;
 
 
  private final int espacioHorizontal;
  private final int espacioVertical;
 
 
 
  public LayoutPersonalizado () {
	  espacioHorizontal = espacioVertical = 0;
	  }
 
  public LayoutPersonalizado (int espacioEntreColumnas, int espacioEntreFilas) {
    espacioHorizontal = espacioEntreColumnas;
    espacioVertical = espacioEntreFilas;
  }
 
 
 
 
  @Override
  public Dimension minimumLayoutSize (Container parent){
	  return preferredLayoutSize(parent);
  }
 
 
  @Override
  public Dimension preferredLayoutSize (Container parent){
    Component[] listaComponenentes = parent.getComponents();
    if (listaComponenentes.length%2 != 0)
      throw new IllegalStateException("Tiene componentes impares ("+listaComponenentes.length+") number of subcomponents");
 
    //Mire todos los componentes y acumule el tamaño preferido
    anchoIzquierdoMaximo = anchoDerechoMaximo = 0;
    int alturaColumna = 0;
    for (int i=0; i<listaComponenentes.length; i+=2 /*2 columns*/) {
 
      Component etiqueta = listaComponenentes[i];      //label of pair (left column)
      Component caja = listaComponenentes[i+1];    //text  of pair (right column)
 
      //Get their preferred size
      Dimension tamCaja = etiqueta.getPreferredSize();
      Dimension tamEtiqueta = caja.getPreferredSize();
 
 
      anchoIzquierdoMaximo =  Math.max(anchoIzquierdoMaximo, tamCaja.width);
      anchoDerechoMaximo   =  Math.max(anchoDerechoMaximo, 	 tamEtiqueta.width);
      alturaColumna   += Math.max(tamCaja.height, tamEtiqueta.height);
    }
 
    return new Dimension(	anchoIzquierdoMaximo
    							+espacioHorizontal
    							+anchoDerechoMaximo, 
    						alturaColumna
    							+espacioVertical*(listaComponenentes.length/2-1));
  }
 
  @Override
  public void layoutContainer(Container parent){
 
    preferredLayoutSize(parent); 
    Component[] componentes = parent.getComponents();    
 
 
    Insets recuadros = parent.getInsets();
    int xDerechaParaEtiquetas = MARGEN_IZQUIERDO+recuadros.left + anchoIzquierdoMaximo;
    int yTopForNext     = MARGEN_SUPERIOR+recuadros.top; 
 
    for (int i=0; i<componentes.length; i+=2 /*2 columns*/) {
 
      Component etiqueta = componentes[i];      //label of pair (left column)
      Component caja = componentes[i+1];    //text  of pair (right column)
 
 
      Dimension tamEtiqueta = etiqueta.getPreferredSize();
      Dimension tamCaja = caja.getPreferredSize();
 
 
 
 
      int anchoParEtiquetaCaja = Math.max(tamEtiqueta.height, tamCaja.height);
 
 
      etiqueta.setBounds(xDerechaParaEtiquetas-tamEtiqueta.width,
                      	yTopForNext+(anchoParEtiquetaCaja-tamEtiqueta.height)/2,
                      	tamEtiqueta.width,
                      	tamEtiqueta.height);
 
      caja.setBounds(xDerechaParaEtiquetas+espacioHorizontal,
                      yTopForNext+(anchoParEtiquetaCaja-tamCaja.height)/2,
                      tamCaja.width,
                      tamCaja.height);
      yTopForNext += anchoParEtiquetaCaja+espacioVertical;
    }
  }
 
 
 
  @Override
  public void addLayoutComponent (String name, Component c)
  {}
  @Override
  public void removeLayoutComponent(Component c)
  {}
 
}
