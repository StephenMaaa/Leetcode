package String;

/*
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

        A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.

        A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

        1 <= xi.length <= 4
        xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
        Leading zeros are allowed in xi.
        For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
*/

import java.util.Arrays;

public class ValidateIPAddress {
    // approach 1 - String TC: O(n) SC: O(1)
    public String validIPAddress(String queryIP) {
        // check type
        int IPv4Dot = 0;
        int IPv6Colon = 0;
        for (int i = 0; i < queryIP.length(); i++) {
            if (queryIP.charAt(i) == '.') {
                IPv4Dot++;
            }
            if (queryIP.charAt(i) == ':') {
                IPv6Colon++;
            }
        }

        // check correctness
        if (IPv4Dot == 3) {
            String[] ip = queryIP.split("\\.", -1);
            for (String str : ip) {
                // case 1: 1 < length < 3
                // case 2: no leading zero
                // case 3: digit only
                // case 4: num <= 255
                if (str.length() < 1 || str.length() > 3) {
                    return "Neither";
                }
                if (str.charAt(0) == '0' && str.length() > 1) {
                    return "Neither";
                }
                for (char c : str.toCharArray()) {
                    if (c < '0' || c > '9') {
                        return "Neither";
                    }
                }
                if (Integer.valueOf(str) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IPv6Colon == 7) {
            String[] ip = queryIP.split(":", -1);
            for (String str : ip) {
                // case 1: 1 < length < 4
                // case 2: digit or letter in a-f or A-F
                if (str.length() < 1 || str.length() > 4) {
                    return "Neither";
                }
                for (char c : str.toCharArray()) {
                    if (!('0' <= c && c <= '9') && !('a' <= c && c <= 'f') && !('A' <= c && c <= 'F')) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        ValidateIPAddress test = new ValidateIPAddress();
        System.out.println(test.validIPAddress(":::::::"));
    }
}
