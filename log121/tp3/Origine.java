package log121.tp3;


public abstract class Origine {

		private static Image state;
	
		/**
		 * Constructeur de la classe Origine
		 */
		public Origine() {}
		
		/**
		 * Methode permettant de creer un nouveau MementoImage
		 * @return le MementoImage creer
		 */
		public static MementoImage createMementoImage()
		{
			return new MementoImage(state);
		}
		
		/**
		 * @param state La nouvelle image
		 */
		public static void setState(Image newState)
		{
			state=newState;
		}
		
}
