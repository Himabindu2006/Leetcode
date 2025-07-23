class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;  // pointer for string a
        int j = b.length() - 1;  // pointer for string b
        int carry = 0;

        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = bitA + bitB + carry;
            result.append(sum % 2);     // append the current binary digit
            carry = sum / 2;            // update carry
        }

        return result.reverse().toString();
    }
}
