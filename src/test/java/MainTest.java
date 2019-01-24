import cx.by.HappyTree.HappyTree;
import cx.by.HappyTree.TreeNode;
import cx.by.HappyTree.inter.Tree;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {
    TreeNode happyTree;
    TreeNode node1,node2,node3;
    TreeNode node1_1,node1_2,node1_3;
    TreeNode node2_1;
    TreeNode node1_1_1,node1_1_2,node1_1_3,node1_1_1_1;
    TreeNode node1_2_1;
    @Before
    public void initData(){
        happyTree = new HappyTree("root");
        node1 = new TreeNode("node1");
        node2 = new TreeNode("node2");
        node3 = new TreeNode("node3");
        node1_1 = new TreeNode("node1_1");
        node1_2 = new TreeNode("node1_2");
        node1_3 = new TreeNode("node1_3");
        node2_1 = new TreeNode("node2_1");
        node1_1_1 = new TreeNode("node1_1_1");
        node1_1_2 = new TreeNode("node1_1_2");
        node1_1_3 = new TreeNode("node1_1_3");
        node1_2_1 = new TreeNode("node1_2_1");
        node1_1_1_1 = new TreeNode("node1_1_1_1");
    }
    public void buildData(){
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
    }
    @Test
    public void A_addChildTest(){
        TestCase.assertNull(node2.getAllChild());
        TestCase.assertNull(node1.getAllChild(node2));
        buildData();
        TestCase.assertEquals(happyTree.length(),5);
        TestCase.assertEquals(happyTree.children().size(),3);
    }
    @Test
    public void B_getAllChildTest(){
        buildData();
        int size = node1.getAllChild().size();
        Assert.assertEquals(size,8);
    }
    @Test
    public void C_findTest(){
        buildData();
        ArrayList<TreeNode> node = happyTree.findAll("node2");
        TestCase.assertEquals(node.get(0),node2);
    }
    @Test
    public void D_removeChildTest(){
        buildData();
        node1.removeChild(node1_1);
        TestCase.assertEquals(node1.length(),3);
        TestCase.assertEquals(node1.children().size(),2);
        happyTree.removeChild(node1);
        TestCase.assertEquals(happyTree.length(),3);
        TestCase.assertEquals(happyTree.children().size(),2);
    }
    @Test
    public void E_objectTest(){
        TreeNode node = new TreeNode();
        HappyTree tree = new HappyTree();
        Object nodeObj = (Object)node;
        Object treeObj = (Object)tree;
        node.setParent(tree);
        tree.insert("root");
        System.out.println(node);
    }
    @Test
    public void F_baseTest(){
        HappyTree happyTree = new HappyTree();
        TreeNode node = new TreeNode();
        happyTree.addChild(node);
    }
    @Test
    public void G_getAllChildTest(){
        buildData();
        List<TreeNode>list = node1.getAllChild(node2);
        TestCase.assertEquals(list.size(),1);
    }
    @Test
    public void H_clearTest(){
        buildData();
        node1_1.clear();
        TestCase.assertEquals(node1_1.children().size(),0);
        TestCase.assertEquals(happyTree.children().size(),3);
    }
}
