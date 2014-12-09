package pl.au.test.java7;

public class StringInSwitch {
	public static void main(String[] args) {
		
		String messageType = "phone";
		
		switch (messageType) {
		case "email":
			System.out.println("Return email strategy");
			break;
		case "phone":
			System.out.println("Return phone strategy");
			break;
		case "websocket":
			System.out.println("Return websocket strategy");
			break;

		default:
			System.out.println("Return default strategy");
			break;
		}
	}
}
