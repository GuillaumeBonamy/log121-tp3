import java.io.File;

import javax.swing.filechooser.FileFilter;


/**
 * Classe permettant de créer un filtre pour un JFileChooser
 *
 */
public class FiltreImage extends FileFilter{

	private final String[] okFileExtensions = 
    new String[] {"jpg","jpeg" ,"png", "gif", "bmp"};

	/**
	 * Methode permettant de savoir quel fichier afficher selon son extension
	 * @param file le fichier à analyser
	 * @return true si le fichier à l'extension d'une image
	 * 
	 */
	public boolean accept(File file)
	{
		if (file.isDirectory()) {
			return true;
		}
		
		for (String extension : okFileExtensions)
		{
			if (file.getName().toLowerCase().endsWith(extension))
			{
				return true;
			}
		}
		return false;
	}

	
	/**Description du filtre**/
	public String getDescription() {
		return "Fichier image";
	}

	

}
