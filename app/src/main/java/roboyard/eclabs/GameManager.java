package roboyard.eclabs;

import android.util.SparseArray;
import android.widget.Toast;

/**
 * Created by Pierre on 04/02/2015.
 */
public class GameManager {
    private GameScreen currentScreen;

    private GameScreen previousScreen;
    private final SparseArray<GameScreen> screens;
    private final InputManager inputManager;
    private final RenderManager renderManager;
    private final int sWidth;
    private final int sHeight;
    private final MainActivity activity;

    public MainActivity getActivity() {
        return activity;
    }

    /*
     * Constructor of the GameManager class.
     * @param Reference to the input manager (InputManager).
     * @param Reference to the render manager (RenderManager).
     * @param Width of the screen.
     * @param Height of the screen.
     */
    public GameManager(InputManager inputManager, RenderManager renderManager, int sWidth, int sHeight, MainActivity activity){
        this.inputManager = inputManager;
        this.renderManager = renderManager;
        this.sWidth = sWidth;
        this.sHeight = sHeight;
        this.screens = new SparseArray<GameScreen>();
        this.activity = activity;
        //list of all screens
        /* screen 1: second start screen
         * screen 2: settings
         * screen 3: credits
         * screen 4: start random game
         * screen 5-8: start level game
         * screen 9: save games
         */
        this.screens.append(0, new MainMenuGameScreen(this));
        this.screens.append(1, new GameOptionsGameScreen(this));
        this.screens.append(2, new SettingsGameScreen(this));
        this.screens.append(3, new CreditsGameScreen(this));
        this.screens.append(4, new GridGameScreen(this));
        this.screens.append(5, new LevelChoiceGameScreen(this, 0, -1, 6));
        this.screens.append(6, new LevelChoiceGameScreen(this, 15, 5, 7));
        this.screens.append(7, new LevelChoiceGameScreen(this, 30, 6, 8));
        this.screens.append(8, new LevelChoiceGameScreen(this, 45, 7, -1));
        this.screens.append(9, new SaveGameScreen(this));

        //end of list of all screens
        this.currentScreen = this.screens.get(0);
        this.previousScreen = this.screens.get(0);
    }

    public void requestEnd(){
        this.activity.closeApp();
    }

    public void requestRestart(){
        this.activity.restartApp();
    }

    public void requestToast(CharSequence str, boolean big){
        this.activity.doToast(str, big);
    }

    public SparseArray<GameScreen> getScreens(){
        return this.screens;
    }

    /*
     * Returns the width of the screen.
     * @return Width of the screen
     */
    public int getScreenWidth(){
        return this.sWidth;
    }

    /*
     * Returns the height of the screen.
     * @return Height of the screen
     */
    public int getScreenHeight(){
        return this.sHeight;
    }

    /*
     * Returns the reference to the render manager.
     * @return Render manager
     */
    public RenderManager getRenderManager(){
        return this.renderManager;
    }

    /*
     * Returns the reference to the input manager.
     * @return Input manager
     */
    public InputManager getInputManager(){
        return this.inputManager;
    }

    /*
     * Returns the reference to the currently used game screen.
     * @return Reference to a game screen
     */
    public GameScreen getCurrentScreen(){
        return this.currentScreen;
    }

    /*
     * Updates the currently used game screen.
     * This means that all objects belonging to this screen will also be updated.
     */
    public void update(){
        this.currentScreen.update(this);
    }

    /*
     * Displays the currently used game screen.
     * This means that all objects belonging to this screen will be displayed.
     */
    public void draw(){
        this.currentScreen.draw(this.renderManager);
    }

    /*
     * Destroys all existing game screens and all objects in these game screens.
     */
    public void destroy() {
        for(int i=0; i<this.screens.size(); i++){
            this.screens.get(this.screens.keyAt(i)).destroy();
        }
    }

    /*
     * Modifies the current game screen, allowing to switch from one game screen to another.
     * @param Index of the new game screen
     */
    public void setGameScreen(int nextScreen){

        if(screens.indexOfValue(this.previousScreen) != nextScreen)
        {
            this.previousScreen = this.currentScreen;
        }
        this.currentScreen = this.screens.get(nextScreen);
    }

    public int getPreviousScreenKey()
    {
        return screens.indexOfValue(this.previousScreen);
    }
}
