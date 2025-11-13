package fileCreatorsKuester;

public class ConcreteReaderCreator extends ReaderCreatorKuester {

	@Override
	public ReaderProductKuester factoryMethod(String typ) {
		if(typ.equals("csv")) {
			return new ConcreteCsvReaderProduct();
		}else {
			return new ConcreteTxtReaderProduct();
		}
	}

}
