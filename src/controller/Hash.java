package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Hash {
	public void Inicio(){
		JOptionPane.showMessageDialog(null, "Bem vinfo, iniciando...");
		ArrayList vet[] = new ArrayList[26];
		for(int i = 0; i < 26; i++){
			vet[i] = new ArrayList<String>();
		}
		String nome;
		int indice;
		for(int i = 0; i < 100; i++) {
			nome = nomeAleatorio();
			indice = hash(nome);
			vet[indice].add(nome);
		}
		mostrar(vet);
	}

	public static String nomeAleatorio() {
		String consonants = "BCDFGHJKLMNPQRSTVWXZ";
		String vowels = "AEIOUY";
		String nome = "";
		if(Math.random()< 0.2){
			nome += vowels.charAt((int)(Math.random()*6));
			nome += consonants.charAt((int)(Math.random()*20));
			nome += vowels.charAt((int)(Math.random()*6));
			nome += consonants.charAt ((int)(Math.random()*20));
			nome += vowels.charAt((int)(Math.random()*6));
		}else{
			nome += consonants.charAt((int)(Math.random()*20));
			nome += vowels.charAt((int)(Math.random()*6));
			nome += consonants.charAt((int)(Math.random()*20));
			nome += vowels.charAt((int)(Math.random()*6));
		}
		return nome;
	}

	public static void mostrar(ArrayList[] v) {
		for(int i = 0; i < 26; i++) {
			System.out.println (v[i].toString());
		}
	}

	public static int hash(String texto){
		char ch = texto.charAt(0);
		int index = ch;
		if(ch > 64 && ch < 91){
			index -= 65;
		}else if(ch > 96 && ch < 123){
			index -= 97;
		}else{ 
			throw new Error("char not letter");
		}
		return index;
	}
}
