package akademia.medievilai;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.List;

public class PlayerView extends Group {
    private Player player;

    public PlayerView(Player player) {
        this.player = player;

        List<Card> cards = player.getCards();

        int cardsWidth = (cards.size() * GUIParams.CARD_VIEW_WIDTH) + (cards.size() - 1) * 20;
        int cardsStartX = GUIParams.SCREEN_WIDTH / 2 - cardsWidth / 2;
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