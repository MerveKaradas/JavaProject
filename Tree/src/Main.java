import java.util.Scanner;

public class Main {
    //21181616028 - MERVE KARADAŞ

    public static void Giris() {

        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();

        tree.Add(8);
        tree.Add(4);
        tree.Add(12);
        tree.Add(2);
        tree.Add(5);
        tree.Add(9);
        tree.Add(14);
        tree.Add(7);
        tree.Add(3);
        tree.Add(10);

        int choice;
        boolean exit = false;

        while (!exit)
        {
            System.out.println("\n           MENU    ");
            System.out.println(" ----------------------------- ");
            System.out.println("1-Add element to Tree  ");
            System.out.println("2-Show sibling nodes  ");
            System.out.println("3-Show full node count  ");
            System.out.println("4-Show height and depth of selected node  ");
            System.out.println("5-Node ancestors  ");
            System.out.println("6-Show Tree info  ");
            System.out.println("7-Show PreOrder  ");
            System.out.println("8-Show InOrder  ");
            System.out.println("9-Show PostOrder  ");
            System.out.println("10-Exit  ");
            System.out.print("->Your choice : ");

            while(true)
            {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 10)
                    System.out.print("Enter a correct value : ");
                else break;
            }

            switch (choice)
            {
                case 1:
                    int data;

                    System.out.print("Eleman data : ");
                    data = scanner.nextInt();
                    tree.Add(data);
                    break;
                case 2 :
                    System.out.print("Which node will you choose : ");
                    int nodeChoice = scanner.nextInt();
                    System.out.println(tree.GetSibling(tree.root, nodeChoice).data);
                    break;
                case 3 :
                    System.out.println("Full node : " +tree.FullNode(tree.root));
                    break;
                case 4 :
                    System.out.print("Which node will you choose : ");
                    int nodeChoice2 = scanner.nextInt();

                    System.out.println("Height : " + tree.SelectedHeight(tree.root,nodeChoice2));
                    System.out.println("Deep : " + tree.SelectedDepth(tree.root,nodeChoice2));

                    break;
                case 5:
                    System.out.print("Which node will you choose : ");
                    int nodeChoice3 = scanner.nextInt();

                    System.out.println(tree.Atalar(tree.root, nodeChoice3));
                    break;
                case 6:
                    System.out.println("Toplam dugum : " + tree.TreeSize(tree.root));
                    System.out.println("Agac yuksekligi : " + tree.Height(tree.root));
                    System.out.println("Kök deger : " + tree.root.data);
                    System.out.println("Yaprak sayisi : " + tree.YaprakSayisi(tree.root));

                    System.out.print("Atalari bulunacak dugumu giriniz : ");
                    int dugumAta = scanner.nextInt();
                    System.out.println(dugumAta + " dugumunun atalari : " + tree.Atalar(tree.root,dugumAta));


                    break;
                case 7 :
                    tree.PreOrder(tree.root);
                    break;
                case 8 :
                    tree.InOrder(tree.root);
                    break;
                case 9 :
                    tree.PostOrder(tree.root);
                    break;
                case 10 :
                    exit = true;
                    break;
                default:
                    break;
            }
        }



    }
    public static void main(String[] args) {

        Giris();




    }

}