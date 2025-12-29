import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
//	final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
	private static final String RESOURCES = "/data/bank-data-simple.csv";
	public static void main(String[] args) {
		try{
			final Path path = Paths.get(RESOURCES);
			final List<String> lines = Files.readAllLines(path);
			double total = 0;
			for (String line : lines) {
				final String[] columns = line.split(",");
				final double amount = Double.parseDouble(columns[1]);
				total += amount;
			}
			System.out.println("Total: " + total);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
