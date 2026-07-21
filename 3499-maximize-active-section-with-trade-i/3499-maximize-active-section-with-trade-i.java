class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
           ArrayList<Integer> zeroGroups = new ArrayList<>();
        int n = s.length();
        int ones = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int j = i;
                while (j < n && s.charAt(j) == '0') {
                    j++;
                }
                zeroGroups.add(j - i);
                i = j;
            }
        }

        int maxGain = 0;
        for (i = 0; i < zeroGroups.size() - 1; i++) {
            maxGain = Math.max(maxGain, zeroGroups.get(i) + zeroGroups.get(i + 1));
        }

        return ones + maxGain;
    }
}