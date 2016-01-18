/*     */ package wreck1;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Game
/*     */   extends JPanel
/*     */ {
/*     */   public static final int WINDOWWIDTH = 1000;
/*     */   public static final int WINDOWHEIGHT = 500;
/*  18 */   Ball ball = new Ball(this);
/*  19 */   Bat bat = new Bat(this);
/*  20 */   public BrickGroup bricks = new BrickGroup(this);
/*  21 */   private boolean helper = false;
/*  22 */   public static final Color BKG = Color.white;
/*     */   
/*     */ 
/*     */   public Game()
/*     */   {
/*  27 */     addKeyListener(new KeyListener()
/*     */     {
/*     */       public void keyTyped(KeyEvent e) {}
/*     */       
/*     */       public void keyReleased(KeyEvent e) {
/*  32 */         Game.this.bat.keyReleased(e);
/*     */       }
/*     */       
/*  35 */       public void keyPressed(KeyEvent e) { Game.this.bat.keyPressed(e);
/*     */       }
/*     */ 
/*  38 */     });
/*  39 */     setFocusable(true);
/*     */   }
/*     */   
/*     */   private void updateComponent() {
/*  43 */     this.bat.updatePosition();
/*  44 */     this.ball.updatePosition();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void paint(Graphics g2d)
/*     */   {
/*  51 */     super.paint(g2d);
/*  52 */     g2d = (Graphics2D)g2d;
/*  53 */     ((Graphics2D)g2d).setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
/*  54 */       RenderingHints.VALUE_ANTIALIAS_ON);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  59 */     this.ball.re_init((Graphics2D)g2d);
/*  60 */     this.bat.re_init((Graphics2D)g2d);
/*     */     
/*     */ 
/*  63 */     if (!this.helper) {
/*  64 */       this.helper = true;
/*  65 */       this.bricks.init((Graphics2D)g2d);
/*     */     }
/*     */     else
/*     */     {
/*  69 */       this.bricks.re_init((Graphics2D)g2d);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void gameOver()
/*     */   {
/*  77 */     JOptionPane.showMessageDialog(this, "Game Over", "Game Over", 0);
/*  78 */     System.exit(128);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws InterruptedException {
/*  82 */     JFrame frame = new JFrame("Mini Tennis Version 2");
/*  83 */     Game game = new Game();
/*  84 */     frame.add(game);
/*     */     
/*     */ 
/*     */ 
/*  88 */     frame.setSize(1000, 500);
/*  89 */     frame.setResizable(false);
/*  90 */     frame.setVisible(true);
/*  91 */     frame.setDefaultCloseOperation(3);
/*     */     
/*     */ 
/*     */ 
/*     */     for (;;)
/*     */     {
/*  97 */       game.updateComponent();
/*  98 */       game.repaint();
/*     */       
/*     */ 
/* 101 */       Thread.sleep(10L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/madking/Desktop/BrickBreaker-Fixed.jar!/wreck1/Game.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */