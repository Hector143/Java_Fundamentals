package Constructors;

public class Doggu {
	
	boolean trained;
	
	Doggu(boolean trained) {
		this.trained = trained;
	}
	
	boolean isTrained() {
		return trained;
	}
	
	public static void main(String[] args) {
		
		Doggu dog = new Doggu(true);
		
		if (dog.isTrained()) {
			System.out.println("The dog is trained?");
			try {
				Thread.sleep(1000);
				System.out.println("True");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("The dog is not trained.");
			try {
				Thread.sleep(1000);
				System.out.println("false");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
