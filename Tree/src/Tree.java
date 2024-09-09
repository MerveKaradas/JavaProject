import java.util.ArrayList;

public class Tree {

    Node root;
    String elemanlar ="" ;
    int selectedDepth=1;

    public Tree() {
        this.root = null;
    }


    public void PreOrder(Node root) // data - left - right
    {
     /*   System.out.print(root.data + " ");
        if (root.left != null)
        {
            PreOrder(root.left);
        }
        if (root.right != null)
        {
            PreOrder(root.right);
        } */

        if(root != null)
        {
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }

    }

    public void InOrder(Node root) // left - data - right
    {
        if(root != null)
        {
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }

    }

    public void PostOrder(Node root) // left - right - data
    {
        if (root != null)
        {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }


    }

    Node Add(int data)
    {
        Node newNode = new Node(data);
        Node temp = root;


        if( root == null)
        {
            root = newNode;

        }
        else
        {
            Node current = root;

            while (true)
            {
                Node parent = current;
                if (data < current.data)
                {
                    current = current.left;
                    if (current == null)
                    {
                        parent.left = newNode;
                        break;
                    }
                }
                else
                {
                    current = current.right;
                    if (current == null)
                    {
                        parent.right = newNode;
                        break;
                    }
                }
            }
        }

        return newNode;

    }


    int Height(Node root)
    {
        if(root == null)
        {
            return -1;
        }
        else
        {
            int left=0,right=0;

            left = Height(root.left);
            right = Height(root.right);

            if(left > right)
            {
                return left +1;
            }
            else
            {
                return right + 1;
            }
        }
    }

    int TreeSize(Node root) //eleman sayısı
    {
        if(root ==null)
            return 0;
        else
            return TreeSize(root.left) + 1 + TreeSize(root.right);
    }


    int FullNode(Node root)
    {
        int fullnode=0;

        if (root == null)
        {
            return 0;
        }
        else
        {
            if (root.left !=null && root.right !=null)
            {
                fullnode++;
            }

            fullnode += FullNode(root.left);
            fullnode += FullNode(root.right);
        }

        return fullnode;
    }

    int YaprakSayisi(Node root)
    {
        int yaprakSayisi=0;

        if (root ==null)
        {
            return 0;
        }
        else
        {
            if (root.left == root.right)
            {
                yaprakSayisi++;
            }


            yaprakSayisi += YaprakSayisi(root.left);
            yaprakSayisi += YaprakSayisi(root.right);
        }

        return yaprakSayisi;

    }





    String Atalar(Node root,int data)
    {
        Node temp= root;

        if (root == null || root.data == data)
        {
            return elemanlar;
        }
        else
        {

            elemanlar += temp.data + " ";

            if (data < temp.data)
            {
                Atalar(temp.left,data);
            }
            else
            {
                Atalar(temp.right,data);
            }
        }

        return elemanlar;

    }


    public Node GetSibling(Node node,int data)
    {
        if(node == null || node.data == data)
        {
            return null;
        }
        if (node.left != null && node.left.data == data)
        {
            return node.right;
        }
        if (node.right != null && node.right.data == data)
        {
            return node.left;
        }

        Node siblings = GetSibling(node.left,data);

        if ( siblings != null )
        {
            return siblings;
        }

        siblings = GetSibling(node.right,data);
        return siblings;


    }

    int SelectedHeight(Node root,int data)
    {
        if (root != null && root.data == data)
        {
            Height(root);
        }
        if (root == null || root.data == data)
        {
            return -1;
        }
        else
        {
            int left=0,right=0;

            left = Height(root.left);
            right = Height(root.right);

            if(left > right)
            {
                return left ;
            }
            else
            {
                return right ;
            }
        }
    }

    int SelectedDepth(Node node, int data)
    {
        if (node == null || node.data == data)
            return 0;

        if( node.data == data)
        {
            return selectedDepth;
        }

        if( data < node.data)
        {
            selectedDepth++;
            int left = SelectedHeight(node.left,data);
        }
        else
        {
            selectedDepth++;
            int right = SelectedHeight(node.right,data);
        }

        return selectedDepth;
    }








}
