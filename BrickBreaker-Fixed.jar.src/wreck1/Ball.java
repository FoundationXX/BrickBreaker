/*     */ package wreck1;
/*     */ 
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class Ball
/*     */ {
/*     */   private static Game game;
/*     */   private static final int DIAMETER = 30;
/*  14 */   private int X = (int)Math.floor(485.0D);
/*  15 */   private int Y = (int)Math.floor(450.0D) - 30;
/*  16 */   private int xa = 1;
/*  17 */   private int ya = 1;
/*     */   
/*     */   public Ball(Game game)
/*     */   {
/*  21 */     game = game;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void re_init(Graphics2D g2d)
/*     */   {
/*  28 */     g2d = g2d;
/*  29 */     g2d.fillOval(this.X, this.Y, 30, 30);
/*     */   }
/*     */   
/*     */   private boolean collisionBat()
/*     */   {
/*  34 */     return game.bat.getBounds().intersects(getBounds());
/*     */   }
/*     */   
/*     */   private BrickGroup.brick collisionBrick() {
/*  38 */     for (BrickGroup.brick currentBrick : game.bricks.list) {
/*  39 */       if (new Rectangle(currentBrick.getX(), currentBrick.getY(), BrickGroup.W, 30).intersects(getBounds())) {
/*  40 */         return currentBrick;
/*     */       }
/*     */     }
/*     */     
/*  44 */     return null;
/*     */   }
/*     */   
/*     */   public Rectangle getBounds() {
/*  48 */     return new Rectangle(this.X, this.Y, 30, 30);
/*     */   }
/*     */   
/*     */ 
/*     */   public void updatePosition()
/*     */   {
/*  54 */     if (this.X + this.xa < 0)
/*  55 */       this.xa = 1;
/*  56 */     if (this.X + this.xa > game.getWidth() - 30)
/*  57 */       this.xa = -1;
/*  58 */     if (this.Y + this.ya < 0)
/*  59 */       this.ya = 1;
/*  60 */     if (this.Y + this.ya > game.getHeight() - 30) {
/*  61 */       game.gameOver();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  66 */     if (collisionBat()) {
/*  67 */       this.ya = -1;
/*  68 */       this.Y = (game.bat.getY() - 30);
/*     */     }
/*  70 */     if (collisionBrick() != null)
/*     */     {
/*  72 */       if ((Math.abs(Math.abs(this.Y - collisionBrick().getY()) - 30) < 5) && (collisionBrick().getOpaque().equals(AlphaComposite.getInstance(3, 1.0F)))) {
/*  73 */         this.ya *= -1;
/*     */       }
/*     */       
/*  76 */       if ((Math.abs(Math.abs(this.X - collisionBrick().getX()) - BrickGroup.W) < 5) && (collisionBrick().getOpaque().equals(AlphaComposite.getInstance(3, 1.0F)))) {
/*  77 */         this.xa *= -1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  82 */       for (int i = 0; i < game.bricks.list.size(); i++) {
/*  83 */         BrickGroup.brick currentBrick = (BrickGroup.brick)game.bricks.list.get(i);
/*  84 */         int XPos = currentBrick.getX();
/*  85 */         int YPos = currentBrick.getY();
/*  86 */         Rectangle decoy = new Rectangle(XPos, YPos, BrickGroup.W, 30);
/*  87 */         if (decoy.intersects(getBounds()))
/*     */         {
/*  89 */           BrickGroup tmp313_310 = game.bricks;tmp313_310.getClass();game.bricks.list.set(i, new BrickGroup.brick(tmp313_310, game, XPos, YPos, Color.green));
/*     */           
/*  91 */           ((BrickGroup.brick)game.bricks.list.get(i)).setTransparent();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */     this.X += this.xa;
/* 112 */     this.Y += this.ya;
/*     */   }
/*     */   
/*     */   public int getX() {
/* 116 */     return this.X;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 120 */     this.X = x;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 124 */     return this.Y;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/* 128 */     this.Y = y;
/*     */   }
/*     */ }


/* Location:              /home/madking/Desktop/BrickBreaker-Fixed.jar!/wreck1/Ball.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */