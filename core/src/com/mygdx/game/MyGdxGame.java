package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameOOP.Main;
import com.mygdx.game.GameOOP.Units.Crossbowman;
import com.mygdx.game.GameOOP.Units.Magican;
import com.mygdx.game.GameOOP.Units.Monk;
import com.mygdx.game.GameOOP.Units.Peasant;
import com.mygdx.game.GameOOP.Units.Sniper;
import com.mygdx.game.GameOOP.Units.Spearman;
import com.mygdx.game.GameOOP.Units.Thief;
import com.mygdx.game.GameOOP.Units.Unit;
import com.mygdx.game.GameOOP.Units.Wizard;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, mage, monk, peasant, rouge, sniper, spMan, crBowMan;
	Music music;
	Main game;
	
	@Override
	public void create () {
		game = new Main();

		batch = new SpriteBatch();
		fon = new Texture("фоны/"+Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Музыка/paul-romero-rob-king-combat-theme-0"+ (new Random().nextInt(4)+1) +".mp3"));
		music.setVolume(.025f);
		music.setLooping(true);
		music.play();

		crBowMan = new Texture("персонажи/CrossBowMan.png");
		mage = new Texture("персонажи/Mage.png");
		monk = new Texture("персонажи/Monk.png");
		peasant = new Texture("персонажи/Peasant.png");
		rouge = new Texture("персонажи/Rouge.png");
		sniper = new Texture("персонажи/Sniper.png");
		spMan = new Texture("персонажи/SpearMan.png");
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		int dx = Gdx.graphics.getWidth()/12;
		int dy = Gdx.graphics.getHeight()/12;

		for (Unit u: Main.team3) {
			if (u instanceof Crossbowman & !u.die()) {
				batch.draw(crBowMan, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
			if (u instanceof Monk & !u.die()) {
				batch.draw(monk, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
			if (u instanceof Peasant & !u.die()) {
				batch.draw(peasant, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
			if (u instanceof Sniper & !u.die()) {
				batch.draw(sniper, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
			if (u instanceof Spearman & !u.die()) {
				batch.draw(spMan, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
			if (u instanceof Thief & !u.die()) {
				batch.draw(rouge, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
			if (u instanceof Wizard & !u.die()) {
				batch.draw(mage, u.getCoords()[1]*dx, u.getCoords()[0]*dy);
			}
		}

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
			game.step();
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}
