package javaTester;

public class Topic_05_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String basicUrl = "http://the-internet.herokuapp.com/basic_auth";
		
		String[] authenUrlArray = basicUrl.split("//");
		System.out.println(authenUrlArray[0]);
		System.out.println(authenUrlArray[1]);
	}

}
