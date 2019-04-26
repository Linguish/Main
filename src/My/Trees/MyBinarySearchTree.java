package My;

import My.Trees.TreeNode;

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
    public boolean find(E data)
    {
        boolean ret = false;
        if(root != null)
        {
            TreeNode<E> temp = root;
            while(true)
            {
                if(data.toString().compareTo(temp.toString())<0)
                {
                    if(temp.getLeftChild() == null){ break; }
                    else{temp = temp.getLeftChild();}
                }
                else if(data.toString().compareTo(temp.toString())>0)
                {
                    if(temp.getRightChild() == null){ break; }
                    else{temp = temp.getRightChild();}
                }
                else
                {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
    /**
     * 在二叉搜索树中查找最大值并返回
     *
     * @return 最大值
     */
    public E findMax()
    {
        E ret = null;
        if(root != null)
        {
            TreeNode<E> temp = root;
            while(temp.getRightChild() != null)
            {temp = temp.getRightChild();}
            ret = temp.getData();
        }
        return ret;
    }
    /**
     * 在二叉搜索树中查找最小值并返回
     *
     * @return 最小值
     */
    public E findMin()
    {
        E ret = null;
        if(root != null)
        {
            TreeNode<E> temp = root;
            while(temp.getLeftChild() != null)
            {temp = temp.getLeftChild();}
            ret = temp.getData();
        }
        return ret;
    }
    /**
     * 在二叉搜索树中插入值，
     * 插入成功则返回true，
     * 若该值已存在则返回false
     *
     * @param data 要插入的值
     * @return 插入结果
     */
    public boolean insert(E data)
    {
        boolean ret = false;
        if(root == null)
        {
            root = new TreeNode<>(data);
            ret = true;
        }
        else
        {
            TreeNode<E> temp = root;
            while(true)
            {
                if(data.toString().compareTo(temp.toString())<0)
                {
                    if(temp.getLeftChild() == null)
                    {
                        temp.setLeftChild(new TreeNode<>(data));
                        ret = true;
                        break;
                    }
                    else{temp = temp.getLeftChild();}
                }
                else if(data.toString().compareTo(temp.toString())>0)
                {
                    if(temp.getRightChild() == null)
                    {
                        temp.setRightChild(new TreeNode<>(data));
                        ret = true;
                        break;
                    }
                    else{temp = temp.getRightChild();}
                }
                else{break;}
            }
        }
        return ret;
    }
    /**
     * 在二叉搜索树中删除值，
     * 删除成功则返回true，
     * 若该值不存在则返回false
     *
     * @param data 要删除的值
     * @return 删除结果
     */
    public boolean delete(E data)
    {
        boolean ret = false;
        if(root != null)
        {
            TreeNode<E> temp = root;
            while(true)
            {
                //查找要删除的节点
                if(data.toString().compareTo(temp.toString())<0)
                {
                    if(temp.getLeftChild() == null){ break; }
                    else
                    { temp = temp.getLeftChild(); }
                }
                else if(data.toString().compareTo(temp.toString())>0)
                {
                    if(temp.getRightChild() == null){ break; }
                    else
                    { temp = temp.getRightChild(); }
                }
                //找到要删除的节点
                else
                {
                    //要删除的节点最多只有一个子节点
                    if(temp.getLeftChild() == null || temp.getRightChild() == null)
                    {
                        
                        if(temp.getLeftChild() != null)
                        {temp.setNode(temp.getLeftChild());}
                        else
                        {temp.setNode(temp.getRightChild());}
                    }
                    //要删除的节点有两个子节点
                    //思路：在要删除的节点temp的左子节点中找最大值
                    else
                    {
                        TreeNode<E> lMax = temp.getLeftChild();
                        TreeNode<E> maxFather = temp;
                        while(lMax.getRightChild() != null)
                        {
                            maxFather = lMax;
                            lMax = lMax.getRightChild();
                        }
                        maxFather.setRightChild(lMax.getLeftChild());
                        temp.setData(lMax.getData());
                    }
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
    
    public static void main(String[] args)
    {
        MyBinarySearchTree<String> test = new MyBinarySearchTree<>();
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(String s : month){ test.insert(s); }
        
        System.out.println("查找\"Feb\":" + test.find("Feb"));
        System.out.println("删除\"Feb\":" + test.delete("Feb"));
        System.out.println("查找\"Feb\":" + test.find("Feb"));
        
        System.out.println("查找\"Mar\":" + test.find("Mar"));
        System.out.println("删除\"Mar\":" + test.delete("Mar"));
        System.out.println("查找\"Mar\":" + test.find("Mar"));
        
        System.out.println("查找\"Jan\":" + test.find("Jan"));
        System.out.println("删除\"Jan\":" + test.delete("Jan"));
        System.out.println("查找\"Jan\":" + test.find("Jan"));
    }
}
