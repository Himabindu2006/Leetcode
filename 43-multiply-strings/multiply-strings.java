class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];

        // Multiply each digit and add at the correct positions
        for (int i = n - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int product = d1 * d2;
                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        // Convert result array to string, skip leading 0s
        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            if (sb.length() == 0 && val == 0) continue; // skip leading zeros
            sb.append(val);
        }

        return sb.toString();
    }
}
