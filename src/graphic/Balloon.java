package graphic;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.*;
import util.ParticleManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Balloon Sprite, Player of the  game
 */
public class Balloon extends SceneObject{

    Animation burnerimage;
    Image[] burnerimages;

    private Sound burner = new Sound("data/sound/ambient/Burner.ogg");

    /*speed of balloon*/
    private float loonspeed = 0;

    private boolean burneron = false;

    private int fuelstate = 0;            //these control the glow effects on the fuelguage
    private float fuelstatetimer = 0;

    protected int fuel = 1000;

    protected int lives = 1;

    protected boolean isLockLife;

    protected boolean islockFuel;

    protected boolean isRenderLock;

    protected int birdhitcounter = 0;

    private int particleTimer;

    int shakeAngle = -100;

    private ParticleManager particleManager = new ParticleManager();


    private HashMap<String, BalloonEffect> balloonEffectsBehind = new HashMap<String, BalloonEffect>();
    private HashMap<String, BalloonEffect> balloonEffectsFront = new HashMap<String, BalloonEffect>();
    private List<String> balloonEffectsRecycler = new ArrayList<String>();
    private boolean isOnShake;

    public Balloon() throws SlickException {
        super("data/image/balloon.png", true);
        burnerimages = new Image[]{ new Image("data/image/balloon2-3.png"), new Image("data/image/balloon2-4.png") };
        burnerimage = new Animation(burnerimages,50);
        particleManager.addParticle(x, y, "data/particles/feather.xml", "data/particles/particle.png");
    }

    public Balloon(float x, float y) throws SlickException {
        super(x, y, "data/image/balloon.png", false);
        burnerimages = new Image[]{ new Image("data/image/balloon2-3.png"), new Image("data/image/balloon2-4.png") };
        burnerimage = new Animation(burnerimages,50);
        particleManager.addParticle(x, y, "data/particles/feather.xml", "data/particles/blood.png");
    }


    /**reset the ballon to coordinates
     *
     * @param x     reset balloon x coordinate
     * @param y     reset balloon y coordinate
     */
    public void reset(float x, float y) {
        this.x = x;
        this.y = y;
        loonspeed = 0;
    }

    /** set the y-speed of the balloon
     *
     * @param speed the desired y-speed
     */
    public void setSpeed(float speed) {
        loonspeed = speed;
    }

    /**get the speed of balloon
     *
     * @return returns a float of the balloons y-speed
     */
    public float getSpeed(){
        return loonspeed;
    }

    /**move the balloon
     *
     * @param offsetX  the amount you want to move the balloons x-coordinate
     * @param offsetY  the amount you want to move the balloons y-coordinate
     */
    public void move(float offsetX, float offsetY){
        x += offsetX;
        y += offsetY;
    }

    /**sets the Fuel state, ie whether you are losing or gaining fuel
     *
     * @param fuelstate  0 for normal, 1 for gaining, 2 for losing
     */
    public void setFuelState(int fuelstate){
        this.fuelstate = fuelstate;
        fuelstatetimer = 5;
    }

    public int getFuelState(){
        return fuelstate;
    }

    public boolean isOnShake() {
        return isOnShake;
    }

    public void setOnShake(boolean onShake) {
        isOnShake = onShake;
    }

    /**print the stats of balloon for error checking
     *
     * @param g     Graphics object
     * @param x     x-coordinate you want to print the stats
     * @param y     y-coordinate you want to print the stats
     */
    public void printStats(Graphics g, int x, int y) {
        g.drawString("Balloon X: " + getX(), x, y);
        g.drawString("Balloon Y: " + getY(), x, y+20);

        g.drawString("Speed: " + getSpeed(), x, y+40);

    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        for (String key : balloonEffectsBehind.keySet()) {
            BalloonEffect balloonEffect = balloonEffectsBehind.get(key);
            balloonEffect.drawOnBalloon(this, graphics);
            if(key.equals("bird")){
                 particleTimer = 200;
            }
        }
        if(!isRenderLock){
            if(isOnShake){
                if(shakeAngle != 100){
                    image.setRotation(shakeAngle / 10);
                    shakeAngle++;
                }else{
                    image.setRotation(0);
                    isOnShake = false;
                    shakeAngle = -100;
                }

            }
            if(burneron){
                burnerimage.draw(x-burnerimage.getWidth()/2, y-burnerimage.getHeight()/2);
            }else{
                image.drawCentered(x, y);
            }

        }
        for (String key : balloonEffectsBehind.keySet()) {
            balloonEffectsBehind.get(key).drawOnBalloon(this, graphics);
        }
        for (String key : balloonEffectsFront.keySet()) {
            balloonEffectsFront.get(key).drawOnBalloon(this, graphics);
        }

        //if(particleTimer > 0){
        //    particleTimer--;
        //    particleManager.render(x, y);
        //    if(particleTimer == 0)particleManager.reset();
        //}
    }


