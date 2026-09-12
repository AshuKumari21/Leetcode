class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int count, String current, List<String> result) {
        if (count == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            String segment = s.substring(index, index + i);
            if ((segment.startsWith("0") && segment.length() > 1) || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            backtrack(s, index + i, count + 1, current + segment + ".", result);
        }
    }
}