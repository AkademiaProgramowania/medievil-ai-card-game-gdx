package akademia.medievilai.client;

import akademia.medievilai.server.GUIParams;
import akademia.medievilai.server.Player;
import akademia.medievilai.server.TurnHandler;
import akademia.medievilai.server.events.Event;
import akademia.medievilai.server.events.EventBus;
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
    private Skin buttonsSkin;

    public MainScreen(final GameScreen game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        buttonsSkin = new Skin(Gdx.files.internal("uiskin.json"));

        stage = new Stage(new ScreenViewport(camera), game.getBatch());

        final TextButton buildButton = new TextButton("Build view", buttonsSkin, "default");
        buildButton.setBounds((int)(SCREEN_WIDTH * 0.1), (int) (SCREEN_HEIGHT * 0.8), 170, 50);
        buildButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BuildScreen(game, buildButton));
            }
        });

        final TextButton turnEndButton = new TextButton("End turn", buttonsSkin, "default");
        turnEndButton.setBounds((int)(SCREEN_WIDTH * 0.1), (int) (SCREEN_HEIGHT * 0.7), 170, 50);
        turnEndButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                EventBus.notify(Event.TURN_END);
            }
        });

        stage.addActor(game.getPlayerView());
        stage.addActor(buildButton);
        stage.addActor(turnEndButton);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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
