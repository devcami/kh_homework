package ncs.test2;

public class CharTest {

	public static void main(String[] args) {
		String input = args[0];
		char[] ch = input.toCharArray();
		
		for(int i = ch.length - 1; i >= 0; i--) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] -= 32;
			}
			System.out.print(ch[i]);
		}
		
	}

}
