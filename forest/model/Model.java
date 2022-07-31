package forest.model;

import java.util.ArrayList;
import java.util.List;

import forest.view.render.Node;
import forest.view.render.brunch.Brunch;
import forest.view.render.reef.Reef;
import forest.view.render.root.Root;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.Reader;

/*
 * モデル
 */
public class Model 
{
    /*
     * 木の親
     */
    private Root root;
    /*
     * 木の葉のリスト
     */
    private List<Reef> reefList = new ArrayList<>(); 
    /*
     * 木の枝のリスト
     */
    private List<Brunch> brunchList = new ArrayList<>(); 

    /*
     * Fileを引数とするモデルコンストラクタ
     */
    public Model(File file) throws IOException 
    {
        FileReader fileReader = new FileReader(file);
        BufferedReader buffer = new BufferedReader((Reader)fileReader);

        readFile(buffer);

        fileReader.close();
        buffer.close();
    }

    /*
     * ファイルを読み込む
     */
    private void readFile(BufferedReader buffer) throws IOException 
    {
        String line;
        while ((line = buffer.readLine()) != null) 
        {
            if (line.equals("trees:")) continue;
            if (line.equals("nodes:")) break;

            int indent = 0;

            String searchStr = "|-- ";
            
            int n = line.indexOf(searchStr, 0);
            int lastN = 0; 
            while (n != -1)
            {
                lastN = n + searchStr.length();
                n = line.indexOf(searchStr, lastN);
                indent++;
            }

            addNode(indent, line.substring(lastN));
        }
    }

    /*木の枝と葉を実装するインターフェース */
    List<Node> parents = new ArrayList<>();
    /* 前のインデント */
    int prevIndent;
    /* 前のインフェース */
    Node prevNode;
    
    /*
     * ノードを追加する
     */
    private void addNode(int indent, String text)
    {
        if (indent == 0) 
        {
            root = new Root(text);
            prevNode = root;
        }
        else 
        {
            if (prevIndent > indent) parents.remove(parents.get(parents.size() - 1));
            if (prevIndent < indent) parents.add(prevNode);

            prevIndent = indent;

            Reef reef = new Reef(parents.get(parents.size() - 1), text);
            reefList.add(reef);
            brunchList.add(new Brunch(reef));
            prevNode = reef;
        }
    }

    /*
     * 木の親を取得する
     */
    public Root getRoot()
    {
        return root;
    }

    /*
     * 木の葉のリストを取得する
     */
    public List<Reef> getReefList()
    {
        return reefList;
    }

    /*
     * 木の枝のリストを取得する
     */
    public List<Brunch> getBrunchList()
    {
        return brunchList;
    }
}
