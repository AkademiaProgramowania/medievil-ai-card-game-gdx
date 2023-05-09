package akademia.medievilai.client;

import akademia.medievilai.server.Player;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Game {
    private SpriteBatch batch;
    private BitmapFont font;
    private PlayerView playerView;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        playerView = new PlayerView(new Player());
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
}
