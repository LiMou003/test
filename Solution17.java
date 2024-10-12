import java.util.*;

class Solution {
    static final int L = 10; // 子序列的长度
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }}; // 将DNA的碱基映射到整数

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>(); // 存储结果的列表
        int n = s.length();
        if (n <= L) {
            return ans; // 如果字符串长度小于L，则没有重复的长度为L的子串
        }
        int x = 0; // 用于存储长度为L的子串的编码
        // 初始化x为字符串前L-1个字符的编码
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>(); // 记录每个编码出现的次数
        // 遍历字符串，计算每个长度为L的子串的编码
        for (int i = 0; i <= n - L; ++i) {
            // 将当前字符编码添加到x的末尾，并移除最左边的两位
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            // 记录编码出现的次数
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            // 如果编码出现的次数为2，则将该子串添加到结果列表中
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans; // 返回结果列表
    }
}
