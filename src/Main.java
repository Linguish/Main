public class Main
{
    //private static TreeNode<String> createRootNode()
    //{
    //    TreeNode<String> d = new TreeNode<>("D");
    //    TreeNode<String> g = new TreeNode<>("G");
    //    TreeNode<String> h = new TreeNode<>("H");
    //    TreeNode<String> e = new TreeNode<>("E", g, null);
    //    TreeNode<String> b = new TreeNode<>("B", d, e);
    //    TreeNode<String> f = new TreeNode<>("F", null, h);
    //    TreeNode<String> c = new TreeNode<>("C", f, null);
    //    return new TreeNode<>("A", b, c);
    //}
    //
    //public static void main(String[] args)
    //{
    //    MyTree<String> tree = new MyTree<>(createRootNode());
    //
    //    System.out.print("递归后序遍历:");
    //    tree.postRootTraverse(tree.getRoot());
    //    System.out.println();
    //    System.out.print("非递归后序遍历:");
    //    tree.postRootTraverse();
    //    System.out.println();
    //
    //}
    
    @FunctionalInterface
    interface MathOperation
    {
        int operation(int a, int b);
    }
    private int operate(int a, int b, MathOperation mathOperation)
    {return mathOperation.operation(a, b);}
    
    @FunctionalInterface
    interface GreetingService
    {
        void sayMessage(String message);
    }
    
    public static void main(String args[])
    {
        Main tester = new Main();
        
        // 类型声明
        MathOperation addition = (int a, int b)->a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b)->a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b)->{ return a*b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b)->a/b;
        
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        
        // 不用括号
        GreetingService greetService1 = message->System.out.println("greetService1 " + message);
        
        // 用括号
        GreetingService greetService2 = (message)->System.out.println("greetService2 " + message);
        
        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }
}