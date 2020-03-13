package com.makc.smith;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
    int turtleSpeed = 3;

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

        // USER INPUT HANDLING
        processUserInput();

        // UPDATE GAME STATE
        updateGameState();

        // RENDERINIG //
        Gdx.gl.glClearColor(0, 0, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // OCEAN
        batch.draw(oceanTexture, 0 ,0);

        // STARFISH
        if (!win) {
            batch.draw(starfishTexture, starfishX, starfishY);
        } else {
            batch.draw(winMessageTexture, 175, 300);
        }

        // TURTLE
        batch.draw(turtleTexture, turtleX, turtleY);

        batch.end();
    }

    private void updateGameState() {
        turtleRectangle.setPosition(turtleX, turtleY);

        if (turtleRectangle.overlaps(starfishRectangle)) {
            win = true;
        }

    }

    private void processUserInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            turtleX -= turtleSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            turtleX += turtleSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            turtleY += turtleSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            turtleY -= turtleSpeed;
        }
    }

    @Override
    public void dispose () {
        batch.dispose();
        turtleTexture.dispose();
        starfishTexture.dispose();
        oceanTexture.dispose();
    }
}
