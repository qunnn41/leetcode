package answer;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
	/**
	 * https://leetcode.com/problems/clone-graph/
	 */
	private Map<Integer, UndirectedGraphNode> hash = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        if (hash.containsKey(node.label))
            return hash.get(node.label);
        UndirectedGraphNode r = new UndirectedGraphNode(node.label);
        hash.put(r.label, r);
        
        for (UndirectedGraphNode n : node.neighbors)
            r.neighbors.add(clone(n));
        return r;
    }
}
