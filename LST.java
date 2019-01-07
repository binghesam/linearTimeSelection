public class BFPRT {
	public int find(int[] a, int j) {
		System.out.println("================================");
		System.out.println(" ： ");
		print(a);
		System.out.println(" " + j + "");
		if (a.length / 5 == 1) {
			return a[a.length - 1];
		}
 
		int x = getCenterForArray(a);
 
		//
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
 
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= x) {
				left.add(a[i]);
			} else {
				right.add(a[i]);
			}
		}
		// 
		int K = left.size();
		if (j == K) {
			return x;
		} else if (j < K) {
			int[] leftArray = new int[left.size()];
			for (int i = 0; i < left.size(); i++) {
				leftArray[i] = left.get(i);
			}
			return find(leftArray, j);
		} else {
			int[] rightArray = new int[right.size()];
			for (int i = 0; i < right.size(); i++) {
				rightArray[i] = right.get(i);
			}
			return find(rightArray, j - K);
		}
	}
 
	// 
	private int getCenterForArray(int[] a) {
		// 
		int length = a.length;
		int num = length / 5;
		int[] centers = new int[num];
		for (int i = 0; i < num; i++) {
			
			int center = getCenterPerArray(a, 5 * i, 5 * (i + 1) - 1);
			centers[i] = center;
			System.out.println(": " + center);
		}
		System.out.println("： ");
		print(centers);
		// 
		new Selectionsort().sort(centers);
		System.out.println("： ");
		print(centers);
		int x = 0;
 
		if (centers.length % 2 == 0) {
			// 
			x = min(centers[centers.length / 2 - 1],
					centers[centers.length / 2]);
		} else {
			x = centers[centers.length / 2];
		}
		System.out.println("x  ： " + x);
 
		return x;
	}
 
	private int min(int a, int b) {
		if (a >= b) {
			return b;
		} else {
			return a;
		}
	}
 
	// 
	private int getCenterPerArray(int[] a, int start, int end) {
		// 
		int[] b = new int[end - start + 1];
		int index = 0;
		for (int i = start; i <= end; i++) {
			b[index++] = a[i];
		}
		System.out.println("： ");
		print(b);
		new Insertsort().sort(b);
		return b[b.length / 2];
	}
 
	public static void main(String[] args) {
		
 
		int[] datas = { 4, 1, 2, 56, 24, 5, 6, 97, 8, 0, 4, 8, 6, 2, 3, 6, 1,
				9, 3, 4, 6, 2 };
		int index = 8;
		int findX = new BFPRT().find(datas, index);
		datas = new QuickSort().sort(datas);
		print(datas);
		System.out.println("" + index + " ： " + findX);
	}
 
	public static void print(int[] datas) {
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i] + " ");
		}
		System.out.println("");
	}
 
}