import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
//import javax.media.opengl.GLCapabilities;
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
   
    Bresenhams(gl, 50, 50, 50, 400);
   Bresenhams(gl, 50, 400, 400, 400);
    Bresenhams(gl, 400, 400, 400, 50);
   Bresenhams(gl, 400, 50, 50, 50);
   
   Bresenhams_dot(gl, 70, 70, 70, 380);
   Bresenhams_dot(gl, 70, 380, 380, 380);
   Bresenhams_dot(gl, 380, 380, 380, 70);
   Bresenhams_dot(gl, 380, 70, 70, 70);
   
   Bresenhams_dash(gl, 90, 90, 90, 360);
    Bresenhams_dash(gl, 90, 360, 360, 360);
    Bresenhams_dash(gl, 360, 360, 360,90);
    Bresenhams_dash(gl, 360, 90, 90, 90);
   
    Bresenhams_thick(gl, 110, 110, 110, 340);
    Bresenhams_thick(gl, 110, 340, 340, 340);
    Bresenhams_thick(gl, 340, 340, 340, 110);
    Bresenhams_thick(gl, 340, 110, 110, 110);
   
   
   
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

void Bresenhams(GL gl,int x1,int y1,int x2,int y2){
    gl.glBegin(GL.GL_POINTS);
    int x=x1,y=y1;
    int dx = Math.abs(x2-x1);
    int dy = Math.abs(y2-y1);
    int s1,s2;
   
    if((x2-x1)>0)
        s1=1;
    else if((x2-x1)==0)
        s1=0;
    else
        s1=-1;
   
    if((y2-y1)>0)
        s2=1;
    else if((y2-y1)==0)
        s2=0;
    else
        s2=-1;
   
    int interchange=0;
    if(dy>dx){
        interchange = 1;
        int t = dx;
        dx = dy;
        dy = t;
    }
    else
        interchange=0;
   
    int e1 = 2*dy - dx;
   
    for(int i=0;i<dx;i++){
         gl.glVertex2i(x,y);
         while(e1>0){
             if(interchange==1){
                 x=x+s1;
             }
             else
                 y=y+s2;
             
             e1=e1-2*dx;
         }
         
         if(interchange==1){
                 y=y+s2;
             }
             else
                 x=x+s1;
         
         e1=e1+2*dy;
    }
    gl.glEnd();
}

void Bresenhams_thick(GL gl,int x1,int y1,int x2,int y2){
    gl.glBegin(GL.GL_POINTS);
    int x=x1,y=y1;
    int dx = Math.abs(x2-x1);
    int dy = Math.abs(y2-y1);
    int s1,s2;
   
    if((x2-x1)>0)
        s1=1;
    else if((x2-x1)==0)
        s1=0;
    else
        s1=-1;
   
    if((y2-y1)>0)
        s2=1;
    else if((y2-y1)==0)
        s2=0;
    else
        s2=-1;
   
    int interchange=0;
    if(dy>dx){
        interchange = 1;
        int t = dx;
        dx = dy;
        dy = t;
    }
    else
        interchange=0;
   
    int e1 = 2*dy - dx;
   
    for(int i=0;i<dx;i++){
         gl.glVertex2i(x,y);
          gl.glVertex2i(x+1,y+1);
           gl.glVertex2i(x+2,y+2);
            gl.glVertex2i(x+3,y+3);
         
         while(e1>0){
             if(interchange==1){
                 x=x+s1;
             }
             else
                 y=y+s2;
             
             e1=e1-2*dx;
         }
         
         if(interchange==1){
                 y=y+s2;
             }
             else
                 x=x+s1;
         
         e1=e1+2*dy;
    }
    gl.glEnd();
}
void Bresenhams_dot(GL gl,int x1,int y1,int x2,int y2){
    gl.glBegin(GL.GL_POINTS);
    int x=x1,y=y1;
    int dx = Math.abs(x2-x1);
    int dy = Math.abs(y2-y1);
    int s1,s2;
   
    if((x2-x1)>0)
        s1=1;
    else if((x2-x1)==0)
        s1=0;
    else
        s1=-1;
   
    if((y2-y1)>0)
        s2=1;
    else if((y2-y1)==0)
        s2=0;
    else
        s2=-1;
   
    int interchange=0;
    if(dy>dx){
        interchange = 1;
        int t = dx;
        dx = dy;
        dy = t;
    }
    else
        interchange=0;
   
    int e1 = 2*dy - dx;
   
    for(int i=0;i<dx;i++){
         if(i%2==0){gl.glVertex2i(x,y);}
         while(e1>0){
             if(interchange==1){
                 x=x+s1;
             }
             else
                 y=y+s2;
             
             e1=e1-2*dx;
         }
         
         if(interchange==1){
                 y=y+s2;
             }
             else
                 x=x+s1;
         
         e1=e1+2*dy;
    }
    gl.glEnd();
}
void Bresenhams_dash(GL gl,int x1,int y1,int x2,int y2){
    gl.glBegin(GL.GL_POINTS);
    int x=x1,y=y1;
    int dx = Math.abs(x2-x1);
    int dy = Math.abs(y2-y1);
    int s1,s2;
   
    if((x2-x1)>0)
        s1=1;
    else if((x2-x1)==0)
        s1=0;
    else
        s1=-1;
   
    if((y2-y1)>0)
        s2=1;
    else if((y2-y1)==0)
        s2=0;
    else
        s2=-1;
   
    int interchange=0;
    if(dy>dx){
        interchange = 1;
        int t = dx;
        dx = dy;
        dy = t;
    }
    else
        interchange=0;
   
    int e1 = 2*dy - dx;
   
    for(int i=0;i<dx;i++){
       
         if(i%7==0){
               
        }
        else
            gl.glVertex2i(x,y);
         
         while(e1>0){
             if(interchange==1){
                 x=x+s1;
             }
             else
                 y=y+s2;
             
             e1=e1-2*dx;
         }
         
         if(interchange==1){
                 y=y+s2;
             }
             else
                 x=x+s1;
         
         e1=e1+2*dy;
    }
    gl.glEnd();
}

}
public class Bresenhams_Line
{
public static void main(String args[])
{
   
     long startTime = System.currentTimeMillis();
 
       //Measure execution time for this method
 
   
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
   
    long endTime = System.currentTimeMillis();
 
    long duration = (endTime - startTime);  
     
    System.out.println(duration);
}
}












