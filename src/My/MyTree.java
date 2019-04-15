package My;

//todo 比较器
//todo 二叉树的插入
//todo 二叉树的删除
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
                    if(temp.leftChild != null)
                    {
                        System.out.print(temp.leftChild);
                    }
                    if(temp.rightChild != null){stack.push(temp.rightChild);}
                    temp = temp.leftChild;
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
                while(stack.peek() != null){stack.push(stack.peek().leftChild);}
                stack.pop();
                if(!stack.isEmpty())
                {
                    temp = stack.pop();
                    System.out.print(temp);
                    if(temp.rightChild != null){stack.push(temp.rightChild);}
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
                while(stack.peek() != null){stack.push(stack.peek().leftChild);}
                stack.pop();
                while(!stack.isEmpty())
                {
                    temp = stack.peek();
                    //一个根节点被访问的前提是：无右子树或右子树已被访问过
                    if(temp.rightChild == null || temp.rightChild == lastVisit)
                    {
                        System.out.print(temp);
                        stack.pop();
                        lastVisit = temp;
                        flag = true;
                    }
                    else
                    {
                        stack.push(temp.rightChild);
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
            preRootTraverse(treeNode.leftChild);
            preRootTraverse(treeNode.rightChild);
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
            inRootTraverse(treeNode.leftChild);
            System.out.print(treeNode);
            inRootTraverse(treeNode.rightChild);
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
            postRootTraverse(treeNode.leftChild);
            postRootTraverse(treeNode.rightChild);
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
            if(temp.leftChild != null){queue.enqueue(temp.leftChild);}
            if(temp.rightChild != null){queue.enqueue(temp.rightChild);}
        }
    }
    public boolean isEmpty(){return root == null;}
    public TreeNode<E> getRoot(){return root;}
    //todo 判断是否同构
    //public boolean isomorphic(TreeNode<E> input){}
}
