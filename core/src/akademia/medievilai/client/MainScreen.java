package akademia.medievilai.client;

import akademia.medievilai.server.GUIParams;
import akademia.medievilai.server.Player;
import akademia.medievilai.server.TurnHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static akademia.medievilai.server.GUIParams.SCREEN_HEIGHT;
import static akademia.medievilai.server.GUIParams.SCREEN_WIDTH;

public class MainScreen implements Screen {
    private final GameScreen game;
    private final OrthographicCamera camera;
    private Stage stage;
    private TurnHandler turnHandler;
    private TextButton button;

    public MainScreen(final GameScreen game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GUIParams.SCREEN_WIDTH, GUIParams.SCREEN_HEIGHT);

        stage = new Stage(new ScreenViewport(camera), game.getBatch());
        Gdx.input.setInputProcessor(stage);

        turnHandler = new TurnHandler();

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        button = new TextButton("Build view", skin, "default");
        button.setBounds((int)(SCREEN_WIDTH * 0.1), (int) (SCREEN_HEIGHT * 0.8), 170, 50);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BuildScreen(game, button));
            }
        });

        stage.addActor(game.getPlayerView());
        stage.addActor(button);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        camera.update();
        SpriteBatch batch = game.getBatch();
        batch.setProjectionMatrix(camera.combined);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
