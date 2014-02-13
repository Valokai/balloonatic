package util;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParticleManager {

    List<ParticleSystem> particleSystemList = new ArrayList<ParticleSystem>();

    public ParticleManager() {
    }

    private String emitterPath;

    public void addParticle(String xmlPath, String particleImage) throws SlickException {
        try {
            //load the test particle and
            Image image = new Image(particleImage, false);
            ParticleSystem particleSystem = new ParticleSystem(image, 5000);
            this.emitterPath = xmlPath;
            File xmlFile = new File(xmlPath);
            ParticleEmitter emitter = ParticleIO.loadEmitter(xmlFile);
            particleSystem.addEmitter(emitter);
            particleSystem.setPosition(0, 0);
            particleSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
            particleSystemList.add(particleSystem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addParticle(float x, float y, String xmlPath, String particleImage) throws SlickException {
        try {
            //load the test particle and
            Image image = new Image(particleImage, false);
            ParticleSystem particleSystem = new ParticleSystem(image, 5000);

            File xmlFile = new File(xmlPath);
            ParticleEmitter emitter = ParticleIO.loadEmitter(xmlFile);
            particleSystem.addEmitter(emitter);
            particleSystem.setPosition(x, y);
            particleSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
            particleSystemList.add(particleSystem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean visible) {
        for (ParticleSystem particleSystem : particleSystemList) {
            particleSystem.setVisible(visible);
        }
    }

    public void upate(int delta) {
        for (ParticleSystem particleSystem : particleSystemList) {
            if (particleSystem.isVisible()) {
                particleSystem.update(delta);
            }
        }
    }

    public void render(Graphics graphics) {
        for (ParticleSystem particleSystem : particleSystemList) {
            particleSystem.render();
        }
    }

    public void render() {
        render(null);
    }

    public void render(float x, float y) {
        for (ParticleSystem particleSystem : particleSystemList) {
            particleSystem.render(x, y);
        }
    }

    public void reset() {
        for (ParticleSystem particleSystem : particleSystemList) {
            particleSystem.reset();
        }
    }
}
