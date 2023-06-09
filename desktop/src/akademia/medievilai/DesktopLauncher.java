package akademia.medievilai;

import akademia.medievilai.client.GameScreen;
import akademia.medievilai.server.GUIParams;
import akademia.medievilai.server.Main;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Medievil AI");
		config.setWindowedMode(GUIParams.SCREEN_WIDTH,GUIParams.SCREEN_HEIGHT);
		new Lwjgl3Application(new GameScreen(), config);
	}
}
