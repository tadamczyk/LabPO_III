import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Forest
{
  private static int size;

  public static void setSize(int x)
  {
    size = x;
  }

  public static int[][] createForest(int[][] f)
  {
    Random rand = new Random();
    int i, j;
    for(i = 0; i < f.length; ++i)
    {
      for (j = 0; j < f.length ; ++j)
      {
        f[i][j] = rand.nextInt(2);
      }
    }
    return f;
  }

  public static void outForest(int[][] f)
  {
    for(int[] row: f)
    {
      for(int tree: row)
      {
        System.out.print(tree+", ");
      }
      System.out.println();
    }
  }

  public static double countTrees(int[][] f)
  {
    double treeNo = 0;
    for(int[] row: f)
    {
      for(int tree: row)
      {
        if(tree == 1) ++treeNo;
      }
    }
    return treeNo;
  }

  public static boolean checkEmptyForest(int[][] f)
  {
    for(int[] row: f)
    {
      for(int tree: row)
      {
        if(tree > 0)  return false;
      }
    }
    return true;
  }

  public static void burnForest(int[][] f, int x, int y)
  {
    //System.out.println("row: "+x+", el: "+y);
    if(!checkEmptyForest(f) && f[x][y] == 1)
    {
      f[x][y] = 0;
      //outForest(f);
      if(x-1 >= 0 && f[x-1][y] == 1)          burnForest(f, x-1, y);      //  <-  E
      if(x-1 >= 0 && y-1 >= 0 && f[x-1][y-1] == 1)  burnForest(f, x-1, y-1);    //  '\  NE
      if(y-1 >= 0 && f[x][y-1] == 1)          burnForest(f, x, y-1);      //  '|  N
      if(x+1 < size && y-1 >= 0 && f[x+1][y-1] == 1)  burnForest(f, x+1, y-1);    //  /'  NW
      if(x+1 < size && f[x+1][y] == 1)        burnForest(f, x+1, y);      //  ->  W
      if(x+1 < size && y+1 < size && f[x+1][y+1] == 1)burnForest(f, x+1, y+1);    //  \,  SW
      if(y+1 < size && f[x][y+1] == 1)        burnForest(f, x, y+1);      //  |,  S
      if(x-1 >= 0 && y+1 < size && f[x-1][y+1] == 1)  burnForest(f, x-1, y+1);    //  ,/  SE
    }
  }

  public static void main(String[] args)
  {
    if(args.length == 1) setSize(Integer.parseInt(args[0]));
    else setSize(15);
    int[][] forest = new int[size][size];
    int[] lightning = new int[2];
    forest = createForest(forest);
    //forest[5][0] = 7;
    outForest(forest);
    System.out.println();

    DecimalFormat df = new DecimalFormat("#0.00");
    double treesBegin = countTrees(forest);
    Random rand = new Random();
    lightning[0] = rand.nextInt(size);
    lightning[1] = rand.nextInt(size);
    System.out.println("row: "+lightning[0]+", el: "+lightning[1]);
    burnForest(forest, lightning[0], lightning[1]);
    double treesEnd = countTrees(forest);

    System.out.println("Spaliles "+df.format((treesBegin-treesEnd)/treesBegin*100)+"% lasu; Na początku "+treesBegin+", na koncu "+treesEnd);
    outForest(forest);
    /*while(!checkEmptyForest(forest))
    {
      Random rand = new Random();
      lightning[0] = rand.nextInt(size);
      lightning[1] = rand.nextInt(size);
      //System.out.println("row: "+lightning[0]+", el: "+lightning[1]);
      burnForest(forest, lightning[0], lightning[1]);
      //outForest(forest);
      System.out.println();
      System.out.println();
    }*/
    System.out.println();
    //outForest(forest);
  }
}
