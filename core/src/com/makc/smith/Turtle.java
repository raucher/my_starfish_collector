package com.makc.smith;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.security.Key;

public class Turtle extends ActorBeta
{
    private int turtleSpeed = 3;

    @Override
    public void act(float delta)
    {
        super.act(delta);

        updateInput();
    }

    private void updateInput()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            this.moveBy(-turtleSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            this.moveBy(turtleSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.moveBy(0, turtleSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            this.moveBy(0, -turtleSpeed);
        }
    }

    public int getTurtleSpeed()
    {
        return turtleSpeed;
    }

    public void setTurtleSpeed(int turtleSpeed)
    {
        this.turtleSpeed = turtleSpeed;
    }
}
