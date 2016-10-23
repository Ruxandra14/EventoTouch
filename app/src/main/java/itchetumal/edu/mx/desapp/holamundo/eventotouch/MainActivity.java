package itchetumal.edu.mx.desapp.holamundo.eventotouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //Variables
    float circuloCoorX=0 ,circuloCoorY=0;
    String mensaje ="";
    float coordIniX=0,coordIniY=0;
    Path ruta = new Path();
    int anchocanvas=0;
    int altocanvas =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutP = (LinearLayout) findViewById(R.id.layoutPrinc);
        Lienzo canvas = new Lienzo(this);
        layoutP.addView(canvas);
    }

    //Lienzo
    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            anchocanvas = canvas.getWidth();
            altocanvas = canvas.getHeight();

            Paint pincel = new Paint();
            pincel.setColor(Color.MAGENTA);
            pincel.setStrokeWidth(5);
            //canvas.drawCircle(100,100,80,pincel);
            //pincel.setAntiAlias(true);
            //pincel.setColor(Color.MAGENTA);
            canvas.drawCircle(circuloCoorX,circuloCoorY,40,pincel);
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(20);
            canvas.drawText("X:"+circuloCoorX +","+ "Y:"+circuloCoorY,0,this.getMeasuredHeight()-20,pincel);
            canvas.drawText(mensaje,0,this.getMeasuredHeight()-5,pincel);

            //canvas.drawLine(coordIniX,coordIniY,circuloCoorX,circuloCoorY,pincel);
            canvas.drawPath(ruta,pincel);


            //Coordenada X & Y
            pincel.setColor(Color.BLACK);
            canvas.drawLine(0,circuloCoorY,anchocanvas,circuloCoorY,pincel);
            canvas.drawLine(circuloCoorX,0,circuloCoorX,altocanvas,pincel);
            //canvas.drawLine(circuloCoorX-50,circuloCoorY,circuloCoorX+50,circuloCoorY,pincel);
            //canvas.drawLine(circuloCoorX,circuloCoorY-50,circuloCoorX,circuloCoorY+50,pincel);
        }
        //Método para eventos Touch
        @Override
        public boolean onTouchEvent(MotionEvent evento){
            circuloCoorX = evento.getX();
            circuloCoorY = evento.getY();

            if(evento.getAction()== MotionEvent.ACTION_DOWN){
                //coordIniX=evento.getX();
                //coordIniY=evento.getY();
                //ruta.moveTo(circuloCoorX,circuloCoorY);
               // mensaje = "Evento Down";

                //Validacion click en origen
                if((circuloCoorX > 0 & circuloCoorX < anchocanvas)& (circuloCoorY > 0 & circuloCoorY < altocanvas)){
                    mensaje= "ORIGEN TOUCH";
                }
                //Coordenadas del origen


            }
            if(evento.getAction() == MotionEvent.ACTION_UP){
                mensaje = "Evento Up";
            }
            /*if(evento.getAction()== MotionEvent.ACTION_MOVE){
                 mensaje = "Evento Move";
                ruta.lineTo(circuloCoorX,circuloCoorY);
            }*/
            this.invalidate();
            return true;
        }
    }


}


