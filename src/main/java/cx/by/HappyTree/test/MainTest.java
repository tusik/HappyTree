import cx.by.HappyTree.HappyTree;
import cx.by.HappyTree.TreeNode;
import org.junit.Test;


public class MainTest {
    @Test
    public void main(){
        long start = System.currentTimeMillis();
        HappyTree happyTree = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node1_1 = new TreeNode();
        TreeNode node1_2 = new TreeNode();
        TreeNode node1_3 = new TreeNode();
        TreeNode node2_1 = new TreeNode();
        TreeNode node1_1_1 = new TreeNode();
        TreeNode node1_1_2 = new TreeNode();
        TreeNode node1_1_3 = new TreeNode();
        TreeNode node1_2_1 = new TreeNode();
        TreeNode node1_1_1_1 = new TreeNode();
        node1_1_1.addChild(node1_1_1_1);
        node1_1.addChild(node1_1_1);
        node1_1.addChild(node1_1_2);
        node1_1.addChild(node1_1_3);
        node1.addChild(node1_1);
        node1_2.addChild(node1_2_1);
        node1.addChild(node1_2);
        node1.addChild(node1_3);
        node2.addChild(node2_1);
        happyTree.addChild(node1);
        happyTree.addChild(node2);
        happyTree.addChild(node3);
        System.out.println(happyTree);
        happyTree.removeChild(node1);
        System.out.println(System.currentTimeMillis()-start);
    }
}
