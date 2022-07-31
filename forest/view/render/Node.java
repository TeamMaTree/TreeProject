package forest.view.render;

import forest.view.render.reef.Reef;
import java.util.List;

/*
 * ノード
 */
public interface Node
{
    /*
     * 表示するテキストを取得
     */
    public String getText();
    /*
     * 親を取得
     */
    public Node getParent();
    /*
     * 子供のリストを取得
     */
    public List<Reef> getReadonlyChildren();
    /*
     * 自身が親に何番目として登録されているか取得
     */
    public int getIndex();
    /*
     * 子供を追加する
     */
    public void addChild(Reef reef);
    /*
     * 階層の深さを取得
     */
    public int getIndent();
}
