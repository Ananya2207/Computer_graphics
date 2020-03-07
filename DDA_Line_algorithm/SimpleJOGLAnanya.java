import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


class ThirdGLEventListener implements GLEventListener {
private GLU glu;

public void init(GLAutoDrawable gld) {
    GL gl = gld.getGL();
    glu = new GLU();
    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(0,0,640,480);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(0,640,0,480);
}

public void display(GLAutoDrawable drawable) {
    GL gl = drawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    
    //drawLine(gl, 0, 0, 100, 100);
    //gl.glColor3f(1.0f, 1.0f, 0.0f );
    DDA(gl,30,30,600,30);
    DDA(gl,600,30,600,400);
    DDA(gl,600,400,30,400);
    DDA(gl,30,400,30,30);
    
    DDA_DOT(gl,40,40,590,40);
    DDA_DOT(gl,590,40,590,390);
    DDA_DOT(gl,590,390,40,390);
    DDA_DOT(gl,40,390,40,40);
    
    DDADASHED(gl,50,50,570,50);
    DDADASHED(gl,570,50,570,370);
    DDADASHED(gl,570,370,50,370);
    DDADASHED(gl,50,370,50,50);
    
    DDATHICK(gl,70,70,550,70);
    DDATHICK(gl,550,70,550,350);
    DDATHICK(gl,550,350,70,350);
    DDATHICK(gl,70,350,70,70);
    
    //Bresenhams(gl,100,100,200,100);

}

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

private void drawLine(GL gl) {
    //gl.glPointSize(3.0f);
    gl.glBegin(GL.GL_LINES);// begin plotting points
   
        gl.glVertex2i(0,0 );
        gl.glVertex2i(100,100 );
        gl.glVertex2i(150,150 );
        gl.glVertex2i(250,300);
   
    gl.glEnd();//end drawing of points

}
public void dispose(GLAutoDrawable arg0)
{
   
}

private void DDA(GL gl, int x1, int y1, int x2, int y2) {

   
   
    gl.glBegin(GL.GL_POINTS);
   
    int steps;
    int dx = (x2 - x1),dy = (y2 - y1);
    
    float x=x1,y=y1;
    float xinc,yinc;
   
    if(Math.abs(dx)>Math.abs(dy))
        steps=(int)Math.abs(dx);
    else
        steps=(int)Math.abs(dy);
   
    xinc=dx/(float)steps;
    yinc=dy/(float)steps;
   
    for( int i = 0; i < steps; i++ )
    {
        gl.glVertex2i((int)x , (int)y );
        x+=xinc;
        y+=yinc;
       
    }
    gl.glEnd();//end drawing of points
}


private void DDA_DOT(GL gl, int x1, int y1, int x2, int y2) {

   
   
    gl.glBegin(GL.GL_POINTS);
   
    int steps;
    int dx = (x2 - x1),dy = (y2 - y1);
    
    float x=x1,y=y1;
    float xinc,yinc;
   
    if(Math.abs(dx)>Math.abs(dy))
        steps=(int)Math.abs(dx);
    else
        steps=(int)Math.abs(dy);
   
    xinc=dx/(float)steps;
    yinc=dy/(float)steps;
   
    for( int i = 0; i < steps; i++ )
    {
        if(i%3==0)
        gl.glVertex2i((int)x , (int)y );
        
        x+=xinc;
        y+=yinc;
       
    }
    gl.glEnd();//end drawing of points
}

private void DDADASHED(GL gl, int x1, int y1, int x2, int y2) {

   
   
    gl.glBegin(GL.GL_POINTS);
   
    int steps;
    int dx = (x2 - x1),dy = (y2 - y1);
    
    float x=x1,y=y1;
    float xinc,yinc;
   
    if(Math.abs(dx)>Math.abs(dy))
        steps=(int)Math.abs(dx);
    else
        steps=(int)Math.abs(dy);
   
    xinc=dx/(float)steps;
    yinc=dy/(float)steps;
   //int count=0;
    for( int i = 0; i < steps; i++ )
    {   if(i%4==0)
        {
        
        }
    else{
        gl.glVertex2i((int)x , (int)y );
    }
        x+=xinc;
        y+=yinc;
       
    }
    gl.glEnd();//end drawing of points
}

private void DDATHICK(GL gl, int x1, int y1, int x2, int y2) {

   
   
    gl.glBegin(GL.GL_POINTS);
   
    int steps;
    int dx = (x2 - x1),dy = (y2 - y1);
    
    float x=x1,y=y1;
    float xinc,yinc;
   
    if(Math.abs(dx)>Math.abs(dy))
        steps=(int)Math.abs(dx);
    else
        steps=(int)Math.abs(dy);
   
    xinc=dx/(float)steps;
    yinc=dy/(float)steps;
   
    for( int i = 0; i < steps; i++ )
    {
        gl.glVertex2i((int)x , (int)y );
        gl.glVertex2i((int)x+1 , (int)y+1 );
        gl.glVertex2i((int)x+2 , (int)y+2 );
        gl.glVertex2i((int)x+3 , (int)y+3 );
        gl.glVertex2i((int)x+4 , (int)y+4 );
        
        x+=xinc;
        y+=yinc;
       
    }
    gl.glEnd();//end drawing of points
}




}


public class SimpleJOGLAnanya
{
public static void main(String args[])
{
    //getting the capabilities object of GL2 profile
    //final GLProfile profile=GLProfile.get(GLProfile.GL);
    GLCapabilities capabilities=new GLCapabilities();
    // The canvas
    final GLCanvas glcanvas=new GLCanvas(capabilities);
    ThirdGLEventListener b=new ThirdGLEventListener();
    glcanvas.addGLEventListener(b);
    glcanvas.setSize(400, 400);
    //creating frame
    final JFrame frame=new JFrame("Basic frame");
    //adding canvas to frame
    frame.add(glcanvas);
    frame.setSize(640,480);
    frame.setVisible(true);
}
}














