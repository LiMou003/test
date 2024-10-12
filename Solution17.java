import java.util.*;

class Solution {
    // 定义子序列的长度为10
    static final int L = 10;
    // 初始化哈希映射，将DNA碱基映射到对应的整数
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    // 主方法，查找所有长度为L的重复DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        // 初始化结果列表，用于存储重复的DNA序列
        List<String> ans = new ArrayList<>();
        // 获取输入字符串的长度
        int n = s.length();
        // 如果字符串长度小于L，则没有重复的长度为L的子串，直接返回空列表
        if (n <= L) {
            return ans;
        }
        // 初始化x为0，用于存储长度为L的子串的编码
        int x = 0;
        // 初始化x为字符串前L-1个字符的编码
        for (int i = 0; i < L - 1; ++i) {
            // 将字符编码左移两位后，通过按位或操作添加下一个字符的编码
            x = (x << 2) | bin.get(s.charAt(i));
        }
        // 初始化哈希映射，用于记录每个编码出现的次数
        Map<Integer, Integer> cnt = new HashMap<>();
        // 遍历字符串，计算每个长度为L的子串的编码
        for (int i = 0; i <= n - L; ++i) {
            // 将当前字符编码添加到x的末尾，并移除最左边的两位
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            // 更新编码出现的次数
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            // 如果编码出现的次数为2，说明找到了一个重复的序列
            // 将该子串添加到结果列表中，确保每个子串只添加一次
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        // 返回包含所有重复DNA序列的结果列表
        return ans;
    }
}

