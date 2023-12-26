package componentes;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

public class UsandoJTree extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsandoJTree();
	}
	public UsandoJTree() {
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("Personaje");
		DefaultMutableTreeNode guerreros=new DefaultMutableTreeNode("Guerrero");
		DefaultMutableTreeNode magos=new DefaultMutableTreeNode("Magos");
		DefaultMutableTreeNode magoOscuro=new DefaultMutableTreeNode("Mago Oscuro");
		DefaultMutableTreeNode magoGris=new DefaultMutableTreeNode("Mago Gris");
		magos.add(magoOscuro);
		magos.add(magoGris);
		root.add(guerreros);
		root.add(magos);
		URL url=this.getClass().getResource("../imagenes/6.jpg");
		ImageIcon icon=new ImageIcon(url);
		Image img=Toolkit.getDefaultToolkit().createImage(url);
		img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		System.out.println(url);
		DefaultTreeCellRenderer render=new DefaultTreeCellRenderer();
		render.setLeafIcon(new ImageIcon(img));
		JTree arbol=new JTree(root);
		arbol.setCellRenderer(render);
		arbol.setShowsRootHandles(true);
		//arbol.setRootVisible(false);
		TreeSelectionListener listener=new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				System.out.println("cambiado "+e.getPath().toString());
				DefaultMutableTreeNode nodoSeleccionado=(DefaultMutableTreeNode)arbol.getLastSelectedPathComponent();
				System.out.println("Nodo Seleccionado: "+nodoSeleccionado.getUserObject());
			}
		};
		arbol.addTreeSelectionListener(listener);
		JScrollPane panel=new JScrollPane(arbol);
		getContentPane().add(panel);
		setSize(500,400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
