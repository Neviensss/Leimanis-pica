import javax.swing.JOptionPane;

public class Picerija {
	
	public static void PievienotSutijumu() {
		
	}
	
	public static void ApskatitPicas() {
		
	}

	public static void main(String[] args) {
		
		String izvele;
		
		do {
			izvele = JOptionPane.showInputDialog("1 - Pievienot pasūtījumu || 2 - Apskatīt picas || stop - Beigt darbības");
			izvele = izvele.toLowerCase();
			
			switch(izvele) {
			
			case "1":
				PievienotSutijumu();
				break;
			case "2":
				ApskatitPicas();
				break;
			case "stop":
				JOptionPane.showMessageDialog(null, "Programma apturēta");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
			
		}while(!izvele.equals("stop"));

	}

}
