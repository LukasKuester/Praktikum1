package fileCreatorsKuester;

import java.io.IOException;

public abstract class ReaderProductKuester {
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
