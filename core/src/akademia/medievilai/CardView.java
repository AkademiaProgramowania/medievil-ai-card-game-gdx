package akademia.medievilai;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CardView extends Actor {

    private Texture texture;
    private Card card;
    private BitmapFont font;
    private GlyphLayout layout = new GlyphLayout();

    public CardView(Texture texture, Card card) {
        this.texture = texture;
        this.card = card;
        font = new BitmapFont();

        setBounds(0, 0, GUIParams.CARDVIEW_WIDTH, GUIParams.CARDVIEW_HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(),
                getRotation(), 0, 0, texture.getWidth(), texture.getHeight(),
                false, false);

        batch.setColor(Color.WHITE);
        layout.setText(font, card.toString());
        float cardCenterX = getX() + GUIParams.CARDVIEW_WIDTH / 2 - layout.width / 2;
        float cardCenterY = getY() + GUIParams.CARDVIEW_HEIGHT / 2 - layout.height / 2;
        font.draw(batch, layout, cardCenterX, cardCenterY);
        super.draw(batch, parentAlpha);
    }
}
