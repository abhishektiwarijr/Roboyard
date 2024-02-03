package roboyard.eclabs;

import android.graphics.Color;

/**
 * Represents the Credits game screen.
 * Created by Pierre on 04/02/2015.
 */
public class CreditsGameScreen extends GameScreen {

    public CreditsGameScreen(GameManager gameManager) {
        super(gameManager);
    }

    int hs2; // Half the screen height

    /**
     * Creates game objects for the Credits screen.
     */
    @Override
    public void create() {
        int ws2 = this.gameManager.getScreenWidth() / 2;
        hs2 = this.gameManager.getScreenHeight() / 2;
        // Add back button
        this.instances.add(new GameButtonGoto(7 * ws2 / 4 - 128, 9 * hs2 / 5 - 128, 128, 128, R.drawable.bt_back_up, R.drawable.bt_back_down, 0));
    }

    /**
     * Loads assets for rendering.
     * @param renderManager The render manager
     */
    @Override
    public void load(RenderManager renderManager) {
        super.load(renderManager);
    }

    /**
     * Renders the Credits screen.
     * @param renderManager The render manager
     */
    @Override
    public void draw(RenderManager renderManager) {
        // Get app version information
        int versionCode = BuildConfig.VERSION_CODE;
        String versionName = BuildConfig.VERSION_NAME;

        // Set background color
        //renderManager.setColor(Color.BLUE);
        renderManager.setColor(Color.parseColor("#B0CC99")); // Light green background
        renderManager.paintScreen();

        // Set text color and size
        renderManager.setColor(Color.BLACK);
        int ts = hs2 / 10; // Text size

        // Draw credits text
        renderManager.setTextSize((int) (1.2 * ts));
        renderManager.drawText(10, 2 * ts, "Created by");
        renderManager.setTextSize((int) (0.7 * ts));
        renderManager.drawText(10, 3 * ts, "Alain Caillaud");
        renderManager.drawText(10, 4 * ts, "Pierre Michel");
        renderManager.drawText(10, 5 * ts, "Ruben Barkow-Kuder");

        renderManager.setTextSize((int) (1.2 * ts));
        renderManager.drawText(10, 7 * ts, "Based on");
        renderManager.setTextSize((int) (0.7 * ts));
        renderManager.drawText(10, 8 * ts, "Ricochet Robots(r)");

        renderManager.setTextSize((int) (1.2 * ts));
        renderManager.drawText(10, 10 * ts, "Imprint/privacy policy");
        renderManager.setTextSize((int) (0.7 * ts));
        renderManager.drawText(10, 11 * ts, "https://eclabs.de/datenschutz.html");

        renderManager.setTextSize((int) (1.2 * ts));
        renderManager.drawText(10, 13 * ts, "Open Source");
        renderManager.setTextSize((int) (0.7 * ts));
        renderManager.drawText(10, 14 * ts, "https://git.io/fjs5H");

        renderManager.drawText(10, 17 * ts, "Version: " + versionName + " (Build " + versionCode + ")");

        super.draw(renderManager);
    }

    /**
     * Updates the Credits screen.
     * @param gameManager The game manager
     */
    @Override
    public void update(GameManager gameManager) {
        super.update(gameManager);
        // Handle back button press to return to the main menu
        if (gameManager.getInputManager().backOccurred()) {
            gameManager.setGameScreen(0); // Set the main menu screen
        }
    }

    /**
     * Cleans up resources used by the Credits screen.
     */
    @Override
    public void destroy() {
        super.destroy();
    }
}
