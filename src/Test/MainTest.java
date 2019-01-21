package Test;

import cx.by.HappyTree.HappyTree;
import cx.by.HappyTree.TreeNode;
import cx.by.HappyTree.inter.Tree;
import org.junit.Test;


public class MainTest {
    @Test
    public void main(){
        HappyTree tree = new HappyTree();
        TreeNode node1=new TreeNode();
        TreeNode node2=new TreeNode();
        TreeNode node3=new TreeNode();
        TreeNode node1_1=new TreeNode();
        TreeNode node1_2=new TreeNode();
        TreeNode node1_3=new TreeNode();
        TreeNode node1_1_1 = new TreeNode();
        node1_1.addChild(node1_1_1);
        node1.addChild(node1_1);
        node1.addChild(node1_2);
        node1.addChild(node1_3);
        tree.addChild(node1);
        tree.addChild(node2);
        tree.addChild(node3);
        System.out.println("final");
    }
}
