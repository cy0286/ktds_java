package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	/**
	 * 순열 배열
	 */
	private int[] permutation;

	/**
	 * 순열 방문 여부 배열
	 */
	private boolean[] visited;
	
	/**
	 * 순열 결과 배열
	 */
	private List<int[]> results;
	
	public Permutation(int arrayCount) {
		this.permutation = new int[arrayCount];
		this.visited = new boolean[arrayCount];
		this.results = new ArrayList<>();
	}
	
	public void permutation(int[] array) {
	
		for (int i = 0; i < array.length; i++) {
			this.permutation(array, 0, i + 1);
		}
	}
	
	/**
	 * 순열 생성
	 * @param array 순열을 만들 원본 배열
	 * @param radix 순열을 만들 때 필요한 지리수
	 * @param length 순열로 만들고 싶은 배열의 자리수
	 */
	public void permutation(int[] array, int radix, int length) {
		
		if (length == radix) {
			// 데이터가 완성되면 List<int[]> results 에 결과를 담아준다.
			int[] copyPermutation = new int[length];
			// this.permutation의 값을 copyPermutation으로 복사한다.
			System.arraycopy(this.permutation, 0, copyPermutation, 0, copyPermutation.length);
			this.results.add(copyPermutation);
			// 현재 Call Stack 을 Pop 한다.
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			// 아직 방문하지 않은 인덱스라면
			if (!this.visited[i]) {
				this.visited[i] = true; // 방문완료!
				
				// 순열데이터를 만들어준다.
				// permutation[radix]에 원본배열[i] 값을 할당한다.
				this.permutation[radix] = array[i];
				
				// radix 가 만약 0이었다면 다음자리인 1번자리에 값을 할당하기 위해서
				// radix 를 하나 증가시켜 다시 permutation 을 호출한다.
				this.permutation(array, radix + 1, length);
				
				// permutation 에 모든 값을 할당했다. 라는 의미다.
				// 다시 처음부터 시작하기 위해서 i 번째 방문여부 값을 false 로 바꿔준다.
				this.visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation p = new Permutation(3);
		
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		
		p.permutation(array);
		
		p.results.forEach(perm -> {
			System.out.println(Arrays.toString(perm));
		});
	}
}
