import java.util.Scanner;

public class NoeudArbre {
	
	private String contenu;
	private NoeudArbre gauche;
	private NoeudArbre droit;
	
	public NoeudArbre(){}
	
	public NoeudArbre(String contenu) {
		this.contenu = contenu;
		gauche = null;
		droit = null;
	}
	
	public NoeudArbre(String contenu, NoeudArbre gauche, NoeudArbre droit) {
		this(contenu);
		this.gauche = gauche;
		this.droit = droit;
	}
	
	public boolean estFeuille() {
		return gauche == null && droit == null;
	}
	
	public String rechercherAnimal() {
		if (estFeuille()) {
			return "Est-ce " + contenu + " ?";
		}
		return contenu;
	}
	
	public void apprendre(String contenu) {
		if (gauche == null) {
			gauche = new NoeudArbre(contenu);
		}
	}
	
	public String getContenu() {
		return contenu;
	}
	
	public String toString() {
		String str = "\"" + contenu + "\"";
		
		if (gauche != null) {
			str += " " + gauche.toString();
		}
		
		if (droit != null) {
			str += " " + droit.toString();
		}
		
		return str;
	}
	
	public static void main(String args[]) {
		NoeudArbre arbre = new NoeudArbre("Est-ce un mamifère ?", new NoeudArbre("Un crocodile ?"), new NoeudArbre("Ext-ce qu'il aboie?", new NoeudArbre("Un cheval"), new NoeudArbre("Un chien")));
		/*System.out.println(arbre);*/
		Scanner sc = new Scanner(System.in);
		boolean gameOver = false;
		
		while (!gameOver) {
		NoeudArbre tmp = arbre;
		String reponse = null;
			do {
				System.out.println(tmp.rechercherAnimal());
				reponse = sc.nextLine();
				if (reponse.equals("oui")) {
					if (tmp.estFeuille()) {
						System.out.print("J'ai trouvé !");
						break;
					}
					else {
						tmp = tmp.droit;
					}
				}
				else if (reponse.equals("non"))  {
					if (tmp.estFeuille()) {
						System.out.println("Qu'est-ce que c'est ?");
						reponse = sc.nextLine();
						tmp.apprendre(reponse);
						break;
					}
					else {
						tmp = tmp.gauche;
					}
				}
			}while (true);
			
			System.out.println("Voulez-vous rejouer ?");
			reponse = sc.nextLine();
			if (reponse.equals("non")) {
				gameOver = true;
			}
		}
	}
}
