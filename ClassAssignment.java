class Tree{
    class Node{
        Node left;
        int data;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    Tree(){
        root = null;
    }

    Node insert(Node root , int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        if(data < root.data)
        {
           root.left = insert(root.left, data);
        }
        else
        {
            root.right = insert(root.right, data);
        }
        return root;
    }

    int height()
    {
        int a ;
        a = calculatedHeight(root);
        return a;
    }
    int calculatedHeight(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int leftHeight = calculatedHeight(root.left);
            int rightHeight = calculatedHeight(root.right);
            if(leftHeight>rightHeight)
            {
                return leftHeight+1;
            }
            else
            {
                return rightHeight+1;
            }
        }
    }

    void revlevel()
    {
        int h = height();
        for(int i = h ; i>=1 ; i--)
        {
            System.out.println();
            printrevlevel(root,i);
        }
    }
    void printrevlevel(Node root , int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.print(root.data + " " );
        }
        else if(level>1)
        {
            printrevlevel(root.left, level-1);
            printrevlevel(root.right, level-1);
        }
    }
}

public class ClassAssignment{
    public static void main(String args[]){
        Tree tree = new Tree();
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 35);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 50);
        tree.insert(tree.root, 80);

        tree.revlevel();
    }
}