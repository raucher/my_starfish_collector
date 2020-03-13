package com.makc.smith;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class StarfishCollectorAlpha extends Game {
    SpriteBatch batch;

    Texture oceanTexture;
    Texture winMessageTexture;

    boolean win = false;

    // TURTLE
    Texture turtleTexture;
    Rectangle turtleRectangle;
    float turtleX;
    float turtleY;

    // STARFISH
    Texture starfishTexture;
    Rectangle starfishRectangle;
    float starfishX;
    float starfishY;

    @Override
    public void create () {
        batch = new SpriteBatch();

        turtleTexture = new Texture("turtle-1.png");
        turtleX = 20;
        turtleY = 20;
        turtleRectangle =
                new Rectangle(turtleX, turtleY, turtleTexture.getWidth(), turtleTexture.getHeight());

        starfishTexture = new Texture("starfish.png");
        starfishX = 320;
        starfishY = 320;
        starfishRectangle =
                new Rectangle(starfishX, starfishY, starfishTexture.getWidth(), starfishTexture.getHeight());

        oceanTexture = new Texture("water.jpg");
        winMessageTexture = new Texture("you-win.png");
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(turtleTexture, turtleX, turtleY);
        batch.draw(starfishTexture, starfishX, starfishY);

        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
