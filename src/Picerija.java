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
		FileWriter afw = new FileWriter("pasutijumi.txt", true);
		PrintWriter abw = new PrintWriter(afw);
		String izvele;
		String lielums;
		int ved = 0;
		
		String vards, pilseta, iela, maja, dzivoklis, javed;
		
		vards = JOptionPane.showInputDialog("Ievadiet savu vārdu:");
		pilseta = JOptionPane.showInputDialog("Ievadiet savu pilsētu:");
		iela = JOptionPane.showInputDialog("Ievadiet savu ielu:");
		maja = JOptionPane.showInputDialog("Ievadiet savu mājas numuru:");
		dzivoklis = JOptionPane.showInputDialog("Ievadiet savu dzīvokļa numuru:");
		do {
			javed = JOptionPane.showInputDialog("Vai pica ir jāpiegādā? (1 - jā / 2 - nē / atpakal - atgriezties)");
			javed = javed.toLowerCase();
			
			switch(javed) {
			case "1":
				ved = 1;
				cena=cena+2;
				break;
			case "2":
				ved = 0;
				break;
			case "atpakal":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
		}while(javed.equals("atpakal"));
		
		
		String dati = "\nVārds: "+vards+"; Pilsēta: "+pilseta+"; Iela: "+iela+"; Māja: "+maja+"; Dzīvoklis: "+dzivoklis;
		do {
		lielums = JOptionPane.showInputDialog(" 1 - 20cm || 2 - 30cm || 3 - 40cm || 4 - 50cm || atpakal - aizvērt izvēlni");
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
		case "atpakal":
			break;
		default:
			JOptionPane.showMessageDialog(null, "Darbība nepastāv");
			break;
		}
		}while(lielums.equals("atpakal"));
		
		
		do {
			izvele = JOptionPane.showInputDialog("1 - Izvēlēties izmēru || 2 - Havaju Pica || 3 - Pikantā pica || 4 - Supreme pica || 5 - Paštaisītā || atpakal - Beigt darbības");
			izvele = izvele.toLowerCase();
			
			
			switch(izvele) {
			
			case "1":
				break;
			case "2":
				cena = cena + 12.45;
					JOptionPane.showMessageDialog(null, "Cena par Havaju picu ir "+cena+"€");
					abw.print("Pasūtītājs: "+dati+"\n"
							+ " Pikantā pica,"+" Cena: "+cena+"€");
					pbw.print("\n Havajas pica,"+" Cena: "+cena+"€");
					cena = cena - 12.45;
					pbw.close();
					abw.close();
				break;
			case "3":
				cena = cena + 13.45;
				JOptionPane.showMessageDialog(null, "Cena par Pikanto picu ir "+cena+"€");
				abw.print("Pasūtītājs: "+dati+"\n"
						+ " Pikantā pica,"+" Cena: "+cena+"€");
				pbw.print("\n Pikantā pica,"+" Cena: "+cena+"€");
				cena = cena - 13.45;
				pbw.close();
				abw.close();
				break;
			case "4":
				cena = cena + 15;
				JOptionPane.showMessageDialog(null, "Cena par Supreme picu ir "+cena+"€");
				abw.print("Pasūtītājs: "+dati+"\n"
						+ " Pikantā pica,"+" Cena: "+cena+"€");
				pbw.print("\n Supereme pica,"+" Cena: "+cena+"€");
				cena = cena - 15;
				pbw.close();
				abw.close();
				break;
			case "5":
				
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
					bw.print(dati);
					pbw.print("\nSiers: "+siers+"; Peperoni: "+peperoni+"; Ananāss: "+ananass+"; Olivas: "+olivas+"; Sēnes: "+senes+" Cena: "+cena+"€");
					abw.print("Pasūtītājs: "+dati+"\n"
							+ " Pica: Siers: "+siers+"; Peperoni: "+peperoni+"; Ananāss: "+ananass+"; Olivas: "+olivas+"; Sēnes: "+senes+" Cena: "+cena+"€");
					pbw.close();
					bw.close();
					abw.close();
				break;
			case "atpakal":
				if(ved == 1) {
					cena = cena -2;
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
		}while(!izvele.equals("atpakal"));
		
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Radusies kļūda", "Kļūda", JOptionPane.ERROR_MESSAGE);
		 }
	}
	
	static void apskatitPicas() {
		try {
			String teksts, virkne="";
			FileReader fr = new FileReader("pasutijumi.txt");
			BufferedReader br = new BufferedReader(fr);
			while((teksts=br.readLine()) !=null){
				virkne = virkne+teksts+"\n";
			}
			br.close();
			JOptionPane.showMessageDialog(null, virkne);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Radusies kļūda", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	static void apskatitCenas() {
		String izvele;
		do {
			izvele = JOptionPane.showInputDialog("1 - Cenas picām || 2 - Cenas Piedevām || atpakal - atgriezties");
			izvele = izvele.toLowerCase();
			
			switch(izvele) {
			case"1":
				JOptionPane.showMessageDialog(null, "Havajas Pica = 20cm - 10.45€ , 30cm - 12.45€ , 40cm - 14.95€ , 50cm - 17.70€, Piegāde - 2€\n"+
						"Pikantā Pica = 20cm - 11.45€ , 30cm - 13.45€ , 40cm - 15.95€ , 50cm - 21.20€, Piegāde - 2€\n"+
						"Supreme Pica = 20cm - 13€ , 30cm - 15€ , 40cm - 17€ , 50cm - 22.20€, Piegāde - 2€");
				break;
			case"2":
				JOptionPane.showMessageDialog(null, "Siers - 0.50€, Peperoni - 0.75€, Ananāss - 0.55€, Olīvas - 0.85€, Sēnes - 0.35€, Piegāde - 2€");
				break;
			case"atpakal":
				JOptionPane.showMessageDialog(null, "Cenu katalogs aizvērts", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				break;
				default:
					JOptionPane.showMessageDialog(null, "Darbība nepastāv");
					break;
			}
		
		}while(!izvele.equals("atpakal"));
	}

	public static void main(String[] args) {
		String izvele;
		
		do {
			izvele = JOptionPane.showInputDialog("1 - Pievienot pasūtījumu || 2 - Apskatīt picas || 3 - Apskatīt cenas || stop - Beigt darbības");
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
			case "3":
				apskatitCenas();
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
