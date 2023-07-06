package P09_07_详解前缀树和贪心算法;

public class Code01_TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;// 如果字符种类特别多可以换成HashMap HashMap<Char, Node> nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // nexts[0] == null 没有走向'a'的路
            // nexts[0] != null 有走向'a'的路
            // ...
            // nexts[26] != null 有走向'z'的路
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String world) {
            if (world == null) {
                return;
            }
            char[] chs = world.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // word这个单词之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所有加入的字符串中，有几个是以pre这个字符串为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[index] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        public void delete(String word) {
            if (search(word) != 0) { // 确定树中确实加入过word,才删除
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        // C++ 需要遍历到底去析构
                        node.nexts[index] = null; // 如果pass为空，说明从该节点向下的所有树都没有用了，直接释放即可
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
    }
}