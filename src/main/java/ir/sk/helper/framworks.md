#Frameworks:
##Array traversal framework, typical linear iterative structure：
```
void traverse(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        // iteratively visit arr[i]
    }
}
```
##Linked list traversal framework has both iterative and recursive structure：
```
/* Basic node of the single linked list */
class Link {
    int val;
    Link next;
}

void traverse(Link head) {
    for (Link p = head; p != null; p = p.next) {
        // iteratively p.val
    }
}

void traverse(Link head) {
    // recusively head.val
    traverse(head.next)
}
```
##Binary tree traversal framework, typical nonlinear recursive traversal structure：
```
/* Basic node of the binary tree */
class TreeNode {
int val;
Node left, right;
}

void DFSTraverse(Node root) {
    // pre order traverse
    traverse(root.left)
    // middle order traverse
    traverse(root.right)
    // post order traverse
}
```
##The binary tree framework can be extended to the n-tree traversal framework：
```
/* Basic node of the N-tree */
class Node {
    int val;
    Node[] children;
}

void DFSTraverse(Node root) {
    for (Node child : root.children)
        traverse(child)
}

void BFSTraverse(Node root) {
    Queue queue = new Queue();
    queue.add(root)
    while (!queue.isEmpty()) {
        Node node = queue.dequeue();
        // iteratively node.val
        queue.addAll(node.children);
    }
}
```

##There is a template for backtracking algorithms:
```
result = []
def backtrack(Path, selection List):
     if meet the End Condition:       
        result.add(Path)
        return

     for selection in selection List:
        select(Remove this Selection from the Selection List, Path.add(Selection))
        backtrack(Path, selection List)
        deselect (Path.remove(selection), Add the selection to the Selection List)
```

