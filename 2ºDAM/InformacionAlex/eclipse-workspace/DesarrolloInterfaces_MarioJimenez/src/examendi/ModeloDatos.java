package examendi;
import java.io.File;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class ModeloDatos extends DefaultTreeModel {

  DefaultMutableTreeNode nodoRaiz = null;

  public ModeloDatos() {
    super(new DefaultMutableTreeNode("root"));
    nodoRaiz = (DefaultMutableTreeNode) getRoot();
  }

  public void cargar(String str) {
	  System.out.println("cargando "+str);
	  nodoRaiz.removeAllChildren();

	    DefaultMutableTreeNode nodoHijo = anadirNodo(null, new File(str)); 

	    nodoRaiz.add(nodoHijo);
    

    super.nodeStructureChanged(nodoRaiz);
  }

  public TreeNode getRootNode() {
    return nodoRaiz;
  }
  
	DefaultMutableTreeNode anadirNodo(DefaultMutableTreeNode nodoPadre, File directorio) {
		String rutaActual = directorio.getPath();
		DefaultMutableTreeNode nodoActual = new DefaultMutableTreeNode(rutaActual);
		if (nodoPadre != null) { // si no es nulo (sistema) lo añado
			nodoPadre.add(nodoActual);
		}
		ArrayList<String> ol = new ArrayList<>();
		String[] tmp = directorio.list();
		if (tmp != null) {
			for (int i = 0; i < tmp.length; i++)
				ol.add(tmp[i]);
		
			File fichero;
			ArrayList<String> listaFicheros = new ArrayList<>();
	
			
			// Haga dos pasadas, una para Dirs y otra para Files. Este es el número 1.
				for (String indice : ol) {
					
				String nuevaRuta;
				if (rutaActual.equals("."))
					nuevaRuta = indice;
				else
					nuevaRuta = rutaActual + File.separator + indice;
				
			//	System.out.println("revisando "+nuevaRuta);
				if ((fichero = new File(nuevaRuta)).isDirectory())
					anadirNodo(nodoActual, fichero);
				else
					listaFicheros.add(indice);
			}
				
				File[]lista=directorio.listFiles();
				for(File f:lista) {
					listaFicheros.add(f.getAbsolutePath());
				}
				
			for (int fnum = 0; fnum < listaFicheros.size(); fnum++) {
				String str=listaFicheros.get(fnum);
				nodoActual.add(new DefaultMutableTreeNode(str));
			}
		}
		return nodoActual;
	}
 
}
