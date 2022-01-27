import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Picerija {
	
	public static double cena = 0;
	
	static void PievienotSutijumu(){
		 try {
		FileWriter fw = new FileWriter("Klienti.txt", true);
		PrintWriter bw = new PrintWriter(fw);
		FileWriter pfw = new FileWriter("picas.txt", true);
		PrintWriter pbw = new PrintWriter(pfw);
		String izvele;
		String lielums;
		
		String vards, pilseta, iela, maja, dzivoklis, javed;
		
		vards = JOptionPane.showInputDialog("Ievadiet savu vārdu:");
		pilseta = JOptionPane.showInputDialog("Ievadiet savu pilsētu:");
		iela = JOptionPane.showInputDialog("Ievadiet savu ielu:");
		maja = JOptionPane.showInputDialog("Ievadiet savu mājas numuru:");
		dzivoklis = JOptionPane.showInputDialog("Ievadiet savu dzīvokļa numuru:");
		do {
			javed = JOptionPane.showInputDialog("Vai pica ir jāpiegādā? (1 - jā / 2 - nē / 3 - atgriezties)");
			javed = javed.toLowerCase();
			
			switch(javed) {
			case "1":
				cena=cena+2;
				break;
			case "2":
				break;
			case"atgriezties":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
		}while(javed.equals("atgriezties"));
		
		String dati = "\nVārds: "+vards+"; Pilsēta: "+pilseta+"; Iela: "+iela+"; Māja: "+maja+"; Dzīvoklis: "+dzivoklis;
		
		bw.print(dati);
		bw.close();
		
		do {
			izvele = JOptionPane.showInputDialog("1 - Havaju Pica || 2 - Pikantā pica || 3 - Supreme pica || 4 - Paštaisītā || atpakal - Beigt darbības");
			izvele = izvele.toLowerCase();
			do {
				lielums = JOptionPane.showInputDialog(" 1 - 20cm || 2 - 30cm || 3 - 40cm || 4 - 50cm || atgriezties - aizvērt izvēlni");
				lielums = lielums.toLowerCase();
				
				switch(lielums) {
				
				case "1":
					cena = cena - 2;
					break;
				case "2":
					break;
				case "3":
					cena = cena + 2.50;
					break;
				case "4":
					cena = cena + 5.25;
					break;
				}
				
			}while(lielums.equals("atgriezties"));
			
			switch(izvele) {
			
			
			case "1":
				cena = cena + 12.45;
					JOptionPane.showMessageDialog(null, "Cena par Havaju picu ir "+cena+"€");
					pbw.print("\n Supereme pica,"+" Cena: "+cena+"€");
					pbw.close();
				break;
			case "2":
				cena = cena + 13.45;
				JOptionPane.showMessageDialog(null, "Cena par Pikanto picu ir "+cena+"€");
				pbw.print("\n Supereme pica,"+" Cena: "+cena+"€");
				pbw.close();
				break;
			case "3":
				cena = cena + 15;
				JOptionPane.showMessageDialog(null, "Cena par Supreme picu ir "+cena+"€");
				pbw.print("\n Supereme pica,"+" Cena: "+cena+"€");
				pbw.close();
				break;
			case "4":
				
				int siers;
				int peperoni;
				int ananass;
				int olivas;
				int senes;
					siers = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz sieru pievienot?"));
					peperoni = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz peperoni pievienot?"));
					ananass = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz ananāsu pievienot?"));
					olivas = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz olivas pievienot?"));
					senes = Integer.parseInt(JOptionPane.showInputDialog("Cik daudz senes pievienot?"));
					cena = cena+ 10 + (siers * 0.50) + (peperoni * 0.75) + (ananass * 0.55) + (olivas * 0.85) + (senes * 0.35);
					pbw.print("\nSiers: "+siers+"; Peperoni: "+peperoni+"; Ananāss: "+ananass+"; Olivas: "+olivas+"; Sēnes: "+senes+" Cena: "+cena+"€");
					pbw.close();
				break;
			case "atpakal":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
		}while(izvele.equals("atpakal"));
		
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Radusies kļūda", "Kļūda", JOptionPane.ERROR_MESSAGE);
		 }
	}
	
	static void apskatitPicas() {
		try {
			String teksts, virkne="", teksts2, virkne2="";
			FileReader fr = new FileReader("picas.txt");
			BufferedReader br = new BufferedReader(fr);
			FileReader kfr = new FileReader("Klienti.txt");
			BufferedReader kbr = new BufferedReader(kfr);
			while((teksts=br.readLine()) !=null){
				virkne = virkne+teksts+"\n";
			}
			while((teksts2=kbr.readLine()) !=null){
				virkne2 = virkne2+teksts2+"\n";
			}
			br.close();
			kbr.close();
			JOptionPane.showMessageDialog(null, virkne2+""+virkne);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Radusies kļūda", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public static void main(String[] args) {
		String izvele;
		
		do {
			izvele = JOptionPane.showInputDialog("1 - Pievienot pasūtījumu || 2 - Apskatīt picas || stop - Beigt darbības");
			izvele = izvele.toLowerCase();
			
			switch(izvele) {
			
			case "1":
				try{
					PievienotSutijumu();
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
				}
				break;
			case "2":
			apskatitPicas();
				break;
			case "stop":
				JOptionPane.showMessageDialog(null, "Programma apturēta");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
		}while(izvele.equals("stop"));

	}

}
