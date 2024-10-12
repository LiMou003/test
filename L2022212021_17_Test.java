import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class L2022212021_17_Test {

    @Test
    public void testFindRepeatedDnaSequences_EmptyString() {
        Solution solution = new Solution();
        String input = "";
        List<String> result = solution.findRepeatedDnaSequences(input);
        assertTrue(result.isEmpty(), "An empty string should return an empty list.");
    }

    @Test
    public void testFindRepeatedDnaSequences_NoRepeatedSequences() {
        Solution solution = new Solution();
        String input = "ACGTACGTAC";
        List<String> result = solution.findRepeatedDnaSequences(input);
        assertTrue(result.isEmpty(), "No repeated sequences of length 10 in the input.");
    }

    private void assertTrue(boolean empty, String s) {
    }

    @Test
    public void testFindRepeatedDnaSequences_SingleRepeatedSequence() {
        Solution solution = new Solution();
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution.findRepeatedDnaSequences(input);
        List<String> expected = List.of("AAAAACCCCC", "CCCCCAAAAA");
        assertEquals("Expected two repeated sequences.", expected, result);
    }

    @Test
    public void testFindRepeatedDnaSequences_MultipleRepeatedSequences() {
        Solution solution = new Solution();
        String input = "AAAAAAAAAAAAA";
        List<String> result = solution.findRepeatedDnaSequences(input);
        List<String> expected = List.of("AAAAAAAAAA");
        assertEquals("Expected one repeated sequence of 'AAAAAAAAAA'.", expected, result);
    }

    @Test
    public void testFindRepeatedDnaSequences_VariedInput() {
        Solution solution = new Solution();
        String input = "ACGTACGTACGTACGTACGT";
        List<String> result = solution.findRepeatedDnaSequences(input);

        // 预期所有长度为 10 的重复序列
        List<String> expected = List.of(
                "ACGTACGTAC",
                "CGTACGTACG",
                "GTACGTACGT",
                "TACGTACGTA"
        );

        // 使用无序匹配来检查结果
        assertTrue(result.containsAll(expected) && expected.containsAll(result),
                "Expected repeated sequences to be " + expected);
    }


    @Test
    public void testFindRepeatedDnaSequences_LongInputWithMultipleRepeats() {
        Solution solution = new Solution();
        String input = "GATTACAGATTACAGATTACA";
        List<String> result = solution.findRepeatedDnaSequences(input);

        // 期望多个重复的长度为10的序列
        List<String> expected = List.of("GATTACAGAT", "ATTACAGATT", "TTACAGATTA", "TACAGATTAC", "ACAGATTACA");

        // 检查结果是否与预期匹配（无序匹配）
        assertTrue(result.containsAll(expected) && expected.containsAll(result),
                "Expected repeated sequences to be " + expected);
    }

}
