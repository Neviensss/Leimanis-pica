import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Picerija {
	
	public static double cena;
	
	static Pica[] PievienotSutijumu(Pica[] masivs) {
		 try {
		FileWriter fw = new FileWriter("Klienti.txt", false);
		PrintWriter bw = new PrintWriter(fw);
		FileWriter pfw = new FileWriter("picas.txt", false);
		PrintWriter pbw = new PrintWriter(pfw);
		String picas;
		
		String vards, pilseta, iela, maja, dzivoklis;
		
		vards = JOptionPane.showInputDialog("Ievadiet savu vārdu:");
		pilseta = JOptionPane.showInputDialog("Ievadiet savu pilsētu:");
		iela = JOptionPane.showInputDialog("Ievadiet savu ielu:");
		maja = JOptionPane.showInputDialog("Ievadiet savu mājas numuru:");
		dzivoklis = JOptionPane.showInputDialog("Ievadiet savu dzīvokļa numuru:");
		
		String dati = "Vārds: "+vards+"; Pilsēta: "+pilseta+"; Iela: "+iela+"; Māja: "+maja+"; Dzīvoklis: "+dzivoklis;
		System.out.print(dati);
		
		bw.print(dati);
		bw.close();
		
		do {
			picas = JOptionPane.showInputDialog("1 - Havaju Pica || 2 - Pikantā pica || 3 - Supreme pica || 4 - Paštaisītā || atpakal - Beigt darbības");
			picas = picas.toLowerCase();
			
			switch(picas) {
			
			case "1":
					
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				int siers;
				int peperoni;
				int ananass;
				int olivas;
				int senes;
				for(int i=0; i<masivs.length;i++){
				do {
					siers = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz sieru pievienot? (max 3)"));
				}while(siers>3);
				do {
					peperoni = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz peperoni pievienot? (max 3)"));
				}while(peperoni>3);
				do {
					ananass = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz ananāsu pievienot? (max 3)"));
				}while(ananass>3);
					do {
					olivas = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz olivas pievienot? (max 3)"));
					}while(olivas>3);
					do {
					senes = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz senes pievienot? (max 3)"));
					}while(senes>3);
					masivs[i] = new Pica(siers, peperoni, ananass, olivas, senes);
					pbw.print("Siers: "+siers+"; Peperoni: "+peperoni+"; Ananāss: "+ananass+"; Olivas: "+olivas+"; Sēnes: "+senes);
					pbw.close();
					break;
				}
					
			case "atpakal":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
			
		}while(!picas.equals("atpakal"));
		
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Radusies kļūda", "Kļūda", JOptionPane.ERROR_MESSAGE);
		 }
		 return masivs;
		
	}

	public static void main(String[] args) {
		Pica[] picaMasivs = null;
		String izvele;
		
		do {
			izvele = JOptionPane.showInputDialog("1 - Pievienot pasūtījumu || 2 - Apskatīt picas || stop - Beigt darbības");
			izvele = izvele.toLowerCase();
			
			switch(izvele) {
			
			case "1":
				try{
					int daudzums = Integer.parseInt(JOptionPane.showInputDialog("Cik picas vēlaties pasūtīt?"));
					picaMasivs = new Pica[daudzums];
					picaMasivs = PievienotSutijumu(picaMasivs);
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				}
				break;
			case "2":
			
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
