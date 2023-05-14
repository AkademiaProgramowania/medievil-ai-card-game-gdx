package akademia.medievilai.client;

import akademia.medievilai.server.GUIParams;
import akademia.medievilai.server.Player;
import akademia.medievilai.server.Card;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;


import java.util.List;

public class PlayerView extends Group {
    private Player player;
    private int cardsWidth;
    private int cardsStartX;

    public PlayerView(Player player) {
        this.player = player;
    }

    @Override
    public void act(float delta) {
        clearChildren();

        List<Card> cards = player.getCardsInHand();

        cardsWidth = (cards.size() * GUIParams.CARD_VIEW_WIDTH) + (cards.size() - 1) * 20;
        cardsStartX = GUIParams.SCREEN_WIDTH / 2 - cardsWidth / 2;

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            CardView cardView = new CardView(AssetReferences.cardTexture, card);
            addActor(cardView);
            cardView.setPosition(
                    cardsStartX + (i * GUIParams.CARD_VIEW_WIDTH) + (i * GUIParams.CARD_VIEW_GAP),
                    GUIParams.CARD_VIEW_Y);
        }
    }
}