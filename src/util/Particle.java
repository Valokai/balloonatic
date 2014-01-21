package util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ParticleSystem;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 21/01/14
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Particle {

    private String imagePath;
    private String xmlPath;


    private Image image;
    private int particleCount;
    private int blendingMode;

    public Particle(String imagePath, String xmlPath, int particleCount) throws GameException {
        this.imagePath = imagePath;
        this.xmlPath = xmlPath;
        this.particleCount = particleCount;
        try {
            this.image = new Image(imagePath);
        } catch (SlickException e) {
            throw new GameException(e.getMessage(), e.getCause());
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getParticleCount() {
        return particleCount;
    }

    public void setParticleCount(int particleCount) {
        this.particleCount = particleCount;
    }

    public int getBlendingMode() {
        return blendingMode;
    }

    public void setBlendingMode(int blendingMode) {
        this.blendingMode = blendingMode;
    }

    @Override
    public String toString() {
        return "Particle{" +
                "imagePath='" + imagePath + '\'' +
                ", xmlPath='" + xmlPath + '\'' +
                ", image=" + image +
                ", particleCount=" + particleCount +
                ", blendingMode=" + blendingMode +
                '}';
    }
}
