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

public class Model 
{
    public Root root;
    public List<Reef> reefs = new ArrayList<>(); 
    public List<Brunch> brunchs = new ArrayList<>(); 

    public Model(File file) throws IOException 
    {
        FileReader fileReader = new FileReader(file);
        BufferedReader buffer = new BufferedReader((Reader)fileReader);

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

            AddNode(indent, line.substring(lastN));
        }

        fileReader.close();
        buffer.close();
    }

    List<Node> parents = new ArrayList<>();
    int prevIndent;
    Node prevNode;
        
    private void AddNode(int indent, String text)
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
            reefs.add(reef);
            brunchs.add(new Brunch(reef));
            prevNode = reef;
        }
    }
}
