import cx.by.HappyTree.HappyTree;
import org.junit.Test;


public class MainTest {
    @Test
    public void main(){
        HappyTree happyTree = new HappyTree();
        happyTree.insert("root");
        HappyTree node1 = new HappyTree();
        happyTree.add(node1);
        System.out.println(happyTree);
        HappyTree node2 = new HappyTree();
        happyTree.add(node2);
        HappyTree node1_1 = new HappyTree();
    }
}
