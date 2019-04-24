import My.MyTree;
import My.TreeNode;

public class Main
{
    private static TreeNode<String> createRootNode1()
    {
        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> g = new TreeNode<>("G");
        TreeNode<String> h = new TreeNode<>("H");
        TreeNode<String> e = new TreeNode<>("E", g, null);
        TreeNode<String> b = new TreeNode<>("B", d, e);
        TreeNode<String> f = new TreeNode<>("F", null, h);
        TreeNode<String> c = new TreeNode<>("C", f, null);
        return new TreeNode<>("A", b, c);
    }
    private static TreeNode<String> createRootNode2()
    {
        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> g = new TreeNode<>("G");
        TreeNode<String> h = new TreeNode<>("H");
        TreeNode<String> e = new TreeNode<>("K", g, null);
        TreeNode<String> b = new TreeNode<>("B", d, e);
        TreeNode<String> f = new TreeNode<>("F", null, h);
        TreeNode<String> c = new TreeNode<>("C", f, null);
        return new TreeNode<>("A", b, c);
    }
    
    public static void main(String[] args)
    {
        System.out.println(MyTree.isomorphic(new MyTree<>(createRootNode1()), new MyTree<>(createRootNode2())));
    }
}