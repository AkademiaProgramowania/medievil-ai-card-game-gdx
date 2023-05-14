package akademia.medievilai.client;

import akademia.medievilai.server.Player;
import akademia.medievilai.server.TurnHandler;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Game {
    private Player player;
    private SpriteBatch batch;
    private BitmapFont font;
    private PlayerView playerView;
    private TurnHandler turnHandler;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        player = new Player();
        playerView = new PlayerView(player);
        turnHandler = new TurnHandler(player);
        setScreen(new MainScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public TurnHandler getTurnHandler() {
        return turnHandler;
    }
}
