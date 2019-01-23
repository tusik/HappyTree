import cx.by.HappyTree.HappyTree;
import cx.by.HappyTree.TreeNode;
import org.junit.Test;


public class MainTest {
    @Test
    public void main(){
        long start = System.currentTimeMillis();
        TreeNode happyTree = new HappyTree("root");
        TreeNode node1 = new TreeNode("node1");
        TreeNode node2 = new TreeNode("node2");
        TreeNode node3 = new TreeNode("node3");
        TreeNode node1_1 = new TreeNode("node1_1");
        TreeNode node1_2 = new TreeNode("node1_2");
        TreeNode node1_3 = new TreeNode("node1_3");
        TreeNode node2_1 = new TreeNode("node2_1");
        TreeNode node1_1_1 = new TreeNode("node1_1_1");
        TreeNode node1_1_2 = new TreeNode("node1_1_2");
        TreeNode node1_1_3 = new TreeNode("node1_1_3");
        TreeNode node1_2_1 = new TreeNode("node1_2_1");
        TreeNode node1_1_1_1 = new TreeNode("node1_1_1_1");
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
        System.out.println(happyTree.findAll("node2"));
        System.out.println(node1.getAllChild());
        for (TreeNode node : node1.getAllChild()){
            System.out.println(node.contain());
        }
    }
    @Test
    public void objectTest(){
        TreeNode node = new TreeNode();
        HappyTree tree = new HappyTree();
        Object nodeObj = (Object)node;
        Object treeObj = (Object)tree;
        node.setParent(tree);
        System.out.println(node);
    }
}
