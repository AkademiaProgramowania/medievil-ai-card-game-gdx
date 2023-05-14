package akademia.medievilai.server;

import akademia.medievilai.client.GameScreen;
import akademia.medievilai.client.PlayerView;
import akademia.medievilai.server.events.Event;
import akademia.medievilai.server.events.EventBus;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {
	private GameScreen game;
	private PlayerView playerView;
	private Stage stage;

	public Main(GameScreen game) {
		this.game = game;
	}

	@Override
	public void create () {
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, GUIParams.SCREEN_WIDTH, GUIParams.SCREEN_HEIGHT);
		stage = new Stage(new ScreenViewport(camera), game.getBatch());
		playerView = game.getPlayerView();

		stage.addActor(playerView);
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.WHITE);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		game.getBatch().dispose();
	}


}
