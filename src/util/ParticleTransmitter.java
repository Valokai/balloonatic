package util;

import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 21/01/14
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParticleTransmitter {

    private List<Particle> list = new ArrayList<Particle>();
    private List<ParticleSystem> systems = new ArrayList<ParticleSystem>();

    public ParticleTransmitter() {}

    public void registerParticle(Particle particle, int x, int y) throws GameException {
        try {
            list.add(particle);
            ParticleSystem system = new ParticleSystem(particle.getImage(), particle.getParticleCount());
            system.addEmitter(ParticleIO.loadEmitter(particle.getXmlPath()));
            system.setPosition(x, y);
            system.setBlendingMode(particle.getBlendingMode());
            systems.add(system);
        } catch (IOException e) {
            throw new GameException(e.getMessage(), e.getCause());
        }
    }

    public void render(){
        if(!systems.isEmpty()){
            for (ParticleSystem system : systems) {
                system.render();
            }
        }
    }

    public void update(int delta){
        if(!systems.isEmpty()){
            for (ParticleSystem system : systems) {
                system.update(delta);
            }
        }
    }


}
