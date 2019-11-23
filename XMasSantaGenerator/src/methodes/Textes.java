package methodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Textes {
	private String text = "";

	ArrayList<String> donneur = new ArrayList<>();
	ArrayList<String> save = new ArrayList<>();
	ArrayList<String> receuveur = new ArrayList<>();


	public String randomDistrib() {
		String res = "";

		//Split le textarea(\n) et l'add dans donneur
		String[] tab = text.split("\n");
		for (String string : tab) {
			donneur.add(string);
		}
		
		//trie donneur
		Collections.sort(donneur);

		//distribution des receuveur
		distribution();

		//System.out.println(donneur + "\n" + receuveur);
		//anti last equal
		antiLast();

		//mise en forme pour return du String
		for (int i = 0; i < donneur.size(); i++) {
			res += donneur.get(i) + " --> " + receuveur.get(i) + "\n" ;
		}
		return res;
	}

	/**
	 * Distribu les donneur vers les receuveur
	 */
	@SuppressWarnings("unchecked")
	private void distribution() {
		save= (ArrayList<String>) donneur.clone();
		for (int i = 0; i < donneur.size(); i++) {
			int r;
			do {
				r = new Random().nextInt(save.size());
				//System.out.println(r + "" + i);
			}while(save.get(r)==donneur.get(i) && save.size()>1);
			receuveur.add(save.get(r));
			save.remove(r);
		}
	}



	/**
	 * Evite que le dernier donneur et receuveur.
	 */
	private void antiLast() {
		int lastidx = donneur.size()-1;
		if(receuveur.get(lastidx)==donneur.get(lastidx)) {
			String save = receuveur.get(lastidx);
			receuveur.set(lastidx, receuveur.get(lastidx-1));
			receuveur.set(lastidx-1, save);

			//System.out.println("after anti last equal");
			//System.out.println(donneur + "\n" + receuveur);
		}
	}


	public Textes(String text) {
		this.text = text;
	}
}
