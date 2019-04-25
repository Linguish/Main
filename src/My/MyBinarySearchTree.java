package My;

public class MyBinarySearchTree<E>
{
    private TreeNode<E> root = null;
    public MyBinarySearchTree(){}
    public MyBinarySearchTree(E data){insert(data);}
    
    /**
     * 在二叉搜索树中查找，存在值为data的节点则返回true，否则false
     *
     * @param data 要查找的值
     * @return 查找结果
     */
    public boolean find(E data){return false;}
    /**
     * 在二叉搜索树中查找最大值并返回
     *
     * @return 最大值
     */
    public E findMax(){return null;}
    /**
     * 在二叉搜索树中查找最小值并返回
     *
     * @return 最小值
     */
    public E findMin(){return null;}
    /**
     * 在二叉搜索树中插入值，
     * 插入成功则返回true，
     * 若该值已存在则返回false
     *
     * @param data 要插入的值
     * @return 插入结果
     */
    public boolean insert(E data){return false;}
    /**
     * 在二叉搜索树中删除值，
     * 删除成功则返回true，
     * 若该值不存在则返回false
     *
     * @param data 要删除的值
     * @return 删除结果
     */
    public boolean delete(E data){ return false;}
}
