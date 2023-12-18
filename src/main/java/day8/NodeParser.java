package day8;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeParser {
    private final Pattern PATTERN = Pattern.compile("(\\w+) = \\((\\w+), (\\w+)\\)");

    public Map<String, Node> parse(String input) {
        String[] split = input.split("\\n");
        Map<String, Node> result = new java.util.HashMap<>();
        for (String s : split) {
            Matcher matcher = PATTERN.matcher(s);
            if (matcher.find()) {
                String name = matcher.group(1);
                Node node = result.computeIfAbsent(name, Node::new);
                Node left = result.computeIfAbsent(matcher.group(2), Node::new);
                Node right = result.computeIfAbsent(matcher.group(3), Node::new);
                node.setLeft(left);
                node.setRight(right);
            } else {
                throw new IllegalStateException("Invalid input " + s);
            }
        }
        return result;
    }
}
