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
            int max = array[leftIndex];
            int min = array[leftIndex];
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                if (array[i] > max)  {
                    max = array[i];
                } else if (array[i] < min) {
                    min = array[i];
                }
            }
			Integer[] resposta = new Integer[array.length];
            Integer[] arrayIndices = new Integer[(max-min) + 1];

            for (int i = 0; i < arrayIndices.length; i ++) {
                arrayIndices[i] = 0;
            }

            for (int i = 0; i < resposta.length; i++) {
                resposta[i] = 0;
            }

            for (int i = 0; i < array.length; i++) {
                int j = array[i];
                arrayIndices[j - min] ++;
            }


            for (int i = 1; i < arrayIndices.length; i ++) {
                arrayIndices[i] += arrayIndices[i -1];
            }

            for (int i = (resposta.length) - 1; i >= 0; i--) {
                resposta[arrayIndices[array[i] - min] -1] = array[i];
                arrayIndices[array[i] -min] --;
            }

            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] = resposta[i-leftIndex];
            }
        } 
    }
}
