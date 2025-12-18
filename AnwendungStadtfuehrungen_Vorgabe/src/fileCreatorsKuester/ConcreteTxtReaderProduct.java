package fileCreatorsKuester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProduct extends ReaderProductKuester {
	BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
		ein = new BufferedReader(new FileReader("Bahnhof.txt"));
		String[] ergebnisZeile=new String[5];
		String zeile = ein.readLine();
		int i=0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[i]=zeile;
			zeile=ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();

	}

}
