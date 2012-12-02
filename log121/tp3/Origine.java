package log121.tp3;


public class Origine {

		private Image state;
	
		/**
		 * Constructeur de la classe Origine
		 */
		public Origine() {}
		
		/**
		 * Methode permettant de creer un nouveau MementoImage
		 * @return le MementoImage creer
		 */
		public MementoImage createMementoImage()
		{
			return new MementoImage(state);
		}
		
		/**
		 * @param state La nouvelle image
		 */
		public void setState(Image state)
		{
			this.state=state;
		}
		
}
