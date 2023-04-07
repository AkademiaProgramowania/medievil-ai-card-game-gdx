package akademia.medievilai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.List;

public class PlayerView extends Group {
    private Player player;

    public PlayerView(Player player) {
        this.player = player;
        Texture texture = new Texture(Gdx.files.internal("card.png"));
        List<Card> cards = player.getCards();

        int cardsWidth = (cards.size() * GUIParams.CARDVIEW_WIDTH) + (cards.size() - 1) * 20;
        int cardsStartX = GUIParams.SCREEN_WIDTH / 2 - cardsWidth / 2;
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            CardView cardView = new CardView(texture, card);
            addActor(cardView);
            cardView.setPosition(cardsStartX + (i * 100) + (i * 20), 50);
        }
    }
}
