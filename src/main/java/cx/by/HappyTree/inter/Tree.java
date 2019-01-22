package cx.by.HappyTree.inter;

import cx.by.HappyTree.HappyTree;
import cx.by.HappyTree.TreeNode;

public interface Tree {
    HappyTree split(TreeNode node);
    void initChild();
    boolean addChild(Object ... node);
    boolean removeChild(Object node);
    boolean clear();
    boolean insert(Object o);
    Object contain();
    boolean setParent(Object node);
    void incrLength();
    void reduceLength();
    long length();
    TreeNode[] findToRear(Object contain);
    TreeNode[] findToFrond(Object contain);
    TreeNode[] findAll(Object contain);

}
