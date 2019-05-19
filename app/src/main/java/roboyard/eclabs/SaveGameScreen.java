package roboyard.eclabs;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Alain on 29/03/2015.
 */
public class SaveGameScreen extends GameScreen{

    public SaveGameScreen(GameManager gameManager){
        super(gameManager);
    }

    @Override
    public void create() {

        gameManager.getRenderManager().loadImage(R.drawable.bt_start_down_saved_used);
        gameManager.getRenderManager().loadImage(R.drawable.bt_start_up_saved_used);
        gameManager.getRenderManager().loadImage(R.drawable.bt_start_up_saved);
        gameManager.getRenderManager().loadImage(R.drawable.bt_start_down_saved);

        createButtons();
    }

    /**
     * creates Buttons for the savescreen which are used both, for saving and loading
     */
    public void createButtons()
    {
        int stepX = 211;
        int stepY = 222;
        int cols = 5;
        int rows = 7;
        int iconsize = 144;
        ArrayList<GameButtonGotoSavedGame> aRemove = new ArrayList<>();
        for(Object currentObject : this.instances)
        {
            if(currentObject.getClass() == GameButtonGotoSavedGame.class)
            {
                aRemove.add((GameButtonGotoSavedGame)currentObject);
            }
        }
        for(GameButtonGotoSavedGame p : aRemove)
        {
            this.instances.remove(p);
        }

        String mapPath = "";
        SaveManager saver = new SaveManager(gameManager.getActivity());

        float ratioW = ((float)gameManager.getScreenWidth()) / ((float)1080);
        float ratioH = ((float)gameManager.getScreenHeight()) / ((float)1920);

        int hs2 = this.gameManager.getScreenHeight()/2;
        int ts = hs2/10;

        int col, row;
        for (int i = 0;  i < cols*rows;  i++) {
            col = i % cols;
            row = (i / cols) % rows;
            mapPath = getMapPath(i);
            if(i == 0){
                // autosave Button with a different image
                this.instances.add(new GameButtonGotoSavedGame((55+(stepX*col))*ratioW, (45+ts+(stepY*row))*ratioH, iconsize*ratioH, iconsize*ratioW, saver.getButtonAutoSaved(mapPath, true), saver.getButtonAutoSaved(mapPath, false), 4, mapPath));
            } else {
                this.instances.add(new GameButtonGotoSavedGame((55+(stepX*col))*ratioW, (45+ts+(stepY*row))*ratioH, iconsize*ratioH, iconsize*ratioW, saver.getButtonSaved(mapPath, true), saver.getButtonSaved(mapPath, false), 4, mapPath));
            }
        }

        this.instances.add(new GameButtonGotoBack((int)(814*ratioW), (int)(1650*ratioH), (int)(222*ratioH), (int)(222*ratioW), R.drawable.bt_back_up, R.drawable.bt_back_down));
    }

    public static String getMapPath(int levelInScreen)
    {
        return "map_"+levelInScreen+".txt";
    }

    @Override
    public void load(RenderManager renderManager) {
        super.load(renderManager);
    }

    @Override
    public void draw(RenderManager renderManager) {
        int stepX = 211;
        int stepY = 222;
        int cols = 5;
        int rows = 7;

        renderManager.setColor(Color.parseColor("#cccccc"));
        renderManager.paintScreen();

        renderManager.setColor(Color.BLACK);

        int hs2 = this.gameManager.getScreenHeight()/2;
        int ts = hs2/10;
        renderManager.setTextSize((int)(0.5*ts));

        float ratioW = ((float)gameManager.getScreenWidth()) / ((float)1080);
        float ratioH = ((float)gameManager.getScreenHeight()) / ((float)1920);

        renderManager.drawText((int)(20*ratioW), (int)(55*ratioH), "Select Savegame");

        int col, row;
        for (int i = 0;  i < cols*rows;  i++) {
            col = i % cols;
            row = (i / cols) % rows;
            if(i == 0){
                renderManager.drawText((int)((20+(stepX*col))*ratioW), (int)((42+ts+(stepY*row))*ratioH), "Autosave");
            } else {
                renderManager.drawText((int)((40+(stepX*col))*ratioW), (int)((45+ts+(stepY*row))*ratioH), i + ".");
            }
        }
        super.draw(renderManager);
    }

    @Override
    public void update(GameManager gameManager) {
        super.update(gameManager);
        if(gameManager.getInputManager().backOccurred()){
            gameManager.setGameScreen(gameManager.getPreviousScreenKey());
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

