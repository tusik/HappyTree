import cx.by.HappyTree.HappyTree;
import org.junit.Test;


public class MainTest {
    @Test
    public void main(){
        HappyTree happyTree = new HappyTree();
        happyTree.insert("root");
        HappyTree node1 = new HappyTree();

        System.out.println(happyTree);
    }
}
