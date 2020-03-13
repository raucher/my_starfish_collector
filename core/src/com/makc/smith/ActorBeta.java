package com.makc.smith;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class ActorBeta extends Actor
{
    private TextureRegion textureRegion;
    private Rectangle rectangle;

    public ActorBeta()
    {
        super();
        textureRegion = new TextureRegion();
        rectangle = new Rectangle();
    }

    public void setTexture(Texture t)
    {
        textureRegion.setRegion(t);

        // set Actor's dimensions
        setSize(t.getWidth(), t.getHeight());

        // set rectangle's dimensions
        rectangle.setSize(t.getWidth(), t.getHeight());
    }

    public Rectangle getRectangle()
    {
        rectangle.setPosition(getX(), getY());

        return rectangle;
    }

    public boolean overlaps(ActorBeta other)
    {
        return getRectangle().overlaps(other.getRectangle());
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);

        batch.setColor(getColor());

        if (isVisible())
        {
            batch.draw(textureRegion,
                    getX(), getY(),
                    getOriginX(), getOriginY(),
                    getWidth(), getHeight(),
                    getScaleX(), getScaleY(),
                    getRotation());

        }

    }
}
