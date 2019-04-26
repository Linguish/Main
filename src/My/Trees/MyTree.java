package My.Trees;

import My.MyLinkedQueue;
import My.MyLinkedStack;

public class MyTree<E>
{
    private TreeNode<E> root = null;
    public MyTree(){}
    public MyTree(TreeNode<E> node){this.root = node;}
    
    /**
     * 非递归先序遍历
     */
    public void preRootTraverse()
    {
        TreeNode<E> temp = root;
        if(temp != null)
        {
            MyLinkedStack<TreeNode<E>> stack = new MyLinkedStack<>();
            stack.push(temp);
            while(!stack.isEmpty())
            {
                temp = stack.pop();
                System.out.print(temp);
                while(temp != null)
                {
                    if(temp.getLeftChild() != null)
                    { System.out.print(temp.getLeftChild()); }
                    if(temp.getRightChild() != null)
                    { stack.push(temp.getRightChild()); }
                    temp = temp.getLeftChild();
                }
            }
        }
    }
    /**
     * 非递归中序遍历
     */
    public void inRootTraverse()
    {
        TreeNode<E> temp = root;
        if(temp != null)
        {
            MyLinkedStack<TreeNode<E>> stack = new MyLinkedStack<>();
            stack.push(temp);
            while(!stack.isEmpty())
            {
                while(stack.peek() != null)
                { stack.push(stack.peek().getLeftChild()); }
                stack.pop();
                if(!stack.isEmpty())
                {
                    temp = stack.pop();
                    System.out.print(temp);
                    if(temp.getRightChild() != null)
                    { stack.push(temp.getRightChild()); }
                }
            }
        }
    }
    /**
     * 非递归后序遍历
     */
    public void postRootTraverse()
    {
        TreeNode<E> temp = root;
        if(temp != null)
        {
            MyLinkedStack<TreeNode<E>> stack = new MyLinkedStack<>();
            stack.push(temp);
            while(!stack.isEmpty())
            {
                //访问标记
                boolean flag = false;
                //上次访问的节点
                TreeNode<E> lastVisit = null;
                while(stack.peek() != null)
                { stack.push(stack.peek().getLeftChild()); }
                stack.pop();
                while(!stack.isEmpty())
                {
                    temp = stack.peek();
                    //一个根节点被访问的前提是：无右子树或右子树已被访问过
                    if(temp.getRightChild() == null || temp.getRightChild() == lastVisit)
                    {
                        System.out.print(temp);
                        stack.pop();
                        lastVisit = temp;
                        flag = true;
                    }
                    else
                    {
                        stack.push(temp.getRightChild());
                        flag = false;
                    }
                    if(!flag){ break; }
                }
            }
        }
    }
    /**
     * 递归先序遍历
     *
     * @param treeNode 要遍历的树
     */
    public void preRootTraverse(TreeNode<E> treeNode)
    {
        if(treeNode != null)
        {
            System.out.print(treeNode);
            preRootTraverse(treeNode.getLeftChild());
            preRootTraverse(treeNode.getRightChild());
        }
    }
    /**
     * 递归中序遍历
     *
     * @param treeNode 要遍历的树
     */
    public void inRootTraverse(TreeNode<E> treeNode)
    {
        if(treeNode != null)
        {
            inRootTraverse(treeNode.getLeftChild());
            System.out.print(treeNode);
            inRootTraverse(treeNode.getRightChild());
        }
    }
    /**
     * 递归后序遍历
     *
     * @param treeNode 要遍历的树
     */
    public void postRootTraverse(TreeNode<E> treeNode)
    {
        if(treeNode != null)
        {
            postRootTraverse(treeNode.getLeftChild());
            postRootTraverse(treeNode.getRightChild());
            System.out.print(treeNode);
        }
    }
    /**
     * 层次遍历
     */
    public void levelTraverse()
    {
        MyLinkedQueue<TreeNode<E>> queue = new MyLinkedQueue<>();
        if(root != null){queue.enqueue(root);}
        while(!queue.isEmpty())
        {
            System.out.print(queue.peek());
            TreeNode<E> temp = queue.dequeue();
            if(temp.getLeftChild() != null){queue.enqueue(temp.getLeftChild());}
            if(temp.getRightChild() != null)
            { queue.enqueue(temp.getRightChild()); }
        }
    }
    public boolean isEmpty(){return root == null;}
    public TreeNode<E> getRoot(){return root;}
    /**
     * 判断两棵树tree1，tree2是否同构
     *
     * @param tree1 第一棵树
     * @param tree2 第二棵树
     * @return 同构则true，否则false
     */
    public static boolean isomorphic(MyTree tree1, MyTree tree2)
    {
        // 先判断根节点，都为null则返回true
        if(tree1.getRoot() == null && tree2.getRoot() == null){ return true; }
        // 若一个根节点为null，一个不是null，则两棵树一定不同构，返回false
        else if((tree1.getRoot() == null && tree2.getRoot() != null) || (tree1.getRoot() != null && tree2.getRoot() == null))
        { return false; }
        // 若两根节点都不为null，但其存储的值不相等，那这两棵树也不同构，返回false
        else if(tree1.getRoot().compareTo(tree2.getRoot()) != 0)
        { return false; }
        // 上述三次判断都跳过了，说明根节点都不为null且值相等
        // 那么接下来判断左子树和右子树
        // 若左子树都为null，则判断两根节点的右子树是否同构
        else if(tree1.getRoot().getLeftChild() == null && tree2.getRoot().getLeftChild() == null)
        { return isomorphic(new MyTree<>(tree1.getRoot().getRightChild()), new MyTree<>(tree2.getRoot().getRightChild()));}
        // 若左子树都不为null，且值相等
        // 那么说明没有交换左右节点，分别递归判断左右子树
        else if((tree1.getRoot().getLeftChild() != null && tree2.getRoot().getLeftChild() != null)
                && (tree1.getRoot().getLeftChild().compareTo(tree2.getRoot().getLeftChild()) == 0))
        {
            return (isomorphic(new MyTree<>(tree1.getRoot().getLeftChild()), new MyTree<>(tree2.getRoot().getLeftChild()))
                    && isomorphic(new MyTree<>(tree1.getRoot().getRightChild()), new MyTree<>(tree2.getRoot().getRightChild())));
        }
        // 其他情况则说明交换了左右节点
        // 判断tree1的左子树和tree2的右子树是否相等
        // 还要判断tree1的右子树和tree2的左子树是否相等
        // 若两个条件都满足则返回ture，否则false
        else
        {
            return (isomorphic(new MyTree<>(tree1.getRoot().getLeftChild()), new MyTree<>(tree2.getRoot().getRightChild()))
                    && isomorphic(new MyTree<>(tree1.getRoot().getRightChild()), new MyTree<>(tree2.getRoot().getLeftChild())));
        }
    }
}
