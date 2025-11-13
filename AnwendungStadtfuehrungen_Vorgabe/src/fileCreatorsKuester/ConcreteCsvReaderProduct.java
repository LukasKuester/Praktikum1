package fileCreatorsKuester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProduct extends ReaderProductKuester{
	BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
		ein = new BufferedReader(new FileReader("Bahnhof.csv"));
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();		
	}

}
