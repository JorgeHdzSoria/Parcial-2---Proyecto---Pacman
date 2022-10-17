import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (Jorge Alberto Hernandez Soria) 
 * @version (0.1)
 */
public class Level extends World
{
    String[] textMap = {
        "****.******.***",
        "P.............O",
        "*.**.*.********",
        "*.*...........*",
        "*.*.*.*.*.*.*.*",
        "*.*.*.*.*.*.*.*",
        "*.*...........*",
        "*.*.**.*S****.*",
        ".......*......C",
        "****.******.***"
    };
    
    Scoreboard sb;

    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 460, 1); 
        GreenfootImage bgImage = new GreenfootImage(1,1);
        bgImage.setColor(Color.BLACK);
        bgImage.drawRect(0, 0, 1, 1);    
        setBackground(bgImage);
        prepare();
        drawMap();
        sb = new Scoreboard();
        addObject(sb, getWidth()/2,430);

    }
    
    public void addScore(int amount){
        sb.addScore(amount);
    }
    
    private void prepare(){
        /*Pacman pacman = new Pacman();
        addObject(pacman, 100,100);
        Wall wall = new Wall();
        addObject(wall,400,200);
        */
    }
    
    private void drawMap(){
        for(int i = 0; i < textMap.length;i++){
            String mapLine = textMap[i];
            for(int j = 0; j < mapLine.length(); j++){
                char mapChar = mapLine.charAt(j);
                int y = i * 40 + 20;
                int x = j * 40 + 20;
                switch(mapChar){
                    case '*':
                        addObject(new Wall(), x, y);
                        break;
                    case '.':
                        addObject(new Pill(), x, y);
                        break;
                    case 'P':
                        addObject(new Pacman(), x, y);
                        break;
                    case 'S':
                        addObject(new Sandia(), x, y);
                        break;
                    case 'C':
                        addObject(new Cosa(), x, y);
                        break;
                    case 'O':
                        addObject(new Orange(), x, y);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