    /**update the timer controlling the glow effect on the fuel gauge
     *
     * @param deltaTime             deltaTime
     */
    private void updateFuelState(float deltaTime){
        if (fuelstatetimer ==0 && getFuelState() == 0){
            return;
        }
        if (fuelstatetimer > 0){
            fuelstatetimer = fuelstatetimer - deltaTime*10;
        } else {
            setFuelState(0);
        }
    }


    /**update the balloon
     *
     * @param gameContainer     the game container
     * @param delta             delta
     */
    @Override
    public void update(GameContainer gameContainer, int delta){
        float deltaTime = delta / 1000.0f;
        if(particleTimer > 0){
            particleManager.upate(delta);
        }
        Input input = gameContainer.getInput();
        updatePlayer(deltaTime, input);
        updateFuelState(deltaTime);
        recycleBalloonEffects();

    }

    public void recycleBalloonEffects(){
        for (String key : balloonEffectsRecycler) {
            balloonEffectsBehind.remove(key);
        }
        for (String key : balloonEffectsRecycler) {
            balloonEffectsFront.remove(key);
        }
        balloonEffectsRecycler.clear();
    }

    /**update the player based on inputs
     *
     * @param deltaTime     deltatime (delta / 1000)
     * @param input         Input object
     */
    private void updatePlayer(float deltaTime, Input input){
        if ((input.isKeyDown(Input.KEY_SPACE) || input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) && fuel > 0 && getY()>0)
        {
            fuel--;
            setSpeed(getSpeed() - (deltaTime * 600.0f));
            move(0.0f, getSpeed() * deltaTime);
            burneron = true;
            if (!burner.playing()){
                burner.loop(1.0f, 0.3f);
            }
        }
        else{
            if(getSpeed() >= 350) {
                setSpeed(350);
            }
            else {
                setSpeed(getSpeed() + (deltaTime * 400.0f));
            }
            move(0.0f, getSpeed() * deltaTime);
            burneron =false;
            super.setImage("data/image/balloon.png");
            burner.stop();

        }
    }

    /**returns the fuel of the balloon
     *
     * @return     the fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**get the lives of the player / balloon
     *
     * @return  the balloons lives
     */
    public int getLives() {
        return lives;
    }

    public void resetBalloonStats() {
        lives = 3;
        fuel = 1000;
        x = 280;
        y = 200;
        burner.stop();
    }

    public void stopBurner(){
        burner.stop();
    }

    @Override
    public void move(int delta) {}

    @Override
    public boolean isReadyForDisposal() {
        return (x < 0);
    }

    public void setFuel(int fuel) {
        if(!islockFuel){
            this.fuel = fuel;
        }
    }

    public void setLives(int lives) {
        if(!isLockLife){
            this.lives = lives;

        }
    }

    public void addBalloonEffect(BalloonEffect effect, String key){
        if(effect.isDrawnOnFront()){
            balloonEffectsFront.put(key, effect);
        }else{
            balloonEffectsBehind.put(key, effect);
        }
    }

    public void removeBalloonEffect(String key){
        balloonEffectsRecycler.add(key);
    }

    public boolean isLockLife() {
        return isLockLife;
    }

    public void setLockLife(boolean lockLife) {
        isLockLife = lockLife;
    }

    public boolean islockFuel() {
        return islockFuel;
    }

    public void setlockFuel(boolean islockFuel) {
        this.islockFuel = islockFuel;
    }

    public boolean isRenderLock() {
        return isRenderLock;
    }

    public void setRenderLock(boolean renderLock) {
        isRenderLock = renderLock;
    }

    public void setBirdCounter(int x) {
        birdhitcounter += x;
    }

    public int getBirdCounter(){
        return birdhitcounter;
    }

    public BalloonEffect findEffect(String id){
        BalloonEffect balloonEffect = balloonEffectsFront.get(id);
        if(balloonEffect == null)balloonEffect = balloonEffectsBehind.get(id);
        return balloonEffect;
    }

    public void setParticleTimer(int x) {
        particleTimer = x;
    }
}

