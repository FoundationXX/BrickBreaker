/*    */ package wreck1;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.event.KeyEvent;
/*    */ 
/*    */ public class Bat
/*    */ {
/*    */   private static Game game;
/*    */   private static final int W = 60;
/*    */   private static final int H = 10;
/* 11 */   public int X = (int)Math.floor(470.0D);
/* 12 */   public final int Y = (int)Math.floor(450.0D);
/*    */   private int xa;
/*    */   
/*    */   public Bat(Game game)
/*    */   {
/* 17 */     game = game;
/*    */   }
/*    */   
/*    */ 
/*    */   public void keyReleased(KeyEvent e)
/*    */   {
/* 23 */     this.xa = 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void keyPressed(KeyEvent e)
/*    */   {
/* 29 */     if (e.getKeyCode() == 37)
/* 30 */       this.xa = -5;
/* 31 */     if (e.getKeyCode() == 39) {
/* 32 */       this.xa = 5;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void re_init(Graphics2D g2d)
/*    */   {
/* 39 */     g2d = g2d;
/* 40 */     g2d.fillRect(this.X, this.Y, 60, 10);
/*    */   }
/*    */   
/*    */ 
/*    */   public void updatePosition()
/*    */   {
/* 46 */     if ((this.X + this.xa > 0) && (this.X + this.xa < 940)) {
/* 47 */       this.X += this.xa;
/*    */     }
/*    */   }
/*    */   
/* 51 */   public java.awt.Rectangle getBounds() { return new java.awt.Rectangle(this.X, this.Y, 60, 10); }
/*    */   
/* 53 */   public int getX() { return this.X; }
/* 54 */   public int getY() { return this.Y; }
/* 55 */   public int getW() { return 60; }
/* 56 */   public int getH() { return 10; }
/*    */ }


/* Location:              /home/madking/Desktop/BrickBreaker-Fixed.jar!/wreck1/Bat.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */