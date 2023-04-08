package akademia.medievilai;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private PlayerView playerView;
	private Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Player player = new Player();
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, GUIParams.SCREEN_WIDTH, GUIParams.SCREEN_HEIGHT);
		stage = new Stage(new ScreenViewport(camera), batch);
		playerView = new PlayerView(player);

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
		batch.dispose();
	}
}
