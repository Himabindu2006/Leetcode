import java.util.*;
class Solution {
    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String serial = "";
        boolean toDelete = false;
    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode node = root;
            for (String folder : path) {
                node.children.putIfAbsent(folder, new TrieNode());
                node = node.children.get(folder);
            }
        }
        Map<String, List<TrieNode>> serialMap = new HashMap<>();
        serialize(root, serialMap);
        for (List<TrieNode> group : serialMap.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.toDelete = true;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }
    private String serialize(TrieNode node, Map<String, List<TrieNode>> serialMap) {
        if (node.children.isEmpty()) return "";
        List<String> serials = new ArrayList<>();
        for (String key : new TreeSet<>(node.children.keySet())) {
            String childSerial = serialize(node.children.get(key), serialMap);
            serials.add(key + "(" + childSerial + ")");
        }
        String serial = String.join("", serials);
        node.serial = serial;
        serialMap.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }
    private void collect(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            if (!child.toDelete) {
                path.add(folder);
                result.add(new ArrayList<>(path));
                collect(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}