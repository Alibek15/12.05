import models.BST;
import models.Tree;

public class Main {
    public static void main(String[] args) {
        BST<Integer,String> tree=new BST<>();

        tree.put(5,"6");
        tree.put(1,"77");
        tree.put(2,"23");
        tree.put(3,"99");
        tree.put(0,"36");
        for (Tree<Integer, String> elem:tree ){
            System.out.print(elem.getKey() + " " + elem.getValue() + " ");
        }


    }
}