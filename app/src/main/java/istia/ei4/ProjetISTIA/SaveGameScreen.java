package istia.ei4.ProjetISTIA;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Alain on 29/03/2015.
 */
public class SaveGameScreen extends GameScreen{

    private ArrayList gridElements;

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

        int col, row;
        for (int i = 0;  i < 15;  i++) {
            col = i % 3;
            row = (i / 3) % 5;
            mapPath = getMapPath(i);
            if(i == 0){
                // TODO: autosave Button with a different image
                this.instances.add(new GameButtonGotoSavedGame((78+(334*col))*ratioW, (45+(311*row))*ratioH, 256*ratioH, 256*ratioW, saver.getButtonSaved(mapPath, true), saver.getButtonSaved(mapPath, false), 4, mapPath));
            } else {
                this.instances.add(new GameButtonGotoSavedGame((78+(334*col))*ratioW, (45+(311*row))*ratioH, 256*ratioH, 256*ratioW, saver.getButtonSaved(mapPath, true), saver.getButtonSaved(mapPath, false), 4, mapPath));
            }
        }

        this.instances.add(new GameButtonGotoBack((int)(54*ratioW), (int)(1600*ratioH), (int)(432*ratioH), (int)(250*ratioW), R.drawable.bt_page_gauche_up, R.drawable.bt_page_gauche_down));
    }

    private String getMapPath(int levelInScreen)
    {
        return "map_"+levelInScreen+".txt";
    }

    @Override
    public void load(RenderManager renderManager) {
        super.load(renderManager);
    }

    @Override
    public void draw(RenderManager renderManager) {
        renderManager.setColor(Color.parseColor("#cccccc"));
        renderManager.paintScreen();

        renderManager.setColor(Color.BLACK);

        int hs2 = this.gameManager.getScreenHeight()/2;
        int ts = hs2/10;
        renderManager.setTextSize((int)(0.5*ts));

        float ratioW = ((float)gameManager.getScreenWidth()) / ((float)1080);
        float ratioH = ((float)gameManager.getScreenHeight()) / ((float)1920);
        int col, row;
        for (int i = 0;  i < 15;  i++) {
            col = i % 3;
            row = (i / 3) % 5;
            if(i == 0){
                //renderManager.drawText(99, 36, "Autosave");
                renderManager.drawText((int)((78+(334*col))*ratioW)+21, (int)((45+(311*row))*ratioH), i + ".");
            } else {
                renderManager.drawText((int)((78+(334*col))*ratioW)+21, (int)((45+(311*row))*ratioH), i + ".");
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

