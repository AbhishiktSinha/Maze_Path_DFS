package MazeSolver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//import MazeSolver.DFS;

public class MazeClass extends JFrame
{
    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            };

    ArrayList<int[]>path = new ArrayList<int[]>();
    MazeClass()
    {
        setTitle("Path Through Maze");
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBackground(new Color(0x88005CB4, true));
        getContentPane().setBackground(new Color(66, 66, 66, 255));
        ImageIcon icon = new ImageIcon("maze.png");
        setIconImage(icon.getImage());
        setVisible(true);

        DFS search = new DFS();
        search.findPath(maze, 1, 1, path);
        System.out.println(path);
    }

    @Override
    public void paint(Graphics g)
    {
        g.translate(300, 100);
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                Color color;
                switch(maze[i][j])
                {
                    case 1 : color = new Color(94, 7, 7); break; //obstruction (red)
                    case 9 : color = new Color(45, 128, 24); break; //exit (green)
                    default : color = new Color(206, 206, 206); //navigable path (white)

                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(new Color(66, 66, 66, 255));
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }

        for(int i = 0; i < path.size(); i++)
        {
            int x = path.get(i)[0];
            int y = path.get(i)[1];
            g.setColor(Color.BLUE);
            g.fillRect(30*x, 30*y, 30, 30);
            g.setColor(new Color(66, 66, 66, 255));
            g.drawRect(30*x, 30*y, 30, 30);
        }
    }

    public static void main(String[] args)
    {
        MazeClass frame = new MazeClass();
    }
}
