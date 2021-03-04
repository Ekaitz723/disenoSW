package ejercicio3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDoctores extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JTextField te;
	private static JLabel la;
	private static JTextArea ta;
	private static JScrollPane sp;
	
	
	//Los dias que durara la simulacion.
	private static int dias;
		
	//La cantidad de ninos que hay. A los doctores les dara tiempo a examinar a todos en el dia en el que trabajen, el 15 o 28.
	private static int cantidadNinos;
	
	//Si porConsola true, da igual verbose y se hace por consola.
	//Si porConsola false, si verbose es true, aparte de guardarse en Guraso (fichero), se va imprimiendo.
	private static boolean porConsola = false;
	private static boolean verbose = true;
	
	//Suponiendo que no hay hermanos, cant guraso == cant ninos.
	
	private static GUIDoctores instanciaGUIDoctores = new GUIDoctores();;
	
	public static GUIDoctores instancia() {
		if(instanciaGUIDoctores==null)
			instanciaGUIDoctores = new GUIDoctores();
		return instanciaGUIDoctores;
	}
	
	public static void instanciaFlush() {
		if(instanciaGUIDoctores!=null)
			instanciaGUIDoctores = null;
	}
	
	private GUIDoctores() {
		setTitle("Guarderia");
		setResizable(true);
		setBounds(100, 100, 400, 401);
		
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);;
		
        te = new JTextField(30);
        te.setFont(new Font("Cosa",Font.BOLD,20));
        te.addActionListener(this);
        add(te,BorderLayout.SOUTH);
        te.setVisible(true);
        
        ta = new JTextArea(5,30);
        ta.setEditable(false);
        ta.setFont(te.getFont());
        ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(ta,BorderLayout.CENTER);
        
        la = new JLabel();
        la.setFont(te.getFont());
        add(la,BorderLayout.NORTH);
        
        sp = new JScrollPane(ta);
        sp.setSize(200,135);
        add(sp);
    }
    public static void main() {
    	instanciaGUIDoctores.setVisible(true);
        la.setText("¿Cuantos dias durará la simulación?");
        ta.setText("");
        te.setText("[r para reiniciar]");
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField t = (JTextField) e.getSource();
		String resp;
		
		if(!(t.getText().equals("")||la.getText().equals("Simulacion: ([r] para repetir)"))) {
			if(verbose) {
				resp = t.getText().replaceAll("\\D", " ").trim().split(" ")[0];
				if(!resp.equals("")) {
					if(la.getText().equals("¿Cuantos dias durará la simulación?")) {
						dias = Integer.parseInt(resp);
						la.setText("¿Cuantos niños hay?");
					}
					else if(la.getText().equals("¿Cuantos niños hay?")) {
						cantidadNinos = Integer.parseInt(resp);
						la.setText("¿Por consola? [si|no]");
						verbose = false;
					}
				}
				if(la.getText().equals("¿Se imprime por aca? [si|no]")) {
					resp = t.getText().trim().split(" ")[0];
					if(resp.equalsIgnoreCase("si") || resp.equalsIgnoreCase("no")) {
						verbose = resp.equalsIgnoreCase("si");
						la.setText("Simulacion: ([r] para repetir)");
						PruebaDoctores.main(dias, cantidadNinos, porConsola, verbose);
						if(verbose)
							setSize(600, 601);
						else {
							ta.append("Documentos guardados en documentosGuraso.");
							setSize(540, 301);
						}
					}
				}
			}
			else {
				resp = t.getText().trim().split(" ")[0];
				if(!porConsola && (resp.equalsIgnoreCase("si") || resp.equalsIgnoreCase("no")))
					la.setText((verbose = !(porConsola = resp.equalsIgnoreCase("si")))?"¿Se imprime por aca? [si|no]":"Simulacion: ([r] para repetir)");
					if(porConsola) {
						PruebaDoctores.main(dias, cantidadNinos, porConsola, verbose);
						setSize(600, 601);
					}
			}
		}
		if(/*la.getText().equals("Simulacion: ([r] para repetir)") && */t.getText().trim().split(" ")[0].equals("r")) {
			System.out.println("pto");
			main();
		}
		t.setText("");
	}
	
	public String getTaText() {
		return ta.getText();
	}
	
	public void appendTaText(String string) {
		ta.append(string);
	}
}