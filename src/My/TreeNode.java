package My;

public class TreeNode<E> implements Comparable<TreeNode<E>>
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
    public E getData(){ return data; }
    public void setData(E data){ this.data = data; }
    public TreeNode<E> getLeftChild(){ return leftChild; }
    public void setLeftChild(TreeNode<E> leftChild){ this.leftChild = leftChild; }
    public TreeNode<E> getRightChild(){ return rightChild; }
    public void setRightChild(TreeNode<E> rightChild){ this.rightChild = rightChild; }
    @Override
    public String toString(){return data + "";}
    @Override
    public int compareTo(TreeNode<E> o)
    { return data.toString().compareTo(o.getData().toString()); }
}
