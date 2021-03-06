package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by michelle on 3/27/2016.
 */
public class ScrGame implements Screen {

    GamIntoTheWoods gamIntoTheWoods;
    TextureAtlas taHero;
    TextureRegion trCurrentFrame, trLeft[], trRight[], trUp[], trDown[];
    Animation aniLeft, aniRight, aniUp, aniDown;
    float fStateTime;
    SpriteBatch spriteBatch;
    Texture Background;
    float HeroX, HeroY, HeroSpeed = 50f;

    public ScrGame(GamIntoTheWoods gamIntoTheWoods) {
        this.gamIntoTheWoods = gamIntoTheWoods;
    }

    @Override
    public void show() {
        Background = new Texture(Gdx.files.internal("lostwoods2.jpg"));
        taHero = new TextureAtlas("Heroinepacked.pack");
        trCurrentFrame = new TextureRegion();
        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        trUp = new TextureRegion[3];
        trDown = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taHero.findRegion("Left" + (i + 1));
            trRight[i] = taHero.findRegion("Right" + (i + 1));
            trUp[i] = taHero.findRegion("Up" + (i + 1));
            trDown[i] = taHero.findRegion("Down" + (i + 1));
        }
        aniRight = new Animation(1f / 4, trRight);
        aniLeft = new Animation(1f / 4, trLeft);
        aniUp = new Animation(1f / 4, trUp);
        aniDown = new Animation(1f / 4, trDown);

        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        trCurrentFrame = aniDown.getKeyFrame(0);
        fStateTime += Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            HeroX -= Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniLeft.getKeyFrame(0 + fStateTime, true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            HeroX += Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniRight.getKeyFrame(0 + fStateTime, true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            HeroY += Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniUp.getKeyFrame(0 + fStateTime, true);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            HeroY -= Gdx.graphics.getDeltaTime() * HeroSpeed;
            trCurrentFrame = aniDown.getKeyFrame(0 + fStateTime, true);
        }
        spriteBatch.begin();
        spriteBatch.draw(Background, 0, 0);
        spriteBatch.draw(trCurrentFrame, (int) HeroX, (int) HeroY);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}