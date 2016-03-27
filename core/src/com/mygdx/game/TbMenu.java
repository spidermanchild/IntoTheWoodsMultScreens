package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * Created by michelle on 3/27/2016.
 */
public class TbMenu extends TextButton{
    String sText;
    // creating it based on a tbs - not a skin
    public TbMenu(String text, TbsMenu skin) {
        super(text, skin);
        sText = text;
        this.setSize(600, 200);
        this.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                System.out.println(sText);
            }
        });
    }
}