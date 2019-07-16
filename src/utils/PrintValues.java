package utils;

public class PrintValues {
	public static String getLogin() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome");
		sb.append("1. Login");
		sb.append("2. Register");
		return sb.toString();
	}
}