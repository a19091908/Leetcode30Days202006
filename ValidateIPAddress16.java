package leetCodeJun2020;

public class ValidateIPAddress16 {
	private String IPv4 = "IPv4";
	private String IPv6 = "IPv6";
	private String Neither = "Neither";

	public static void main(String[] args) {
//		String IP = "172.16.254.1";
//		String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
		String IP = "256.256.256.256";
		
		ValidateIPAddress16 validateIP = new ValidateIPAddress16();
		String ans = validateIP.validIPAddress(IP);
		System.out.println(ans);

	}

	private String validIPAddress(String IP) {
		
		if (IP.indexOf(".") != -1) {
			return validateIPv4(IP);
		}else
		if (IP.indexOf(":") != -1) {
			return validateIPv6(IP);
		}else {
			return Neither;
		}

	}
	
	private String validateIPv4(String ip) {
		if (ip.charAt(0)=='.' || ip.charAt(ip.length()-1)=='.') 
			return Neither;
		
		String[] spiltedIPArr = ip.split("\\.");
		
		if (spiltedIPArr.length != 4) 
			return Neither;
		
		for (int i = 0; i < spiltedIPArr.length; i++) {
			String tempStr = spiltedIPArr[i];
			
			switch (tempStr.length()) {
			case 1:
				if (tempStr.matches("[0-9]")) 
					continue;
				else 
					return Neither;
			case 2:
				if (tempStr.matches("[1-9][0-9]")) 
					continue;
				else 
					return Neither;
			case 3:
				if (tempStr.matches("[1][0-9][0-9]"))
					continue;
				else 
				if (tempStr.matches("[2][0-4][0-9]"))
					continue;
				else 
				if (tempStr.matches("[2][5][0-5]"))
					continue;
				else
					return Neither;
			default:
				return Neither;
			}
			
		}
		
		return IPv4;
	}

	private String validateIPv6(String ip) {
		if (ip.charAt(0)==':' || ip.charAt(ip.length()-1)==':') 
			return Neither;
		
		String[] spiltedIPArr = ip.split(":");

		if (spiltedIPArr.length != 8)
			return Neither;
		
		for (int i = 0; i < spiltedIPArr.length; i++) {
			
			if (spiltedIPArr[i].matches("[0-9a-fA-F]{1,4}"))
				continue;
			else
				return Neither;
			
		}

		return IPv6;
	}

	

}
