package workshop5;

public class Test01 {

	public static void main(String[] args) {
		char[] charArr = args[0].toCharArray();
		
		for(int i = charArr.length - 1; i >= 0; i--) {
			System.out.println(charArr[i]);
		}
	}

}
