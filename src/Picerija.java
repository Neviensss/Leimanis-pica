import javax.swing.JOptionPane;

public class Picerija {
	
	public static double cena;
	public String[] pica;
	
	public static void PievienotSutijumu() {
		String picas;
		String custom;
		boolean siers = false, desa = false, senes = false, ananass = false, olivas = false;
		int sieraDaudzums = 0, desaDaudzums = 0, senesDaudzums = 0, ananassDaudzums = 0, olivasDaudzums = 0;
		
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
				do {
				custom = JOptionPane.showInputDialog("1 - Siers || 2 - Peperoni || 3 - Sēnes || 4 - Ananāss || 5 - Olīvas || atpakal - atgriezties pie izvēles");
				custom = custom.toLowerCase();
				
				switch(custom) {
				
				case "1":
					if(siers == false) {
						JOptionPane.showMessageDialog(null, "Tu picai pievienoji sieru");
						cena = cena + 0.25;
						siers = true;
						sieraDaudzums++;
						System.out.println(sieraDaudzums);
					}else if(siers == true && sieraDaudzums <=2) {
						JOptionPane.showInputDialog(null, "Tu jau pievienoji sieru, vēlies pielikt vēl? (1 - jā || 2 - nē)");
						cena = cena + 0.25;
						sieraDaudzums++;
						System.out.println(sieraDaudzums);
					}else if(siers == true && sieraDaudzums >=3) {
						JOptionPane.showMessageDialog(null, "Tu vairs nevari pielikt sieru");
					}
				case "2":
					if(desa == false) {
						JOptionPane.showMessageDialog(null, "Tu picai pievienoji peperoni");
						cena = cena + 0.25;
						desa = true;
						desaDaudzums++;
						System.out.println(desaDaudzums);
					}else if(desa == true && desaDaudzums <=2) {
						JOptionPane.showInputDialog(null, "Tu jau pievienoji peperoni, vēlies pielikt vēl? (1 - jā || 2 - nē)");
						cena = cena + 0.25;
						desaDaudzums++;
						System.out.println(desaDaudzums);
					}else if(desa == true && desaDaudzums >=3) {
						JOptionPane.showMessageDialog(null, "Tu vairs nevari pielikt peperoni");
					}
				case "3":
					if(senes == false) {
						JOptionPane.showMessageDialog(null, "Tu picai pievienoji sēnes");
						cena = cena + 0.25;
						senes = true;
						senesDaudzums++;
						System.out.println(senesDaudzums);
					}else if(senes == true && senesDaudzums <=2) {
						JOptionPane.showInputDialog(null, "Tu jau pievienoji sēnes, vēlies pielikt vēl? (1 - jā || 2 - nē)");
						cena = cena + 0.25;
						senesDaudzums++;
						System.out.println(senesDaudzums);
					}else if(senes == true && senesDaudzums >=3) {
						JOptionPane.showMessageDialog(null, "Tu vairs nevari pielikt sēnes");
					}
				case "4":
					if(ananass == false) {
						JOptionPane.showMessageDialog(null, "Tu picai pievienoji ananāsu");
						cena = cena + 0.25;
						ananass = true;
						ananassDaudzums++;
						System.out.println(ananassDaudzums);
					}else if(ananass == true && ananassDaudzums <=2) {
						JOptionPane.showInputDialog(null, "Tu jau pievienoji ananāsu, vēlies pielikt vēl? (1 - jā || 2 - nē)");
						cena = cena + 0.25;
						ananassDaudzums++;
						System.out.println(ananassDaudzums);
					}else if(ananass == true && ananassDaudzums >=3) {
						JOptionPane.showMessageDialog(null, "Tu vairs nevari pielikt ananāsu");
					}
				case "5":
					if(olivas == false) {
						JOptionPane.showMessageDialog(null, "Tu picai pievienoji olīvas");
						cena = cena + 0.25;
						olivas = true;
						olivasDaudzums++;
						System.out.println(olivasDaudzums);
					}else if(olivas == true && olivasDaudzums <=2) {
						JOptionPane.showInputDialog(null, "Tu jau pievienoji olīvas, vēlies pielikt vēl? (1 - jā || 2 - nē)");
						cena = cena + 0.25;
						olivasDaudzums++;
						System.out.println(olivasDaudzums);
					}else if(olivas == true && olivasDaudzums >=3) {
						JOptionPane.showMessageDialog(null, "Tu vairs nevari pielikt olīvas");
					}
					case "atpakal":
						sieraDaudzums  = 0;
						desaDaudzums  = 0;
						senesDaudzums = 0;
						ananassDaudzums = 0;
						olivasDaudzums = 0;
						break;
				}
				
				}while(!custom.equals("atpakal"));
				
				break;
			case "atpakal":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv");
				break;
			}
			
		}while(!picas.equals("atpakal"));
		
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
