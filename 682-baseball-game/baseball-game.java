import java.util.ArrayList;

class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> record = new ArrayList<>();

        for (String op : operations) {
            if (op.equals("C")) {
                record.remove(record.size() - 1); // Remove the last score
            } else if (op.equals("D")) {
                int last = record.get(record.size() - 1);
                record.add(2 * last); // Double the last score
            } else if (op.equals("+")) {
                int last = record.get(record.size() - 1);
                int secondLast = record.get(record.size() - 2);
                record.add(last + secondLast); // Sum of last two scores
            } else {
                // It's a number, so parse and add it
                record.add(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int score : record) {
            sum += score;
        }
        return sum;
    }
}
