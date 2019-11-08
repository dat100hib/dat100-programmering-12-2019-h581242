package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;
import javax.swing.JOptionPane;
import java.io.File;


public class SkrivBlogg {
	
	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		
		boolean print = true;
		
		 PrintWriter skriver;
		 
		try {
			File file = new File(MAPPE + filnavn);
			skriver = new PrintWriter(file);
	        skriver.println(samling.toString());
	        skriver.close();
	        
		} catch (FileNotFoundException e) {
			print = false;
			JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + e.getMessage());
		}
		return print;
	}
}