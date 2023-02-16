package dailyChallenge;

/*
*@Author SORO
*/
public class ArrayProcessorLambdas {

	// Définir la variable de type ArrayProcessor pour trouver la valeur maximale
	// dans un tableau
	public static final ArrayProcessor max = (double[] array) -> {
		double maxValue = Double.NEGATIVE_INFINITY;
		for (double value : array) {
			maxValue = Math.max(maxValue, value);
		}
		return maxValue;
	};

	// Définir la variable de type ArrayProcessor pour trouver la valeur minimale
	// dans un tableau
	public static final ArrayProcessor min = (double[] array) -> {
		double minValue = Double.POSITIVE_INFINITY;
		for (double value : array) {
			minValue = Math.min(minValue, value);
		}
		return minValue;
	};

	// Définir la variable de type ArrayProcessor pour trouver la somme des valeurs
	// dans un tableau
	public static final ArrayProcessor sum = (double[] array) -> {
		double total = 0;
		for (double value : array) {
			total += value;
		}
		return total;
	};

	// Définir la variable de type ArrayProcessor pour trouver la moyenne des
	// valeurs dans un tableau
	public static final ArrayProcessor average = (double[] array) -> {
		return sum.apply(array) / array.length;
	};

	// Définir une fonction pour retourner un ArrayProcessor qui compte le nombre de
	// fois où une valeur donnée se produit dans un tableau
	public static ArrayProcessor counter(double value) {
		return (double[] array) -> {
			int count = 0;
			for (double val : array) {
				if (val == value) {
					count++;
				}
			}
			return count;
		};
	}
	
	
	public static void main(String[] args) {
	    double[] array = {1, 5, 3, 4, 5, 6, 7, 8, 5., 5};
	    
	    System.out.println("La valeur maximale dans le tableau est : " + max.apply(array));
	    System.out.println("La valeur minimale dans le tableau est : " + min.apply(array));
	    System.out.println("La somme des valeurs dans le tableau est : " + sum.apply(array));
	    System.out.println("La moyenne des valeurs dans le tableau est : " + average.apply(array));
	    
	    ArrayProcessor countFive = counter(5);
	    System.out.println("Le nombre de fois où la valeur 5 se produit dans le tableau est : " + countFive.apply(array));
	  }

}

