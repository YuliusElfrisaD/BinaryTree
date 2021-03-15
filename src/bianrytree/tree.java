package bianrytree;

public class tree {

    private treeNode root;
    private int size;

    public tree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public treeNode getRoot() {
        return root;
    }

    public void setRoot(treeNode root) {
        this.root = root;
    }

    public void add(int x) {
        treeNode baru = new treeNode(x, null);
        if (isEmpty()) {
            root = baru;
        } else {
            root.insert(x);
        }
    }

    public void preOrder(treeNode root) {
        if (root != null) {
            System.out.print(root.getElemen() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        } else {
            return;
        }
    }

    public void inOrder(treeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getElemen() + " ");
            inOrder(root.getRight());
        } else {
            return;
        }
    }

    public void postOrder(treeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getElemen() + " ");
        } else {
            return;
        }
    }

    public treeNode search(int key) {
        if (isEmpty()) {
            return null;
        } else {
            treeNode bantu = root;
            while (bantu != null) {
                if (key == bantu.getElemen()) {
                    return bantu;
                } else if (key < bantu.getElemen()) {
                    bantu = bantu.getLeft();
                } else {
                    bantu = bantu.getRight();
                }
            }
            return null;
        }
    }

    public treeNode searchChild(int key, treeNode child1, treeNode child2) {
        if (isEmpty()) {
            return null;
        } else {
            treeNode bantu = root;
            while (bantu != null) {
                if (key == bantu.getElemen()) {
                    if (bantu.getLeft() == null) {
                        child1 = null;
                        System.out.println("tidak mempunyai anak kiri");
                    } else {
                        child1 = bantu.getLeft();
                        System.out.println("anak kirinya adalah :" + bantu.getLeft().getElemen());
                    }
                    if (bantu.getRight() == null) {
                        child2 = null;
                        System.out.println("tidak mempunyai anak kanan");
                    } else {
                        child2 = bantu.getRight();
                        System.out.println("anak kanannya adalah :" + bantu.getRight().getElemen());
                    }
                    return bantu;
                } else if (key < bantu.getElemen()) {
                    bantu = bantu.getLeft();
                } else {
                    bantu = bantu.getRight();
                }
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addNonrekur(int key) {

        if (isEmpty()) {
            setRoot(new treeNode(key, null));
        } else {
            treeNode bantu = root;
            while (bantu != null) {
                if (key < bantu.getElemen()) {
                    if (bantu.getLeft() == null) {
                        bantu.setLeft(new treeNode(key, bantu));
                        bantu = null;
                    } else {
                        bantu = bantu.getLeft();
                    }
                } else {
                    if (bantu.getRight() == null) {
                        bantu.setRight(new treeNode(key, bantu));
                        bantu = null;
                    } else {
                        bantu = bantu.getRight();
                    }
                }
            }
        }
    }

    public treeNode getCurrent(int x) {
        treeNode bantu = root;
        while (bantu != null) {
            if (x == bantu.getElemen()) {
                return bantu;
            } else if (x < bantu.getElemen()) {
                bantu = bantu.getLeft();
            } else {
                bantu = bantu.getRight();
            }
        }
        return bantu;
    }

    public treeNode getPredecessor(treeNode x) {
        treeNode bantu = x.getLeft();
        if (bantu == null) {
            return null;
        } else {
            while (bantu.getRight() != null) {
                bantu = bantu.getRight();
            }
        }
        return bantu;
    }

    public treeNode Remove(int x) {
        treeNode bantu = search(x);
        if (bantu == null) {
            return null;
        } else {
            if (bantu.getElemen() == root.getElemen()) {

            } else {

            }
        }
        return null;
    }
    //23 19 5 21 8 33 65 42 35 45

    public treeNode hapus0anak(int x) {
        treeNode bantu = search(x);
        treeNode parent = bantu.getParent();
        if (x < parent.getElemen()) {
            if (bantu.getLeft() == null && bantu.getRight() == null) {
                parent.setLeft(null);
            }
        } else {
            if (bantu.getLeft() == null && bantu.getRight() == null) {
                parent.setRight(null);
            }
        }
        return bantu;
    }
    
    public treeNode hapus1anak(int x) {
        treeNode bantu = search(x);
        treeNode parent = bantu.getParent();
        if (x < parent.getElemen()) {
            if (bantu.getLeft() == null && bantu.getRight() == null) {
                parent.setLeft(null);
            }else if(bantu.getLeft()== null){
                parent.setLeft(bantu.getLeft());
            }else if (bantu.getRight() == null){
                parent.setLeft(bantu.getRight());
            }
        } else {
            if (bantu.getLeft() == null && bantu.getRight() == null) {
                parent.setRight(null);
            }else if(bantu.getRight() == null){
                parent.setRight(bantu.getLeft());
            }else if(bantu.getLeft() == null){
                parent.setRight(bantu.getRight());
            }
        }
        return bantu;
    }
    public treeNode hapus0dan1(int x){
        treeNode bantu = search(x);
        if (bantu == null) {//periksa tree ada atau tidak
            return null;
        } else {
            if (bantu.getElemen() == root.getElemen()) {//periksa yang di cari adalah root atau bukan
                if (bantu.getLeft() == null && bantu.getRight() == null) {
                    root = null;
                } else {
                    if (bantu.getRight() == null) {
                        root = bantu.getLeft();
                    } else if (bantu.getLeft() == null) {
                        root = bantu.getRight();
                    }
                }
            } else { // //jika yang di cari bukan root
                treeNode ortu = bantu.getParent();
                if (x < ortu.getElemen()) {//jika x lebih kecil dari parent
                    if (bantu.getLeft() == null && bantu.getRight() == null) {
                        ortu.setLeft(null);
                    } else if (bantu.getRight() == null) {
                        ortu.setLeft(bantu.getLeft());
                    } else if (bantu.getLeft() == null) {
                        ortu.setLeft(bantu.getRight());
                    }

                } else {// jika x lebih besar dari parent
                    if (bantu.getLeft() == null && bantu.getRight() == null) {
                        ortu.setRight(null);
                    } else if (bantu.getRight() == null) {
                        ortu.setRight(bantu.getLeft());
                    } else if (bantu.getLeft() == null) {
                        ortu.setRight(bantu.getRight());
                    } 
                }
            }
        }
        return bantu;
    }

    public treeNode remove(int x) {
        treeNode bantu = search(x);
        if (bantu == null) {
            return null;
        } else {
            if (bantu.getElemen() == root.getElemen()) {
                if (bantu.getLeft() == null && bantu.getRight() == null) {
                    root = null;
                } else {
                    if (bantu.getRight() == null) {
                        root = bantu.getLeft();
                    } else if (bantu.getLeft() == null) {
                        root = bantu.getRight();
                    } else {
                        treeNode predecessor = getPredecessor(bantu);
                        treeNode parentPredecessor = predecessor.getParent();
                        root.setElemen(predecessor.getElemen());
                        if (parentPredecessor != bantu) {
                            if (predecessor.getLeft() != null) {
                                parentPredecessor.setRight(predecessor.getLeft());
                            } else {
                                parentPredecessor.setRight(null);
                            }
                        } else {
                            bantu.setLeft(predecessor.getLeft());
                        }
                    }
                }
            } else { // bila yang di temukan bookan root
                treeNode ortu = bantu.getParent();
                if (x < ortu.getElemen()) {
                    if (bantu.getLeft() == null && bantu.getRight() == null) {
                        ortu.setLeft(null);
                    } else if (bantu.getRight() == null) {
                        ortu.setLeft(bantu.getLeft());
                    } else if (bantu.getLeft() == null) {
                        ortu.setLeft(bantu.getRight());
                    } else {
                        treeNode predecessor = getPredecessor(bantu);
                        treeNode parentPredecessor = predecessor.getParent();
                        bantu.setElemen(predecessor.getElemen());
                        if (parentPredecessor != bantu) {
                            if (predecessor.getLeft() != null) {
                                parentPredecessor.setRight(predecessor.getLeft());
                            } else {
                                parentPredecessor.setRight(null);
                            }
                        } else {
                            bantu.setLeft(predecessor.getLeft());
                        }
                    }

                } else {
                    if (bantu.getLeft() == null && bantu.getRight() == null) {
                        ortu.setRight(null);
                    } else if (bantu.getRight() == null) {
                        ortu.setRight(bantu.getLeft());
                    } else if (bantu.getLeft() == null) {
                        ortu.setRight(bantu.getRight());
                    } else {
                        treeNode predecessor = getPredecessor(bantu);
                        treeNode parentPredecessor = predecessor.getParent();
                        bantu.setElemen(predecessor.getElemen());
                        if (parentPredecessor != bantu) {
                            if (predecessor.getLeft() != null) {
                                parentPredecessor.setRight(predecessor.getLeft());
                            } else {
                                parentPredecessor.setRight(null);
                            }
                        } else {
                            bantu.setLeft(predecessor.getLeft());
                        }
                    }
                }
            }
        }
        return bantu;
    }
}
