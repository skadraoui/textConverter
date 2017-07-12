import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hardis.fr.text.converter.exceptions.ReportException;
import com.hardis.fr.text.converter.soa.TextParserSOA;

/**
 * Classe principale
 * 
 * @author SFKI
 *
 */
public class Principal {
	public static void main(String[] args) throws ReportException, IOException {
		if (args.length == 3) {
			String fichierEntree = args[0];
			String formatFichier = args[1];
			String fichierSortie = args[2];
			// String entryFileName =
			// Principal.class.getResource("/references.txt").getFile();
			File fileEntree = new File(fichierEntree);
			if (!fileEntree.exists() || !fileEntree.isFile()) {
				throw new ReportException("Le fichier à traiter est inexistant! Traitement impossible");
			}
			File fileSortie = new File(fichierSortie);
			if (!fileSortie.exists() || !fileSortie.isFile()) {
				throw new IOException("Le fichier en sortie est inexistant! Traitement impossible");
			}
			ApplicationContext context = new ClassPathXmlApplicationContext("t9-custom-spring-context.xml");
			TextParserSOA textParserBean = (TextParserSOA) context.getBean("textParserSOA");

			// String resultFileName =
			// Principal.class.getResource("/ReportSortie.txt").getFile();

			if ("XML".equals(formatFichier.toUpperCase())) {
				// écrire le flux construit dans un fichier en sortie
				ecrireFluxDansFichierEnSortir(textParserBean.generateXmlFromText(fileEntree), fileSortie);

			} else if ("JSON".equals(formatFichier.toUpperCase())) {
				// écrire le flux construit dans un fichier en sortie
				ecrireFluxDansFichierEnSortir(textParserBean.generateJsonFromText(fileEntree), fileSortie);
			}
		} else {
			throw new IllegalArgumentException("Arguments attendus non trouvé ! Traitement impossible");
		}
	}

	/**
	 * écrire le flux construit dans un fichier en sortie
	 * 
	 * @param fluxResultat
	 *            rapport généré
	 * @param file
	 *            chemin vers le fichier en sortie
	 * @throws IOException
	 *             exception en cas de problème de lecture du fichier en sortie
	 */
	private static void ecrireFluxDansFichierEnSortir(String fluxResultat, File file) throws IOException {

		final BufferedWriter writer;

		writer = new BufferedWriter(new FileWriter(file));
		writer.append(fluxResultat);
		writer.flush();
		writer.close();

	}
}
