package My;

public class TreeNode<E>
{
    E data;
    TreeNode<E> leftChild = null;
    TreeNode<E> rightChild = null;
    public TreeNode(){}
    public TreeNode(E data){this.data = data;}
    public TreeNode(E data, TreeNode<E> leftChild, TreeNode<E> rightChild)
    {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    @Override
    public String toString(){return data + "";}
}
