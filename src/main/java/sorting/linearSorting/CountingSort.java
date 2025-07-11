package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 0 && leftIndex != rightIndex) {
			Integer[] resposta = new Integer[array.length];
			int tamanho = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > tamanho)
					tamanho = array[i];
			}
			Integer[] arrayIndices = new Integer[tamanho + 1];

			for (int i = 0; i < arrayIndices.length; i++) {
				arrayIndices[i] = 0;
			}

			for (int i = 0; i < array.length; i++) {
				int j = array[i];
				arrayIndices[j] ++;
			}

			int indexResp = 0;
			for (int i = 0; i <= tamanho; i++) {
				if (arrayIndices[i] != 0) {
					for (int j = indexResp; j < arrayIndices[i]; j ++) {
						resposta[j] = i;
					}
				}
			}
		}
	}

	public static Integer[] print(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 0 && leftIndex != rightIndex) {
			Integer[] resposta = new Integer[array.length];
			int tamanho = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > tamanho)
					tamanho = array[i];
			}
			Integer[] arrayIndices = new Integer[tamanho + 1];

			for (int i = 0; i < arrayIndices.length; i++) {
				arrayIndices[i] = 0;
			}

			for (int i = 0; i < array.length; i++) {
				int j = array[i];
				arrayIndices[j] ++;
			}

			int indexResp = 0;
			for (int i = 0; i <= tamanho; i++) {
				if (arrayIndices[i] != 0) {
					for (int j = indexResp; j < resposta.length; j ++) {
						resposta[j] = i;
					}
					indexResp++;
				}
			}
			return resposta;
		}
		return array;
	}

	public static void main(String[] args) {
		Integer[] array = {10, 0, 8, 4};
		Integer[] resp = print(array, 0, 3);
		System.out.println(Arrays.toString(resp));
	}

}
