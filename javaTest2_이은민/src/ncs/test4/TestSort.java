package ncs.test4;


public class TestSort {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		System.out.print("before : [");
		for(int i = 0; i < arr.length; i++) {
			int random = (int) (Math.random() * 51 + 50);
			arr[i] = random;
			
			if(i == arr.length - 1) {
				System.out.print(arr[i]);
			}
			else{
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println("]");
		
		//Selection Sort
		System.out.print("atfer  : [");
		for(int i = 0; i < arr.length; i++) {
			int max = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[max] < arr[j])
					max = j;
			}
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			
			if(i == arr.length - 1 ) {
				System.out.print(arr[i]);
			}
			else{
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println("]");
	}

}
