package view.Dialogs;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import view.GlavniProzor;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9092523893932457031L;

	public HelpDialog() {

		JDialog dialog = new JDialog();

		dialog.setTitle("Help");
		  JTextArea txtArea = new JTextArea(20,80);
          txtArea.setAutoscrolls(true);
          txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          txtArea.setFont(new Font("SansSerif", Font.BOLD, 16));
          txtArea.setLineWrap(true);
          txtArea.setEditable(false);
          JScrollPane txtAreaScroll = new JScrollPane (txtArea, 
          JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          txtAreaScroll.setViewportView(txtArea);
          txtAreaScroll.setAutoscrolls(true);

		String text = "KORISCENJE APLIKACIJE:\r\n" + 
				"-se oslanja na sledece funkcionalnosti:\r\n" + 
				"1. Dodavanje novog studenta:[u tabu studenti] klikom na prvo dugme[Dodaj] iz toolbara dobijate mogucnost dodavanja entiteta student u sistem.\r\n" + 
				"2. Izmena postojeceg studenta:[u tabu studenti] klikom na drugo dugme[Izmeni] iz toolbara imate mogucnost menjanja odabranog entiteta student u sistemu.\r\n" + 
				"3. Brisanje postojeceg studenta:[u tabu studenti] klikom na trece dugme[Izbrisi] iz toolbara imate mogucnost brisanja odabranog entiteta student iz sistema.\r\n" + 
				"4. Kombinovana pretraga studenta:[u tabu studentii] klikom na dugme za pretragu, mozete vrsiti i prostu i slozenu pretragu. Npr: ime:Marko; ili ime:Marko;prezime:Peric;\r\n" + 
				"5. Sortiranje studenata: [u tabu studenti] prilikom klika na odgovarajuce ime kolone, vrsi se sortiranje tabele po toj koloni.\r\n" + 
				"6. Dodavanje studenata na predmet: [u tabu predmeti] klikom na cetvrto dugme[Dodaj studenta] iz toolbara, imate mogucnost dodavanja studenta na taj predmet.\r\n" + 
				"7. Uklanjanje studenata sa predmeta:[u tabu predmeti] prilikom klika na neko polje iz poslednje kolone, otvara se spisak studenata koji taj predmeta ima, a tu imate mogucnost uklanjanja studenta sa predmeta.\r\n" + 
				"\r\n" + 
				"8. Dodavanje novog predmeta: [u tabu predmeti] klikom na prvo dugme[Dodaj] iz toolbara dobijate mogucnost dodavanja entiteta predmet u sistem.\r\n" + 
				"9. Izmena postojeceg predmeta: [u tabu predmeti] klikom na drugo dugme[Izmeni] iz toolbara dobijate mogucnost menjanja entiteta predmet u sistemu.\r\n" + 
				"10.  Brisanje postojeceg predmeta: [u tabu predmeti] klikom na trece dugme[Izbrisi] iz toolbara dobijate mogucnost brisanja entiteta predmet iz sistema.\r\n" + 
				"11.  Kombinovana pretraga predmeta: [u tabu predmeti] klikom na dugme za pretragu, mozete vrsiti i prostu i slozenu pretragu. Npr: naziv:Analiza.\r\n" + 
				"12.  Sortiranje predmeta:[u tabu predmeti] prilikom klika na odgovarajuce ime kolone, vrsi se sortiranje tabele po toj koloni.\r\n" + 
				"\r\n" + 
				"13. Dodavanje novog profesora: [u tabu profesori] klikom na prvo dugme[Dodaj] iz toolbara dobijate mogucnost dodavanja entiteta profesor u sistem.\r\n" + 
				"14. Izmena postojeceg profesora: [u tabu profesori] klikom na drugo dugme[Izmeni] iz toolbara dobijate mogucnost menjanja entiteta profesor u sistemu. \r\n" + 
				"15. Brisanje postojeceg profesora: [u tabu profesori] klikom na trece dugme[Izbrisi] iz toolbara dobijate mogucnost brisanja entiteta profesor iz sistema. \r\n" + 
				"16. Kombinovana pretraga profesora: [u tabu profesori] klikom na dugme za pretragu, mozete vrsiti i prostu i slozenu pretragu. Npr: ime:Marko; ili ime:Marko;prezime:Peric;\r\n" + 
				"17. Sortiranje profesora: [u tabu profesori] prilikom klika na odgovarajuce ime kolone, vrsi se sortiranje tabele po toj koloni.\r\n" + 
				"\r\n" + 
				"18. Dodavanje profesora na predmet: [u tabu predmeti] klikom na peto dugme[Dodaj profesora] iz toolbara, imate mogucnost dodavanja profesora na taj predmet. \r\n" + 
				"19.  Uklanjanje profesora sa predmeta [u tabu profesori] klikom na poslednju kolonu, za izabrano polje dobijamo spisak predmeta tog profesora i tu imamo mogucnost brisanja profesora sa predmeta.\r\n" + 
				"\r\n" + 
				"PRECICE:\r\n" + 
				"CTRL-N: u zavisnosti od taba imate mogucnost dodavanja novog entiteta u sistem.\r\n" + 
				"CTRL-W: imate mogucnost naglog prekidanja programa bez sacuvavanja izmena u predjasnjem radu.\r\n" + 
				"CTRL-E: u zavisnosti od taba imate mogucnost menjanja odabranog entiteta.\r\n" + 
				"CTRL-D: u zavisnosti od taba imate mogucnost brisanja odabranog entiteta iz sistema.\r\n" + 
				"CTRL-H: dobijanje informacija o precicama i nacinu koriscenja aplikacije.\r\n" + 
				"CTRL-I: dobijanje informacija o kreatorima i glavnim izvrsiocima programa.\r\n" + 
				"\r\n" + 
				"MNEMONICI:\r\n" + 
				"ALT-F: Otvara karticu File u meny bary, zatim na ALT-N otvaramo kreiranje novog entiteta, a na ALT-W zatvaramo prozor\r\n" + 
				"ALT-E:  Otvara karticu Edit u meny bary , zatim na ALT-E otvaramo editovanje postojeceg entitera a na ALT-D brisemo selektovani entitet u tabeli\r\n" + 
				"ALT-H:  Otvara karticu Help u meny bary , zatim na ALT-H otvaramo karticu sa informacijama o precicama i nacinu koriscenja aplikacije, ALT-I otvaramo karticu sa informacijama o kreatorima i glavnim izvrsiocima programa\r\n" + 
				"ALT-S: Direktno nas navigira na tabelu sa studentima\r\n" + 
				"ALT-P: Direktno nas navigira na tabelu sa profesorima\r\n" + 
				"ALT-R: Direktno nas navigira na tabelu sa predmetima\r\n" + 
				"\r\n" + 
				"FORMATI:\r\n" + 
				"DATUM UPISA: Format datuma upisa je u sledecem obliku YYYY-MM-DD , sto znaci prvo navodimo godinu (YYYY) pa zatim mesec (MM) i na kraju dan, separatisani su crticom (\"-\"). Datum upisa mora biti manji od trenutnog datuma, takodje student mora biti stariji od 18 godina u trenutku upisa na fakultet.\r\n" + 
				"DATUM RODJENJA: Format datuma rodjenja je u sledecem obliku YYYY-MM-DD , sto znaci prvo navodimo godinu (YYYY) pa zatim mesec (MM) i na kraju dan, separatisani su crticom (\"-\").\r\n" + 
				"INDEX STUDENTA: Podrzani format indexa studenta je sledeceg oblika: XXYYY-BBBB , sto znaci pocetak indexa je jedno ili dva velika slova, zatim slede cifre, jedna ili tri cifre, zatim crtica i na kraju godina upisa cetiri cifre, u rasponu od 1000-2999\r\n" + 
				"";

		txtArea.setText(text);

		dialog.add(txtAreaScroll);
		dialog.pack();
		dialog.setLocationRelativeTo(GlavniProzor.getInstance());
		dialog.setVisible(true);
	}

}
