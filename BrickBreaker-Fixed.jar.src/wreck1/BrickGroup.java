/*     */ package wreck1;
/*     */ 
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BrickGroup
/*     */ {
/*     */   private Game game;
/*  14 */   private final int rows = 3;
/*  15 */   private final int columns = 10;
/*     */   private int X;
/*  17 */   private int Y; public static final int W = (int)Math.floor(90.0D);
/*     */   public static final int H = 30;
/*  19 */   private int gap = (int)Math.floor((1000 - 10 * W) / 11);
/*  20 */   public List<brick> list = new ArrayList();
/*     */   
/*  22 */   public final Color backgroundColor = Game.BKG;
/*  23 */   private final Color brickColor = new Color(1.0F, 0.0F, 0.0F, 1.0F);
/*     */   
/*     */ 
/*     */   public BrickGroup(Game game)
/*     */   {
/*  28 */     this.game = game;
/*     */   }
/*     */   
/*     */ 
/*     */   public void init(Graphics2D g2d)
/*     */   {
/*  34 */     for (int i = 0; i < 3; i++) {
/*  35 */       this.Y = (this.gap + i * (30 + this.gap));
/*  36 */       for (int j = 0; j < 10; j++) {
/*  37 */         this.X = (this.gap + j * (W + this.gap));
/*  38 */         brick currentBrick = new brick(this.game, this.X, this.Y, this.brickColor);
/*  39 */         this.list.add(currentBrick);
/*  40 */         currentBrick.drawBrick(g2d);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void re_init(Graphics2D g2d)
/*     */   {
/*  49 */     for (brick b : this.list) {
/*  50 */       b.drawBrick(g2d);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getW()
/*     */   {
/*  57 */     return W;
/*     */   }
/*     */   
/*     */   public int getH() {
/*  61 */     return 30;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public class brick
/*     */   {
/*  71 */     Game game = BrickGroup.this.game;
/*  72 */     private int X = BrickGroup.this.X;
/*  73 */     private int Y = BrickGroup.this.Y;
/*  74 */     private int W = BrickGroup.W;
/*  75 */     private int H = 30;
/*     */     private Color color;
/*  77 */     private AlphaComposite opaque = AlphaComposite.getInstance(3, 1.0F);
/*     */     
/*     */     public brick(Game game, int X, int Y, Color c) {
/*  80 */       this.game = game;
/*  81 */       this.X = X;
/*  82 */       this.Y = Y;
/*  83 */       this.color = c;
/*     */     }
/*     */     
/*     */     private void drawBrick(Graphics2D g2d)
/*     */     {
/*  88 */       g2d = g2d;
/*  89 */       g2d.setPaint(this.color);
/*  90 */       g2d.setComposite(this.opaque);
/*  91 */       g2d.fillRect(this.X, this.Y, this.W, this.H);
/*     */     }
/*     */     
/*     */     public void setTransparent()
/*     */     {
/*  96 */       this.opaque = AlphaComposite.getInstance(3, 0.0F);
/*     */     }
/*     */     
/*     */     public AlphaComposite getOpaque()
/*     */     {
/* 101 */       return this.opaque;
/*     */     }
/*     */     
/* 104 */     public int getX() { return this.X; }
/*     */     
/*     */     public void setX(int x)
/*     */     {
/* 108 */       this.X = x;
/*     */     }
/*     */     
/*     */     public int getY() {
/* 112 */       return this.Y;
/*     */     }
/*     */     
/*     */     public void setY(int y) {
/* 116 */       this.Y = y;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 120 */       return "--" + this.color + "--";
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/madking/Desktop/BrickBreaker-Fixed.jar!/wreck1/BrickGroup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */