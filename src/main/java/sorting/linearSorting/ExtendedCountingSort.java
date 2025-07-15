package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ((array != null) && (array.length > 0) && (leftIndex < rightIndex)) {
			int min = array[leftIndex];
			int max = array[leftIndex];
			for (int i = leftIndex + 1; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
				} else if (array[i] < min) {
					min = array[i];
				}
			}
			int tamanho = (max - min) + 1;
			Integer[] resposta = new Integer[array.length];
			Integer[] arrayIndices = new Integer[tamanho];

			for (int i = 0; i < resposta.length; i++) {
				resposta[i] = 0;
			}

			for (int i = 0; i < arrayIndices.length; i++) {
				arrayIndices[i] = 0;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				int j = array[i];
				arrayIndices[j - min] ++;
			}

			for (int i = 1; i < arrayIndices.length; i++) {
				arrayIndices[i] += arrayIndices[i-1];
			}

			for (int i = (resposta.length) -1; i >= 0 ; i--) {
				resposta[arrayIndices[array[i] - min] -1] = array[i];
				arrayIndices[array[i] - min] --;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = resposta[i - leftIndex];
			}
		}	
	}

}
