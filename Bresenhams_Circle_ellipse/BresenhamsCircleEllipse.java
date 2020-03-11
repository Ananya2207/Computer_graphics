import static java.lang.Math.sin;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
//import javax.media.opengl.GLCapabilities;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
class ThirdGLEventListener implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;
    private int x,y,cx,cy,r,a,b;
    private double d1,d2,di;
    public ThirdGLEventListener() {
        this.cx = 150;
        this.cy = 150;
        this.r = 45;
        this.a=150;
        this.b=100;
    }
 
    /**
     * Take care of initialization here.
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 600, 600);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0, 640, 0, 480);
    }
    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */
        //drawLine(gl, 0, 0, 100, 100);
        gl.glColor3f(1.0f, 0.0f, 1.0f);
//        drawLine(gl);
       
         drawEllipse(gl, 300,250,50, 25, 0);
         drawEllipse(gl,300,100,50,100,0);
       
         drawcircle(gl,300,300,100);
         drawcircle(gl,275,350,10);
         drawcircle(gl,325,350,10);
//         cx=cx+r+30;
//        drawcircle(gl, r);
//         cx=cx+r+30;
//        drawcircle(gl, r);
//         cx=cx+r+30;
//        drawcircle(gl, r);
     
       
    }
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }
    @Override
    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }
    public void drawLine(GL gl) {
       
    }
   
     public void drawEllipse(GL gl,int cx,int cy, double a, double b, double fix) {
        //first quadrant
//    double a=50,b=100,d,dd;
        int change = 63;
        double x = 0, y = b;
        double d, dd;
        double di = 1 / (a * a) + 11 / (b * b) - 2 / b;
        if (fix == 0) {
            while (y >= 0) {
                gl.glBegin(GL.GL_POINTS);// begin plotting points
                gl.glVertex2i((int) x + cx, (int) y + cy + (int) fix * change);
                if (di < 0) {
                    d = 2 * di + (2 * y) / (b * b) - 1 / (b * b);
                    if (d <= 0) {
                        x = x + 1;
                        di = di + 2 * x / (a * a) + 1 / (a * a);
                    } else {
                        x = x + 1;
                        y = y - 1;
                        di = di + 2 * x / (a * a) - 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                    }
                } else {
                    if (di > 0) {
                        dd = 2 * di - 2 * x / (a * a) - 1 / (a * a);
                        if (dd <= 0) {
                            x = x + 1;
                            y = y - 1;
                            di = di + 2 * x / (a * a) - 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                        } else {
                            y = y - 1;
                            di = di - 2 * y / (b * b) + 1 / (b * b);
                        }
                    } else {
                        x = x + 1;
                        y = y - 1;
                        di = di + 2 * x / (a * a) - 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                    }
                }
            }
            gl.glEnd();
        }
    //fourth quadrant
        x = a;
        y = 0;
        di = 1 / (a * a) + 11 / (b * b) - 2 / a;
        while (x >= 0) {
            gl.glBegin(GL.GL_POINTS);// begin plotting points
            gl.glVertex2i((int) x + cx, (int) y + cy + (int) fix * change);
            if (di < 0) {
                d = 2 * di + 2 * x / (a * a) - 1 / (a * a);
                if (d <= 0) {
                    y = y - 1;
                    di = di - 2 * y / (b * b) + 2 / (b * b);
                } else {
                    x = x - 1;
                    y = y - 1;
                    di = di - 2 * x / (a * a) - 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                }
            } else {
                if (di > 0) {
                    dd = 2 * di - 2 * x / (a * a) - 1 / (a * a);
                    if (dd <= 0) {
                        x = x - 1;
                        y = y - 1;
                        di = di - 2 * x / (a * a) - 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                    } else {
                        x = x - 1;
                        di = di - 2 * x / (a * a) + 1 / (a * a);
                    }
                } else {
                    x = x - 1;
                    y = y - 1;
                    di = di - 2 * x / (a * a) - 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                }
            }
        }
        gl.glEnd();
    //third quadrant
        x = 0;
        y = -b;
        di = 1 / (a * a) + 11 / (b * b) - 2 / b;
        while (y <= 0) {
            gl.glBegin(GL.GL_POINTS);// begin plotting points
            gl.glVertex2i((int) x + cx, (int) y + cy + (int) fix * change);
            if (di < 0) {
                d = 2 * di - 2 * y / (b * b) - 1 / (b * b);
                if (d <= 0) {
                    x = x - 1;
                    di = di - 2 * x / (a * a) + 1 / (a * a);
                } else {
                    x = x - 1;
                    y = y + 1;
                    di = di - 2 * x / (a * a) + 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                }
            } else {
                if (di > 0) {
                    dd = 2 * di + 2 * x / (a * a) - 1 / (a * a);
                    if (dd <= 0) {
                        x = x - 1;
                        y = y + 1;
                        di = di - 2 * x / (a * a) + 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                    } else {
                        y = y + 1;
                        di = di + 2 * y / (b * b) + 1 / (b * b);
                    }
                } else {
                    x = x - 1;
                    y = y + 1;
                    di = di - 2 * x / (a * a) + 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                }
            }
        }
        gl.glEnd();
        //second quadrant
        if (fix == 0) {
            x = -a;
            y = 0;
            di = 1 / (a * a) + 11 / (b * b) - 2 / a;
            while (x <= 0) {
                gl.glBegin(GL.GL_POINTS);// begin plotting points
                gl.glVertex2i((int) x + cx, (int) y + cy + (int) fix * change);
                if (di < 0) {
                    d = 2 * di - 2 * x / (a * a) - 1 / (a * a);
                    if (d <= 0) {
                        y = y + 1;
                        di = di + 2 * y / (b * b) + 1 / (b * b);
                    } else {
                        x = x + 1;
                        y = y + 1;
                        di = di + 2 * x / (a * a) + 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                    }
                } else {
                    if (di > 0) {
                        dd = 2 * di + 2 * x / (a * a) - 1 / (a * a);
                        if (dd <= 0) {
                            x = x + 1;
                            y = y + 1;
                            di = di + 2 * x / (a * a) + 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                        } else {
                            x = x + 1;
                            di = di + 2 * x / (a * a) + 1 / (a * a);
                        }
                    } else {
                        x = x + 1;
                        y = y + 1;
                        di = di + 2 * x / (a * a) + 2 * y / (b * b) + 1 / (a * a) + 1 / (b * b);
                    }
                }
            }
            gl.glEnd();
        }
    }
   
     private void drawcircle(GL gl ,int cx,int cy,int r) {
        gl.glPointSize(3.0f);
        x=0;
        y=r;
        di = 2*(1-r);
        gl.glBegin(GL.GL_POINTS);
        while(y>=0){
            gl.glVertex2d((int)x+cx,(int)y+cy);
            gl.glVertex2d(-1*(int)x+cx,(int)y+cy);
            gl.glVertex2d((int)x+cx,-1*(int)y+cy);
            gl.glVertex2d(-1*(int)x+cx,-1*(int)y+cy);
            if(di<0){
                d1=2*di+2*y-1;
                if(d1<=0)
                    mh();
                else
                    md();
            }else if(di>0){
                d2=2*di-2*x-1;
                if(d2<=0)
                    md();
                else
                    mv();
            }else{
                md();
            }  
        }
        gl.glEnd();//end drawing of points
    }
   
     private void Elmh(){
        x+=1;
        di=di+2*x+1;
    }
    private void Elmd(){
        x+=1;
        y-=1;
        di=di+2*x-2*y+2;
    }
    private void Elmv(){
        y-=1;
        di=di-2*y+1;
    }
   
    private void mh(){
        x+=1;
        di=di+2*x+1;
    }
    private void md(){
        x+=1;
        y-=1;
        di=di+2*x-2*y+2;
    }
    private void mv(){
        y-=1;
        di=di-2*y+1;
    }
    private float sign(double val){
        if(val>0)
            return 1;
        else if(val==0)
            return 0;
        else
            return -1;
    }
    public void dispose(GLAutoDrawable arg0) {
    }
}
public class BresenhamsCircleEllipse {
    public static void main(String args[]) {      //getting the capabilities object of GL2 profile
        //final GLProfile profile=GLProfile.get(GLProfile.GL);
        GLCapabilities capabilities = new GLCapabilities();
        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        ThirdGLEventListener b = new ThirdGLEventListener();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(400, 400);
        //creating frame
        final JFrame frame = new JFrame("Basic frame");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
