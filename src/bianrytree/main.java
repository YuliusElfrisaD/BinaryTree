package bianrytree;

public class main {

    public static void main(String[] args) {
        tree n = new tree();
        //11, 6, 2, 4, 1, 10, 21, 17, 19, 9, 12
        n.add(11);
        n.add(6);
        n.add(2);
//        n.add(4);
        n.add(1);
        n.add(10);
        n.add(21);
        n.add(17);
        n.add(19);
        n.add(9);
        n.add(12);
        System.out.println("Pre Order Traversal");
        n.preOrder(n.getRoot());
        System.out.println("\n" + "In Order Traversal");
        n.inOrder(n.getRoot());
        System.out.println("\n" + "Post Order Traversal");
        n.postOrder(n.getRoot());

//        treeNode hapus = n.remove(9);
        treeNode hapus = n.hapus0dan1(2);
        if (hapus != null) {
            System.out.println("\n\n" + "Satu simpul terhapus");
        } else {
            System.out.println("tidak");
        }
        System.out.println("Pre Order Traversal");
        n.preOrder(n.getRoot());
        System.out.println("\n" + "In Order Traversal");
        n.inOrder(n.getRoot());
        System.out.println("\n" + "Post Order Traversal");
        n.postOrder(n.getRoot());
//
//        treeNode hasil = n.search(26);
//        if (hasil == null) {
//            System.out.println("Data tidak ditemukan");
//        } else {
//            System.out.println("Data ditemukan : " + hasil.getElemen());
//        }
//        n.searchChild(69, null, null);

    }
}
